package arthur;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EchantillonTest {

    @Test
    public void testEchantillonSettersAndNoArgsConstructor() {
        // 1. Test du constructeur par défaut (0% -> 100%)
        Echantillon echantillon = new Echantillon();
        assertNotNull(echantillon);

        // 2. Test du setter setNombreDeVoitures (0% -> 100%)
        echantillon.setNombreDeVoitures(10);
        assertEquals(10, echantillon.getNombreDeVoitures());

        // 3. Test du setter setPrixMoyen (0% -> 100%)
        echantillon.setPrixMoyen(15000);
        assertEquals(15000, echantillon.getPrixMoyen());
    }
}