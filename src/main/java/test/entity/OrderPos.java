package test.entity;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "ORDERPOS")

public class OrderPos {

    @Id
    @Column(name = "ORDERPOS_ID")
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(name = "ORDERPOS_PRICE", nullable = false)
    private Double price;

    @Column(name = "ORDERPOS_QUANTITY", nullable = false)
    private Integer quantity;

    @Column(name = "ORDERPOS_GOODNAME", nullable = false)
    private String goodname;

    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name = "ORDERPOS_ORDER_ID")
    private Order order;

    @ManyToOne(targetEntity = Coat.class)
    @JoinColumn(name = "ORDERPOS_COAT_ID", nullable = false)
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

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
