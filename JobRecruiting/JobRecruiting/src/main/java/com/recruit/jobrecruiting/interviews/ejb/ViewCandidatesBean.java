/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.interviews.ejb;

import com.recruit.jobrecruiting.common.InterviewDetails;
import com.recruit.jobrecruiting.jobPost.ejb.JobPostBean;
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
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Doly
 */
@Stateless
public class ViewCandidatesBean {

    private static final Logger LOG = Logger.getLogger(ViewCandidatesBean.class.getName());

    @Inject
    private JobPostBean jobPostBean;

    @Inject
    private UserBean userBean;

    @PersistenceContext
    private EntityManager em;

    public List<InterviewDetails> getAllCandidates() {
        LOG.info("getAllCandidates");
        try {
            TypedQuery<Interview> typedQuery = em.createQuery("SELECT i FROM Interview i WHERE i.status = :interviewStatus", Interview.class)
                    .setParameter("interviewStatus", InterviewStatus.APPLIED_FOR);

            List<Interview> candidates = (List<Interview>) typedQuery.getResultList();
//        Query query = em.createQuery("SELECT i FROM Interviews i WHERE i.status = :interviewStatus")
//                .setParameter("interviewStatusid", InterviewStatus.WAITING_INTERVIEW_DATE);

            //List<Interview> candidates = (List<Interview>)query.getResultList();
            List<InterviewDetails> x = copyCandidateToDetails(candidates);
            return x;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

//    public List<InterviewDetails> getAllInterviewsAsCandidate(Integer userId)
//    {
//        try {
//            TypedQuery<Interview> typedQuery = em.createQuery("SELECT i FROM interviews i WHERE i.candidate_key = :id", Interview.class)
//                .setParameter("id", userId);
//        List<Interview> interviews = (List<Interview>)typedQuery.getResultList();
//        List<InterviewDetails> x = copyInterviewToDetails(interviews);
//        return x;
//        } catch (Exception ex) {
//            throw new EJBException(ex);
//        }
//    }
    private List<InterviewDetails> copyCandidateToDetails(List<Interview> candidates) {
        List<InterviewDetails> detailsList = new ArrayList<>();
        for (Interview candidate : candidates) {
            InterviewDetails candidateDetails = new InterviewDetails(candidate.getId(), candidate.getJobPost(), candidate.getCandidate(), candidate.getInterviewer(), candidate.getStatus());
            detailsList.add(candidateDetails);
        }
        return detailsList;
    }

    public List<String> getAllCandidateEmail(Integer jobpostId) {
        LOG.info("getAllCandidateEmail:" + jobpostId);
        Query query = em.createQuery("SELECT i.candidate.email FROM Interview i WHERE i.jobPost.id = :jobPostId")
                .setParameter("jobPostId", jobpostId);
        return query.getResultList();
    }

}
