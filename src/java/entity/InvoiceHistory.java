package entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author admin
 */
public class InvoiceHistory {

    private Long historyId;
    private Long invoiceId;
    private BigDecimal oldAmount;
    private BigDecimal newAmount;
    private Long modifiedBy;
    private Long shiftId;
    private String reason;
    private LocalDateTime modifiedAt;

    public InvoiceHistory() {
    }

    public InvoiceHistory(Long historyId, Long invoiceId, BigDecimal oldAmount, BigDecimal newAmount, Long modifiedBy, Long shiftId, String reason, LocalDateTime modifiedAt) {
        this.historyId = historyId;
        this.invoiceId = invoiceId;
        this.oldAmount = oldAmount;
        this.newAmount = newAmount;
        this.modifiedBy = modifiedBy;
        this.shiftId = shiftId;
        this.reason = reason;
        this.modifiedAt = modifiedAt;
    }

    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public BigDecimal getOldAmount() {
        return oldAmount;
    }

    public void setOldAmount(BigDecimal oldAmount) {
        this.oldAmount = oldAmount;
    }

    public BigDecimal getNewAmount() {
        return newAmount;
    }

    public void setNewAmount(BigDecimal newAmount) {
        this.newAmount = newAmount;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Long getShiftId() {
        return shiftId;
    }

    public void setShiftId(Long shiftId) {
        this.shiftId = shiftId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
    
}
