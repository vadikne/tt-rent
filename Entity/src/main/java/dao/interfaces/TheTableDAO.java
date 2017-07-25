package dao.interfaces;

import dao.entity.TheTable;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface TheTableDAO {
    public void addTheTable(TheTable theTable) throws SQLException;
    public void updateTheTable(TheTable theTable) throws SQLException;
   // public TheTable getTheTableByNum(String name) throws SQLException;
    public void deleteTheTable(TheTable TheTable) throws SQLException;
    public List<TheTable> getThetablesByNumberOfTable(int number, Date date) throws SQLException;

}
