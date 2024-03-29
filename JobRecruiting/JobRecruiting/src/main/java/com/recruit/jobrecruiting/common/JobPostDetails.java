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
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author DENISA
 */
public class JobPostDetails {

    private Integer id;
    private String title;
    private String requirements;
    private String responsabilities;
    private int noOfPositionsAvailable;
    private int noOfPositionsFilled;

    private List<SkillDetails> skills;

    private Department department;
    private User poster;
    private Status status;
    private Type type;
    private int salary;

    public JobPostDetails(Integer id, String title, String requirements, String responsabilities, int noOfPositionsAvailable, int noOfPositionsFilled, List<SkillDetails> skills, Department department, User poster, Status status, Type type, int salary) {
        this.id = id;
        this.title = title;
        this.requirements = requirements;
        this.responsabilities = responsabilities;
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

    public boolean statusShouldBeEditable() {
        return status != Status.WAITING_FOR_APPROVAL;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getResponsabilities() {
        return responsabilities;
    }

    public void setResponsabilities(String responsabilities) {
        this.responsabilities = responsabilities;
    }

    public List<String> bullets(String string) {
        return Arrays.asList(string.split("~"));
    }

    public boolean isAppliable(String username) {
        return status == Status.ACTIVE && !poster.getUsername().equals(username);
    }

}
