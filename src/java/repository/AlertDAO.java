package repository;

import entity.Alert;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlertDAO {

    // =================================
    // INSERT ALERT
    // =================================
    public boolean insert(Alert alert) {

        String sql = "INSERT INTO Alerts " +
                "(entity_type, entity_id, risk_score, message, status, created_at) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, alert.getEntityType());
            ps.setLong(2, alert.getEntityId());
            ps.setInt(3, alert.getRiskScore());
            ps.setString(4, alert.getMessage());
            ps.setString(5, alert.getStatus());
            ps.setTimestamp(6, Timestamp.valueOf(alert.getCreatedAt())); // LocalDateTime

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // =================================
    // FIND BY ID
    // =================================
    public Alert findById(Long id) {

        String sql = "SELECT * FROM Alerts WHERE alert_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapResultSet(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // =================================
    // FIND ALL
    // =================================
    public List<Alert> findAll() {

        List<Alert> list = new ArrayList<>();
        String sql = "SELECT * FROM Alerts ORDER BY created_at DESC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(mapResultSet(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // =================================
    // FIND BY ENTITY
    // =================================
    public List<Alert> findByEntity(String entityType, Long entityId) {

        List<Alert> list = new ArrayList<>();
        String sql = "SELECT * FROM Alerts WHERE entity_type = ? AND entity_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, entityType);
            ps.setLong(2, entityId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(mapResultSet(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // =================================
    // UPDATE STATUS
    // =================================
    public boolean updateStatus(Long alertId, String status) {

        String sql = "UPDATE Alerts SET status = ? WHERE alert_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setLong(2, alertId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // =================================
    // DELETE
    // =================================
    public boolean delete(Long id) {

        String sql = "DELETE FROM Alerts WHERE alert_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // =================================
    // MAP RESULT SET
    // =================================
    private Alert mapResultSet(ResultSet rs) throws SQLException {

        Alert alert = new Alert();

        alert.setAlertId(rs.getLong("alert_id"));
        alert.setEntityType(rs.getString("entity_type"));
        alert.setEntityId(rs.getLong("entity_id"));
        alert.setRiskScore(rs.getInt("risk_score"));
        alert.setMessage(rs.getString("message"));
        alert.setStatus(rs.getString("status"));

        Timestamp created = rs.getTimestamp("created_at");
        if (created != null) {
            alert.setCreatedAt(created.toLocalDateTime());
        }

        return alert;
    }
}