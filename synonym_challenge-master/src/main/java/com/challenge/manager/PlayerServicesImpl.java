package com.challenge.manager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.challenge.dao.GenericDao;
import com.challenge.entity.Player;
import com.challenge.exceptions.ResourceNotFoundException;

@Named
public class PlayerServicesImpl implements PlayerServices {

    @Inject
    GenericDao genericDao;

    @Transactional
    @Override
    public Player add(Player player) throws Exception {
        return genericDao.addEntity(player);
    }

    @Transactional
    @Override
    public Player update(Player player, Integer id) throws Exception {
        try {
        	Player newPlayer = getPlayer(id);
            if (player.getFirstName() != null)
                newPlayer.setFirstName(player.getFirstName());

            if (player.getLastName() != null)
                newPlayer.setLastName(player.getLastName());
            
            if (player.getEmailId() != null)
                newPlayer.setEmailId(player.getEmailId());
            
            if (player.getUserId() != null)
                newPlayer.setUserId(player.getUserId());
            
            if (player.getUserPassword() != null)
                newPlayer.setUserPassword(player.getUserPassword());

            return genericDao.updateEntity(newPlayer);
        } catch (ResourceNotFoundException re) {
            throw re;
        }
    }

    @Transactional
    @Override
    public Player getPlayer(Integer id) throws Exception {
        String query = "from Player where playerId = ?";
        List<Object> list = new ArrayList<Object>();
        list.add(id);
        Player player = genericDao.getEntity(query, list);
        if (player == null)
            throw new ResourceNotFoundException("Player Id :" + id + " not exist");
        return player;
    }

    @Transactional
    @Override
    public List<Player> getPlayers() throws Exception {
        String query = "from Player";
        return genericDao.getEntities(query, null);
    }


    @Transactional
    @Override
    public boolean delete(Integer id) throws Exception {
        return genericDao.deleteEntity(getPlayer(id));
    }
    
    @Transactional
    @Override
    public Player getPlayer(String userId, String pswd) throws Exception {
        String query = "from Player where userId = ? and userPassword = ?";
        List<Object> list = new ArrayList<Object>();
        list.add(userId);
        list.add(pswd);
        Player player = genericDao.getEntity(query, list);
        if (player == null)
            return null;
        return player;
    }

}

