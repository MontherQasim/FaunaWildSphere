package dev.springhandson.faunawildsphere.entity.base;

import jakarta.persistence.Basic;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Column;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditListener.class)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public abstract class AuditInfo {

    @Column(name = "created_at", updatable = false)
    @Basic(optional = false)
    private LocalDateTime createdAt;


    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
    private boolean isDeleted;

}
