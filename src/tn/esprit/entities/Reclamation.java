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
public final class Reclamation implements Serializable{

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
    private String type;

    /**
     *
     */
    private String details;

    /**
     *
     */
    private Job job;

    /**
     *
     */
    private Comment comment;

    /**
     *
     */
    private User claimer;

    /**
     *
     */
    private User staff;

    /**
     *
     */
    private String feedback;

    /**
     *
     */
    private String status;

    /**
     *
     * @param id
     * @param type
     * @param details
     * @param job
     * @param comment
     * @param claimer
     * @param staff
     * @param feedback
     * @param status
     */
    private Reclamation(Integer id, String type, String details, Job job, Comment comment, User claimer, User staff, String feedback, String status) {
        this.id = id;
        this.type = type;
        this.details = details;
        this.job = job;
        this.comment = comment;
        this.claimer = claimer; 
        this.staff = staff;
        this.feedback = feedback;
        this.status = status;
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
        private String type;

        /**
         *
         */
        private String details;

        /**
         *
         */
        private Job job;

        /**
         *
         */
        private Comment comment;

        /**
         *
         */
        private User claimer;

        /**
         *
         */
        private User staff;

        /**
         *
         */
        private String feedback;

        /**
         *
         */
        private String status;

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
        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        /**
         *
         * @param type
         * @return
         */
        public Builder type(ReclamationType type) {
            this.type = type.name();
            return this;
        }

        /**
         *
         * @param details
         * @return
         */
        public Builder details(String details) {
            this.details = details;
            return this;
        }

        /**
         *
         * @param job
         * @return
         */
        public Builder job(Job job) {
            this.job = job;
            return this;
        }

        /**
         *
         * @param comment
         * @return
         */
        public Builder comment(Comment comment) {
            this.comment = comment;
            return this;
        }

        /**
         *
         * @param claimer
         * @return
         */
        public Builder claimer(User claimer) {
            this.claimer = claimer;
            return this;
        }

        /**
         *
         * @param staff
         * @return
         */
        public Builder staff(User staff) {
            this.staff = staff;
            return this;
        }

        /**
         *
         * @param feedback
         * @return
         */
        public Builder feedback(String feedback) {
            this.feedback = feedback;
            return this;
        }

        /**
         *
         * @param status
         * @return
         */
        public Builder status(ReclamationStatus status) {
            this.status = status.name();
            return this;
        }

        /**
         *
         * @return
         */
        public Reclamation build() {
            return new Reclamation(
                    this.id,
                    this.type,
                    this.details,
                    this.job,
                    this.comment,
                    this.claimer,
                    this.staff,
                    this.feedback,
                    this.status);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", type=" + type + ", details=" + details + ", job=" + job + ", comment=" + comment + ", claimer=" + claimer + ", staff=" + staff + ", feedback=" + feedback + ", status=" + status + '}';
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
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(ReclamationType type) {
        this.type = type.name();
    }

    /**
     *
     * @return
     */
    public String getDetails() {
        return details;
    }

    /**
     *
     * @param details
     */
    public void setDetails(String details) {
        this.details = details;
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
    public Comment getComment() {
        return comment;
    }

    /**
     *
     * @param comment
     */
    public void setComment(Comment comment) {
        this.comment = comment;
    }

    /**
     *
     * @return
     */
    public User getClaimer() {
        return claimer;
    }

    /**
     *
     * @param claimer
     */
    public void setClaimer(User claimer) {
        this.claimer = claimer;
    }

    /**
     *
     * @return
     */
    public User getStaff() {
        return staff;
    }

    /**
     *
     * @param staff
     */
    public void setStaff(User staff) {
        this.staff = staff;
    }

    /**
     *
     * @return
     */
    public String getFeedback() {
        return feedback;
    }

    /**
     *
     * @param feedback
     */
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    /**
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(ReclamationStatus status) {
        this.status = status.name();
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
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
        final Reclamation other = (Reclamation) obj;
        return Objects.equals(this.id, other.id);
    }

}
