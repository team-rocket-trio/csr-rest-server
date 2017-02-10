package ru.teamrocket.csrsystemweb.model;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import javax.persistence.*;
import java.util.List;

/**
 * Created by Kate on 03.02.2017.
 */

@Entity
@Table(name = "characteristic", schema = "csrdb")
public class Characteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "characteristic_id")
    private Integer characteristicId;

    @Column(name = "name")
    private String name;

    @Column(name = "activation_price")
    private Integer activationPrice;

    @Column(name = "monthly_price")
    private Integer monthlyPrice;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="offer_id")
    @JsonBackReference("offer-characteristics")
    private Offer offer;

    @OneToMany(mappedBy = "characteristic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference("characteristic-values")
    private List<CharacteristicValue> characteristicValues;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="created_by_user_id", referencedColumnName = "user_id")
    @JsonBackReference("user-created-characteristics")
    private User userCreatedCharacteristic;

    public Characteristic() {
    }

    public Characteristic(String name, int activationPrice, int monthlyPrice) {
        this.name = name;
        this.activationPrice = activationPrice;
        this.monthlyPrice = monthlyPrice;
    }

    public Integer getCharacteristicId() {
        return characteristicId;
    }

    public void setCharacteristicId(int characteristicId) {
        this.characteristicId = characteristicId;
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

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public List<CharacteristicValue> getCharacteristicValues() {
        return characteristicValues;
    }

    public void setCharacteristicValues(List<CharacteristicValue> characteristicValues) {
        this.characteristicValues = characteristicValues;
    }

    public User getUserCreatedCharacteristic() {
        return userCreatedCharacteristic;
    }

    public void setUserCreatedCharacteristic(User createdByUser) {
        this.userCreatedCharacteristic = createdByUser;
    }
}
