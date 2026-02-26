package entity;

import java.time.LocalDateTime;

/**
 *
 * @author admin
 */
public class Shift {

    private Long shiftId;
    private Long userId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status; // OPEN / CLOSED

    public Shift() {
    }

    public Shift(Long shiftId, Long userId, LocalDateTime startTime, LocalDateTime endTime, String status) {
        this.shiftId = shiftId;
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public Long getShiftId() {
        return shiftId;
    }

    public void setShiftId(Long shiftId) {
        this.shiftId = shiftId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
