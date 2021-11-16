package ua.ivashchuk.domains;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bucket")
public class Bucket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bucket_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "macaron_id", referencedColumnName = "macaron_id")
    private Macaron macaron;

    @ManyToOne
    @JoinColumn(name= "cupcake_id", referencedColumnName = "cupcake_id")
    private Cupcake cupcake;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    public Bucket() {

    }

    public Bucket(Integer id) {
        this.id = id;
    }

    public Bucket(User user, Macaron macaron, Cupcake cupcake, Date purchaseDate) {
        this.user = user;
        this.macaron = macaron;
        this.cupcake = cupcake;
        this.purchaseDate = purchaseDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Macaron getMacaron() {
        return macaron;
    }

    public void setMacaron(Macaron macaron) {
        this.macaron = macaron;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Cupcake getCupcake() {
        return cupcake;
    }

    public void setCupcake(Cupcake cupcake) {
        this.cupcake = cupcake;
    }
}
