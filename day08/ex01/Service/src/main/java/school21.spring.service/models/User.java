package school21.spring.service.models;

public class User {

    private Long identifier;
    private String email;

    public User() {
    }

    public String getEmail() {
        return (this.email);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getIdentifier() {
        return (this.identifier);
    }

    public void setIdentifier(Long identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return "User{" +
                "identifier=" + identifier +
                ", email='" + email + '\'' +
                '}';
    }

}
