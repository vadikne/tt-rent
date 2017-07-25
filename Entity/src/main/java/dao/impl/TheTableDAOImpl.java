package dao.impl;

import dao.entity.TheTable;
import dao.interfaces.TheTableDAO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import util.HibernateSessionFactory;
import util.HibernateUtil;

import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TheTableDAOImpl implements TheTableDAO{

    private int number;
    private Date date;

    public void addTheTable(TheTable theTable) throws SQLException {
            Session session = null;
          try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(theTable);
                session.getTransaction().commit();
          }catch(Exception e){
              System.out.println( "waited err");
              JOptionPane.showMessageDialog(null,e.getMessage(),"Ошибка I/O- -1", JOptionPane.OK_OPTION);
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

    @Override
    public List<TheTable> getThetablesByNumberOfTable(int number, Date date) throws SQLException {
        // List<TheTable> tableList = new ArrayList<TheTable>();
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()){
            //tableList = session.createFilter("num", Integer.toString(number)).list();
            Criteria criteria = session.createCriteria(TheTable.class);
            List<TheTable> tableList = criteria.add(Restrictions.like("num", Long.toString(number), MatchMode.ANYWHERE)).list();
            System.out.println(tableList.toString());
            return tableList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    }
