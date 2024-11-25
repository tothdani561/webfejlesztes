package hu.unideb.inf.server.service.impl;

import hu.unideb.inf.server.model.Task;
import hu.unideb.inf.server.model.User;
import hu.unideb.inf.server.repository.TaskRepository;
import hu.unideb.inf.server.repository.UserRepository;
import hu.unideb.inf.server.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private UserRepository userRepository;
    private TaskRepository taskRepository;

    @Override
    public void createTaskForUser(String username, Task task) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("User with id " + username + " does not exist.");
        }

        User user = userOptional.get();

        task.setUser(user);
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());

        taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long taskId) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        if (taskOptional.isEmpty()) {
            throw new IllegalArgumentException("Task with id " + taskId + " does not exist.");
        }

        taskRepository.deleteById(taskId);
    }
}
