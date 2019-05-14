package chess;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Random;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.nwgjb.xrmi.RMIConnection;

public class Main {

	static {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

	static final boolean NETWORKING = false;

	public static void startGame(Player p1, Player p2) {
		GameBoard board = new GameBoard();
		p1.update(board);
		p2.update(board);
		int currentTurn = Piece.WHITE;
		Player[] players = new Player[Piece.COLORS.length];
		players[0] = p1.getColor() == Piece.WHITE ? p1 : p2;
		players[1] = p2.getColor() == Piece.BLACK ? p2 : p1;
		while (true) {
			currentTurn = (currentTurn + 1) % 2;
			Move m = players[currentTurn].makeMove(board);
			if (m == null) {
				System.out.println("~~~~~~~" + players[currentTurn].getClass().getName() + " Defeated~~~~~~~~~");
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			board.apply(m);
			p1.update(board);
			p2.update(board);
		}
	}

	public static void main(String[] args) throws IOException {
		Random r = new Random();
		int col = r.nextInt(2);
		Player p2;
		if (NETWORKING) {
			ServerSocket socket = new ServerSocket(12345);
			p2 = ((ClientPlayerFactory) new RMIConnection(socket.accept()).getBind()).create(Piece.BLACK);
			socket.close();
		} else {
			p2 = new PlayerComputer(Piece.getOppositeColor(col), 5.0);
		}
		Player p1 = new PlayerUser(col);
		startGame(p1, p2);
	}
}
