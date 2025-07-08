package com.sevensystems.doit.task;

import com.sevensystems.doit.exception.NotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(UUID id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Não foi encontrada nenhuma tarefa com o ID: " + id));
    }

    public Task insert(Task obj) {
        Task task = new Task(null, obj.getName(), obj.getStatus(), obj.getCreation(), obj.getDeadline(), null);
        task = taskRepository.save(task);

        return task;
    }

    public Task update(UUID id, Task obj) {
        Task entity = this.findById(id);
        updateData(entity, obj);
        entity = taskRepository.save(entity);

        return entity;
    }

    public void delete(UUID id) {
        taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Não foi encontrada nenhuma tarefa com o ID: " + id));

        taskRepository.deleteById(id);
    }

    private void updateData(Task entity, Task obj) {
        entity.setName(obj.getName());
        entity.setStatus(obj.getStatus());
        entity.setCreation(obj.getCreation());
        entity.setDeadline(obj.getDeadline());
        entity.setConclusion(obj.getConclusion());
    }
}
