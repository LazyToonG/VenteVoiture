package arthur;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatistiqueImplTest {

    private StatistiqueImpl statistique;

    @BeforeEach
    void setUp() {
        statistique = new StatistiqueImpl();
    }

    @Test
    void testPrixMoyenAvecPlusieursVoitures() {
        statistique.ajouter(new Voiture("A", 10));
        statistique.ajouter(new Voiture("B", 20));
        statistique.ajouter(new Voiture("C", 30));

        Echantillon result = statistique.prixMoyen();

        assertEquals(3, result.getNombreDeVoitures());
        assertEquals(20, result.getPrixMoyen()); // (10+20+30)/3
    }

    @Test
    void testPrixMoyenAvecUneVoiture() {
        statistique.ajouter(new Voiture("A", 50));

        Echantillon result = statistique.prixMoyen();

        assertEquals(1, result.getNombreDeVoitures());
        assertEquals(50, result.getPrixMoyen());
    }
}