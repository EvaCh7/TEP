/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEPDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author evach
 */
public class ShiftDB {
    public static void createShift() throws ClassNotFoundException, SQLException {
        Statement stmt = null;
        Connection con = null;
        con = TEPDB.getConnection();
        stmt = con.createStatement();
        try {

            String sql = "CREATE TABLE SHIFT "
                    + "(AT VARCHAR(255), "
                    + " full_name VARCHAR(255), "
                    + " proffession VARCHAR(255), "
                    + " date VARCHAR(255), "
                    + " hours VARCHAR(255), "
                    + " PRIMARY KEY ( AT ))";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    con.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        System.out.println(
                "Goodbye!");
    }
}
