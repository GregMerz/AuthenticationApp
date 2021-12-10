package com.hellowalnut.login.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String password;
    private String authorization;

    public User() {
    }

    public User(String username, String password, String authorization) {
        this.username = username;
        this.password = password;
        this.authorization = authorization;
    }

    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthorization() {
        return this.authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }
}
