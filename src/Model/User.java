package Model;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private UserType classification;

    public User(int id, String name, String email,String password, UserType classification) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.classification = classification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public UserType getClassification() {
        return classification;
    }

    public void setClassification(UserType classification) {
        this.classification = classification;
    }

    @Override
    public String toString() {
        return "User [id=" + id +
                ", name=" + name +
                ", email=" + email +
                ", classification=" + classification + "]";
    }
}
