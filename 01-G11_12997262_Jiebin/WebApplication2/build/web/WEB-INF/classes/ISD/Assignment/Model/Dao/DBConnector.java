package ISD.Assignment.Model.Dao;

 

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

 

public class DBConnector extends DB{

 

public DBConnector() throws ClassNotFoundException, SQLException {

Class.forName(driver);

conn = DriverManager.getConnection(URL, dbuser, dbpass);

}

 

public Connection openConnection(){

return this.conn;

}

 

public void closeConnection() throws SQLException {

this.conn.close();

}

}