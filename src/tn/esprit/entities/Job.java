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
 * @author Dhia
 */
public final class Job implements Serializable {

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
    private Company company;

    /**
     *
     */
    private String title;

    /**
     *
     */
    private String description;

    /**
     *
     */
    private Category category;

    /**
     *
     */
    private String location;

    /**
     *
     */
    private Date creationDate;

    /**
     *
     */
    private Date expireDate;

    /**
     *
     */
    private Double salary;

    /**
     *
     */
    private String status;

    /**
     *
     * @param id
     * @param company
     * @param title
     * @param description
     * @param category
     * @param location
     * @param creationDate
     * @param expireDate
     * @param salary
     * @param status
     */
    private Job(Integer id, Company company, String title, String description, Category category, String location, Date creationDate, Date expireDate, Double salary, String status) {
        this.id = id;
        this.company = company;
        this.title = title;
        this.description = description;
        this.category = category;
        this.location = location;
        this.creationDate = creationDate;
        this.expireDate = expireDate;
        this.salary = salary;
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
        private Company company;

        /**
         *
         */
        private String title;

        /**
         *
         */
        private String description;

        /**
         *
         */
        private Category category;

        /**
         *
         */
        private String location;

        /**
         *
         */
        private Date creationDate;

        /**
         *
         */
        private Date expireDate;

        /**
         *
         */
        private Double salary;

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
         * @param company
         * @return
         */
        public Builder company(Company company) {
            this.company = company;
            return this;
        }

        /**
         *
         * @param title
         * @return
         */
        public Builder title(String title) {
            this.title = title;
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
         * @param category
         * @return
         */
        public Builder category(Category category) {
            this.category = category;
            return this;
        }

        /**
         *
         * @param location
         * @return
         */
        public Builder location(String location) {
            this.location = location;
            return this;
        }

        /**
         *
         * @param creationDate
         * @return
         */
        public Builder creationDate(Date creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        /**
         *
         * @param expireDate
         * @return
         */
        public Builder expireDate(Date expireDate) {
            this.expireDate = expireDate;
            return this;
        }

        /**
         *
         * @param salary
         * @return
         */
        public Builder salary(Double salary) {
            this.salary = salary;
            return this;
        }

        /**
         *
         * @param status
         * @return
         */
        public Builder status(JobStatus status) {
            this.status = status.name();
            return this;
        }

        /**
         *
         * @return
         */
        public Job build() {
            return new Job(
                    id,
                    company,
                    title,
                    description,
                    category,
                    location,
                    creationDate,
                    expireDate,
                    salary,
                    status);
        }
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
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
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
    public Category getCategory() {
        return category;
    }

    /**
     *
     * @param category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     *
     * @return
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     *
     * @return
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     *
     * @param creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     *
     * @return
     */
    public Date getExpireDate() {
        return expireDate;
    }

    /**
     *
     * @param expireDate
     */
    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    /**
     *
     * @return
     */
    public Double getSalary() {
        return salary;
    }

    /**
     *
     * @param salary
     */
    public void setSalary(Double salary) {
        this.salary = salary;
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
    public void setStatus(JobStatus status) {
        this.status = status.name();
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Job other = (Job) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Job{" + "id=" + id + ", company=" + company.getName() + ", title=" + title + ", description=" + description + ", category=" + category.getLabel() + ", location=" + location + ", creationDate=" + creationDate + ", expireDate=" + expireDate + ", salary=" + salary + ", status=" + status + '}';
    }

}
