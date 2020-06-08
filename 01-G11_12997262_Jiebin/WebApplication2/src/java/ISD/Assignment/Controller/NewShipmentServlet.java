/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISD.Assignment.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ISD.Assignment.Model.shipment;
import ISD.Assignment.Model.Dao.ShipmentManager;

/**
 *
 * @author admin
 */
public class NewShipmentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String preferName = request.getParameter("name");
        String email = request.getParameter("email");
        String phone_number = request.getParameter("phone");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String territory = request.getParameter("city");
        String post_code = request.getParameter("post_code");
        String startDate = request.getParameter("startDate");
        String shipmentMethod = request.getParameter("shipmentMethod");
        ShipmentManager manager = (ShipmentManager) session.getAttribute("manager");
        
        //validator
        if(!validator.validateInt(post_code)){
            session.setAttribute("intErr","Error: It should be digits");
            request.getRequestDispatcher("shipmentNew.jsp").include(request, response);
        }else if(!validator.validateInt(phone_number)){
            session.setAttribute("IDErr","Error:ID format incorrect");
            request.getRequestDispatcher("shipmentSearch.jsp").include(request, response);            
        }else{ 
            try{
            manager.addShipment(preferName, email, Integer. parseInt(phone_number), address, city, territory,Integer. parseInt(post_code) , startDate, shipmentMethod);
            //shipment shipment = new shipment();
            //session.setAttribute("shipment", shipment);
            request.getRequestDispatcher("main.jsp").include(request, response);
        }catch(SQLException ex){
            Logger.getLogger(NewShipmentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }}
}
