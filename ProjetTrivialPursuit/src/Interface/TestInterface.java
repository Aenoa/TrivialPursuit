package Interface;

import classes.Players;

public class TestInterface {
	public static void main(String[] args)
	{
            CreerCarte cr= new CreerCarte();
            cr.setVisible(true);
            
            Connection login = new Connection();
            login.setVisible(true);
            
            Game game = new Game(Players.getPlayerList());
            game.setVisible(true);
            
            MenuJeu mj = new MenuJeu();
            mj.setVisible(true);
	}

}
