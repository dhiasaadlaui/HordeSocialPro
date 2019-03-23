/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.entities;

import java.util.Objects;

/**
 *
 * @author Dhia
 */
public class Apply {

    /**
     *
     */
    private Job job;

    /**
     *
     */
    private User candidate;

    /**
     *
     */
    private String letter;

    /**
     *
     * @param job
     * @param candidate
     * @param letter
     */
    private Apply(Job job, User candidate, String letter) {
        this.job = job;
        this.candidate = candidate;
        this.letter = letter;
    }

    /**
     *
     */
    public static class Builder {

        /**
         *
         */
        private Job job;

        /**
         *
         */
        private User candidate;

        /**
         *
         */
        private String letter;

        /**
         *
         */
        public Builder() {

        }
        
        /**
         *
         * @param letter
         * @return
         */
        public Builder letter(String letter){
            this.letter=letter;
            return this;
        }

        /**
         *
         * @param candidate
         * @return
         */
        public Builder candidate(User candidate){
            this.candidate=candidate;
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
         * @return
         */
        public Apply build() {
            return new Apply(
                    this.job,
                    this.candidate,
                    this.letter);
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
    public String getLetter() {
        return letter;
    }

    /**
     *
     * @param letter
     */
    public void setLetter(String letter) {
        this.letter = letter;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.job);
        hash = 17 * hash + Objects.hashCode(this.candidate);
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
        final Apply other = (Apply) obj;
        if (!Objects.equals(this.job, other.job)) {
            return false;
        }
        if (!Objects.equals(this.candidate, other.candidate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Apply{" + "job id=" + job.getId() +", job title=" + job.getTitle() + ", candidate=" + candidate.getUserName() + ", letter=" + letter + '}';
    }

}
