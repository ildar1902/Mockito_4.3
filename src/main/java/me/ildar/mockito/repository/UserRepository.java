package me.ildar.mockito.repository;

import me.ildar.mockito.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private List<User> users = new ArrayList<>();
    private User user;

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    public Optional<User> findUserByLogin(String login) {
        return users.stream()
                .filter(e -> user.getLogin().equals(login))
                .findAny();
    }

    public Optional<User> findUserByLoginAndPassword(String login, String password) {
        return users.stream()
                .filter(e -> user.getLogin().equals(login) && user.getPassword().equals(password))
                .findAny();
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
