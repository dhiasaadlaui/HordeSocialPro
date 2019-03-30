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
public final class User implements Serializable {

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
    private String firstName;

    /**
     *
     */
    private String lastName;

    /**
     *
     */
    private String userName;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private String email;

    /**
     *
     */
    private String adress;

    /**
     *
     */
    private String authorization;

    /**
     *
     */
    private String photo;

    /**
     *
     */
    private String accountStatus;

    /**
     *
     */
    private String activationCode;

    /**
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param userName
     * @param password
     * @param email
     * @param adress
     * @param authorization
     * @param photo
     * @param accountStatus
     * @param activationCode
     */
    private User(Integer id, String firstName, String lastName, String userName, String password, String email, String adress, String authorization, String photo, String accountStatus, String activationCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.adress = adress;
        this.authorization = authorization;
        this.photo = photo;
        this.accountStatus = accountStatus;
        this.activationCode = activationCode;
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
        private String firstName;

        /**
         *
         */
        private String lastName;

        /**
         *
         */
        private String userName;

        /**
         *
         */
        private String password;

        /**
         *
         */
        private String email;

        /**
         *
         */
        private String adress;

        /**
         *
         */
        private String authorization;

        /**
         *
         */
        private String photo;

        /**
         *
         */
        private String accountStatus;

        /**
         *
         */
        private String activationCode;

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
         * @param firstName
         * @return
         */
        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        /**
         *
         * @param lastName
         * @return
         */
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        /**
         *
         * @param userName
         * @return
         */
        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        /**
         *
         * @param password
         * @return
         */
        public Builder password(String password) {
            this.password = password;
            return this;
        }

        /**
         *
         * @param email
         * @return
         */
        public Builder email(String email) {
            this.email = email;
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
         * @param authorization
         * @return
         */
        public Builder authorization(UserRole authorization) {
            this.authorization = authorization.name();
            return this;
        }

        /**
         *
         * @param photo
         * @return
         */
        public Builder photo(String photo) {
            this.photo = photo;
            return this;
        }

        /**
         *
         * @param activationCode
         * @return
         */
        public Builder activationCode(String activationCode) {
            this.activationCode = activationCode;
            return this;
        }

        /**
         *
         * @param accountStatus
         * @return
         */
        public Builder accountStatus(UserAccountStatus accountStatus) {
            this.accountStatus = accountStatus.name();
            return this;
        }

        /**
         *
         * @return
         */
        public User build() {
            return new User(
                    this.id,
                    this.firstName,
                    this.lastName,
                    this.userName,
                    this.password,
                    this.email,
                    this.adress,
                    this.authorization,
                    this.photo,
                    this.accountStatus,
                    this.activationCode
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
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
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
    public String getAuthorization() {
        return authorization;
    }

    /**
     *
     * @param authorization
     */
    public void setAuthorization(UserRole authorization) {
        this.authorization = authorization.name();
    }

    /**
     *
     * @return
     */
    public String getPhoto() {
        return photo;
    }

    /**
     *
     * @param photo
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     *
     * @return
     */
    public String getActivationCode() {
        return activationCode;
    }

    /**
     *
     * @param activationCode
     */
    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    /**
     *
     * @return
     */
    public String getAccountStatus() {
        return accountStatus;
    }

    /**
     *
     * @param accountStatus
     */
    public void setAccountStatus(UserAccountStatus accountStatus) {
        this.accountStatus = accountStatus.name();
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password=" + password + ", email=" + email + ", adress=" + adress + ", authorization=" + authorization + ", photo=" + photo + ", accountStatus=" + accountStatus + ", activationCode=" + activationCode + '}';
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final User other = (User) obj;
        return Objects.equals(this.id, other.id);
    }

}
