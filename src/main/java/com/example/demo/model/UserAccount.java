package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="testtable")
public class UserAccount {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer col1;
    
    private String col2;
    
    public Integer getCol1() {
    	return col1;
    }

    public void setCol1(Integer col1) {
    	this.col1 = col1;
    }

    public String getCol2() {
    	return col2;
    }

    public void setCol2(String col2) {
    	this.col2 = col2;
    }
}
