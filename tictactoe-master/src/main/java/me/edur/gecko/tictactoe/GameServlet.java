package me.edur.gecko.tictactoe;

import com.google.gson.Gson;
import me.edur.gecko.tictactoe.engine.Game;
import me.edur.gecko.tictactoe.engine.GameList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter out = resp.getWriter();
        
        
        String id = req.getParameter("id");
         if(id==null||id.trim().isEmpty()) {
            out.println("{error:'No parameter id'}");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        int intId = Integer.parseInt(id);
        GameList gameList = GameList.getInstance();
        Game game = gameList.getGame(intId);
        
     


        out.println(new Gson().toJson(game));

        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter out = resp.getWriter();


        GameList gameList = GameList.getInstance();
        Game game = gameList.newGame();
        out.println(new Gson().toJson(game));



        resp.setStatus(HttpServletResponse.SC_OK);
    }

}
