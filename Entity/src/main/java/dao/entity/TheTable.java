package dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name="theTable")
public class TheTable {
    private int num;
    private Date dateOfOrder;
    private Time startTime;
    private Time endTime;

public TheTable(){}

    public TheTable(int num, Date dateOfOrder) {
        this.num = num;
        this.dateOfOrder = dateOfOrder;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "num")
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


    @Temporal(TemporalType.DATE)
    @Column(name="dateOfOrder",nullable = true, insertable = true)
    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    @Temporal(TemporalType.TIME)
    @Column(name="startTime")
    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }
    @Temporal(TemporalType.TIME)
    @Column(name="endTime")
    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "TheTable{" +
                "num=" + num +
                ", dateOfOrder=" + dateOfOrder +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
