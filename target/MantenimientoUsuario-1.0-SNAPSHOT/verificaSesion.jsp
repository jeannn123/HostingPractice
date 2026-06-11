<%@ page session="true" %>
<%
    String varNombresMostrar="";
    HttpSession varSesion2=request.getSession();
    if(varSesion2.getAttribute("varNombresSesion")==null){
%>
        <jsp:forward page="index.jsp">
            <jsp:param name="error" value="Ingreses sus datos"/>
        </jsp:forward>
<%
    }else{
        varNombresMostrar=""+session.getAttribute("varNombresSesion");
    }
%>
