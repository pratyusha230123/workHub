package com.jdbc.example;

import java.sql.*;
import java.util.*;


public class SelectStatementEx {
    public static void main(String[] args) {
        getActorsAsMap();

    }
//    GOAL IS TO UNDERSTAND THE WORKING OF ORM
    public static Map<Integer,ActorModel> getActorsAsMap() {
//        USE JDBC TO POPULATE ACTORS INSIDE THE MAP.
        Map<Integer, ActorModel> map =new HashMap<>();
        int id=0;
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SAKILA","root","mysql");

            Statement statement = connection.createStatement();

            String selectQuery = "SELECT ACTOR_ID, FIRST_NAME, LAST_NAME FROM ACTOR";
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while(resultSet.next()){
                int actorId = resultSet.getInt("ACTOR_ID");
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString("LAST_NAME");
                map.put(id, new ActorModel(actorId, firstName,lastName));
                id++;
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return map;
    }
}
