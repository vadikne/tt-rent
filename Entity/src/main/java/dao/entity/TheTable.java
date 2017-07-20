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
    private int timePlay;
    private User user;



    public TheTable(int num, int startTime, int endTime){}
  public TheTable(int num, LocalDate dateOfOrder, int startTime, int timePlay, User user) {
        this.num = num;
        this.dateOfOrder = dateOfOrder;
        this.startTime = startTime;
        this.timePlay = timePlay;
        this.user = user;
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

    @Column(name="timePlay")
    public int getEndTime() {
        return timePlay;
    }

    public void setEndTime(int endTime) {
        this.timePlay = endTime;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JoinColumn(name = "idUser")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "TheTable{" +
                "idOfTable=" +idOfTable+
                "num=" + num +
                ", dateOfOrder=" + dateOfOrder +
                ", startTime=" + startTime +
                ", timePlay=" + timePlay +
                ", user=" + user+
                '}';
    }
}
