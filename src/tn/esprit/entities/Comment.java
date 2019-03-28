/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.entities;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Dhia
 */
public class Comment implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private User user;

    /**
     *
     */
    private Job job;

    /**
     *
     */
    private String content;

    /**
     *
     * @param id
     * @param user
     * @param job
     * @param content
     */
    private Comment(Integer id, User user, Job job, String content) {
        this.id = id;
        this.user = user;
        this.job = job;
        this.content = content;
    }

    /**
     *
     */
    public static class Builder {

        /**
         *
         */
        private Integer id;

        /**
         *
         */
        private User user;

        /**
         *
         */
        private Job job;

        /**
         *
         */
        private String content;

        /**
         *
         */
        public Builder() {
        }
        
        /**
         *
         * @param id
         * @return
         */
        public Builder id(Integer id){
            this.id=id;
            return this;
        }

        /**
         *
         * @param user
         * @return
         */
        public Builder user(User user){
            this.user=user;
            return this;
        }

        /**
         *
         * @param job
         * @return
         */
        public Builder job(Job job){
            this.job=job;
            return this;
        }

        /**
         *
         * @param content
         * @return
         */
        public Builder content(String content){
            this.content=content;
            return this;
        }
        
        /**
         *
         * @return
         */
        public Comment build(){
            return new Comment(
                    this.id, 
                    this.user, 
                    this.job, 
                    this.content);
        }

        
        
        
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", user=" + user.getId()+ ", job id=" + job.getId() + ", content=" + content + '}';
    }

    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     * @return
     */
    public Job getJob() {
        return job;
    }

    /**
     *
     * @param job
     */
    public void setJob(Job job) {
        this.job = job;
    }

    /**
     *
     * @return
     */
    public String getContent() {
        return content;
    }

    /**
     *
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Comment other = (Comment) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
