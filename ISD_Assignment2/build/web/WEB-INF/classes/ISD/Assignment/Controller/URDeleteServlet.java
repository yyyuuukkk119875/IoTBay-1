/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISD.Assignment.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ISD.Assignment.Model.Dao.UserManagementDao;
import ISD.Assignment.Model.User;
import ISD.Assignment.Model.Dao.DBConnector;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class URDeleteServlet extends HttpServlet {

  @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{ 
            HttpSession session = request.getSession();
            UserManagementDao ud = (UserManagementDao) session.getAttribute("ud");
            String email = request.getParameter("email");
            try {
                ud.deleteUserRecord(email);
                response.sendRedirect("URServlet");
            } catch (SQLException e){
               throw new ServletException("Cannot add UR to DB", e); 
            }
        }  
}
