/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author mdsaadlaoui
 */
public final class Abonnement implements Serializable {

    private static final long serialVersionUID = 1L;
    private Company company;
    private User candidate;
    private Date dateAbonnement;

    /**
     *
     */
    public static class Builder {

        private Company company;
        private User candidate;
        private Date dateAbonnement;

        /**
         *
         * @param company
         * @return
         */
        public Builder company(Company company) {
            this.company = company;
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
         * @param dateAbonnement
         * @return
         */
        public Builder dateAbonnement(Date dateAbonnement) {
            this.dateAbonnement = dateAbonnement;
            return this;
        }

        /**
         *
         * @return
         */
        public Abonnement build() {
            return new Abonnement(
                    this.company,
                    this.candidate,
                    this.dateAbonnement);
        }

    }

    private Abonnement(Company company, User candidate, Date dateAbonnement) {
        this.company = company;
        this.candidate = candidate;
        this.dateAbonnement = dateAbonnement;

    }

    /**
     *
     * @return
     */
    public Company getCompany() {
        return company;
    }

    /**
     *
     * @param company
     */
    public void setCompany(Company company) {
        this.company = company;
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
    public Date getDateAbonnement() {
        return dateAbonnement;
    }

    /**
     *
     * @param dateAbonnement
     */
    public void setDateAbonnement(Date dateAbonnement) {
        this.dateAbonnement = dateAbonnement;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Abonnement{" + "company=" + company + ", candidate=" + candidate + ", dateAbonnement=" + dateAbonnement + '}';
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.company);
        hash = 97 * hash + Objects.hashCode(this.candidate);
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
        final Abonnement other = (Abonnement) obj;
        if (!Objects.equals(this.company, other.company)) {
            return false;
        }
        return Objects.equals(this.candidate, other.candidate);
    }

}
