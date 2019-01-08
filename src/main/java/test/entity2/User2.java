package test.entity2;

import test.entity.Order;
import test.entity.User;

import javax.persistence.*;

import java.util.Date;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "USER2", schema = "public")

public class User2 {
    @Id
    @Column(name = "USER_ID",  nullable = false)
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(name = "USER_NAME", nullable = false, length = 50)
    private String name;

    @Column (name = "USER_PHONE", nullable = false, length = 50)
    private String phone;

    @Column(name = "operation")
    private String operation;

    @Column(name = "stamp")
    private Date stamp;

    @Column(name = "userid")
    private String userid;

    @Column(name = "read")
    private boolean isRead;

    @OneToMany(mappedBy = "user")
    private Set<Order> order;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Date getStamp() {
        return stamp;
    }

    public void setStamp(Date stamp) {
        this.stamp = stamp;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public Set<Order> getOrder() {
        return order;
    }

    public void setOrder(Set<Order> order) {
        this.order = order;
    }

    public User getUser(){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPhone(phone);
        return user;
    }
}
