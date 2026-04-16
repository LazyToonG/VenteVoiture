package arthur;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VoitureTest {

    @Test
    void testConstructeur() {
        Voiture v = new Voiture("Toyota", 20000);

        assertAll(
                () -> assertEquals("Toyota", v.getMarque(), "La marque doit être Toyota"),
                () -> assertEquals(20000, v.getPrix(), "Le prix doit être 20000")
        );
    }

    @Test
    void testGetMarque() {
        Voiture v = new Voiture("BMW", 30000);

        assertEquals("BMW", v.getMarque());
    }

    @Test
    void testSetMarque() {
        Voiture v = new Voiture("Audi", 25000);
        v.setMarque("Mercedes");

        assertEquals("Mercedes", v.getMarque());
    }

    @Test
    void testGetPrix() {
        Voiture v = new Voiture("Peugeot", 14000);

        assertEquals(14000, v.getPrix());
    }

    @Test
    void testSetPrix() {
        Voiture v = new Voiture("Renault", 10000);
        v.setPrix(12000);

        assertEquals(12000, v.getPrix());
    }

    @Test
    void testPlusieursModifications() {
        Voiture v = new Voiture("Ford", 18000);

        v.setMarque("Tesla");
        v.setPrix(50000);

        assertAll(
                () -> assertEquals("Tesla", v.getMarque()),
                () -> assertEquals(50000, v.getPrix())
        );
    }
}