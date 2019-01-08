package test.entity;

import javax.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "USER", schema = "public")

public class User {

    @Id
    @Column(name = "USER_ID",  nullable = false)
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(name = "USER_NAME", nullable = false, length = 50)
    private String name;

    @Column (name = "USER_PHONE", nullable = false, length = 50)
    private String phone;

    @OneToMany(mappedBy = "user")
    private Set<Order> order = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Order> user2;
    
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Order> getOrder() {
        return order;
    }

    public void setOrder(Set<Order> order) {
        this.order = order;
    }

    public Set<Order> getUser2() {
        return user2;
    }

    public void setUser2(Set<Order> user2) {
        this.user2 = user2;
    }
}

