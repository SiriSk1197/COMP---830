package com.challenge.manager;

import java.util.List;

import com.challenge.entity.Dictionary;

public interface DictionaryServices {
	
	// category related stubs
	public Dictionary add(Dictionary dictionary) throws Exception;
	public Dictionary update(Dictionary dictionary, Integer id) throws Exception;
	public Dictionary getDictionary(Integer id) throws Exception;
	public List<Dictionary> getDictionary() throws Exception;
	public boolean delete(Integer id) throws Exception;
}
