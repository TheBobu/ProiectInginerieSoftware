/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.jobPost.ejb;

import com.recruit.jobrecruiting.common.JobPostDetails;
import com.recruit.jobrecruiting.skill.ejb.SkillBean;
import com.recruit.jobrecruiting.entity.Department;
import com.recruit.jobrecruiting.entity.JobPost;
import com.recruit.jobrecruiting.entity.Status;
import com.recruit.jobrecruiting.entity.Type;
import com.recruit.jobrecruiting.entity.User;
import com.recruit.jobrecruiting.user.ejb.UserBean;
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
 * @author DENISA, Andreea Purta, robert
 */
@Stateless
public class JobPostBean {

    private static final Logger LOG = Logger.getLogger(JobPostBean.class.getName());

    @PersistenceContext
    private EntityManager em;

    @Inject
    private SkillBean skillBean;

    @Inject
    private UserBean userBean;

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
            Query query = em.createQuery("SELECT j FROM JobPost j where (lower(j.title) like :keyword or lower(j.requirements) like :keyword or lower(j.responsabilities) like :keyword) and j.type in :types  and j.salary >= :salary and j.status in :statuses")
                    .setParameter("keyword", "%" + Util.string(keyword).toLowerCase() + "%")
                    .setParameter("salary", Util.number(salary))
                    .setParameter("types", Util.types(type))
                    .setParameter("statuses", Util.statuses(status));
            return Util.detachEntities(query.getResultList());

        } catch (Exception ex) {
            throw (ex);
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

    public JobPostDetails createJobPost(String title, String requirements, String responsabilities, String noOfPositionsAvailable, String[] skillIds, String department, int poster, String status, String type, String salary) {
        LOG.info("createJobPost");
        JobPost jobPost = new JobPost();

        jobPost.setTitle(title);
        jobPost.setRequirements(requirements);
        jobPost.setResponsabilities(responsabilities);
        User user = em.find(User.class, poster);
        jobPost.setPoster(user);
        jobPost.setNoOfPositionsAvailable(Util.number(noOfPositionsAvailable));
        jobPost.setDepartment(Department.valueOf(department));
        jobPost.setStatus(Status.valueOf(status));
        jobPost.setType(Type.valueOf(type));
        jobPost.setSalary(Util.number(salary));

        jobPost.setSkills(skillBean.findSkills(Arrays.asList(skillIds)));

        em.persist(jobPost);

        return jobPost.detach();
    }

    public void deleteJobPost(int id) {
        LOG.info("deleteJobPost");
        try {
            em.remove(em.find(JobPost.class, id));
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public JobPostDetails editJobPost(int id, String title, String requirements, String responsabilities, String noOfPositionsAvailable, String[] skillIds, String department, String status, String type, String salary) {
        LOG.info("editJobPost");
        try {
            JobPost jobPost = em.find(JobPost.class, id);
            jobPost.setTitle(title);
            jobPost.setRequirements(requirements);
            jobPost.setResponsabilities(responsabilities);
            jobPost.setDepartment(Department.valueOf(department));
            jobPost.setNoOfPositionsAvailable(Util.number(noOfPositionsAvailable));

            setJobpostStatus(jobPost, status);

            jobPost.setType(Type.valueOf(type));
            jobPost.setSalary(Util.number(salary));
            jobPost.setSkills(skillBean.findSkills(Arrays.asList(skillIds)));
            return jobPost.detach();
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    /**
     * Closes the position automatically when there are enough applicants,
     * otherwise sets the desired status
     *
     */
    protected void setJobpostStatus(JobPost jobPost, String status) {
        if (jobPost.getNoOfPositionsFilled() >= jobPost.getNoOfPositionsAvailable()) {
            jobPost.setStatus(Status.INACTIVE);
        } else {
            jobPost.setStatus(Status.valueOf(status));
        }
    }

    public void activateDeactivateJobPost(Integer id) {
        JobPost jobPost = em.find(JobPost.class, id);

        if (jobPost.getStatus() == Status.ACTIVE) {
            jobPost.setStatus(Status.INACTIVE);
        } else {
            jobPost.setStatus(Status.ACTIVE);
        }
        JobPost oldJobPost = em.find(JobPost.class, id);
        em.remove(oldJobPost);
        em.persist(jobPost);
    }

    /**
     * Gets job posts from a specific department
     *
     * @param dep the department of the job posts you want to get
     * @return Returns a list of JobPostDetails, from the specified department
     */
    public List<JobPostDetails> JobPostsByDepartment(Department dep) {
        try {
            Query query = em.createQuery("SELECT j FROM JobPost j where j.department = :dep")
                    .setParameter("dep", dep);

            return Util.detachEntities(query.getResultList());
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public JobPostDetails copyJobPost(int id, Status status, String posterUsername) {

        LOG.info("copyJobPost," + id);

        JobPost jobPost = getJobPostEntity(id);

        JobPost copiedJobPost = (JobPost) jobPost.copy();

        copiedJobPost.setStatus(status);

        User poster = userBean.getUserByUsername(posterUsername);

        copiedJobPost.setPoster(poster);

        em.persist(copiedJobPost);

        return copiedJobPost.detach();
    }

    public void increasePositionsFilled(JobPost jobPost) {
        int old = jobPost.getNoOfPositionsFilled();
        jobPost.setNoOfPositionsFilled(old + 1);

        setJobpostStatus(jobPost, jobPost.getStatus().toString());
    }
}
