package com.challenge.manager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.challenge.dao.GenericDao;
import com.challenge.entity.Dictionary;
import com.challenge.exceptions.ResourceNotFoundException;

@Named
public class DictionaryServicesImpl implements DictionaryServices {

    @Inject
    GenericDao genericDao;

    @Transactional
    @Override
    public Dictionary add(Dictionary dictionary) throws Exception {
        return genericDao.addEntity(dictionary);
    }

    @Transactional
    @Override
    public Dictionary update(Dictionary dictionary, Integer id) throws Exception {
        try {
        	Dictionary newDictionary = getDictionary(id);
            if (dictionary.getWord() != null)
            	newDictionary.setWord(dictionary.getWord());
            if (dictionary.getSynonym1() != null)
            	newDictionary.setSynonym1(dictionary.getSynonym1());
            if (dictionary.getSynonym2() != null)
            	newDictionary.setSynonym2(dictionary.getSynonym2());
            if (dictionary.getSynonym3() != null)
            	newDictionary.setSynonym3(dictionary.getSynonym3());
  
            
            return genericDao.updateEntity(newDictionary);
        } catch (ResourceNotFoundException re) {
            throw re;
        }
    }

    @Transactional
    @Override
    public Dictionary getDictionary(Integer id) throws Exception {
        String query = "from Dictionary where word_id = ?";
        List<Object> list = new ArrayList<Object>();
        list.add(id);
        Dictionary dictionary = genericDao.getEntity(query, list);
        if (dictionary == null)
            throw new ResourceNotFoundException("Dictionary Id :" + id + " not exist");
        return dictionary;
    }

    @Transactional
    @Override
    public List<Dictionary> getDictionary() throws Exception {
        String query = "from Dictionary";
        return genericDao.getEntities(query, null);
    }


    @Transactional
    @Override
    public boolean delete(Integer id) throws Exception {
        return genericDao.deleteEntity(getDictionary(id));
    }

}

