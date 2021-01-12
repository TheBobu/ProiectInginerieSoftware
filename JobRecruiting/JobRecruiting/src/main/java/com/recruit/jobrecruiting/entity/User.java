/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.entity;

import com.recruit.jobrecruiting.common.UserDetails;
import com.recruit.jobrecruiting.util.Detachable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The model for an user.
 *
 * @author andrei
 * @author robert
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable, Detachable {
    
    private static final long serialVersionUID = 1L;

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;

    private String email;

    private String password;

    private LocalDate birthDate;

    private String firstName;

    private String lastName;

    private String address;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Photo profilePhoto;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Photo cv;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Position position;

    @Enumerated(EnumType.STRING)
    private Department department;

    @JsonbTransient
    @OneToMany(mappedBy = "candidate")
    private Collection<Interview> interviewsAsCandidate;

    @JsonbTransient
    @OneToMany(mappedBy = "interviewer")
    private Collection<Interview> interviewsAsInterviewer;

    @JsonbTransient
    @OneToMany(mappedBy = "poster")
    private Collection<JobPost> jobPostsAsPoster;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Photo getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(Photo profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public Photo getCv() {
        return cv;
    }

    public void setCv(Photo cv) {
        this.cv = cv;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Collection<Interview> getInterviewsAsCandidate() {
        return interviewsAsCandidate;
    }

    public void setInterviewsAsCandidate(Collection<Interview> interviewsAsCandidate) {
        this.interviewsAsCandidate = interviewsAsCandidate;
    }

    public Collection<Interview> getInterviewsAsInterviewer() {
        return interviewsAsInterviewer;
    }

    public void setInterviewsAsInterviewer(Collection<Interview> interviewsAsInterviewer) {
        this.interviewsAsInterviewer = interviewsAsInterviewer;
    }

    public Collection<JobPost> getJobPostsAsPoster() {
        return jobPostsAsPoster;
    }

    public void setJobPostsAsPoster(Collection<JobPost> jobPostsAsPoster) {
        this.jobPostsAsPoster = jobPostsAsPoster;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
        hash = 11 * hash + Objects.hashCode(this.username);
        hash = 11 * hash + Objects.hashCode(this.email);
        hash = 11 * hash + Objects.hashCode(this.password);
        hash = 11 * hash + Objects.hashCode(this.birthDate);
        hash = 11 * hash + Objects.hashCode(this.firstName);
        hash = 11 * hash + Objects.hashCode(this.lastName);
        hash = 11 * hash + Objects.hashCode(this.address);
        hash = 11 * hash + Objects.hashCode(this.profilePhoto);
        hash = 11 * hash + Objects.hashCode(this.cv);
        hash = 11 * hash + Objects.hashCode(this.status);
        hash = 11 * hash + Objects.hashCode(this.position);
        hash = 11 * hash + Objects.hashCode(this.department);
        hash = 11 * hash + Objects.hashCode(this.interviewsAsCandidate);
        hash = 11 * hash + Objects.hashCode(this.interviewsAsInterviewer);
        hash = 11 * hash + Objects.hashCode(this.jobPostsAsPoster);
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
        final User other = (User) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.birthDate, other.birthDate)) {
            return false;
        }
        if (!Objects.equals(this.profilePhoto, other.profilePhoto)) {
            return false;
        }
        if (!Objects.equals(this.cv, other.cv)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (this.position != other.position) {
            return false;
        }
        if (this.department != other.department) {
            return false;
        }
        if (!Objects.equals(this.interviewsAsCandidate, other.interviewsAsCandidate)) {
            return false;
        }
        if (!Objects.equals(this.interviewsAsInterviewer, other.interviewsAsInterviewer)) {
            return false;
        }
        if (!Objects.equals(this.jobPostsAsPoster, other.jobPostsAsPoster)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", birthDate=" + birthDate + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", profilePhoto=" + profilePhoto + ", cv=" + cv + ", status=" + status + ", position=" + position + ", department=" + department + ", interviewsAsCandidate=" + interviewsAsCandidate + ", interviewsAsInterviewer=" + interviewsAsInterviewer + ", jobPostsAsPoster=" + jobPostsAsPoster + '}';
    }
    
    @Override
    public UserDetails detach() {
        return new UserDetails();
    }
}
