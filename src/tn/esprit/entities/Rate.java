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
 * @author mdsaadlaoui
 */
public final class Rate implements Serializable {

    private static final long serialVersionUID = 1L;
    private Job job;
    private User candidate;
    private Double note;
    private String feedback;

    private Rate(Job job, User candidate, Double note, String feedback) {
        this.job = job;
        this.candidate = candidate;
        this.note = note;
        this.feedback = feedback;
    }

    /**
     *
     */
    public static class Builder {

        private Job job;
        private User candidate;
        private Double note;
        private String feedback;

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
         * @param candidate
         * @return
         */
        public Builder candidate(User candidate) {
            this.candidate = candidate;
            return this;
        }

        /**
         *
         * @param note
         * @return
         */
        public Builder note(Double note) {
            this.note = note;
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
         * @return
         */
        public Rate build() {
            return new Rate(
                    this.job,
                    this.candidate,
                    this.note,
                    this.feedback);
        }

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
    public User getCandidate() {
        return candidate;
    }

    /**
     *
     * @param candidate
     */
    public void setCandidate(User candidate) {
        this.candidate = candidate;
    }

    /**
     *
     * @return
     */
    public Double getNote() {
        return note;
    }

    /**
     *
     * @param note
     */
    public void setNote(Double note) {
        this.note = note;
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
    @Override
    public String toString() {
        return "Rate{" + "job=" + job + ", candidate=" + candidate + ", note=" + note + ", feedback=" + feedback + '}';
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.job);
        hash = 23 * hash + Objects.hashCode(this.candidate);
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
        final Rate other = (Rate) obj;
        if (!Objects.equals(this.job, other.job)) {
            return false;
        }
        return Objects.equals(this.candidate, other.candidate);
    }

}
