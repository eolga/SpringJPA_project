package test.entity2;

import test.entity.Coat;
import test.entity.Order;
import test.entity.OrderPos;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "ORDERPOS2")

public class OrderPos2 {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ORDERPOS_ID")
    private Integer id;

    @Column(name = "ORDERPOS_PRICE", nullable = false)
    private Integer price;

    @Column(name = "ORDERPOS_QUANTITY", nullable = false)
    private Integer quantity;

    @Column(name = "ORDERPOS_GOODNAME")
    private String goodName;

    @Column(name = "operation")
    private String operation;

    @Column(name = "stamp")
    private Date stamp;

    @Column(name = "userid")
    private String userid;

    @Column(name = "read")
    private boolean isRead;

    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name = "ORDER_ID", nullable = false)
    private Order order;

    @ManyToOne(targetEntity = Coat.class)
    @JoinColumn(name = "COAT_ID", nullable = false)
    private Coat coat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Coat getCoat() {
        return coat;
    }

    public void setCoat(Coat coat) {
        this.coat = coat;
    }

    public OrderPos getOrderPos(){
        OrderPos orderPos = new OrderPos();
        orderPos.setId(id);
        orderPos.setGoodName(goodName);
        orderPos.setPrice(price);
        orderPos.setQuantity(quantity);
        orderPos.setCoat(coat);
        orderPos.setOrder(order);
        return orderPos;
    }
}
