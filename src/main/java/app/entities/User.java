package app.entities;

import java.util.Objects;

public class User {
    private int userId;
    private String login;
    private String password;
    private Role role;
    public enum Role { user, manager }
    public User(String name, String password) {
        this.login = name;
        this.password = password;
    }
    public User(String name, String password, String role) {
        this.login = name;
        this.password = password;
        this.role = Role.valueOf(role);
    }

    public void setUserId(int id) {
        userId = id;
    }

    public int getUserId() {
        return userId;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {return role;}

    @Override
    public String toString() {
        return "User{" +
                "name='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!Objects.equals(login, user.login)) return false;
        return Objects.equals(password, user.password);

    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
