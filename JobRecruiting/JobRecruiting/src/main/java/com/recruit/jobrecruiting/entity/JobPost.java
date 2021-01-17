/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.entity;

import com.recruit.jobrecruiting.common.JobPostDetails;
import com.recruit.jobrecruiting.util.Detachable;
import com.recruit.jobrecruiting.util.Util;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The model for a JobPost.
 *
 * @author denisa
 * @author robert
 */
@Entity
@Table(name = "JOBPOSTS")

public class JobPost implements Serializable, Detachable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "JOBPOST_SKILL")
    private List<Skill> skills;

    private int noOfPositionsAvailable;

    private int noOfPositionsFilled = 0;

    @Enumerated(EnumType.STRING)
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POSTER_KEY")
    private User poster;

    @JsonbTransient
    @OneToMany(mappedBy = "jobPost")
    private Collection<Interview> interviewsForJobPost;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Type type;

    private int salary;

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

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
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

    public Collection<Interview> getInterviewsForJobPost() {
        return interviewsForJobPost;
    }

    public void setInterviewsForJobPost(Collection<Interview> interviewsForJobPost) {
        this.interviewsForJobPost = interviewsForJobPost;
    }

    public Status getStatus() {
        return status;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.title);
        hash = 47 * hash + Objects.hashCode(this.description);
        hash = 47 * hash + Objects.hashCode(this.skills);
        hash = 47 * hash + this.noOfPositionsAvailable;
        hash = 47 * hash + this.noOfPositionsFilled;
        hash = 47 * hash + Objects.hashCode(this.department);
        hash = 47 * hash + Objects.hashCode(this.poster);
        hash = 47 * hash + Objects.hashCode(this.interviewsForJobPost);
        hash = 47 * hash + Objects.hashCode(this.status);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JobPost other = (JobPost) obj;
        if (this.noOfPositionsAvailable != other.noOfPositionsAvailable) {
            return false;
        }
        if (this.noOfPositionsFilled != other.noOfPositionsFilled) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.skills, other.skills)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.department != other.department) {
            return false;
        }
        if (!Objects.equals(this.poster, other.poster)) {
            return false;
        }
        if (!Objects.equals(this.interviewsForJobPost, other.interviewsForJobPost)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JobPost{" + "id=" + id + ", title=" + title + ", description=" + description + ", skills=" + skills + ", noOfPositionsAvailable=" + noOfPositionsAvailable + ", noOfPositionsFilled=" + noOfPositionsFilled + ", department=" + department + ", poster=" + poster + ", interviewsForJobPost=" + interviewsForJobPost + ", status=" + status + '}';
    }

    @Override
    public JobPostDetails detach() {
        return new JobPostDetails(
                id,
                title,
                description,
                noOfPositionsAvailable,
                noOfPositionsFilled,
                Util.detachEntities(skills),
                department,
                poster,
                status,
                type,
                salary
        );
    }

    public JobPost copy() {
        JobPost jobPost = new JobPost();

        jobPost.setTitle(title);
        jobPost.setDescription(description);
        jobPost.setDepartment(department);
        jobPost.setNoOfPositionsFilled(0);
        jobPost.setNoOfPositionsAvailable(noOfPositionsAvailable);
        jobPost.setType(type);
        jobPost.setSalary(salary);
        jobPost.setSkills(skills);

        return jobPost;
    }
}
