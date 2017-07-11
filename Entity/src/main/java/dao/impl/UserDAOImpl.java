package main.java.dao.impl;

import main.java.dao.entity.User;
import main.java.dao.interfaces.UserDAO;
import main.java.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.swing.*;
import java.sql.SQLException;


public class UserDAOImpl implements UserDAO{
    public void addUser(User user) throws SQLException{
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            {
                if(session !=null && session.isOpen()){
                    session.close();
                }
            }
        }
    }
    public void updateUser(User user) throws SQLException{
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            {
                if(session !=null && session.isOpen()){
                    session.close();
                }
            }
        }
    }

    @Override
    public User getUserByName(String name) {
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM User WHERE name =:paramName");
            query.setParameter("paramName", name);
            user = (User) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
                    }
        return user;
    }

    public Long getUserIdByName(String name) {
        Long idUser = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("SELECT idUser FROM User WHERE name =:paramName");
            query.setParameter("paramName", name);
            idUser = (Long) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
                  }
        return idUser;
    }
    public User getUserById(long id) {
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM User WHERE idUser =:paramId");
            query.setParameter("paramId", id);
            user = (User) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void deleteUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
