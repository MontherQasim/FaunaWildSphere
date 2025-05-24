package dev.springhandson.faunawildsphere.entity.base;

import jakarta.persistence.Basic;
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

    @Column(name = "created_at", updatable = false)
    @Basic(optional = false)
    @NonNull    private LocalDateTime createdAt;


    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
    private boolean isDeleted;

}
