/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.common;

import com.recruit.jobrecruiting.entity.Department;
import com.recruit.jobrecruiting.entity.Status;
import com.recruit.jobrecruiting.entity.Type;
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
    private Type type;
    private int salary;

    public JobPostDetails(Integer id, String title, String description, int noOfPositionsAvailable, int noOfPositionsFilled, List<SkillDetails> skills, Department department, User poster, Status status, Type type, int salary) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.noOfPositionsAvailable = noOfPositionsAvailable;
        this.noOfPositionsFilled = noOfPositionsFilled;
        this.skills = skills;
        this.department = department;
        this.poster = poster;
        this.status = status;
        this.type = type;
        this.salary = salary;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNoOfPositionsAvailable(int noOfPositionsAvailable) {
        this.noOfPositionsAvailable = noOfPositionsAvailable;
    }

    public void setNoOfPositionsFilled(int noOfPositionsFilled) {
        this.noOfPositionsFilled = noOfPositionsFilled;
    }

    public void setSkills(List<SkillDetails> skills) {
        this.skills = skills;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setPoster(User poster) {
        this.poster = poster;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getjobCode() {
        return department.toString() + "_" + type.getAbbreviation() + "_" + id;
    }
}
