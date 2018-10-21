package test.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table
public class IssuePoit {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ISSUEPOINT_ID", nullable = false)
    private Integer id;

    @Column (name = "ISSUEPOINT_ADRESS", nullable = false, length = 50)
    private String adress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
