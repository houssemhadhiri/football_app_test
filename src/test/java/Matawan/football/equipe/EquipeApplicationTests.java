package Matawan.football.equipe;

import Matawan.football.equipe.controller.EquipeController;
import Matawan.football.equipe.model.Equipe;
import Matawan.football.equipe.service.EquipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class EquipeApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private EquipeService equipeService;

    @InjectMocks
    private EquipeController equipeController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(equipeController).build();
    }

    @Test
    public void testGetAllEquipes() throws Exception {
        Equipe equipe = new Equipe();
        equipe.setName("Nice");
        equipe.setAcronym("OGCN");
        equipe.setBudget(50000000);

        Page<Equipe> equipes = new PageImpl<>(List.of(equipe), PageRequest.of(0, 10, Sort.by("name")), 1);

        when(equipeService.getAllEquipes(0, 10, "name")).thenReturn(equipes);

        mockMvc.perform(get("/api/equipe")
                        .param("page", "0")
                        .param("size", "10")
                        .param("sortBy", "name")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.content[0].name").value("Nice"))
                .andExpect(jsonPath("$.content[0].acronym").value("OGCN"))
                .andExpect(jsonPath("$.content[0].budget").value(50000000));
    }

    @Test
    public void testCreateEquipe() throws Exception {
        Equipe equipe = new Equipe();
        equipe.setName("Nice");
        equipe.setAcronym("OGCN");
        equipe.setBudget(50000000);

        when(equipeService.saveEquipe(any(Equipe.class))).thenReturn(equipe);

        mockMvc.perform(post("/api/equipe")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Nice\", \"acronym\":\"OGCN\", \"budget\":50000000}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Nice"))
                .andExpect(jsonPath("$.acronym").value("OGCN"))
                .andExpect(jsonPath("$.budget").value(50000000));
    }
}
