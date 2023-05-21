package javadev_module4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final Database INSTANCE = new Database();

    private Connection connection;
    private Database() {
        try {
            String connectUrl = "jdbc:h2:./test";
            Connection connection = DriverManager.getConnection(connectUrl);
            Statement st = connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

        public static Database getInstance () {
            return INSTANCE;
        }

        public Connection getConnection() {
        return connection;
        }

        public void close() {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

