package Matawan.football.equipe;

import Matawan.football.equipe.model.Equipe;
import Matawan.football.equipe.repository.EquipeRepository;
import Matawan.football.equipe.service.EquipeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.*;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class EquipeServiceTest {
    @InjectMocks
    private EquipeService equipeService;

    @Mock
    private EquipeRepository equipeRepository;

    public EquipeServiceTest() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testGetAllEquipes() {
        // Given
        Equipe equipe = new Equipe();
        Page<Equipe> equipePage = new PageImpl<>(Collections.singletonList(equipe));
        Pageable pageable = PageRequest.of(0, 10, Sort.by("name"));

        when(equipeRepository.findAll(pageable)).thenReturn(equipePage);

        // When
        Page<Equipe> result = equipeService.getAllEquipes(0, 10, "name");

        // Then
        assertEquals(1, result.getTotalElements());
        assertEquals(equipe, result.getContent().get(0));
    }
    @Test
    void testSaveEquipe() {
        Equipe equipe = new Equipe();
        equipe.setName("OGC Nice");
        equipe.setAcronym("OGCN");
        equipe.setBudget(1000000.00);

        when(equipeRepository.save(equipe)).thenReturn(equipe);

        Equipe savedEquipe = equipeService.saveEquipe(equipe);

        assertEquals(equipe.getName(), savedEquipe.getName());
        verify(equipeRepository).save(equipe);
    }
}

