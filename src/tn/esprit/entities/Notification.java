/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Mehdi Sarray
 */
public final class Notification implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
     /**
     *
     */
    private Integer id;
    
    /**
     *
     */
    private Company company;
    
    /**
     *
     */
    private Integer is_read;
    
    /**
     *
     */
    private LocalDateTime date;
    
    /**
     *
     */
    private Job job;
    
     /**
     *
     * @param id
     * @param Company
     * @param is_read
     * @param date
     * @param job
     */
    
    
    private Notification(Integer id, Company company, Integer is_read, LocalDateTime date, Job job) {
        this.id = id;
        this.company = company;
        this.is_read = is_read;
        this.date = date;
        this.job = job;
    }
    
    public static class Builder { 
        
    /**
     *
     */
     private Integer id;
    
    /**
     *
     */
    private Company company;
    
    /**
     *
     */
    private Integer is_read;
    
    /**
     *
     */
    private LocalDateTime date;
    
    /**
     *
     */
    private Job job;
    
    
    public Builder() {
        }
    
         /**
         *
         * @param id
         * @return
         */
        public Builder id(Integer id) {
            this.id = id;
            return this;
        }
        
        public Builder company(Company company) {
            this.company = company;
            return this;
        }
        
        public Builder is_read(Integer is_read) {
            this.is_read = is_read;
            return this;
        }
        
        public Builder date(LocalDateTime date) {
            this.date = date;
            return this;
        }
        
        public Builder job(Job job) {
            this.job = job;
            return this;
        }
        
        /**
         *
         * @return
         */
        public Notification build() {
            return new Notification(
                    this.id,
                    this.company,
                    this.is_read,
                    this.date,
                    this.job);
        }
    }

    @Override
    public String toString() {
        return "notification{" + "id=" + id + ", company=" + company + ", is_read=" + is_read + ", date=" + date + ", job=" + job + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Integer getIs_read() {
        return is_read;
    }

    public void setIs_read(Integer is_read) {
        this.is_read = is_read;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
    
    
}
