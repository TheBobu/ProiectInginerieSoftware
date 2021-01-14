/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.comment.ejb;

import com.recruit.jobrecruiting.common.CommentDetails;
import com.recruit.jobrecruiting.entity.Comment;
import com.recruit.jobrecruiting.entity.Interview;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Deea
 */
@Stateless
public class CommentBean {

    private static final Logger LOG = Logger.getLogger(CommentBean.class.getName());

    @PersistenceContext
    private EntityManager em;

    public List<CommentDetails> getAllComments(Integer interviewId) {
        LOG.info("getAllComments");
        try {
            //List<Comment> comments = (List<Comment>) em.createQuery("SELECT c FROM Comment c WHERE ").getResultList();
            //return comments;
            TypedQuery<Comment> typedQuery = em.createQuery("SELECT c FROM Comment c WHERE c.interview.id = :id", Comment.class)
                .setParameter("id", interviewId);
        List<Comment> comments = (List<Comment>)typedQuery.getResultList();
        List<CommentDetails> x = copyCommentToDetails(comments);
        return x;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    private List<CommentDetails> copyCommentToDetails(List<Comment> comments){
        List<CommentDetails> detailsList = new ArrayList<>();
        for (Comment comment: comments) {
            CommentDetails commentDetails = new CommentDetails();
            commentDetails.setId(comment.getId());
            commentDetails.setComment(comment.getMessage());
            commentDetails.setUsername(comment.getWrittenBy());
            detailsList.add(commentDetails);
        }
        return detailsList;
    }

    public void deleteCommentbyId(Integer id) {
        Comment comment = em.find(Comment.class, id);
        em.remove(comment);
    }
    
    public void createComment(String username, String comment_text, Integer interviewId) {
        LOG.info("createComment");
        Comment comment = new Comment();

        comment.setWrittenBy(username);
        comment.setMessage(comment_text);
        Interview interview = em.find(Interview.class, interviewId);
        interview.getComments().add(comment);
        comment.setInterview(interview);

        em.persist(comment);
    }
}
