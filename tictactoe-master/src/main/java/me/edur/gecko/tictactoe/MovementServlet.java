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

public class MovementServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter out = resp.getWriter();

        int id = Integer.parseInt(req.getParameter("id"));
        int token = Integer.parseInt(req.getParameter("token"));
        int x = Integer.parseInt(req.getParameter("x"));
        int y = Integer.parseInt(req.getParameter("y"));

        GameList gameList = GameList.getInstance();
        Game game = gameList.getGame(id);
        game.play(x,y,token);
        

        out.println(new Gson().toJson(game));

        resp.setStatus(HttpServletResponse.SC_OK);
    }
    
    
   
}
