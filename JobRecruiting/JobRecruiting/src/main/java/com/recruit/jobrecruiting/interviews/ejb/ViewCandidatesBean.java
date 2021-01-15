/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.interviews.ejb;

import com.recruit.jobrecruiting.common.InterviewDetails;
import com.recruit.jobrecruiting.entity.Interview;
import com.recruit.jobrecruiting.entity.InterviewStatus;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Doly
 */
@Stateless
public class ViewCandidatesBean {

    @PersistenceContext
    private EntityManager em;
    
    public List<InterviewDetails> getAllCandidates()
    {
        try {
            TypedQuery<Interview> typedQuery = em.createQuery("SELECT i FROM interviews i WHERE i.status = :interviewStatus", Interview.class)
                .setParameter("interviewStatusid", InterviewStatus.WAITING_INTERVIEW_DATE);
        List<Interview> candidates = (List<Interview>)typedQuery.getResultList();
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
            InterviewDetails candidateDetails = new InterviewDetails(candidate.getId(), candidate.getJobPost(), candidate.getCandidate(), candidate.getStatus());
            detailsList.add(candidateDetails);
        }
        return detailsList;
    }
}
