/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.skill.ejb;

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
 * EJB for {@link Skill} Entity.
 *
 * @author DENISA, robert
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

    public void createSkill(String name) {
        LOG.info("createSkill");

        Skill skill = new Skill();
        skill.setName(name);
        em.persist(skill);
    }

    /**
     * Gets a specific skill based on its id
     *
     * @param id the id of the skill you want to get
     * @return Returns the skill
     * @throws EJBException when the id could not be found
     */
    public SkillDetails getSkill(Integer id) throws EJBException {
        try {
            return em.find(Skill.class, id).detach();
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    /**
     * Edits a skill
     *
     * @param id the id of the skill to be edited
     * @param updatedName the new name of the skill
     * @throws EJBException when the id could not be found
     */
    public void updateSkill(Integer id, String updatedName) throws EJBException {
        try {
            Skill skill = em.find(Skill.class, id);
            skill.setName(updatedName);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
}
