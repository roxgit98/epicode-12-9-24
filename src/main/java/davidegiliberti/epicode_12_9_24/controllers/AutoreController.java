package davidegiliberti.epicode_12_9_24.controllers;


import davidegiliberti.epicode_12_9_24.entities.Autore;
import davidegiliberti.epicode_12_9_24.services.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autore")
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    @GetMapping
    private List<Autore> getAllAutori() {
        return autoreService.findAll();
    }

    @GetMapping("/autoreId")
    private Autore getAutoreById(@PathVariable int autoreId) {
        return autoreService.findById(autoreId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Autore createAutore(@RequestBody Autore body) {
        return autoreService.saveAutore(body);
    }

    @PutMapping("/autoreId")
    private Autore findAndUpdate(@PathVariable int autoreId, @RequestBody Autore body) {
        return autoreService.update(autoreId, body);
    }

    @DeleteMapping("/blogId")
    @ResponseStatus(HttpStatus.OK)
    private void deleteAutore(@PathVariable int autoreId) {
        autoreService.delete(autoreId);
    }
}
