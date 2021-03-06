/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISD.Assignment.Model.Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import ISD.Assignment.Model.Payment;
import java.sql.PreparedStatement;
import java.util.ArrayList;
/**
 *
 * @author CristinaFidelino
 */
public class PaymentDAO {
    
    private Statement st;
    private Connection conn;
    
    public PaymentDAO(Connection conn) throws SQLException{
        st = conn.createStatement();
        this.conn = conn;
    }
    
    public ArrayList<Payment> searchPayment(String searchID) throws SQLException {
        ArrayList<Payment> searchPayments = new ArrayList();
        String search = "Select * from IOTUSER.Payment where PAYMENTID=" + searchID ;
        ResultSet rs = st.executeQuery(search);
        
        while (rs.next()){
            int paymentID = rs.getInt(1);
            String cardHolderName = rs.getString(2);
            String firstName = rs.getString(3);
            String lastName = rs.getString(4);
            int cardNumber = rs.getInt(5);
            String expDate = rs.getString(6);
            String paidDate = rs.getString(7);
            String paymentMethod = rs.getString(8);
            double paidAmount = rs.getDouble(9);
            searchPayments.add(new Payment(paymentID, cardHolderName, firstName, lastName, cardNumber, expDate, paidDate, paymentMethod,paidAmount));
        }
        if(searchPayments.size() > 0){
            return searchPayments;
        }
        else{
            return null;
        }
    }
    
    public void addPayment(int paymentID, String cardHolderName, String firstName, String lastName, int cardNumber, String expDate, String paidDate, String paymentMethod, double paidAmount) throws SQLException{
        String update = "INSERT INTO IOTUSER.Payment(paymentid, cardHolderName, firstName, lastName, cardNumber, expDate, paidDate, paymentMethod, paidAmount) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement st = conn.prepareStatement(update);
        st.setInt(1, paymentID);
        st.setString(2, cardHolderName);
        st.setString(3, firstName);
        st.setString(4, lastName);
        st.setInt(5, cardNumber);
        st.setString(6, expDate);
        st.setString(3, paidDate);
        st.setString(4, paymentMethod);
        st.setDouble(5, paidAmount);
        st.execute();
    }
    
        public void updatePayment(String cardHolderName, String firstName, String lastName, int cardNumber, String expDate) throws SQLException{
        st.executeUpdate("UPDATE IOTUSER.Payment SET CARDHOLDERNAME='" + cardHolderName + "', FIRSTNAME'=" + firstName +"', LASTNAME='" + lastName +"', CARDNUMBER='" + cardNumber +"', EXPDATE='" + expDate + "'");
    }
    
    public void deletePayment(String paymentID) throws SQLException {
        st.executeUpdate("DELETE FROM IOTUSER.Payment WHERE PAYMENTID='" + paymentID + "'");
    }
    
    public ArrayList<Payment> fetchPayments() throws SQLException {
        ArrayList<Payment> payments = new ArrayList();
        String fetch = "Select * from IOTUSER.Payment";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()){
            int paymentID = rs.getInt(1);
            String cardHolderName = rs.getString(2);
            String firstName = rs.getString(3);
            String lastName = rs.getString(4);
            int cardNumber = rs.getInt(5);
            String expDate = rs.getString(6);
            String paidDate = rs.getString(7);
            String paymentMethod = rs.getString(8);
            double paidAmount = rs.getDouble(9);
            payments.add(new Payment(paymentID, cardHolderName, firstName, lastName, cardNumber, expDate, paidDate, paymentMethod,paidAmount));
        }
        return payments;
    }
    
    public boolean checkPayment(String paymentID) throws SQLException{
       String fetch = "select * from IOTUSER.Payment where PAYMENTID = '" + paymentID + "'";
       ResultSet rs = st.executeQuery(fetch);
       
       while(rs.next()) {
           String userPayment = rs.getString(1);
           
           if (userPayment.equals(paymentID)) {
               return true;
           }
       }
       return false;
   }
}
