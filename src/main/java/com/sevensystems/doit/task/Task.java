package com.sevensystems.doit.task;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private Status status;
    private Instant creation;
    private Instant deadline;
    private Instant conclusion;

    public Task() {

    }

    public Task(UUID id, String name, Status status, Instant creation, Instant deadline, Instant conclusion) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.creation = creation;
        this.deadline = deadline;
        this.conclusion = conclusion;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Instant getCreation() {
        return creation;
    }

    public void setCreation(Instant creation) {
        this.creation = creation;
    }

    public Instant getDeadline() {
        return deadline;
    }

    public void setDeadline(Instant deadline) {
        this.deadline = deadline;
    }

    public Instant getConclusion() {
        return conclusion;
    }

    public void setConclusion(Instant conclusion) {
        this.conclusion = conclusion;
    }
}
