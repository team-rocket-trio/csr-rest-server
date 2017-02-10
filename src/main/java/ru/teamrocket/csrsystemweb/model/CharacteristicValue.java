package ru.teamrocket.csrsystemweb.model;

import org.codehaus.jackson.annotate.JsonBackReference;
import javax.persistence.*;

/**
 * Created by Kate on 03.02.2017.
 */

@Entity
@Table(name = "characteristic_value", schema = "csrdb")
public class CharacteristicValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "characteristic_value_id")
    private Integer characteristicValueId;

    @Column(name = "value_text")
    private String valueText;

    @Column(name = "value_min_num")
    private Integer valueMinNum;

    @Column(name = "value_max_num")
    private Integer valueMaxNum;

    @Column(name = "value_list")
    private String valueList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="characteristic_id")
    @JsonBackReference("characteristic-values")
    private Characteristic characteristic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    @JsonBackReference("product-values")
    private Product product;

    public CharacteristicValue(){
    }

    public CharacteristicValue(String valueText, int valueMinNum, int valueMaxNum, String valueList) {
        this.valueText = valueText;
        this.valueMinNum = valueMinNum;
        this.valueMaxNum = valueMaxNum;
        this.valueList = valueList;
    }

    public int getCharacteristicValueId() {
        return characteristicValueId;
    }

    public void setCharacteristicValueId(int characteristicValueId) {
        this.characteristicValueId = characteristicValueId;
    }

    public String getValueText() {
        return valueText;
    }

    public void setValueText(String valueText) {
        this.valueText = valueText;
    }

    public Integer getValueMinNum() {
        return valueMinNum;
    }

    public void setValueMinNum(int valueMinNum) {
        this.valueMinNum = valueMinNum;
    }

    public Integer getValueMaxNum() {
        return valueMaxNum;
    }

    public void setValueMaxNum(int valueMaxNum) {
        this.valueMaxNum = valueMaxNum;
    }

    public String getValueList() {
        return valueList;
    }

    public void setValueList(String valueList) {
        this.valueList = valueList;
    }

    public Characteristic getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(Characteristic characteristic) {
        this.characteristic = characteristic;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
