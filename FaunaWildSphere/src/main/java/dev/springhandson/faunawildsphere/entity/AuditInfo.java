package dev.springhandson.faunawildsphere.entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.NonNull;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditListener.class)
@Getter
@Setter
public abstract class AuditInfo {

    @Column(name="Created At: ", updatable = false)
    @NonNull
    private LocalDateTime createdAt;
    @Column(name="Created At: ")
    private LocalDateTime updatedAt;
    @Column(name="Deleted At: ")
    private LocalDateTime deletedAt;
    private boolean isDeleted;

}
