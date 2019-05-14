package chess;
public interface Player
{
	Move makeMove(GameBoard board);

	void update(GameBoard board);
	
	int getColor();
}
