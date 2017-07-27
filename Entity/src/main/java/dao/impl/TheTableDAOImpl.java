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

import javax.persistence.Query;
import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheTableDAOImpl implements TheTableDAO{

    private int number;
    private Date date;

    public void addTheTable(TheTable theTable) throws SQLException {
            Session session = null;
           // Integer idOfTable = null;
          try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
               // idOfTable = (Integer) session.save(theTable);
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
          //return idOfTable;
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
           List<TheTable> tableList = new ArrayList<TheTable>();
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()){
         // 2. tableList = session.createFilter("num", Integer.toString(number)).list();
         // 2. Criteria criteria = session.createCriteria(TheTable.class);
         // 2. List<TheTable> tableList = criteria.add(Restrictions.like("num", Long.toString(number), MatchMode.ANYWHERE)).list();
          Query query = session.createQuery("from TheTable where num= :number ").setInteger("number", number);
            tableList = (List<TheTable>) query.getResultList();
            System.out.println(Arrays.toString(new List[]{tableList}));
            } catch (Exception e) {
            e.printStackTrace();
        }
        for (TheTable order : tableList) {
            System.out.println(order.getStartTime() +" -"+ order.getTimePlay()+ "Имя - " + order.getUser().getName());
        }
        return tableList;
    }
    }
