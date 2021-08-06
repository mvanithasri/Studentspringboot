package com.kgisl.studentspringboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long studid;
    public String name;
    public String city;
    public String department;
    public String gender;

    
    /**
     * @return the teamid
     */
    public Long getStudid() {
        return studid;
    }

    /**
     * @param teamid the teamid to set
     */
    public void setStudid(Long studid) {
        this.studid = studid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getDepartment(){
        return department;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }


    

   
    
}
