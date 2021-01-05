/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.ejb;

import com.recruit.jobrecruiting.common.JobPostDetails;
import com.recruit.jobrecruiting.entity.JobPost;
import com.recruit.jobrecruiting.util.Detachable;
import com.recruit.jobrecruiting.util.Util;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
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

}
