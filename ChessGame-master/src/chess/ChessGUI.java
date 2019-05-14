package chess;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ChessGUI extends JFrame implements ActionListener
{
	public static interface ClickListener
	{
		void onClick(Position position);
	}

	PieceButton[][] buttons = new PieceButton[8][8];

	public static final ImageIcon[][] CHESS_PIECE_IMAGES = new ImageIcon[2][6];
	static
	{
		try
		{
			BufferedImage black_king = ImageIO.read(new File("king.png"));
			BufferedImage black_queen = ImageIO.read(new File("black_queen.png"));
			BufferedImage black_rook = ImageIO.read(new File("black_rook.png"));
			BufferedImage black_bishop = ImageIO.read(new File("black_bishop.png"));
			BufferedImage black_knight = ImageIO.read(new File("black_knight.png"));
			BufferedImage black_pawn = ImageIO.read(new File("black_pawn.png"));
			
			BufferedImage white_king = ImageIO.read(new File("white_king.png"));
			BufferedImage white_queen = ImageIO.read(new File("white_queen.png"));
			BufferedImage white_rook = ImageIO.read(new File("white_rook.png"));
			BufferedImage white_bishop = ImageIO.read(new File("white_bishop.png"));
			BufferedImage white_knight = ImageIO.read(new File("white_knight.png"));
			BufferedImage white_pawn = ImageIO.read(new File("white_pawn.png"));
			
			
			
			
			
			
			for (int color = 0; color < 2; color++) {
				for (int type = 0; type < 6; type++) {
					if(color ==0 && type ==0) {
						CHESS_PIECE_IMAGES[color][type] = new ImageIcon(black_king);
					}
					else if(color ==0 && type ==1) {
						CHESS_PIECE_IMAGES[color][type] = new ImageIcon(black_queen);
					}
					else if(color ==0 && type ==2) {
						CHESS_PIECE_IMAGES[color][type] = new ImageIcon(black_rook);
					}
					else if(color ==0 && type ==3) {
						CHESS_PIECE_IMAGES[color][type] = new ImageIcon(black_knight);
					}
					else if(color ==0 && type ==4) {
						CHESS_PIECE_IMAGES[color][type] = new ImageIcon(black_bishop);
					}
					else if(color ==0 && type ==5) {
						CHESS_PIECE_IMAGES[color][type] = new ImageIcon(black_pawn);
					}
					else if(color ==1 && type ==0) {
						CHESS_PIECE_IMAGES[color][type] = new ImageIcon(white_king);
					}
					else if(color ==1 && type ==1) {
						CHESS_PIECE_IMAGES[color][type] = new ImageIcon(white_queen);
					}
					else if(color ==1 && type ==2) {
						CHESS_PIECE_IMAGES[color][type] = new ImageIcon(white_rook);
					}
					else if(color ==1 && type ==3) {
						CHESS_PIECE_IMAGES[color][type] = new ImageIcon(white_knight);
					}
					else if(color ==1 && type ==4) {
						CHESS_PIECE_IMAGES[color][type] = new ImageIcon(white_bishop);
					}
					else if(color ==1 && type ==5) {
						CHESS_PIECE_IMAGES[color][type] = new ImageIcon(white_pawn);
					}
					
				}
			}
				} catch (Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}

	ClickListener onClick;
	JPanel gameBoard;
	private boolean firstUpdate = true;

	public ChessGUI(ClickListener onClick, int color)
	{
		gameBoard = new JPanel();
		gameBoard.setLayout(new GridLayout(8, 8));
		if (color == Piece.WHITE)
		{
			for (Position position : Position.all())
			{
				PieceButton b = new PieceButton(position);
				buttons[position.getColumn()][position.getRow()] = b;
				b.addActionListener(this);
				gameBoard.add(b);
			}
		} else
		{
			Position[] all = Position.all();
			for (int i = all.length - 1; i >= 0; i--)
			{
				Position position = all[i];
				PieceButton b = new PieceButton(position);
				buttons[position.getColumn()][position.getRow()] = b;
				b.addActionListener(this);
				gameBoard.add(b);
			}
		}

		add(gameBoard);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);

		this.onClick = onClick;
	}
	
	public void showThinkingModal(long startTime) {
		JOptionPane.showConfirmDialog(null,
                "Thinking",
                "Thinking", 
                JOptionPane.NO_OPTION,
                JOptionPane.QUESTION_MESSAGE); 
	}
	
	public void hideThinkingModal() {
		
	}

	public void updateBoard(GameBoard board)
	{
		for (Position position : Position.all())
		{
			PieceButton button = buttons[position.getColumn()][position.getRow()];
			Piece piece = board.getPiece(position);
			if (button.getPiece() == null ? piece != null : !button.getPiece().equals(piece)) {
				button.setPiece(piece, !firstUpdate);
			} else if (piece != null && piece.getType() == Piece.KING && board.isCheck(piece.getColor())) {
				button.setPieceCheck(piece);
			} else {
				button.setPiece(piece);
			}
		}
		if (firstUpdate) {
			firstUpdate = false;
		}
		repaint();
	}

	public void clearReachablity()
	{
		for (int r = 0; r < 8; r++)
		{
			for (int c = 0; c < 8; c++)
			{
				if (buttons[c][r].isReachable())
				{
					buttons[c][r].markReachable(false);
				}
			}
		}
	}

	public void setReachablity(ArrayList<Move> pm)
	{
		for (Move m : pm)
		{
			buttons[m.getDestPosition().getColumn()][m.getDestPosition().getRow()].markReachable(true);
		}
	}

	PieceButton selectedbutton;

	@Override
	public void actionPerformed(ActionEvent e)
	{
		PieceButton button = (PieceButton) e.getSource();
		if (onClick != null)
		{
			onClick.onClick(button.getPosition());
		}
	}
}
