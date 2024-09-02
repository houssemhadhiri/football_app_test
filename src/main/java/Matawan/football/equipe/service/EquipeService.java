package Matawan.football.equipe.service;

import Matawan.football.equipe.model.Equipe;
import Matawan.football.equipe.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EquipeService {
    @Autowired
    private EquipeRepository equipeRepository;


    public Page<Equipe> getAllEquipes(int page, int size, String sortBy) {
        Pageable paging = PageRequest.of(page, size, Sort.by(sortBy));
        return equipeRepository.findAll(paging);
    }

    public Equipe saveEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }
}
