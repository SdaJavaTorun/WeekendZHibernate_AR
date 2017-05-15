package main.java.com.sdajava.jpa_ostatnie.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import static main.java.com.sdajava.jpa_ostatnie.utility.DataToList.*;

public class JdbcSqlInsert {

    public static void sqlInsertRow() {
        Connection connection = JdbcConnection.setJdbcConnection();
        String sql = "INSERT INTO workers (id,first_name,last_name, boss_id) values (?,?,?,?)";

        try {
            PreparedStatement stateUpdate = connection.prepareStatement(sql);

            for (int row = 1; row<=10000; row++) {
                int randomName = (int) (Math.random() * nameList.size());
                int randomLast = (int) (Math.random() * lastNamesList.size());

                stateUpdate.setLong(1, row);
                stateUpdate.setString(2, nameList.get(randomName));
                stateUpdate.setString(3, lastNamesList.get(randomLast));
                stateUpdate.setLong(4, (long) Math.floor(row/2));

                stateUpdate.executeUpdate();
            }
            stateUpdate.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
