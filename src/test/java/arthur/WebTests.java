package arthur;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class WebTests {

    @MockBean
    Statistique statistique;

    @Autowired
    MockMvc mockMvc;

    @Test
    void testCreerVoiture() throws Exception {

        String voitureJson = """
        {
          "marque": "Renault",
          "prix": 20000
        }
        """;

        mockMvc.perform(post("/voiture")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(voitureJson))
                .andExpect(status().isOk());

        verify(statistique, times(1)).ajouter(any(Voiture.class));
    }

    @Test
    void testGetStatistiquesSuccess() throws Exception {

        Echantillon mock = new Echantillon(2, 25000);

        when(statistique.prixMoyen()).thenReturn(mock);

        mockMvc.perform(get("/statistique"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreDeVoitures").value(2))
                .andExpect(jsonPath("$.prixMoyen").value(25000));
    }

    @Test
    void testGetStatistiquesException() throws Exception {

        when(statistique.prixMoyen())
                .thenThrow(new ArithmeticException());

        mockMvc.perform(get("/statistique"))
                .andExpect(status().isBadRequest());    }
}