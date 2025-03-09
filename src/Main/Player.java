package Main;

import java.util.Objects;



public class Player {

    public String PlayerIdentity;
    public String Turn;
    public String PlayerX;
    public String PlayerO;
    public String player;

    public String getTurn() { return Turn; }

    public void setTurn(String turn)
    {
        if (Objects.equals(turn, "X"))
            Turn = "X";
        else if (Objects.equals(turn, "O"))
            Turn = "O";
        this.Turn = turn;
    }

    public String getPlayer()
    {
      return player;

    }

    public void setPlayer(String player) {
        this.player = player;
    }





}
