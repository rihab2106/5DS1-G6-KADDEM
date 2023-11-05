package tn.esprit.spring.kaddem.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.kaddem.entities.Universite;
import tn.esprit.spring.kaddem.services.IUniversiteService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UniversiteRestControllerMockTest {

    @InjectMocks
    private UniversiteRestController universiteRestController;

    @Mock
    private IUniversiteService universiteService;

    @Test
    public void testGetUniversites() {
        // Mock the behavior of the universiteService for retrieveAllUniversites method
        List<Universite> mockUniversites = new ArrayList<>();
        mockUniversites.add(new Universite(1, "Test University 1")); // add mock Universite
        mockUniversites.add(new Universite(2, "Test University 2")); // add another mock Universite

        Mockito.when(universiteService.retrieveAllUniversites()).thenReturn(mockUniversites);

        List<Universite> universites = universiteRestController.getUniversites();

        // Now, you should assert the values of the universites list
        assertEquals(2, universites.size());
        assertEquals("Test University 1", universites.get(0).getNomUniv());
        assertEquals("Test University 2", universites.get(1).getNomUniv());
    }

    @Test
    public void testAddUniversite() {
        // Mock the behavior of the universiteService for addUniversite method
        Universite universite = new Universite("Test University");
        universite.setIdUniv(1);

        Mockito.when(universiteService.addUniversite(Mockito.any(Universite.class))).thenReturn(universite);

        Universite addedUniversite = universiteRestController.addUniversite(universite);

        // Now, you should assert the values of the addedUniversite object
        assertEquals("Test University", addedUniversite.getNomUniv());
        assertEquals(1, addedUniversite.getIdUniv());
    }

    // Additional test methods for other endpoints in your controller can be added here,
    // such as testRetrieveUniversite, testRemoveUniversite, testUpdateUniversite, etc.
}
