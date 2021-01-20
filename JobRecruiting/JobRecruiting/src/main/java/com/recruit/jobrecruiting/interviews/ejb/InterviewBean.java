/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.interviews.ejb;

import com.recruit.jobrecruiting.common.InterviewDetails;
import com.recruit.jobrecruiting.common.UserDetails;
import com.recruit.jobrecruiting.jobPost.ejb.JobPostBean;
import com.recruit.jobrecruiting.entity.Interview;
import com.recruit.jobrecruiting.entity.InterviewStatus;
import com.recruit.jobrecruiting.entity.JobPost;
import com.recruit.jobrecruiting.entity.User;
import com.recruit.jobrecruiting.user.ejb.UserBean;
import com.recruit.jobrecruiting.util.Util;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
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
 * @author Doly, robert, denisa
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
     * Gets all interviews for a specific job post with a specific status.
     *
     * @param id the id of the JobPost
     * @param status the status of the interview
     * @return Returns the list of interviews
     */
    public List<InterviewDetails> getInterviewsForJobPost(Integer id, InterviewStatus status) {
        try {
            TypedQuery<InterviewDetails> typedQuery = em.createQuery("SELECT i FROM Interview i WHERE i.jobPost.id = :id AND i.status = :status", InterviewDetails.class)
                    .setParameter("id", id)
                    .setParameter("status", status);

            return typedQuery.getResultList();
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
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
    public void setFinalAccept(Integer id) {
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
    public void setFinalReject(Integer id) {
        try {
            Interview interview = em.find(Interview.class, id);
            interview.setStatus(InterviewStatus.REJECTED_BY_DIRECTOR);
            em.persist(interview);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public InterviewDetails createInterview(String _jobPostId, String username) {
        try {
            Interview interview = new Interview();

            interview.setStatus(InterviewStatus.APPLIED_FOR);

            Integer jobPostId = Util.number(_jobPostId);

            JobPost jobPost = jobPostBean.getJobPostEntity(jobPostId);
            interview.setJobPost(jobPost);

            interview.setInterviewer(jobPost.getPoster());

            User user = userBean.getUserByUsername(username);
            interview.setCandidate(user);

            em.persist(interview);

            return copyInterviewToDetails(interview);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }

    }

    public List<Integer> getAllJobPostsAsCandidate(Integer userId) {
        try {
            Query query = em.createQuery("SELECT i.jobPost.id FROM Interview i WHERE i.candidate.id = :id")
                    .setParameter("id", userId);
            return query.getResultList();
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private InterviewDetails copyInterviewToDetails(Interview interview) {
        InterviewDetails interviewDetails = new InterviewDetails(interview.getId(), interview.getJobPost(), interview.getCandidate(), interview.getInterviewer(), interview.getStatus());
        return interviewDetails;
    }

    public Interview getInterviewById(Integer id) {
        return em.find(Interview.class, id);
    }
    
    public LocalDateTime toDateTime(LocalDate date, LocalTime time){
        return LocalDateTime.of(date, time);
    }
    
     public void setDateTime(Integer id, LocalDate date, LocalTime time){
        try {
            Interview interview = em.find(Interview.class, id);
            LocalDateTime interviewDateTime=LocalDateTime.of(date, time);
            interview.setDateTime(interviewDateTime);
            interview.setStatus(InterviewStatus.BEFORE_INTERVIEW);
            em.persist(interview);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
     }
        
    public void setPlace(Integer id, String place){
        try {
            Interview interview = em.find(Interview.class, id);
            interview.setPlace(place);
            interview.setStatus(InterviewStatus.BEFORE_INTERVIEW);
            em.persist(interview);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    } 
    
//    private String getDateTime() {
//    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//    Date date = new Date();
//    return dateFormat.format(date);
//}
//    var dt = new DateTime(1970, 1, 1, 0, 0, 0, 0).AddSeconds(Math.Round(1372061224000 / 1000d)).ToLocalTime();
//Console.WriteLine(dt); // Prints: 6/24/2013 10:07:04 AM
}
