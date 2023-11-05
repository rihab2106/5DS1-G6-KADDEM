import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.services.EquipeServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

public class EquipeTest {

    @InjectMocks
    private EquipeServiceImpl equipeService;

    @Mock
    private EquipeRepository equipeRepository; // Mocking the repository

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllEquipes() {
        //  Create a list of Equipe objects to be returned by the mock repository
        List<Equipe> mockEquipes = new ArrayList<>();
        // Create an Equipe object for testing
        Equipe equipe = new Equipe();
        equipe.setIdEquipe(1); // Set the ID
        equipe.setNomEquipe("Test Equipe"); // Set the name
        equipe.setNiveau(Niveau.JUNIOR); // Set the level



        mockEquipes.add(equipe);

        // Configure the behavior of the mock repository
        when(equipeRepository.findAll()).thenReturn(mockEquipes);

        // Act: Call the method to be tested
        List<Equipe> result = equipeService.retrieveAllEquipes();

        // Assert: Verify the result matches your expectations
        assertEquals(mockEquipes, result);
    }


}
