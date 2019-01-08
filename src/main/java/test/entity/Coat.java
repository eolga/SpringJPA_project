package test.entity;

import javax.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "COAT", schema = "public")

public class Coat {

    @Id
    @Column(name = "COAT_ID", nullable = false)
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column (name = "COAT_NAME", nullable = false, length = 50)
    private String coatName;

    @Column (name = "COAT_SIZE", nullable = false)
    private Integer coatSize;

    @Column(name = "PRODUCT_PRICE")
    private Integer coatPrice;

    @OneToMany(mappedBy = "coat")
    private Set<OrderPos> orderPos;

    @ManyToOne(targetEntity = Clothes.class)
    @JoinColumn(name = "COATCLOTHES_ID", nullable = false)
    private Clothes clothes;
    private HashSet<OrderPos> orderPoss;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoatName() {
        return coatName;
    }

    public void setCoatName(String coatName) {
        this.coatName = coatName;
    }

    public Integer getCoatSize() {
        return coatSize;
    }

    public void setCoatSize(Integer coatSize) {
        this.coatSize = coatSize;
    }

    public Integer getCoatPrice() {
        return coatPrice;
    }

    public void setCoatPrice(Integer coatPrice) {
        this.coatPrice = coatPrice;
    }

    public Set<OrderPos> getOrderPos() {
        return orderPos;
    }

    public void setOrderPos(Set<OrderPos> orderPos) {
        this.orderPos = orderPos;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public void setOrderPoss(HashSet<OrderPos> orderPoss) {
        this.orderPoss = orderPoss;
    }

    public HashSet<OrderPos> getOrderPoss() {
        return orderPoss;
    }
}
