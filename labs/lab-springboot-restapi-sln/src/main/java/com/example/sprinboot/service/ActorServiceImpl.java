package com.example.sprinboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sprinboot.model.Actor;
import com.example.springboot.repository.ActorRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActorServiceImpl implements ActorService{

    private final ActorRepository repository;

    @Autowired
    public ActorServiceImpl(ActorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Map<Integer, Actor> getActors() {
        List<Actor> all = repository.findAll();
        Map<Integer, Actor> map = new HashMap<>();

        for(int i=0; i<5; i++){
            map.put(i, all.get(i));
        }
        return map;
    }
}
