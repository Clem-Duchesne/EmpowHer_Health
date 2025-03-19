package com.dev.model.UserModels;
import java.util.List;

import com.dev.model.PatientModels.Patient;
import jakarta.persistence.*;

@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient", referencedColumnName = "id")
    private Patient patient;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="password",nullable = false)
    private String password;

    @ElementCollection
    @CollectionTable(
        name = "user_roles",  // This is the table where roles will be stored
        joinColumns = @JoinColumn(name = "user_id")  // Foreign key to the User entity
    )
    @Column(name = "role")  // Column name in the 'user_roles' table
    private List<String> userRoles;

    public User(){}

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return List<UserRole> return the userRoles
     */
    public List<String> getUserRoles() {
        return userRoles;
    }
        

    /**
     * @param userRoles the userRoles to set
     */
     
    public void setUserRoles(List<String> userRoles) {
        this.userRoles = userRoles;
    }

}