/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.ejb;

import com.recruit.jobrecruiting.common.JobPostDetails;
import com.recruit.jobrecruiting.entity.Department;
import com.recruit.jobrecruiting.entity.JobPost;
import com.recruit.jobrecruiting.entity.Status;
import com.recruit.jobrecruiting.entity.Type;
import com.recruit.jobrecruiting.entity.User;
import com.recruit.jobrecruiting.util.Detachable;
import com.recruit.jobrecruiting.util.Util;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author DENISA
 */
@Stateless
public class JobPostBean {

    private static final Logger LOG = Logger.getLogger(JobPostBean.class.getName());

    @PersistenceContext
    private EntityManager em;

    @Inject
    private SkillBean skillBean;

    public List<JobPostDetails> getAllJobPosts() {
        LOG.info("getAllJobPosts");
        try {
            Query query = em.createQuery("SELECT j FROM JobPost j");
            List<Detachable> jobPosts = (List<Detachable>) query.getResultList();
            return Util.detachEntities(jobPosts);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public List<JobPostDetails> getAllActiveJobPosts() {
        LOG.info("getAllJobPosts");
        try {
            Query query = em.createQuery("SELECT j FROM JobPost j where status=:status")
                    .setParameter("status", Status.ACTIVE);
            return Util.detachEntities(query.getResultList());
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public List<JobPostDetails> filterJobPosts(String keyword, String type, String salary, String status) {
        LOG.info("filterJobPosts" + status);
        try {
            Query query = em.createQuery("SELECT j FROM JobPost j where (lower(j.title) like :keyword or lower(j.description) like :keyword ) and j.type in :types  and j.salary >= :salary and j.status in :statuses")
                    .setParameter("keyword", "%" + Util.string(keyword).toLowerCase() + "%")
                    .setParameter("salary", Util.number(salary))
                    .setParameter("types", Util.types(type))
                    .setParameter("statuses", Util.statuses(status));

            return Util.detachEntities(query.getResultList());

        } catch (Exception ex) {
            throw (ex);
            //return getAllJobPosts();
        }
    }

    public JobPostDetails getJobPost(int id) {
        LOG.info("getJobPost");
        try {
            return em.find(JobPost.class, id).detach();
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public JobPost getJobPostEntity(int id) {
        LOG.info("getJobPostEntity");
        try {
            return em.find(JobPost.class, id);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public JobPost createJobPost(String title, String description, String noOfPositionsFilled, String noOfPositionsAvailable, String[] skillIds, String department, int poster, String status, String type, String salary) {
        LOG.info("createJobPost");
        JobPost jobPost = new JobPost();

        jobPost.setTitle(title);
        jobPost.setDescription(description);
        User user = em.find(User.class, poster);
        jobPost.setPoster(user);
        jobPost.setNoOfPositionsFilled(Util.number(noOfPositionsFilled));

        jobPost.setNoOfPositionsAvailable(Util.number(noOfPositionsAvailable));
        jobPost.setDepartment(Department.valueOf(department));
        jobPost.setStatus(Status.valueOf(status));
        jobPost.setType(Type.valueOf(type));
        jobPost.setSalary(Util.number(salary));

        jobPost.setSkills(skillBean.findSkills(Arrays.asList(skillIds)));

        em.persist(jobPost);

        return jobPost;
    }

    public void deleteJobPost(int id) {
        LOG.info("deleteJobPost");
        try {
            em.remove(em.find(JobPost.class, id));
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public void editJobPost(int id, String title, String description, String noOfPositionsFilled, String noOfPositionsAvailable, String[] skillIds, String department, String status, String type, String salary) {
        LOG.info("editJobPost");
        try {
            JobPost jobPost = em.find(JobPost.class, id);
            jobPost.setTitle(title);
            jobPost.setDescription(description);
            jobPost.setDepartment(Department.valueOf(department));
            jobPost.setNoOfPositionsFilled(Util.number(noOfPositionsFilled));
            jobPost.setNoOfPositionsAvailable(Util.number(noOfPositionsAvailable));

            setJobpostStatus(jobPost, status);

            jobPost.setType(Type.valueOf(type));
            jobPost.setSalary(Util.number(salary));
            jobPost.setSkills(skillBean.findSkills(Arrays.asList(skillIds)));
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    /**
     * Closes the position automatically when there are enough applicants,
     * otherwise sets the desired status
     *
     * @param jobPost the job post to be updated
     * @param status the desired status
     * @return bool whether all values valid or not
     */
    protected void setJobpostStatus(JobPost jobPost, String status) {
        if (jobPost.getNoOfPositionsFilled() >= jobPost.getNoOfPositionsAvailable()) {
            jobPost.setStatus(Status.INACTIVE);
        } else {
            jobPost.setStatus(Status.valueOf(status));
        }
    }
}
