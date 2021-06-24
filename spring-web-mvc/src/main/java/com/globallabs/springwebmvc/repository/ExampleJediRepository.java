package com.globallabs.springwebmvc.repository;

import com.globallabs.springwebmvc.model.Jedi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ExampleJediRepository {

    private List<Jedi> jedi;

    public ExampleJediRepository() {
        jedi = new ArrayList<>();
        jedi.add(new Jedi("Luke", "Skywalker"));
        jedi.add(new Jedi("Obi-Wan", "Kenobi"));
    }

    public List<Jedi> getAllJedi(){
        return this.jedi;
    }

    public void add(Jedi jedi) {
        this.jedi.add(jedi);
    }
}
