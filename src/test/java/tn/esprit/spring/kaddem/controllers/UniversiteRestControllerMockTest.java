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
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class UniversiteRestControllerMockTest {

    @InjectMocks
    private UniversiteRestController universiteRestController;

    @Mock
    private IUniversiteService universiteService;

    @Test
    public void testGetUniversites() {
        List<Universite> mockUniversites = new ArrayList<>();
        Universite uni = new Universite();
        uni.setIdUniversite(1);
        uni.setNomUniversite("Test University");
        mockUniversites.add(uni);

        Mockito.when(universiteService.retrieveAllUniversites()).thenReturn(mockUniversites);

        List<Universite> result = universiteRestController.getUniversites();

        assertEquals(1, result.size());
        assertEquals("Test University", result.get(0).getNomUniversite());
    }

    @Test
    public void testAddUniversite() {
        Universite universite = new Universite();
        universite.setIdUniversite(1);
        universite.setNomUniversite("Test University");

        Mockito.when(universiteService.addUniversite(any(Universite.class))).thenReturn(universite);

        Universite addedUniversite = universiteRestController.addUniversite(universite);

        assertEquals("Test University", addedUniversite.getNomUniversite());
        assertEquals(1, addedUniversite.getIdUniversite());
    }

    @Test
    public void testRetrieveUniversite() {
        Universite universite = new Universite();
        universite.setIdUniversite(1);
        universite.setNomUniversite("Test University");

        Mockito.when(universiteService.retrieveUniversite(any(Integer.class))).thenReturn(universite);

        Universite foundUniversite = universiteRestController.retrieveUniversite(1);

        assertEquals("Test University", foundUniversite.getNomUniversite());
        assertEquals(1, foundUniversite.getIdUniversite());
    }

    @Test
    public void testRemoveUniversite() {
        Mockito.doNothing().when(universiteService).deleteUniversite(any(Integer.class));

        universiteRestController.removeUniversite(1);

        Mockito.verify(universiteService, Mockito.times(1)).deleteUniversite(1);
    }

    @Test
    public void testUpdateUniversite() {
        Universite universite = new Universite();
        universite.setIdUniversite(1);
        universite.setNomUniversite("Updated University");

        Mockito.when(universiteService.updateUniversite(any(Universite.class))).thenReturn(universite);

        Universite updatedUniversite = universiteRestController.updateUniversite(universite);

        assertEquals("Updated University", updatedUniversite.getNomUniversite());
        assertEquals(1, updatedUniversite.getIdUniversite());
    }

    // Additional tests for other methods like 'affecterUniversiteToDepartement' and 'listerDepartementsUniversite' can be added here
}