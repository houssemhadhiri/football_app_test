package Matawan.football.equipe.controller;

import Matawan.football.equipe.model.Equipe;
import Matawan.football.equipe.service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/equipe")
public class EquipeController {
    @Autowired
    private EquipeService equipeService;

    @GetMapping
    public Page<Equipe> getAllEquipes(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size,
                                      @RequestParam(defaultValue = "name") String sortBy) {
        return equipeService.getAllEquipes(page, size, sortBy);
    }

    @PostMapping
    public Equipe createEquipe(@RequestBody Equipe equipe) {
        return equipeService.saveEquipe(equipe);
    }
}

