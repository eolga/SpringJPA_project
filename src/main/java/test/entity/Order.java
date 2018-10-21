package test.entity;

import javax.persistence.*;
import javax.persistence.GenerationType.*;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="ORDER", schema = "public")
public class Order {

    @Id
    @Column(name = "ORDER_ID")
    @GeneratedValue(strategy =  IDENTITY)
    private Integer id;

    @Column(name = "ORDER_COAT", length = 20)
    private String coat;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "ORDER_USER_ID", nullable = false)
    private User user ;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "order")
    private Set<OrderPos> orderPoses;

    public Set<OrderPos> getOrderPoses() {
        return orderPoses;
    }

    public void setOrderPoses(Set<OrderPos> orderPoses) {
        this.orderPoses = orderPoses;
    }

    @Column(name = "ORDER_REMARK", length = 1000)
    private String remark;

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
}
