/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * // TODO: To be created by Denisa
 *
 */
@Entity
@Table(name = "JOBPOSTS")
public class JobPost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;
    private String description;

    @ManyToMany
    @JoinTable(name = "JOBPOST_SKILL")
    private List<Skill> skills;

    private int noOfPositionsAvailable;
    private int noOfPositionsFilled;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTMENT_KEY")
    private Department department;

    @OneToMany(mappedBy = "jobPost")
    private List<Interview> interviews;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POSTER_KEY")
    private Employee poster;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INTERVIEWER_KEY")
    private Employee interviwer;

    private Status status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public int getNoOfPositionsAvailable() {
        return noOfPositionsAvailable;
    }

    public void setNoOfPositionsAvailable(int noOfPositionsAvailable) {
        this.noOfPositionsAvailable = noOfPositionsAvailable;
    }

    public int getNoOfPositionsFilled() {
        return noOfPositionsFilled;
    }

    public void setNoOfPositionsFilled(int noOfPositionsFilled) {
        this.noOfPositionsFilled = noOfPositionsFilled;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Interview> getInterviews() {
        return interviews;
    }

    public void setInterviews(List<Interview> interviews) {
        this.interviews = interviews;
    }

    public Employee getPoster() {
        return poster;
    }

    public void setPoster(Employee poster) {
        this.poster = poster;
    }

    public Employee getInterviwer() {
        return interviwer;
    }

    public void setInterviwer(Employee interviwer) {
        this.interviwer = interviwer;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
