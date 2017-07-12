package main.java.dao.interfaces;

import main.java.dao.entity.TheTable;

import java.sql.SQLException;

public interface TheTableDAO {
    public void addTheTable(TheTable theTable) throws SQLException;
    public void updateTheTable(TheTable theTable) throws SQLException;
   // public TheTable getTheTableByNum(String name) throws SQLException;
    public void deleteTheTable(TheTable TheTable) throws SQLException;

}
