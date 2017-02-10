package ru.teamrocket.csrsystemweb.model;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import javax.persistence.*;
import java.util.List;

/**
 * Created by Kate on 03.02.2017.
 */

@Entity
@Table(name = "offer", schema = "csrdb")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "offer_id")
    private Integer offerId;

    @Column(name = "name")
    private String name;

    @Column(name = "activation_price")
    private Integer activationPrice;

    @Column(name = "monthly_price")
    private Integer monthlyPrice;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "offer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference("offer-characteristics")
    private List<Characteristic> characteristics;

    @OneToMany(mappedBy = "offer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference("offer-products")
    private List<Product> products;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="created_by_user_id", referencedColumnName = "user_id")
    @JsonBackReference("user-created-offers")
    private User userCreatedOffer;

    public Offer() {
    }

    public Offer(String name, int activationPrice, int monthlyPrice, String description) {
        this.name = name;
        this.activationPrice = activationPrice;
        this.monthlyPrice = monthlyPrice;
        this.description = description;
    }

    public Integer getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getActivationPrice() {
        return activationPrice;
    }

    public void setActivationPrice(int activationPrice) {
        this.activationPrice = activationPrice;
    }

    public Integer getMonthlyPrice() {
        return monthlyPrice;
    }

    public void setMonthlyPrice(int monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUserCreatedOffer() {
        return userCreatedOffer;
    }

    public void setUserCreatedOffer(User offerCreatedByUser) {
        this.userCreatedOffer = offerCreatedByUser;
    }

    public List<Characteristic> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<Characteristic> characteristics) {
        this.characteristics = characteristics;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return new StringBuffer(" name : ").append(this.name)
            .append(" activationPrice : ").append(this.activationPrice)
            .append(" monthlyPrice : ").append(this.monthlyPrice)
            .append(" description : ").append(this.description)
            .append(" offerId : ").append(this.offerId).toString();
}

}
