package net.joaoqalves.domain;

import java.util.UUID;

public class Task {
    private UUID id;
    private String title;
    private Long createdAt;
    private Long modifiedAt;

    public Task() {

    }

    public Task(UUID id, String title, Long createdAt, Long modifiedAt) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Long modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }
}
