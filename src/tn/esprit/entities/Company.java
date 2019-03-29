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
public final class Company implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    private User recruiter;

    /**
     * e User recruiter;
     */
    private String name;

    /**
     *
     */
    private String description;

    /**
     *
     */
    private String adress;

    /**
     *
     */
    private String domain;

    /**
     *
     */
    private String image;

    /**
     *
     */
    private String phone;

    /**
     *
     * @param recruiter
     * @param name
     * @param description
     * @param adress
     * @param domain
     * @param image
     * @param phone
     */
    private Company(User recruiter, String name, String description, String adress, String domain, String image, String phone) {
        this.recruiter = recruiter;
        this.name = name;
        this.description = description;
        this.adress = adress;
        this.domain = domain;
        this.image = image;
        this.phone = phone;
    }

    /**
     *
     */
    public static class Builder {

        /**
         *
         */
        private User recruiter;

        /**
         *
         */
        private String name;

        /**
         *
         */
        private String description;

        /**
         *
         */
        private String adress;

        /**
         *
         */
        private String domain;

        /**
         *
         */
        private String image;

        /**
         *
         */
        private String phone;

        /**
         *
         * @param recruiter
         * @return
         */
        public Builder recruiter(User recruiter) {
            this.recruiter = recruiter;
            return this;
        }

        /**
         *
         * @param name
         * @return
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         *
         * @param description
         * @return
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         *
         * @param adress
         * @return
         */
        public Builder adress(String adress) {
            this.adress = adress;
            return this;
        }

        /**
         *
         * @param domain
         * @return
         */
        public Builder domain(String domain) {
            this.domain = domain;
            return this;
        }

        /**
         *
         * @param image
         * @return
         */
        public Builder image(String image) {
            this.image = image;
            return this;
        }

        /**
         *
         * @param phone
         * @return
         */
        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        /**
         *
         */
        public Builder() {
        }

        /**
         *
         * @return
         */
        public Company build() {
            return new Company(
                    this.recruiter,
                    this.name,
                    this.description,
                    this.adress,
                    this.domain,
                    this.image,
                    this.phone);
        }

    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Company{" + "recruiter=" + recruiter.getUserName() + ", name=" + name + ", description=" + description + ", adress=" + adress + ", domain=" + domain + ", image=" + image + ", phone=" + phone + '}';
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.recruiter);
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
        final Company other = (Company) obj;
        return Objects.equals(this.recruiter, other.recruiter);
    }

    /**
     *
     * @return
     */
    public User getRecruiter() {
        return recruiter;
    }

    /**
     *
     * @param recruiter
     */
    public void setRecruiter(User recruiter) {
        this.recruiter = recruiter;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public String getAdress() {
        return adress;
    }

    /**
     *
     * @param adress
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     *
     * @return
     */
    public String getDomain() {
        return domain;
    }

    /**
     *
     * @param domain
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     *
     * @return
     */
    public String getImage() {
        return image;
    }

    /**
     *
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
