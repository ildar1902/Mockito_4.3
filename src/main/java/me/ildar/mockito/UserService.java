package me.ildar.mockito;

import me.ildar.mockito.exception.UserNonUniqueException;

import java.util.List;

public class UserService {
    private UserRepository userRepository;

    public List<String> getLogins() {
        List<User> users = userRepository.getUsers();
        return users.stream()
                .map(User::getLogin)
                .toList();
    }

    public void createNewUser(String login, String password) {
        if (login == null || password == null) {
            throw new IllegalArgumentException("поля логин и пароль не должны быть пустыми!");
        }
        if (userRepository.findUserByLogin(login).isPresent()) {
            throw new UserNonUniqueException();
        }
        if (userRepository.findUserByLogin(login).isEmpty()) {
            userRepository.addUser(new User(login, password));
        }
    }

    public boolean logInUser(String login, String password) {
        List<User> users = userRepository.getUsers();
        return users.stream()
                .anyMatch(e -> e.getLogin().equals(login) && e.getPassword().equals(password));
    }
}
