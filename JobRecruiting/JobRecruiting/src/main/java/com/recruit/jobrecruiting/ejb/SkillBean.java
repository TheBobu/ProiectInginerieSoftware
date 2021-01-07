/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.ejb;

import com.recruit.jobrecruiting.common.SkillDetails;
import com.recruit.jobrecruiting.entity.Skill;
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
public class SkillBean {

    @PersistenceContext
    private EntityManager em;

    private static final Logger LOG = Logger.getLogger(SkillBean.class.getName());

    public List<SkillDetails> getAllSkills() {
        LOG.info("getAllSkills");
        try {
            Query query = em.createQuery("SELECT s FROM Skill s");
            List<Detachable> skills = query.getResultList();
            return Util.detachEntities(skills);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public List<Skill> findSkills(List<String> skillIds) {
        LOG.info("findSkills");

        return (List<Skill>) em
                .createQuery("SELECT s FROM Skill s where s.id IN ?1")
                .setParameter(1, skillIds)
                .getResultList();
    }
}
