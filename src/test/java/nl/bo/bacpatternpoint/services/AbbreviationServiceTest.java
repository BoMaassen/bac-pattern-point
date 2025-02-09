package nl.bo.bacpatternpoint.services;

import nl.bo.bacpatternpoint.dtos.AbbreviationCreateDto;
import nl.bo.bacpatternpoint.dtos.AbbreviationResponseDto;
import nl.bo.bacpatternpoint.dtos.AbbreviationUpdateDto;
import nl.bo.bacpatternpoint.exception.RecordNotFoundException;
import nl.bo.bacpatternpoint.models.Abbreviation;
import nl.bo.bacpatternpoint.models.Pattern;
import nl.bo.bacpatternpoint.repositories.AbbreviationRepository;
import nl.bo.bacpatternpoint.repositories.PatternRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AbbreviationServiceTest {

    @Mock
    private AbbreviationRepository abbreviationRepository;

    @Mock
    private PatternRepository patternRepository;

    @InjectMocks
    private AbbreviationService abbreviationService;

    private Pattern mockPattern;
    private List<Abbreviation> mockAbbreviations;
    private List<AbbreviationCreateDto> abbreviationCreateDtos;
    private AbbreviationUpdateDto abbreviationUpdateDto;
    private Abbreviation updatedAbbreviation;
    private AbbreviationResponseDto expectedResponse;

    @BeforeEach
    void setUp() {
        mockPattern = new Pattern(1L, "Title", "Beginner", "Beschrijving", 3.0, 30, "wol", true, true, true, 10.5, 15.5, false);
        mockAbbreviations = Arrays.asList(
                new Abbreviation("dc", "Double crochet"),
                new Abbreviation("sc", "Single crochet")
        );
        mockPattern.setAbbreviations(mockAbbreviations);

        abbreviationCreateDtos = Arrays.asList(
                new AbbreviationCreateDto("dc", "Double crochet"),
                new AbbreviationCreateDto("sc", "Single crochet")
        );

        abbreviationUpdateDto = new AbbreviationUpdateDto("hdc", "Half double crochet");

        updatedAbbreviation = new Abbreviation();
        updatedAbbreviation.setId(1L);
        updatedAbbreviation.setAbbreviated("hdc");
        updatedAbbreviation.setFullForm("Half double crochet");
        updatedAbbreviation.setPattern(mockPattern);

        expectedResponse = new AbbreviationResponseDto();
        expectedResponse.setId(1L);
        expectedResponse.setAbbreviated("hdc");
        expectedResponse.setFullForm("Half double crochet");
    }

    @Test
    void testCreateAbbreviationsPatternFound() {
        // Arrange
        when(patternRepository.findById(1L)).thenReturn(Optional.of(mockPattern));
        when(abbreviationRepository.saveAll(anyList())).thenReturn(mockAbbreviations);

        // Act
        List<AbbreviationResponseDto> response = abbreviationService.createAbbreviations(1L, abbreviationCreateDtos);

        // Assert
        assertNotNull(response);
        assertEquals(mockAbbreviations.size(), response.size());
        verify(patternRepository).findById(1L);
        verify(abbreviationRepository).saveAll(anyList());
    }

    @Test
    void testUpdateAbbreviationPatternAndAbbreviationFound() {
        // Arrange
        when(abbreviationRepository.findById(1L)).thenReturn(Optional.of(mockAbbreviations.get(0)));
        when(patternRepository.findById(1L)).thenReturn(Optional.of(mockPattern));
        when(abbreviationRepository.save(any(Abbreviation.class))).thenReturn(updatedAbbreviation);

        // Act
        AbbreviationResponseDto actualResponse = abbreviationService.updateAbbreviation(1L, 1L, abbreviationUpdateDto);

        // Assert
        assertNotNull(actualResponse);
        assertEquals(expectedResponse.getAbbreviated(), actualResponse.getAbbreviated());
        assertEquals(expectedResponse.getFullForm(), actualResponse.getFullForm());
        verify(abbreviationRepository).findById(1L);
        verify(patternRepository).findById(1L);
        verify(abbreviationRepository).save(any(Abbreviation.class));
    }

    @Test
    void testCreateAbbreviationsPatternNotFound() {
        // Arrange
        when(patternRepository.findById(99L)).thenReturn(Optional.empty());

        // Act
        Exception exception = assertThrows(RecordNotFoundException.class, () -> {
            abbreviationService.createAbbreviations(99L, abbreviationCreateDtos);
        });

        // Assert
        assertEquals("Geen patroon gevonden met id 99", exception.getMessage());
        verify(patternRepository).findById(99L);
    }

    @Test
    void testUpdateAbbreviationPatternNotFound() {
        // Arrange
        when(abbreviationRepository.findById(1L)).thenReturn(Optional.of(mockAbbreviations.get(0)));
        when(patternRepository.findById(99L)).thenReturn(Optional.empty());

        // Act
        Exception exception = assertThrows(RecordNotFoundException.class, () -> {
            abbreviationService.updateAbbreviation(99L, 1L, abbreviationUpdateDto);
        });

        // Assert
        assertEquals("Geen Patroon gevonden met id 99", exception.getMessage());
        verify(patternRepository).findById(99L);
    }

    @Test
    void testUpdateAbbreviationAbbreviationNotFound() {
        // Arrange
        when(abbreviationRepository.findById(99L)).thenReturn(Optional.empty());

        // Act
        Exception exception = assertThrows(RecordNotFoundException.class, () -> {
            abbreviationService.updateAbbreviation(1L, 99L, abbreviationUpdateDto);
        });

        // Assert
        assertEquals("Geen afkorting gevonden met id 99", exception.getMessage());
        verify(abbreviationRepository).findById(99L);
    }

    @Test
    void testGetAbbreviationsPatternFound() {
        // Arrange
        when(patternRepository.findById(1L)).thenReturn(Optional.of(mockPattern));

        // Act
        List<AbbreviationResponseDto> abbreviations = abbreviationService.getAbbreviations(1L);

        // Assert
        assertNotNull(abbreviations);
        verify(patternRepository).findById(1L);
    }

    @Test
    void testGetAbbreviationsPatternNotFound() {
        // Arrange
        when(patternRepository.findById(99L)).thenReturn(Optional.empty());

        // Act
        Exception exception = assertThrows(RecordNotFoundException.class, () -> {
            abbreviationService.getAbbreviations(99L);
        });

        // Assert
        assertEquals("Geen Patroon gevonden met id 99", exception.getMessage());
        verify(patternRepository).findById(99L);
    }
}
