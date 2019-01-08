package test.entity;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Clothes", schema = "public")

public class Clothes {

    @Id
    @Column(name = "CLOTHES_ID", nullable = false)
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column (name = "CLOTHES_NAME", nullable = false, length = 50)
    private String clothesName;

    @Column (name = "REMARK", nullable = false, length = 50)
    private String remark;

    public Set<Coat> getCoat() {
        return coat;
    }

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

    public void setCoat(Set<Coat> coat) {
        this.coat = coat;
    }
}
