FROM tomcat:11.0-jdk21

COPY target/MantenimientoUsuario-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080