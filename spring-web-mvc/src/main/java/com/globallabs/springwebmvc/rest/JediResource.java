package com.globallabs.springwebmvc.rest;


import com.globallabs.springwebmvc.model.Jedi;
import com.globallabs.springwebmvc.service.JediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class JediResource {

    @Autowired
    private JediService jediService;

    @GetMapping("/api/jedi")
    public List<Jedi> getAllJedi()
    {
        return jediService.findAll();
    }

    @GetMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> getJediById(@PathVariable("id") Long id, HttpResponse response)
    {
        Jedi jedi = jediService.findById(id);

        return ResponseEntity.ok(jedi);
    }

    @PostMapping("/api/jedi")
    @ResponseStatus(HttpStatus.CREATED)
    public Jedi createJedi(@Valid @RequestBody Jedi jedi)
    {
        return jediService.save(jedi);
    }

    @PutMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> updateJedi(@PathVariable("id") Long id, @Valid @RequestBody Jedi dto) //@RequestBody = converter de JSON
    {
        return ResponseEntity.ok(jediService.update(id, dto));
    }

    @DeleteMapping("/api/jedi/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id)
    {
        jediService.delete(id);
    }
}
