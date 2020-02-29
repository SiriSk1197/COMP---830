package com.challenge.manager;

import java.util.List;

import com.challenge.entity.Game;

public interface GameServices {
	
	// category related stubs
	public Game add(Game Player) throws Exception;
	public Game update(Game Player, Integer id) throws Exception;
	public Game getGame(Integer id) throws Exception;
	public List<Game> getGames() throws Exception;
	public boolean delete(Integer id) throws Exception;
}
