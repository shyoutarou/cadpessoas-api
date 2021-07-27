package apirest.maven.cadpessoas.service;

import apirest.maven.cadpessoas.dto.request.PersonDTO;
import apirest.maven.cadpessoas.dto.response.MessageResponseDTO;
import apirest.maven.cadpessoas.entity.Person;
import apirest.maven.cadpessoas.repository.PersonRepository;
import apirest.maven.cadpessoas.utils.PersonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = PersonUtils.createFakeDTO();
        Person expectedSavedPerson = PersonUtils.createFakeEntity();

        Mockito.when(personRepository.save(Mockito.any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = CreateExpectedMessageResponse(expectedSavedPerson.getId());

        MessageResponseDTO successMessage = personService.createPerson(personDTO);

        Assertions.assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO CreateExpectedMessageResponse(long id) {
        return MessageResponseDTO.builder()
                .message("Created person with ID " + id)
                .build();
    }

}
