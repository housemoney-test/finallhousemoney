package com.example.demo.entity;

import java.sql.Date;

public class Post{
    
    private int id;
    
    private int user_id;
    
    private String title;
    
    private String body;
    
    private Date created_at;
    
    private Date updated_at;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
    public Date getCreated_at() {
    	return created_at;
    }
    
    public void setCreated_at(Date created_at) {
    	this.created_at = created_at;
    }
    
    public Date getUpdated_at() {
    	return updated_at;
    }
    
    public void setUpdated_at(Date updated_at) {
    	this.updated_at = updated_at;
    }
}