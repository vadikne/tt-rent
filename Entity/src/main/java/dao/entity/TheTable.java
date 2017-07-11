package main.java.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="theTable")
public class TheTable {
    private int num;
    private Date timeOfOrder;

public TheTable(){}

    public TheTable(int num, Date timeOfOrder) {
        this.num = num;
        this.timeOfOrder = timeOfOrder;
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
    @Column(name="timeOfOrder",nullable = true, insertable = true, updatable = true)
    public Date getTimeOfOrder() {
        return timeOfOrder;
    }

    public void setTimeOfOrder(Date timeOfOrder) {
        this.timeOfOrder = timeOfOrder;
    }

    @Override
    public String toString() {
        return "TheTable{" +
                "num=" + num +
                ", timeOfOrder=" + timeOfOrder +
                '}';
    }
}
