/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.interviews.ejb;

import com.recruit.jobrecruiting.common.InterviewDetails;
import com.recruit.jobrecruiting.common.InterviewLightDetails;
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
 * @author Doly
 */

@Stateless
public class InterviewBean {  //DB->
    
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
            TypedQuery<Interview> typedQuery = em.createQuery
                ("SELECT i FROM Interview i WHERE (i.interviewer.id = :id AND i.status <> :st)", Interview.class)
                .setParameter("id", userId).setParameter("st", InterviewStatus.APPLIED_FOR);
        List<Interview> interviews = (List<Interview>)typedQuery.getResultList();
        List<InterviewDetails> x = copyInterviewToDetails(interviews);    //schimbare cu light details!!!!
        return x;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    public List<InterviewDetails> getAllInterviewsAsCandidate(Integer userId)
    {
        try {
            TypedQuery<Interview> typedQuery = em.createQuery("SELECT i FROM Interview i WHERE i.candidate.id = :id", Interview.class)
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
            InterviewDetails interviewDetails = new InterviewDetails(interview.getId(), interview.getJobPost(), interview.getCandidate(), interview.getInterviewer(), interview.getStatus());
            detailsList.add(interviewDetails);
        }
        return detailsList;
    }
    
//    public Interview getInterviewById(Integer id) {
//        return 
//    }
    
    private InterviewDetails copyInterviewToDetails(Interview interview){
        InterviewDetails interviewDetails = new InterviewDetails(interview.getId(), interview.getJobPost(), interview.getCandidate(), interview.getInterviewer(), interview.getStatus());
        return interviewDetails;
    }
    
    public InterviewDetails getInterviewById(Integer id){
        Interview interview=em.find(Interview.class, id);
        return copyInterviewToDetails(interview);
    }
//    private List<InterviewLightDetails> copyInterviewToLightDetails(List<Interview> interviews) {
//        List<InterviewLightDetails> lightDetailsList = new ArrayList<>();
//        for (Interview interview : interviews) {
//            InterviewLightDetails interviewLightDetails = new InterviewLightDetails(interview.getId(), interview.getJobPost(), interview.getCandidate(), interview.getInterviewer(), interview.getStatus());
//            lightDetailsList.add(interviewLightDetails);
//        }
//        return lightDetailsList;
//    }
    
    
}
