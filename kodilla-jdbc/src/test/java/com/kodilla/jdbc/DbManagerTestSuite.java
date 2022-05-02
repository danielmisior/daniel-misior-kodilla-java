package com.kodilla.jdbc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DbManagerTestSuite {

    private DbManager dbManager;
    private int counter;

    @BeforeEach
    public void before() {
        dbManager = DbManager.getInstance();
        counter = 0;
    }
    @Test
    void testConnect() throws SQLException {
        //Given
        //When
        //Then
        assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUsers() throws SQLException {
        //Given
        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        while(rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(5, counter);
    }

    @Test
    void testSelectUsersAndPosts() throws SQLException {
        //Given
        //When
        String sqlQuery = "SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POSTS_NUMBER\n" +
                "FROM USERS U JOIN POSTS P on U.ID = P.USER_ID\n" +
                "GROUP BY P.USER_ID\n" +
                "HAVING COUNT(*) >= 2\n" +
                "ORDER BY U.LASTNAME, U.FIRSTNAME;";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet result = statement.executeQuery(sqlQuery);

        //Then
        while(result.next()) {
            System.out.println(result.getString("FIRSTNAME") + " " +
                    result.getString("LASTNAME") + " has: " +
                    result.getInt("POSTS_NUMBER") + " posts.");
            counter++;
        }
        result.close();
        statement.close();
        assertEquals(1, counter);
    }
}
