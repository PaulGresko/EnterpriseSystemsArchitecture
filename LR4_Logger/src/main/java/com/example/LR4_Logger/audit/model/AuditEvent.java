package com.example.LR4_Logger.audit.model;

import com.example.LR4_Logger.audit.utils.ChangeType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "audit_events")
@NoArgsConstructor
public class AuditEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String entityName;

    @Column(nullable = false)
    private Long entityId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ChangeType changeType;

    @Column(nullable = false)
    private String changeDetails;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime timestamp;

    public AuditEvent(String entityName, Long entityId, ChangeType changeType, String changeDetails) {
        this.entityName = entityName;
        this.entityId = entityId;
        this.changeDetails = changeDetails;
        this.changeType = changeType;
    }
}
