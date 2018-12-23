package test.entity;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="ORDER", schema = "public")

public class Order {

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

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user ;

    @ManyToOne(targetEntity = IssuePoint.class)
    @JoinColumn (name = "ISSUEPOIT_ID", nullable = false)
    private IssuePoint issuePoint;

    @OneToMany(mappedBy = "order")
    private Set<OrderPos> orderPoses;

    public Set<OrderPos> getOrderPoses() {
        return orderPoses;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setOrderPoses(Set<OrderPos> orderPoses) {
        this.orderPoses = orderPoses;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
