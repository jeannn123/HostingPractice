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


public class sesionVerificaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest objetoPeticion1, HttpServletResponse objetoRespuesta1)
            throws ServletException, IOException {

        objetoRespuesta1.setContentType("text/html;charset=UTF-8");
        PrintWriter out = objetoRespuesta1.getWriter();
        try {

            String varUsuario =objetoPeticion1.getParameter("txtUsuario");
            String varPassword =objetoPeticion1.getParameter("txtPassword");
            String [] datos=sesionClase.getFila("select * from defaultdb.usuario where usuario='"+varUsuario+"' and password='"+varPassword+"'");
            if (datos==null){
                out.println("<html>");
                out.println("Error, el usuario ");
                out.println("<b>"+varUsuario+"</b>");
                out.println(", no cumple con los datos solicitados, Para reingresar de click<a href='index.jsp'>Aqui</a>");
                out.println("</html>");
            }else{//Capturamos las variables
                String varCodigo=datos[0];
                String varNombres=datos[3];
                String varApellidos=datos[4];
                HttpSession session=objetoPeticion1.getSession(true);//Obtenemos los objetos a guardar en la sesion
                session.setAttribute("varCodigoSesion",varCodigo);
                session.setAttribute("varNombresSesion",varNombres);
                session.setAttribute("varApellidosSesion",varApellidos);
                objetoRespuesta1.sendRedirect("menuPrincipal.jsp");
            }
        } finally {out.close(); }
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
