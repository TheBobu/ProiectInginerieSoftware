/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.interviews.ejb;

import com.recruit.jobrecruiting.common.InterviewDetails;
import com.recruit.jobrecruiting.common.UserDetails;
import com.recruit.jobrecruiting.ejb.JobPostBean;
import com.recruit.jobrecruiting.entity.Interview;
import com.recruit.jobrecruiting.entity.InterviewStatus;
import com.recruit.jobrecruiting.user.ejb.UserBean;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Doly, robert
 */
@Stateless
public class InterviewBean {

    private static final Logger LOG = Logger.getLogger(InterviewBean.class.getName());

    @Inject
    private JobPostBean jobPostBean;

    @Inject
    private UserBean userBean;

    @PersistenceContext
    private EntityManager em;

    public List<InterviewDetails> getAllInterviewsAsInterviewer(Integer userId)///////////doar cele pt care s-a stabilit interviul
    {
        try {
            TypedQuery<Interview> typedQuery = em.createQuery("SELECT i FROM Interview i WHERE (i.interviewer.id = :id AND i.status <> :st)", Interview.class)
                    .setParameter("id", userId).setParameter("st", InterviewStatus.APPLIED_FOR);
            List<Interview> interviews = (List<Interview>) typedQuery.getResultList();
            List<InterviewDetails> x = copyInterviewToDetails(interviews);
            return x;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public List<InterviewDetails> getAllInterviewsAsCandidate(Integer userId) {
        try {
            TypedQuery<Interview> typedQuery = em.createQuery("SELECT i FROM Interview i WHERE i.candidate.id = :id", Interview.class)
                    .setParameter("id", userId);
            List<Interview> interviews = (List<Interview>) typedQuery.getResultList();
            List<InterviewDetails> x = copyInterviewToDetails(interviews);
            return x;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private List<InterviewDetails> copyInterviewToDetails(List<Interview> interviews) {
        List<InterviewDetails> detailsList = new ArrayList<>();
        for (Interview interview : interviews) {
            InterviewDetails interviewDetails = new InterviewDetails(interview.getId(), interview.getJobPost(), interview.getCandidate(), interview.getInterviewer(), interview.getStatus());
            detailsList.add(interviewDetails);
        }
        return detailsList;
    }

    /**
     * Gets all successful interviews (candidates accepted by
     * recruiter/interviewer) for a specific job post.
     *
     * @param id the id of the JobPost
     * @return Returns the list of successful interviews
     */
    public List<InterviewDetails> getAllSuccessfulInterviewsForJobPost(Integer id) {
        try {
            TypedQuery<InterviewDetails> typedQuery = em.createQuery("SELECT i FROM Interview i WHERE i.jobPost.id = :id AND i.status = :status", InterviewDetails.class)
                    .setParameter("id", id)
                    .setParameter("status", InterviewStatus.ACCEPTED_BY_RECRUITER);

            return typedQuery.getResultList();
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    /**
     * Grant final candidate accept after a successful interview with the
     * interviewer. Should only be used by the department director.
     *
     * @param id the id of the interview
     */
    public void finalAccept(Integer id) {
        try {
            Interview interview = em.find(Interview.class, id);
            interview.setStatus(InterviewStatus.ACCEPTED_BY_DIRECTOR);
            em.persist(interview);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    /**
     * Grant final candidate reject after a successful interview with the
     * interviewer. Should only be used by the department director.
     *
     * @param id the id of the interview
     */
    public void finalReject(Integer id) {
        try {
            Interview interview = em.find(Interview.class, id);
            interview.setStatus(InterviewStatus.REJECTED_BY_DIRECTOR);
            em.persist(interview);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
}
