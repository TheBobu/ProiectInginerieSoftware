/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.common;

import java.util.Date;

/**
 *
 * @author Deea
 */
public class CommentDetails implements java.io.Serializable {
    private Integer id;
    private String username;
    private String comment;
    private Date date;
    
    public CommentDetails (Integer id, String username, String comment, Date date){
        this.id = id;
        this.username = username;
        this.comment = comment;
        this.date = date;
    }

    public CommentDetails() {
    }

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
