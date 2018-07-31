package me.edur.gecko.tictactoe;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class SimpleServer {
    public static void main( String[] args ) throws Exception {
        Server server = new Server(8425);
        //Web services
        ServletContextHandler servletContextHandler = new ServletContextHandler();
        servletContextHandler.addServlet(GameServlet.class,"/game/*");
        servletContextHandler.addServlet(MovementServlet.class,"/movement/*");
        server.setHandler(servletContextHandler);

        //Serving static content
        ServletHolder staticHolder = new ServletHolder(new DefaultServlet());
        staticHolder.setInitParameter("resourceBase","./src/main/resources");
        servletContextHandler.addServlet(staticHolder,"/");


        server.start();
        server.dumpStdErr();
        server.join();
    }
}
