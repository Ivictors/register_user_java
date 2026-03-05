package victor.model;

import java.time.LocalDate;

public class User {
    private Integer id;
    private String name;
    private String email;
    private LocalDate registrationDate;

    public User(Integer id, String name, String email, LocalDate registrationDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.registrationDate = registrationDate;
    }

    public User(String name, String email, LocalDate registrationDate) {
        this.name = name;
        this.email = email;
        this.registrationDate = registrationDate;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(LocalDate registrationDate) { this.registrationDate = registrationDate; }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }
}
