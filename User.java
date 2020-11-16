package Lab7;

public class User {
    private int id;
    private String username;
    private String password;
    private int role;
    private String create;
    private String update;

    public User() {
        this.id = 0;
        this.username = "";
        this.password = "";
        this.role = 0;
        this.create = "";
        this.update = "";
    }

    public User(int id, String user, String password, int role, String create, String update) {
        this.id = id;
        this.username = user;
        this.password = password;
        this.role = role;
        this.create = create;
        this.update = update;
    }

    public User(String user, String password, int role) {
        this.username = user;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return this.id;
    }

    public int getRole() {
        return this.role;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCreate(String create) {
        this.create = create;
    }

    public void setUpdate(String delete) {
        this.update = delete;
    }

    public String getCreate() {
        return this.create;
    }

    public String getUpdate() {
        return this.update;
    }

    public String toString() {
        return String.format("%-30d%-30s%-30s%-30d%-30s%-30s", this.id, this.username, this.password, this.role, this.create, this.update);
    }
}
