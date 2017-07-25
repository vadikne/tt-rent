package dao.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    private long idUser;
    private String name;
    private String phoneNumber;
    private String password;
    // private TheTable theTable;
    private Set<TheTable> theTableSet = new HashSet<>();

    public User() {
        name = null;
    }

    public User(String name, String phoneNumber, String password){
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.password=password;
        this.theTableSet=theTableSet;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<TheTable> getTheTableSet() { return theTableSet; }
    public void setTheTableSet(Set<TheTable> theTableSet) {
        this.theTableSet = theTableSet;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "idUser")
    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "phoneNumber" )//unique = true/)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "password",nullable = true)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                               '}';
    }
}
