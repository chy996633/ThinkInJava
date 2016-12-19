package interfaces;

import static net.mindview.util.Print.*;

interface Game {
	boolean move();
}

interface GameFactory {
	Game getGame();
}

class CheckerGame implements Game {
	private int moves = 0;
	private static final int MOVES = 3;

	public boolean move() {
		print("Checkers move " + moves);
		return ++moves != MOVES;
	}
}

class CheckerFactory implements GameFactory {
	public Game getGame() {
		return new CheckerGame();
	}
}

class Chess implements Game {
	private int moves = 0;
	private static final int MOVES = 4;

	public boolean move() {
		print("Chess move " + moves);
		return ++moves != MOVES;
	}
}

class ChessFactory implements GameFactory {
	public Game getGame() {
		return new Chess();
	}
}

public class Games {
	/**
	 * 这段代码可以被复用
	 * @param factory
	 */
	public static void playGame(GameFactory factory){
		Game game = factory.getGame();
		while(game.move())
			;
	}
	
	public static void main(String[] args){
		playGame(new CheckerFactory());
		playGame(new ChessFactory());
	}
	

}
