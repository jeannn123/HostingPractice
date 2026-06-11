/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package logicaNegocio;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;

import logicaNegocio.mantenimientoUsuarioMetodos;
import logicaNegocio.mantenimientoUsuarioClase;


public class mantenimientoUsuarioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String varCodigo=request.getParameter("txtCodigo");
            String varUsuario=request.getParameter("txtUsuario");
            String varPassword=request.getParameter("txtPassword");
            String varNombres=request.getParameter("txtNombres");
            String varApellidos=request.getParameter("txtApellidos");
            if(!varCodigo.equalsIgnoreCase("") && !varUsuario.equalsIgnoreCase("") && !varPassword.equalsIgnoreCase("")
                    && !varNombres.equalsIgnoreCase("") && !varApellidos.equalsIgnoreCase("")){
                mantenimientoUsuarioClase busuario=new mantenimientoUsuarioClase(varCodigo, varUsuario, varPassword, varNombres, varApellidos);
                boolean sw=mantenimientoUsuarioMetodos.agregarUsuario(busuario);
                if(sw){
                    request.getRequestDispatcher("mantenimientoUsuario.jsp").forward(request, response);
                }else{
                    //PrintWriter out=response.getWriter();
                    out.println("Error.");
                }
            }
        } finally {
            out.close();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
