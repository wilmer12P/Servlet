/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MiServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String usuario = request.getParameter("usuario");
            String clave = request.getParameter("clave");
            String msg;
            if (usuario.equals("wilmer primo") && clave.equals("123")) {
                msg = "Bienvenido " + usuario;

            } else {
                msg = "usuario o clave incorrecto";
            }
            System.out.println("usuario: " + usuario + " clave" + clave);
            
            JsonObject gson = new JsonObject();
            gson.addProperty("msg", msg);
            out.print(gson.toString());

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
