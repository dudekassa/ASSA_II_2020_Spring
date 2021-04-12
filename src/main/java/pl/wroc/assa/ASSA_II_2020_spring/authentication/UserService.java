package pl.wroc.assa.ASSA_II_2020_spring.authentication;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return user;
    }

    public boolean deleteUser(User user) {
        userRepository.delete(user);
        return true;
    }

    public boolean deleteUser(int id) {
        userRepository.deleteById(id);
        return true;
    }

}
