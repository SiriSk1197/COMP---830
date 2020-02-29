package com.challenge.manager;

import java.util.List;

import com.challenge.entity.Player;

public interface PlayerServices {
	
	// category related stubs
	public Player add(Player Player) throws Exception;
	public Player update(Player Player, Integer id) throws Exception;
	public Player getPlayer(Integer id) throws Exception;
	public List<Player> getPlayers() throws Exception;
	public boolean delete(Integer id) throws Exception;
	public Player getPlayer(String userId, String pswd) throws Exception;
}
