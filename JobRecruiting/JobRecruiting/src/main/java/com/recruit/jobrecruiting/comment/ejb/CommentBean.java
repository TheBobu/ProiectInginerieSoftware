/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.comment.ejb;

import com.recruit.jobrecruiting.entity.Comment;
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

    public List<Comment> getAllComments(Integer interviewId) {
        LOG.info("getAllComments");
        try {
            //List<Comment> comments = (List<Comment>) em.createQuery("SELECT c FROM Comment c WHERE ").getResultList();
            //return comments;
            TypedQuery<Comment> typedQuery = em.createQuery("SELECT c FROM Comment c WHERE c.interview.id = :id", Comment.class)
                .setParameter("id", interviewId);
        List<Comment> comments = typedQuery.getResultList();
        return comments;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
