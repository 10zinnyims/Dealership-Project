package com.yearup.dealership.db;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InventoryDao {
    private DataSource dataSource;

    public InventoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addVehicleToInventory(String vin, int dealershipId) {
        // Implement the logic to add a vehicle to the inventory
        String query = "SELECT dealership_id, vin FROM car_dealership.inventory;";

        try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, vin);
            statement.setInt(2, dealershipId);

            statement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void removeVehicleFromInventory(String vin) {
        // TODO: Implement the logic to remove a vehicle from the inventory
    }
}
