package test.entity2;

import test.entity.IssuePoint;
import test.entity.Order;
import test.entity.OrderPos;
import test.entity.User;

import javax.persistence.*;

import java.util.Date;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="ORDER2", schema = "public")

public class Order2 {

    @Id
    @GeneratedValue(strategy =  IDENTITY)
    @Column(name = "ORDER_ID")
    private Integer id;

    @Column(name = "ORDER_PHONE", length = 20)
    private String phone;

    @Column(name = "ORDER_COAT", length = 20)
    private String coat;

    @Column(name = "ORDER_REMARK", length = 1000)
    private String remark;

    @Column(name = "operation")
    private String operation;

    @Column(name = "stamp")
    private Date stamp;

    @Column(name = "userid")
    private String userid;

    @Column(name = "read")
    private boolean isRead;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user ;

    @ManyToOne(targetEntity = IssuePoint.class)
    @JoinColumn (name = "ISSUEPOIT_ID", nullable = false)
    private IssuePoint issuePoint;

    @OneToMany(mappedBy = "order")
    private Set<OrderPos> orderPoses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCoat() {
        return coat;
    }

    public void setCoat(String coat) {
        this.coat = coat;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public IssuePoint getIssuePoint() {
        return issuePoint;
    }

    public void setIssuePoint(IssuePoint issuePoint) {
        this.issuePoint = issuePoint;
    }

    public Set<OrderPos> getOrderPoses() {
        return orderPoses;
    }

    public void setOrderPoses(Set<OrderPos> orderPoses) {
        this.orderPoses = orderPoses;
    }

    public Order getOrder(){
        Order order = new Order();
        order.setId(id);
        order.setPhone(phone);
        order.setRemark(remark);
        return order;
    }
}
