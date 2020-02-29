package com.challenge.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.challenge.dao.GenericDao;
import com.challenge.entity.Dictionary;
import com.challenge.entity.Game;
import com.challenge.exceptions.ResourceNotFoundException;

@Named
public class GameServicesImpl implements GameServices {

    @Inject
    GenericDao genericDao;
    
    @Inject
	DictionaryServices dictionaryServicesImpl;

	private static List<String> vowels = new ArrayList<String>(Arrays.asList("a", "e", "i", "o", "u","A", "E", "I", "O", "U"));

	Random r = new Random();


    @Transactional
    @Override
    public Game add(Game game) throws Exception {

		// Fetch a random word from dictionary
		List<Dictionary> wordList = dictionaryServicesImpl.getDictionary();

		// Set the word_id in game object

		Dictionary word = wordList.get(r.nextInt(wordList.size()));

		// Insert the game object and return the word id to front end
		game.setWord(word);
        return genericDao.addEntity(game);
    }

    @Transactional
    @Override
    public Game update(Game game, Integer id) throws Exception {
        try {
        	Game newGame = getGame(id);
            if (game.getWord() != null)
                newGame.setWord(game.getWord());
            if (game.getPlayer() != null)
                newGame.setPlayer(game.getPlayer());
            if (game.getResponse1() != null)
				newGame.setResponse1(game.getResponse1());
			if (game.getResponse2() != null)
				newGame.setResponse2(game.getResponse2());
			if (game.getResponse3() != null)
				newGame.setResponse3(game.getResponse3());


			//Get the Word for the game
			Game gameDb = getGame(id);

			//Find the correct responses from the dictionary table
			List<String> correctSynonyms = new ArrayList<String>();
			correctSynonyms.add(gameDb.getWord().getSynonym1());
			correctSynonyms.add(gameDb.getWord().getSynonym2());
			correctSynonyms.add(gameDb.getWord().getSynonym3());

			//Calculate the score for the actual response
			char[] response1 = null;
			char[] response2 = null;
			char[] response3 = null;

			if (game.getResponse1() != null && correctSynonyms.contains(game.getResponse1())) {
				response1 = game.getResponse1().toCharArray();
			}
			if (game.getResponse2() != null && correctSynonyms.contains(game.getResponse2())) {
				response2 = game.getResponse2().toCharArray();
			}
			if (game.getResponse3() != null && correctSynonyms.contains(game.getResponse3())) {
				response3 = game.getResponse3().toCharArray();
			}

			int totalScore = calculateScore(response1) + calculateScore(response2) + calculateScore(response3);

			newGame.setScore(totalScore);


            return genericDao.updateEntity(newGame);
        } catch (ResourceNotFoundException re) {
            throw re;
        }
    }
    
 // Calculating score for a response
 	private int calculateScore(char[] response) {
 		int score = 0;
 		if (response == null) {
 			return 0;
 		} else {
 			System.out.println(response);
 			for (int i = 0; i < response.length; i++) {
 				if (vowels.contains(String.valueOf(response[i]))) {
 					score = score + 1;
 				} else {
 					score = score + 2;
 				}

 			}

 		}
 		return score;
 	}

    @Transactional
    @Override
    public Game getGame(Integer id) throws Exception {
        String query = "from Game where gameId = ?";
        List<Object> list = new ArrayList<Object>();
        list.add(id);
        Game game = genericDao.getEntity(query, list);
        if (game == null)
            throw new ResourceNotFoundException("Game Id :" + id + " not exist");
        return game;
    }

    @Transactional
    @Override
    public List<Game> getGames() throws Exception {
        String query = "from Game";
        return genericDao.getEntities(query, null);
    }


    @Transactional
    @Override
    public boolean delete(Integer id) throws Exception {
        return genericDao.deleteEntity(getGame(id));
    }

}

