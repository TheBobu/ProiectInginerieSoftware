/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The model of a department.
 *
 * @author robert
 */
@Entity
@Table(name = "DEPARTMENTS")
public class Department implements Serializable {

    @OneToMany(mappedBy = "department")
    private List<JobPost> jobPosts;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @JsonbTransient
    @OneToMany(mappedBy = "department")
    private Collection<Employee> employees;

    @JsonbTransient
    @OneToMany(mappedBy = "department")
    private Collection<JobPost> JobPost;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }

// uncomment after JobPost entity is created by Denisa
//    public Collection<JobPost> getJobPost() {
//        return JobPost;
//    }
//
//    public void setJobPost(Collection<JobPost> JobPost) {
//        this.JobPost = JobPost;
//    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Objects.hashCode(this.employees);
//        hash = 23 * hash + Objects.hashCode(this.JobPost);
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
        final Department other = (Department) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.employees, other.employees)) {
            return false;
        }
//        if (!Objects.equals(this.JobPost, other.JobPost)) {
//            return false;
//        }
        return true;
    }

    // uncomment after JobPost entity is created by Denisa
//    @Override
//    public String toString() {
//        return "Department{" + "id=" + id + ", name=" + name + ", employees=" + employees + ", JobPost=" + JobPost + '}';
//    }
}
