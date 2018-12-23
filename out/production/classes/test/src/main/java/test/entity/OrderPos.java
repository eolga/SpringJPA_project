package test.entity;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "ORDERPOS")

public class OrderPos {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ORDERPOS_ID")
    private Integer id;

    @Column(name = "ORDERPOS_PRICE", nullable = false)
    private Double price;

    @Column(name = "ORDERPOS_QUANTITY", nullable = false)
    private Integer quantity;

    @Column(name = "ORDERPOS_GOODNAME")
    private String goodName;

    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name = "ORDER_ID", nullable = false)
    private Order order;

    @ManyToOne(targetEntity = Coat.class)
    @JoinColumn(name = "COAT_ID", nullable = false)
    private Coat coat;

    public Coat getCoat() {
        return coat;
    }

    public void setCoat(Coat coat) {
        this.coat = coat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
