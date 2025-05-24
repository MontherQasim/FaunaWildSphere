package dev.springhandson.faunawildsphere.entity.base;

import jakarta.persistence.*;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public class AuditListener {

    @PrePersist
    public void prePersist(Object obj) {
        if (obj instanceof AuditInfo audit) {
            if (audit.isDeleted()) {
                throw new IllegalStateException("Cannot persist a deleted entity");
            }
            audit.setCreatedAt(LocalDateTime.now());
        }
    }

    @PostPersist
    public void postPersist(Object obj) {
        if (obj instanceof AuditInfo audit) {
            log.info("Entity created at: {}", audit.getCreatedAt());
        }
    }

    @PreUpdate
    public void preUpdate(Object obj) {
        if (obj instanceof AuditInfo audit) {
            if (audit.isDeleted()) {
                throw new IllegalStateException("Cannot update a deleted entity");
            }
            audit.setUpdatedAt(LocalDateTime.now());
        }
    }

    @PostUpdate
    public void postUpdate(Object obj) {
        if (obj instanceof AuditInfo audit) {
            log.info("Entity updated at: {}", audit.getUpdatedAt());
        }
    }

    @PreRemove
    public void preRemove(Object obj) {
        if (obj instanceof AuditInfo audit) {
            audit.setDeletedAt(LocalDateTime.now());
            audit.setDeleted(true);
        }
    }

    @PostRemove
    public void postRemove(Object obj) {
        if (obj instanceof AuditInfo audit) {
            log.info("Entity deleted at: {}", audit.getDeletedAt());
        }
    }

    @PostLoad
    public void postLoad(Object obj) {
        if (obj instanceof AuditInfo audit) {
            if (audit.isDeleted()) {
                log.warn("Entity is marked as deleted. Created at: {}, Updated at: {}, Deleted at: {}",
                        audit.getCreatedAt(), audit.getUpdatedAt(), audit.getDeletedAt());
            } else {
                log.info("Entity loaded. Created at: {}, Updated at: {}",
                        audit.getCreatedAt(), audit.getUpdatedAt());
            }
        }
    }
}