package util;

import dao.impl.TheTableDAOImpl;
import dao.impl.UserDAOImpl;
import dao.interfaces.TheTableDAO;
import dao.interfaces.UserDAO;

public class Factory {

    private static UserDAO userDAO = null;
    private static TheTableDAO theTableDAO = null;

    private static Factory instance = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public UserDAO getUserDAO() {
        if (userDAO == null) {
            userDAO = new UserDAOImpl();
        }
        return userDAO;
    }

    public TheTableDAO getTheTableDAO() {
        if (theTableDAO == null) {
            theTableDAO = new TheTableDAOImpl();
        }
        return theTableDAO;
    }
}
