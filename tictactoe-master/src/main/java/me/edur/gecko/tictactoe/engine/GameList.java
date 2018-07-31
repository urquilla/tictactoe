package me.edur.gecko.tictactoe.engine;

public class GameList {
    private static final GameList instance = new GameList();

    private Game[] games = new Game[20];

    private int lastId = -1;

    private GameList(){
    }

    public static GameList getInstance() {
        return instance;
    }


    public synchronized Game getGame(int id){
        return games[id];
    }

    public synchronized Game newGame(){
        lastId++;
        games[lastId] = new Game(lastId);
        return games[lastId];
    }
    
    
}
