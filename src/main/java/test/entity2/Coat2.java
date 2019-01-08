package test.entity2;

import test.entity.Clothes;
import test.entity.Coat;
import test.entity.OrderPos;

import javax.persistence.*;

import java.util.Date;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "COAT2", schema = "public")

public class Coat2 {

    @Id
    @Column(name = "COAT_ID", nullable = false)
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(name = "COAT_NAME", nullable = false, length = 50)
    private String coatName;

    @Column(name = "COAT_SIZE", nullable = false)
    private Integer coatSize;

    @Column(name = "PRODUCT_PRICE")
    private Integer coatPrice;

    @Column(name = "operation")
    private String operation;

    @Column(name = "stamp")
    private Date stamp;

    @Column(name = "userid")
    private String userid;

    @Column(name = "read")
    private boolean isRead;

    @OneToMany(mappedBy = "coat")
    private Set<OrderPos> orderPos;

    @ManyToOne(targetEntity = Clothes.class)
    @JoinColumn(name = "COATCLOTHES_ID", nullable = false)
    private Clothes clothes;

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

    public Coat getCoat() {
        Coat coat = new Coat();
        coat.setId(id);
        coat.setCoatName(coatName);
        coat.setCoatPrice(coatPrice);
        coat.setCoatSize(coatSize);
        return coat;
    }
}
