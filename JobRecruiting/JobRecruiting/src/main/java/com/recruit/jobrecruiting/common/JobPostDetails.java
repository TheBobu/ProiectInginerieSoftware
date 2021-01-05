/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.common;

import com.recruit.jobrecruiting.entity.Department;
import com.recruit.jobrecruiting.entity.Skill;
import com.recruit.jobrecruiting.entity.Status;
import com.recruit.jobrecruiting.entity.User;
import java.util.List;

/**
 *
 * @author DENISA
 */
public class JobPostDetails {

    private Integer id;
    private String title;
    private String description;
    private int noOfPositionsAvailable;
    private int noOfPositionsFilled;

    private List<Skill> skills;

    private Department department;
    private User poster;
    private Status status;

    public JobPostDetails(Integer id, String title, String description, int noOfPositionsAvailable, int noOfPositionsFilled, List<Skill> skills, Department department, User poster, Status status) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.noOfPositionsAvailable = noOfPositionsAvailable;
        this.noOfPositionsFilled = noOfPositionsFilled;
        this.skills = skills;
        this.department = department;
        this.poster = poster;
        this.status = status;
    }

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

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public User getPoster() {
        return poster;
    }

    public void setPoster(User poster) {
        this.poster = poster;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
