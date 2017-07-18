package dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "thetable")
public class TheTable {
    private long idOfTable;
    private int num;
    private LocalDate dateOfOrder;
    private int startTime;
    private int endTime;


    public TheTable(int num, int startTime, int endTime){}
  public TheTable(int num, LocalDate dateOfOrder, int startTime, int endTime) {
        this.num = num;
        this.dateOfOrder = dateOfOrder;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public TheTable() {
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "idOfTable")
    public long getIdOfTable() {
        return idOfTable;
    }

    public void setIdOfTable(long idOfTable) {
        this.idOfTable = idOfTable;
    }

    @Column(name = "num")
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


   // @Temporal(TemporalType.DATE)
    @Column(name="dateOfOrder",nullable = true, insertable = true)
    public LocalDate getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(LocalDate dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }


    @Column(name="startTime")
    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    @Column(name="endTime")
    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "TheTable{" +
                "idOfTable=" +idOfTable+
                "num=" + num +
                ", dateOfOrder=" + dateOfOrder +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
