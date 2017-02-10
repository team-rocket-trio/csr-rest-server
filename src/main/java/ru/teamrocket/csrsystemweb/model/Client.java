package ru.teamrocket.csrsystemweb.model;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Kate on 26.01.2017.
 */

@Entity
@Table(name = "client", schema = "csrdb")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Integer clientId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference("client-products")
    private List<Product> products;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="created_by_user_id", referencedColumnName = "user_id")
    @JsonBackReference("user-created-clients")
    private User userCreatedClient;

    public Client(String firstName, String middleName, String lastName, String phone, String address) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public Client() {
    }

    public Integer getClientId() {
        return this.clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUserCreatedClient() {
        return userCreatedClient;
    }

    public void setUserCreatedClient(User clientCreatedByUser) {
        this.userCreatedClient = clientCreatedByUser;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return new StringBuffer(" client_id : ").append(this.clientId)
                .append(" first_name : ").append(this.firstName)
                .append(" middle_name : ").append(this.middleName)
                .append(" last_name : ").append(this.lastName)
                .append(" phone : ").append(this.phone)
                .append(" address : ").append(this.address)
                .toString();
    }

}
