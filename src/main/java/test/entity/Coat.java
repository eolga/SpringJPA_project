package test.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "COAT")
public class Coat {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "COAT_ID", nullable = false)
    private Integer id;

    @Column (name = "COAT_NAME", nullable = false, length = 50)
    private String name;

    @Column (name = "COAT_SIZE", nullable = false)
    private Integer size;

    @Column (name = "COAT_COLOR", nullable = false, length = 50)
    private String color;

    @ManyToOne(targetEntity = Clothes.class)
    @JoinColumn(name = "COAT_CLOTHES_ID", nullable = false)
    private Clothes clothes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
