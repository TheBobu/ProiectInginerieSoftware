/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.common;

import com.recruit.jobrecruiting.entity.Department;
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

    private List<SkillDetails> skills;

    private Department department;
    private User poster;
    private Status status;

    public JobPostDetails(Integer id, String title, String description, int noOfPositionsAvailable, int noOfPositionsFilled, List<SkillDetails> skills, Department department, User poster, Status status) {

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

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getNoOfPositionsAvailable() {
        return noOfPositionsAvailable;
    }

    public int getNoOfPositionsFilled() {
        return noOfPositionsFilled;
    }

    public List<SkillDetails> getSkills() {
        return skills;
    }

    public Department getDepartment() {
        return department;
    }

    public User getPoster() {
        return poster;
    }

    public Status getStatus() {
        return status;
    }

}
