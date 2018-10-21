package test.entity;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Clothes")
public class Clothes {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "CLOTHES_SKIRT", nullable = false, length = 50)
    private String skirt;

    @Column (name = "CLOTHES_DRESS", nullable = false, length = 50)
    private String dress;

    @Column (name = "CLOTHES_SHIRT", nullable = false, length = 50)
    private String shirt;

    @OneToMany(mappedBy = "clothes")
    private Set<Coat> coat;

    public String getSkirt() {
        return skirt;
    }

    public void setSkirt(String skirt) {
        this.skirt = skirt;
    }

    public String getDress() {
        return dress;
    }

    public void setDress(String dress) {
        this.dress = dress;
    }

    public String getShirt() {
        return shirt;
    }

    public void setShirt(String shirt) {
        this.shirt = shirt;
    }
}
