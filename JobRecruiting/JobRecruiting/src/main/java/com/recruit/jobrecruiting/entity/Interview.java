/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The model of an interview
 *
 * @author robert
 */
@Entity
@Table(name = "INTERVIEWS")
public class Interview implements Serializable {

    private static final long serialVersionUID = 1L;

    public Interview() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOBPOST_KEY")
    private JobPost jobPost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CANDIDATE_KEY")
    private User candidate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INTERVIEWER_KEY")
    private User interviewer;

    private LocalDateTime dateTime;

    private String place;

    @Enumerated(EnumType.STRING)
    private InterviewStatus status;

    @OneToMany(mappedBy = "interview", fetch = FetchType.LAZY)
    private Collection<Comment> comments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JobPost getJobPost() {
        return jobPost;
    }

    public void setJobPost(JobPost jobPost) {
        this.jobPost = jobPost;
    }

    public User getCandidate() {
        return candidate;
    }

    public void setCandidate(User candidate) {
        this.candidate = candidate;
    }

    public User getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(User interviewer) {
        this.interviewer = interviewer;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public InterviewStatus getStatus() {
        return status;
    }

    public void setStatus(InterviewStatus status) {
        this.status = status;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }
    
    public LocalDate getDate (){
        return this.dateTime.toLocalDate();
    }
    
    public LocalTime getTime (){
        return this.dateTime.toLocalTime();
    }
    
    public Boolean checkAfterInterview(){
        if((this.status==InterviewStatus.BEFORE_INTERVIEW) && (LocalDate.now().isAfter(this.getDate())))
            return Boolean.TRUE;
        return Boolean.FALSE;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.jobPost);
        hash = 29 * hash + Objects.hashCode(this.candidate);
        hash = 29 * hash + Objects.hashCode(this.interviewer);
        hash = 29 * hash + Objects.hashCode(this.dateTime);
        hash = 29 * hash + Objects.hashCode(this.place);
        hash = 29 * hash + Objects.hashCode(this.status);
        hash = 29 * hash + Objects.hashCode(this.comments);
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
        final Interview other = (Interview) obj;
        if (!Objects.equals(this.place, other.place)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.jobPost, other.jobPost)) {
            return false;
        }
        if (!Objects.equals(this.candidate, other.candidate)) {
            return false;
        }
        if (!Objects.equals(this.interviewer, other.interviewer)) {
            return false;
        }
        if (!Objects.equals(this.dateTime, other.dateTime)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.comments, other.comments)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Interview{" + "id=" + id + ", jobPost=" + jobPost + ", candidate=" + candidate + ", interviewer=" + interviewer + ", dateTime=" + dateTime + ", place=" + place + ", status=" + status + ", comments=" + comments + '}';
    }
}
