package com.globallabs.springwebmvc.service;

import com.globallabs.springwebmvc.exception.JediNotFoundException;
import com.globallabs.springwebmvc.model.Jedi;
import com.globallabs.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class JediService {

    @Autowired
    private JediRepository jediRepository;

    public List<Jedi> findAll()
    {
        return jediRepository.findAll();
    }

    public Jedi findById(Long id) {
        Optional<Jedi> jedi = jediRepository.findById(id);

        if(jedi.isPresent())
        {
            return jedi.get();
        }
        else
        {
            throw new JediNotFoundException();
        }
    }

    public Jedi save(Jedi jedi) {
        return jediRepository.save(jedi);
    }

    public Jedi update(Long id, Jedi dto) {
        Optional<Jedi> newJedi = jediRepository.findById(id);
        Jedi jedi;

        if(newJedi.isPresent())
        {
            jedi = newJedi.get();
        }else{
            throw new JediNotFoundException();
        }

        jedi.setName(dto.getName());
        jedi.setLastName(dto.getLastName());

        return jediRepository.save(jedi);
    }

    public void delete(Long id)
    {
        Jedi jedi = findById(id);

        jediRepository.delete(jedi);
    }

}
