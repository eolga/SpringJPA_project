package test.entity;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table

public class IssuePoint {

    @Id
    @Column(name = "ISSUEPOINT_ID", nullable = false)
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(name = "ISSUEPOINT_NAME", length = 100)
    private String issuePointName;

    @Column (name = "ADDRESS", nullable = false, length = 50)
    private String address;

    @OneToMany(mappedBy = "issuePoint")
    private Set<Order> order;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIssuePointName() {
        return issuePointName;
    }

    public void setIssuePointName(String issuePointName) {
        this.issuePointName = issuePointName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Order> getOrder() {
        return order;
    }

    public void setOrder(Set<Order> order) {
        this.order = order;
    }
}
