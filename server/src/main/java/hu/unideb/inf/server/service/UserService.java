package hu.unideb.inf.server.service;

import hu.unideb.inf.server.model.Task;
import hu.unideb.inf.server.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    Optional<User> findOne(String id);

    void updateOne(User updated);

    void deleteOne(String id);

    boolean authenticate(String username, String password) throws UsernameNotFoundException;

    public List<Task> getTasksByUserId(Long userId);

    void register(User user);

}
