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
import com.recruit.jobrecruiting.entity.User;
import com.recruit.jobrecruiting.util.Detachable;
import com.recruit.jobrecruiting.util.Util;
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
        try {
            Query query = em.createQuery("SELECT j FROM JobPost j");
            List<Detachable> jobPosts = (List<Detachable>) query.getResultList();
            return Util.detachEntities(jobPosts);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public JobPostDetails getJobPost(int id) {
        LOG.info("getCar");
        try {
            return em.find(JobPost.class, id).detach();
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public void createJobPost(String title, String description, int noOfPositionsFilled, int noOfPositionsAvailable, List<String> skillIds, Department department, int poster, Status status) {
        LOG.info("createJobPost");
        JobPost jobPost = new JobPost();

        jobPost.setTitle(title);
        jobPost.setDescription(description);
        jobPost.setDepartment(department);
        User user = em.find(User.class, poster);
        jobPost.setPoster(user);
        jobPost.setNoOfPositionsAvailable(noOfPositionsFilled);
        jobPost.setNoOfPositionsAvailable(noOfPositionsAvailable);
        jobPost.setStatus(status);

        jobPost.setSkills(skillBean.findSkills(skillIds));

        em.persist(jobPost);
    }

    public void deleteJobPost(int id) {
        LOG.info("deleteJobPost");
        try {
            em.remove(em.find(JobPost.class, id));
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public void editJobPost(int id, String title, String description, int noOfPositionsFilled, int noOfPositionsAvailable, List<String> skillIds, Department department, Status status) {
        LOG.info("editJobPost");
        try {
            JobPost jobPost = em.find(JobPost.class, id);
            jobPost.setTitle(title);
            jobPost.setDescription(description);
            jobPost.setDepartment(department);
            jobPost.setNoOfPositionsAvailable(noOfPositionsFilled);
            jobPost.setNoOfPositionsAvailable(noOfPositionsAvailable);
            jobPost.setSkills(skillBean.findSkills(skillIds));
            jobPost.setStatus(status);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

}
