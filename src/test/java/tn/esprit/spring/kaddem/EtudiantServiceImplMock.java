package tn.esprit.spring.kaddem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;
import tn.esprit.spring.kaddem.services.EtudiantServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class EtudiantServiceImplMock {

    @InjectMocks
    private EtudiantServiceImpl etudiantService;

    @Mock
    private EtudiantRepository etudiantRepository;

    @Test
    public void testAddEtudiant() {
        // Mock the behavior of the EtudiantRepository for save method
        Etudiant etudiant = new Etudiant();
        etudiant.setNomE("Ayoub");
        etudiant.setPrenomE("Mouelhi");

        Mockito.when(etudiantRepository.save(Mockito.any(Etudiant.class))).thenReturn(etudiant);

        Etudiant addedEtudiant = etudiantService.addEtudiant(etudiant);

        // Now, you should assert the values of the addedEtudiant object
        assertEquals("Ayoub", addedEtudiant.getNomE());
        assertEquals("Mouelhi", addedEtudiant.getPrenomE());
    }

    @Test
    public void testRetrieveAllEtudiants() {
        // Mock the behavior of the EtudiantRepository for findAll method
        Etudiant etudiant = new Etudiant();
        etudiant.setIdEtudiant(1);
        etudiant.setNomE("foulen");
        etudiant.setPrenomE("fouleni");

        List<Etudiant> etudiantList = new ArrayList<>();
        etudiantList.add(etudiant);



        Mockito.when(etudiantRepository.findAll()).thenReturn(etudiantList);

        List<Etudiant> etudiantListResult = etudiantService.retrieveAllEtudiants();

        assertEquals(1, etudiantListResult.size()); // Assuming one Etudiant was added in the setup
    }
}