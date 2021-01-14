/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.interviews.ejb;

import com.recruit.jobrecruiting.common.InterviewDetails;
import com.recruit.jobrecruiting.entity.Interview;
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
public class InterviewBean {  //DB->

    @PersistenceContext
    private EntityManager em;
    
    public List<InterviewDetails> getAllInterviewsAsInterviewer(Integer userId)
    {
        try {
            TypedQuery<Interview> typedQuery = em.createQuery("SELECT i FROM interviews i WHERE i.interviewer_key = :id", Interview.class)
                .setParameter("id", userId);
        List<Interview> interviews = (List<Interview>)typedQuery.getResultList();
        List<InterviewDetails> x = copyInterviewToDetails(interviews);
        return x;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    public List<InterviewDetails> getAllInterviewsAsCandidate(Integer userId)
    {
        try {
            TypedQuery<Interview> typedQuery = em.createQuery("SELECT i FROM interviews i WHERE i.candidate_key = :id", Interview.class)
                .setParameter("id", userId);
        List<Interview> interviews = (List<Interview>)typedQuery.getResultList();
        List<InterviewDetails> x = copyInterviewToDetails(interviews);
        return x;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private List<InterviewDetails> copyInterviewToDetails(List<Interview> interviews) {
        List<InterviewDetails> detailsList = new ArrayList<>();
        for (Interview interview : interviews) {
            InterviewDetails interviewDetails = new InterviewDetails(interview.getId(), interview.getJobPost(), interview.getCandidate(), interview.getStatus());
            detailsList.add(interviewDetails);
        }
        return detailsList;
    }
    
    
}
