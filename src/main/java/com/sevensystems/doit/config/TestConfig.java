package com.sevensystems.doit.config;

import com.sevensystems.doit.task.Status;
import com.sevensystems.doit.task.Task;
import com.sevensystems.doit.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    public TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {

        Task task1 = new Task(null, "Estudar JAVA", Status.FINISHED, Instant.parse("2025-07-01T14:00:00Z"), Instant.parse("2025-07-10T18:00:00Z"), Instant.parse("2025-07-08T12:00:00Z"));
        Task task2 = new Task(null, "Escrever artigo", Status.TO_DO, Instant.parse("2025-07-03T08:00:00Z"), Instant.parse("2025-07-31T22:00:00Z"), null);
        Task task3 = new Task(null, "Ler o livro", Status.IN_PROGRESS, Instant.parse("2025-07-05T09:00:00Z"), Instant.parse("2025-07-20T18:00:00Z"), null);

        taskRepository.saveAll(Arrays.asList(task1, task2, task3));
    }
}
