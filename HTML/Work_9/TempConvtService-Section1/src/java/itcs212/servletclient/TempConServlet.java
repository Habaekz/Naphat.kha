/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itcs212.servletclient;

import itcs212.tutews1.HelloWorldWS_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author naphatkhajohn-udomrith
 */
@WebServlet(name = "TempConServlet", urlPatterns = {"/TempConServlet"})
public class TempConServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "/Users/naphatkhajohn-udomrith/data/TempConvtService-Section1/src/conf/xml-resources/web-service-references/HelloWorldWS/wsdl/localhost_8080/HelloWorldWebApplication-Section1/HelloWorldWS.wsdl")
    private HelloWorldWS_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String celsius = request.getParameter("tempc"); 
            String fahrenheit =celsiusToFahrenheit(Double.parseDouble(celsius));
            out.println("<!DOCTYPE html>"); 
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TempConServlet</title>"); 
            out.println("</head>");
            out.println("<body>");
            out.println("The temperature in Fahrenheit is: " + fahrenheit);
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String celsiusToFahrenheit(double celsius) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        itcs212.tutews1.HelloWorldWS port = service.getHelloWorldWSPort();
        return port.celsiusToFahrenheit(celsius);
    }

}
