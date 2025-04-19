package quizcheat.backend.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
    @Id
    private String email;
    private String name;
    private String password;
    private String role;

    @OneToMany(mappedBy = "user")
    private List<Point> points;

    public User() {
        this.role = "ROLE_USER";
    }

    public User(String email, String name, String acount, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = "ROLE_USER";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
