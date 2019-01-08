package test.entity2;

import test.entity.Clothes;
import test.entity.Coat;

import javax.persistence.*;

import java.util.Date;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Clothes2", schema = "public")

public class Clothes2 {
    @Id
    @Column(name = "CLOTHES_ID", nullable = false)
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column (name = "CLOTHES_NAME", nullable = false, length = 50)
    private String clothesName;

    @Column (name = "REMARK", nullable = false, length = 50)
    private String remark;

    @Column(name = "operation")
    private String operation;

    @Column(name = "stamp")
    private Date stamp;

    @Column(name = "userid")
    private String userid;

    @Column(name = "read")
    private boolean isRead;

    @OneToMany(mappedBy = "clothes")
    private Set<Coat> coat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClothesName() {
        return clothesName;
    }

    public void setClothesName(String clothesName) {
        this.clothesName = clothesName;
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

    public Set<Coat> getCoat() {
        return coat;
    }

    public void setCoat(Set<Coat> coat) {
        this.coat = coat;
    }

    public Clothes getClothes(){
        Clothes clothes = new Clothes();
        clothes.setId(id);
        clothes.setClothesName(clothesName);
        return clothes;
    }
}
