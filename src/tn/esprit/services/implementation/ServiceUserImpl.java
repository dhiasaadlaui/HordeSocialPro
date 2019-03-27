/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.implementation;

import java.util.List;
import java.util.Optional;
import javax.mail.MessagingException;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.dao.implementation.UserDaoImpl;
import tn.esprit.dao.interfaces.IUserDao;
import tn.esprit.entities.User;
import tn.esprit.entities.UserAccountStatus;
import tn.esprit.entities.UserRole;
import tn.esprit.gui.login.LanguageToolBar;
import tn.esprit.services.exceptions.ConstraintViolationException;
import tn.esprit.services.exceptions.ObjectNotFoundException;
import tn.esprit.services.interfaces.IServiceUser;
import tn.esprit.services.util.ServiceInputValidator;
import tn.esprit.services.util.ServiceMail;

/**
 *
 * @author Dhia
 */
public class ServiceUserImpl implements IServiceUser {

    /**
     *
     */
    IUserDao userDao;

    /**
     *
     */
    public ServiceUserImpl() {
        userDao = new UserDaoImpl();
      
    }

    /**
     *
     * @param identifier
     * @param password
     * @return
     * @throws ObjectNotFoundException
     */
    @Override
    public User authentication(String identifier, String password) throws ObjectNotFoundException {

        try {
            List<User> users = userDao.findAll();
            Optional<User> optional = users.stream()
                    .filter(e -> (e.getUserName().equals(identifier) || e.getEmail().equals(identifier)))
                    .filter(e -> e.getPassword().equals(password))
                    .findFirst();
            if (optional.isPresent()) {
                return optional.get();
            } else {
                throw new ObjectNotFoundException(LanguageToolBar.BUNDLE.getString("loginfail"));
            }
        } catch (DataBaseException ex) {
            throw new ObjectNotFoundException(ex.getMessage());
        }

    }

    /**
     *
     * @return @throws DataBaseException
     */
    @Override
    public List<User> findAll() throws DataBaseException {
        return userDao.findAll();
    }

    /**
     *
     * @param entity
     * @return
     * @throws DataBaseException
     */
    @Override
    public Integer create(User entity) throws DataBaseException {
        return userDao.create(entity);
    }

    /**
     *
     * @param entity
     * @return
     * @throws DataBaseException
     */
    @Override
    public Integer edit(User entity) throws DataBaseException {
        return userDao.edit(entity);
    }

    /**
     *
     * @param entity
     * @return
     * @throws DataBaseException
     */
    @Override
    public Integer delete(User entity) throws DataBaseException {
        return userDao.delete(entity);
    }

    /**
     *
     * @param id
     * @return
     * @throws ObjectNotFoundException
     */
    @Override
    public User findByID(Integer id) throws ObjectNotFoundException {

        try {
            return userDao.findByID(id);
        } catch (DataBaseException ex) {
            throw new ObjectNotFoundException(ex.getMessage());
        }

    }

    @Override
    public void signUp(User user) throws ConstraintViolationException {
        try {
            ServiceInputValidator.mail(user.getEmail());
            ServiceInputValidator.string(user.getFirstName());
            ServiceInputValidator.string(user.getLastName());
            user.setAccountStatus(UserAccountStatus.PENDING);
            user.setActivationCode(gnerateActivationCode(10));
            create(user);
            ServiceMail.sendMail(user.getEmail(), "SocialPro Account Activation",
                    "<body aria-readonly=\"false\"><span style=\"font-size:14px\">Hi&nbsp; "
                    + user.getFirstName()
                    + " "
                    + user.getLastName()
                    + ",&nbsp;<br />\n"
                    + "<br />\n"
                    + "Thanks for signing up to keep in touch with HordeSocialPro, "
                    + "after activating your account , "
                    + "you will get regular updates on fare jobs , "
                    + "and recruiters feedbacks about your applications on their posts.<br />\n"
                    + "<br />\n"
                    + "Here is your <strong>activation code</strong>: <span style=\"color:#FF0000\">"
                    + user.getActivationCode()
                    + "</span></span><br />\n"
                    + "<br />\n"
                    + "<br />\n"
                    + "<span style=\"font-size:11px\">Kind Regards,<br />\n"
                    + "HordeSocialPro Support Team<br />\n"
                    + "<br />\n"
                    + "Please do not reply to this message. Replies to this message are routed to an unmonitored mailbox. If you have any queries visit</span>&nbsp;<span style=\"font-size:9px\"><a href=\"https://github.com/dhiasaadlaui/HordeSocialPro\">https://github.com/dhiasaadlaui/HordeSocialPro</a>"
            );
        } catch (ConstraintViolationException | DataBaseException | MessagingException cvx) {
            throw new ConstraintViolationException(cvx.getMessage());

        }
    }

    @Override
    public void banUser(User user) throws ConstraintViolationException {

        try {
            user.setAccountStatus(UserAccountStatus.BANNED);
            edit(user);
        } catch (DataBaseException ex) {
            throw new ConstraintViolationException(ex.getMessage());
        }

    }

    @Override
    public void changeRole(User user, UserRole to) throws ConstraintViolationException {
        user.setAuthorization(to);

    }

    @Override
    public void accountActivation(User user, String code) throws ConstraintViolationException {
        if (user.getActivationCode().equals(code)) {
            user.setAccountStatus(UserAccountStatus.ACTIVATED);
            try {
                edit(user);
            } catch (DataBaseException ex) {
                throw new ConstraintViolationException(ex.getMessage());
            }
        } else {
            throw new ConstraintViolationException("Invalid code");
        }

    }

    private String gnerateActivationCode(int length) {

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {

            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

}
