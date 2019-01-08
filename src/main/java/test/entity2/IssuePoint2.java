package test.entity2;

import test.entity.IssuePoint;
import test.entity.Order;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table

public class IssuePoint2 {
    @Id
    @Column(name = "ISSUEPOINT_ID", nullable = false)
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(name = "ISSUEPOINT_NAME", length = 100)
    private String issuePointName;

    @Column (name = "ADDRESS", nullable = false, length = 50)
    private String address;

    @Column(name = "operation")
    private String operation;

    @Column(name = "stamp")
    private Date stamp;

    @Column(name = "userid")
    private String userid;

    @Column(name = "read")
    private boolean isRead;

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

    public void setOrder(Set<Order> order) {
        this.order = order;
    }

    public IssuePoint getIssuePoint(){
        IssuePoint issuePoint = new IssuePoint();
        issuePoint.setId(id);
        issuePoint.setIssuePointName(issuePointName);
        issuePoint.setAddress(address);
        return issuePoint;
    }
}
