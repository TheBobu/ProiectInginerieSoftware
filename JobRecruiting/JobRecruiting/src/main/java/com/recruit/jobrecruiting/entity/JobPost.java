/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.entity;

import com.recruit.jobrecruiting.common.JobPostDetails;
import com.recruit.jobrecruiting.util.Detachable;
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

    public JobPost() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;
    
    private String description;

    @ManyToMany
    @JoinTable(name = "JOBPOST_SKILL")
    private List<Skill> skills;

    private int noOfPositionsAvailable;
    
    private int noOfPositionsFilled = 0;

    @Enumerated(EnumType.STRING)
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POSTER_KEY")
    private User poster;

    @OneToMany(mappedBy = "jobPost")
    private Collection<Interview> interviewsForJobPost;
        
    @Enumerated(EnumType.STRING)
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
                skills,
                department,
                poster,
                status
        );
    }
}
