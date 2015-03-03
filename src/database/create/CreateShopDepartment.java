package database.create;

<<<<<<< HEAD
import java.sql.SQLException;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
=======
import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;
>>>>>>> 26363321cf193cbebd289640200b25c03d478695

/**
 * Created by DL on 02/03/2015.
 */

public class CreateShopDepartment {
<<<<<<< HEAD
    private PreparedStatement pstmt;
    private Statement stmt;
    private Connection conn;
=======

    private Connection conn;
    private PreparedStatement pstmt;
    private Statement stmt;
>>>>>>> 26363321cf193cbebd289640200b25c03d478695

    public CreateShopDepartment(Connection connIn) {
        conn = connIn;
    }

<<<<<<< HEAD
    public void dropShopDepartmentTable() {
        try {
            stmt = conn.createStatement();
            try {
                stmt.execute("DROP TABLE ShopDepartment");
                System.out.println("ShopDepartment table dropped successfully\n");
            } catch (SQLException ex) {
                System.out.println("Error dropping ShopDepartment table or it may not exist\n");
            }
        } catch (SQLException e) {
            //System.out.println(e);
            System.out.println("Error with connection");
        }
    }

    public void createShopDepartmentTable() {
        try {
            stmt = conn.createStatement();

            stmt.execute("CREATE TABLE ShopDepartment(" +
                    "shopId INTEGER," +
                    "deptId INTEGER," +
                    "PRIMARY KEY (shopId, deptId)," +
                    "FOREIGN KEY (shopId) REFERENCES Shop(shopId)," +
                    "FOREIGN KEY (deptId) REFERENCES Department(deptId)" +
                    ")");
            System.out.println("ShopDepartment table created successfully\n");

            String sql = "INSERT INTO ShopDepartment(shopId, deptId)VALUES (?,?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, 1);
            pstmt.setInt(2, 1);
            pstmt.execute();

            pstmt.setInt(1, 1);
            pstmt.setInt(2, 2);
            pstmt.execute();

            pstmt.setInt(1, 1);
            pstmt.setInt(2, 3);
            pstmt.execute();

            pstmt.setInt(1, 1);
            pstmt.setInt(2, 4);
            pstmt.execute();

            pstmt.setInt(1, 1);
            pstmt.setInt(2, 5);
            pstmt.execute();

        } catch (SQLException sqlE) {
            System.out.println("Error creating ShopDepartment table");
=======
    public void dropShopDepartment() {
        try {
            stmt = conn.createStatement();
            try {
                stmt.execute("DROP TABLE shopdepartment");
                System.out.println("ShopDepartment Table Dropped");
            } catch (SQLException e) {
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void createShopDepartment() {
        try {
            // create shopdepartment table
            stmt = conn.createStatement();
            stmt.execute("CREATE TABLE shopdepartment(" +
                    "shopId INTEGER," +
                    "deptId INTEGER," +
                    "PRIMARY KEY (shopId, deptId)," +
                    "FOREIGN KEY (shopId) REFERENCES shop(shopId)," +
                    "FOREIGN KEY (deptId) REFERENCES department(deptId))");
        } catch (SQLException e) {
            System.out.println(e);
        }
        try {
            String sqlData = "INSERT INTO shopdepartment (shopId, deptId) VALUES (?,?)";
            pstmt = conn.prepareStatement(sqlData);

            pstmt.setInt(1,1);
            pstmt.setInt(2,1);
            pstmt.execute();

            pstmt.setInt(1,1);
            pstmt.setInt(2,2);
            pstmt.execute();

            pstmt.setInt(1,1);
            pstmt.setInt(2,3);
            pstmt.execute();

            pstmt.setInt(1,1);
            pstmt.setInt(2,4);
            pstmt.execute();

            pstmt.setInt(1,1);
            pstmt.setInt(2,5);
            pstmt.execute();

        } catch (SQLException e){
            System.out.println(e);
>>>>>>> 26363321cf193cbebd289640200b25c03d478695
        }
    }
}
