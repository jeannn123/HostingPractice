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

public class mantenimientoUsuarioServletBuscar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String usuario=request.getParameter("txtUsuarioB");
            mantenimientoUsuarioClase busuario=mantenimientoUsuarioMetodos.consultarUsuario(usuario);
            if(busuario!=null){
                request.setAttribute("busuario", busuario);
                request.getRequestDispatcher("mantenimientoUsaurioBuscar.jsp").forward(request, response);
            }else{
                out.println("Error, no se encontro el usuario.");
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
