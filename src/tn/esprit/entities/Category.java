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
public final class Category implements Serializable {

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
    private String label;

    /**
     *
     */
    private String description;

    /**
     *
     */
    private User moderator;

    /**
     *
     * @param id
     * @param label
     * @param description
     * @param moderator
     */
    private Category(Integer id, String label, String description, User moderator) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.moderator = moderator;
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
        private String label;

        /**
         *
         */
        private String description;

        /**
         *
         */
        private User moderator;

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
         * @param label
         * @return
         */
        public Builder label(String label) {
            this.label = label;
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
         * @param moderator
         * @return
         */
        public Builder moderator(User moderator) {
            this.moderator = moderator;
            return this;
        }

        /**
         *
         * @return
         */
        public Category build() {
            return new Category(
                    this.id,
                    this.label,
                    this.description,
                    this.moderator
            );

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
    public String getLabel() {
        return label;
    }

    /**
     *
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
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
    public User getModerator() {
        return moderator;
    }

    /**
     *
     * @param moderator
     */
    public void setModerator(User moderator) {
        this.moderator = moderator;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", label=" + label + ", description=" + description + ", moderator=" + moderator.getUserName() + '}';
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Category other = (Category) obj;
        return Objects.equals(this.id, other.id);
    }

}
