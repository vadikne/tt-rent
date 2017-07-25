package dao.entity;

//import org.hibernate.annotations.Entity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "thetable")
public class TheTable {
    private long idOfTable;
    private int num;
    private Date dateOfOrder;
    private int startTime;
    private int timePlay;
    private User user;
  //  long uId;




  public TheTable(int num, Date dateOfOrder, int startTime, int timePlay, User user) {
        this.num = num;
        this.dateOfOrder = dateOfOrder;
        this.startTime = startTime;
        this.timePlay = timePlay;
        this.user = user;
    }



    public TheTable() {
    }

 //   public TheTable(int num, Date dateOfOrder, int startTime, int timePlay, long uId) {
 //       this.num = num;
 //       this.dateOfOrder = dateOfOrder;
 //       this.startTime = startTime;
 //       this.timePlay = timePlay;
 //       this.uId=uId;
 //   }


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
    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
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
   //@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
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
