package test.entity;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "USER_ID")
    private Integer id;

    @Column(name = "USER_SURNAME", nullable = false)
    private String surname;

    @Column (name = "USER_ADRESS", nullable = false, length = 50)
    private String adress;

    @Column (name = "USER_EMAIL", nullable = false)
    private Integer email;

    @Column (name = "USER_PHONE", nullable = false, length = 50)
    private String phone;

    @OneToMany(mappedBy = "user")
    private Set<Order> order;

    public Set<Order> getOrder() {
        return order;
    }

    public void setOrder(Set<Order> order) {
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getEmail() {
        return email;
    }

    public void setEmail(Integer email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
