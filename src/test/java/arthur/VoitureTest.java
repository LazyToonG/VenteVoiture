package arthur;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.util.*;

//import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest
public class VoitureTest {

    private Voiture voiture;

    @BeforeEach
    public void setUp(){
        this.voiture=new Voiture();
    }

    @Test
    public void creerVoiture() {
        assertEquals(1, 1);
    }

    @Test
    public void testConstructeurParDefaut() {
        assertNull(this.voiture.getMarque());
        assertEquals(0, this.voiture.getPrix());
        assertEquals(0, voiture.getId());
    }

    @Test
    void testConstructeurAvecParametres() {
        Voiture voitureB = new Voiture("Toyota", 20000);
        assertEquals("Toyota", voitureB.getMarque());
        assertEquals(20000, voitureB.getPrix());
    }

    @Test
    public void testSettersEtGetters() {
        Voiture voiture = new Voiture();

        voiture.setMarque("BMW");
        voiture.setPrix(35000);
        voiture.setId(1);

        assertEquals("BMW", voiture.getMarque());
        assertEquals(35000, voiture.getPrix());
        assertEquals(1, voiture.getId());
    }

    @Test
    public void testToString() {
        Voiture voiture = new Voiture("Audi", 30000);
        voiture.setId(5);

        String resultat = voiture.toString();

        assertTrue(resultat.contains("Audi"));
        assertTrue(resultat.contains("30000"));
        assertTrue(resultat.contains("5"));
    }

}