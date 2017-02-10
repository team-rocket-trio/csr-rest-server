package ru.teamrocket.csrsystemweb.model;

import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Kate on 03.02.2017.
 */

@Entity
@Table(name = "user", schema = "csrdb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "userCreatedClient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference("user-created-clients")
    private List<Client> createdClients;

    @OneToMany(mappedBy = "userCreatedOffer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference("user-created-offers")
    private List<Offer> createdOffers;

    @OneToMany(mappedBy = "userCreatedCharacteristic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference("user-created-characteristics")
    private List<Characteristic> createdCharacteristics;

    public User() {
    }

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Client> getCreatedClients() {
        return createdClients;
    }

    public void setCreatedClients(List<Client> createdClients) {
        this.createdClients = createdClients;
    }

    public List<Offer> getCreatedOffers() {
        return createdOffers;
    }

    public void setCreatedOffers(List<Offer> createdOffers) {
        this.createdOffers = createdOffers;
    }

    public List<Characteristic> getCreatedCharacteristics() {
        return createdCharacteristics;
    }

    public void setCreatedCharacteristics(List<Characteristic> createdCharacteristics) {
        this.createdCharacteristics = createdCharacteristics;
    }

}
