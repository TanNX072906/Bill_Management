package entity;

import java.time.LocalDateTime;

/**
 *
 * @author admin
 */
public class ActivityLog {
    
    private Long logId;
    private Long userId;
    private Long shiftId;
    private String actionType;
    private String entityType;
    private Long entityId;
    private String description;
    private LocalDateTime createdAt;

    public ActivityLog() {
    }

    public ActivityLog(Long logId, Long userId, Long shiftId, String actionType, String entityType, Long entityId, String description, LocalDateTime createdAt) {
        this.logId = logId;
        this.userId = userId;
        this.shiftId = shiftId;
        this.actionType = actionType;
        this.entityType = entityType;
        this.entityId = entityId;
        this.description = description;
        this.createdAt = createdAt;
    }

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShiftId() {
        return shiftId;
    }

    public void setShiftId(Long shiftId) {
        this.shiftId = shiftId;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
}
