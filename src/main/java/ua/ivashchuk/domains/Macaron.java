package ua.ivashchuk.domains;

import javax.persistence.*;

@Entity
@Table(name="macarons")
public class Macaron {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "macaron_id")
    private Integer id;

    private String name;
    private String description;
    private Double price;

    @Lob
    private String encodeImage;

    public Macaron() {

    }

    public Macaron(Integer id) {
        this.id = id;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getEncodeImage() {
        return encodeImage;
    }

    public void setEncodeImage(String encodeImage) {
        this.encodeImage = encodeImage;
    }
}
