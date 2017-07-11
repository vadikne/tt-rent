package main.java.dao.impl;

import main.java.dao.entity.TheTable;
import main.java.dao.interfaces.TheTableDAO;
import main.java.util.HibernateUtil;
import org.hibernate.Session;
import javax.swing.*;
import java.sql.SQLException;

public class TheTableDAOImpl implements TheTableDAO{

            public void addTheTable(TheTable theTable) throws SQLException {
            Session session = null;
            try{
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(theTable);
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
        public void updateTheTable(TheTable theTable) throws SQLException{
            Session session = null;
            try{
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.update(theTable);
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
        public void deleteTheTable(TheTable theTable) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                session.beginTransaction();
                session.delete(theTable);
                session.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
