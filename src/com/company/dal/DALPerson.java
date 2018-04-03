package com.company.dal;

import java.io.IOException;
import java.sql.*;

public class DALPerson {

    private static DALPerson dalPerson;

    public DALPerson() {
    }

    public static DALPerson getInstance(){
        if(dalPerson==null)
            dalPerson = new DALPerson();

        return dalPerson;
    }

    public String getPersonName(int personID) throws SQLException, IOException {
        String personName = "";
        PreparedStatement personStmt = null;
        String selectSQL = "SELECT name FROM LECTURERS Where id = ?";

        personStmt = DALConnection.getInstance().getConnection().prepareStatement(selectSQL);
        personStmt.setInt(1, personID);
        ResultSet rs = personStmt.executeQuery();

        if(!rs.wasNull()) {
            rs.first();
            personName = rs.getString(1);
        }

        return personName;
    }

    public String getPersonEmail(int personID) throws SQLException, IOException {
        String personEmail = "";
        PreparedStatement personStmt = null;
        String selectSQL = "SELECT email FROM LECTURERS Where id = ?";

        personStmt = DALConnection.getInstance().getConnection().prepareStatement(selectSQL);
        personStmt.setInt(1, personID);
        ResultSet rs = personStmt.executeQuery();

        if(!rs.wasNull()) {
            rs.first();
            personEmail = rs.getString("email");
        }

        return personEmail;
    }
}
