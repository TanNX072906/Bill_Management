package repository;

import entity.InvoiceHistory;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

public class InvoiceHistoryDAO {

    public void insert(InvoiceHistory history) {
        String sql = "INSERT INTO InvoiceHistory(invoice_id, old_amount, new_amount, changed_by, changed_at) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, history.getInvoiceId());
            ps.setBigDecimal(2, history.getOldAmount());
            ps.setBigDecimal(3, history.getNewAmount());
            ps.setLong(4, history.getModifiedBy());
            ps.setTimestamp(5, Timestamp.valueOf(history.getModifiedAt()));

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}