package nl.bo.bacpatternpoint.services;

import nl.bo.bacpatternpoint.dtos.StepCreateDto;
import nl.bo.bacpatternpoint.dtos.StepResponseDto;
import nl.bo.bacpatternpoint.dtos.StepUpdateDto;
import nl.bo.bacpatternpoint.exception.RecordNotFoundException;
import nl.bo.bacpatternpoint.models.Pattern;
import nl.bo.bacpatternpoint.models.Step;
import nl.bo.bacpatternpoint.repositories.PatternRepository;
import nl.bo.bacpatternpoint.repositories.StepRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class StepServiceTest {

    @Mock
    private PatternRepository patternRepository;

    @Mock
    private StepRepository stepRepository;

    @InjectMocks
    private StepService stepService;

    private Pattern mockPattern;
    private List<Step> mockSteps;
    private List<StepCreateDto> stepCreateDtos;
    private StepUpdateDto mockStepUpdateDto;
    private Step updatedMockStep;
    private StepResponseDto expectedResponse;

    @BeforeEach
    void setUp() {
        mockPattern = new Pattern(1L, "Title", "Beginner", "Beschrijving", 3.0, 30, "wol", true, true, true, 10.5, 15.5, false);
        mockSteps = Arrays.asList(
                new Step("stap 1", "beschrijving stap 1"),
                new Step("stap 2", "beschrijving stap 2")
        );
        mockPattern.setSteps(mockSteps);

        stepCreateDtos = Arrays.asList(
                new StepCreateDto("stap 1", "Beschrijving stap 1"),
                new StepCreateDto("stap 2", "Beschrijving stap 2")
        );

        mockStepUpdateDto = new StepUpdateDto( "stap 1 updated", "beschrijving stap 1 updated");

        updatedMockStep = new Step();
        updatedMockStep.setId(1L);
        updatedMockStep.setTitle("Nieuwe titel");
        updatedMockStep.setDescription("Nieuwe beschrijving");
        updatedMockStep.setPattern(mockPattern);

        expectedResponse = new StepResponseDto();
        expectedResponse.setId(1L);
        expectedResponse.setTitle("Nieuwe titel");
        expectedResponse.setDescription("Nieuwe beschrijving");
    }

    @Test
    void testCreateStepsPatternFound() {
        // Arrange
        when(patternRepository.findById(1L)).thenReturn(Optional.of(mockPattern));
        when(stepRepository.saveAll(anyList())).thenReturn(mockSteps);

        // Act
        List<StepResponseDto> response = stepService.createSteps(1L, stepCreateDtos);

        // Assert
        assertNotNull(response);
        assertEquals(mockSteps.size(), response.size());
        verify(patternRepository).findById(1L);
        verify(stepRepository).saveAll(anyList());
    }

    @Test
    void testUpdateStepPatternAndStepFound() {
        // Arrange
        when(stepRepository.findById(1L)).thenReturn(Optional.of(mockSteps.get(0)));
        when(patternRepository.findById(1L)).thenReturn(Optional.of(mockPattern));
        when(stepRepository.save(any(Step.class))).thenReturn(updatedMockStep);

        // Act
        StepResponseDto actualResponse = stepService.updateStep(1L, 1L, mockStepUpdateDto);

        // Assert
        assertNotNull(actualResponse, "Step mag niet null zijn!");
        assertEquals(expectedResponse.getTitle(), actualResponse.getTitle());
        assertEquals(expectedResponse.getDescription(), actualResponse.getDescription());
        verify(stepRepository).findById(1L);
        verify(patternRepository).findById(1L);
        verify(stepRepository).save(any(Step.class));
    }

    @Test
    void testCreateStepsPatternNotFound() {
        // Arrange
        when(patternRepository.findById(99L)).thenReturn(Optional.empty());

        // Act
        Exception exception = assertThrows(RecordNotFoundException.class, () -> {
            stepService.createSteps(99L, stepCreateDtos);
        });

        // Assert
        assertEquals("Geen patroon gevonden met id 99", exception.getMessage());
        verify(patternRepository).findById(99L);
    }

    @Test
    void testUpdateStepPatternNotFound() {
        // Arrange
        when(stepRepository.findById(1L)).thenReturn(Optional.of(mockSteps.get(0)));
        when(patternRepository.findById(99L)).thenReturn(Optional.empty());

        // Act
        Exception exception = assertThrows(RecordNotFoundException.class, () -> {
            stepService.updateStep(99L, 1L, mockStepUpdateDto);
        });

        // Assert
        assertEquals("Geen Patroon gevonden met id 99", exception.getMessage());
        verify(patternRepository).findById(99L);
    }

    @Test
    void testUpdateStepStepNotFound() {
        // Arrange
        when(stepRepository.findById(99L)).thenReturn(Optional.empty());

        // Act
        Exception exception = assertThrows(RecordNotFoundException.class, () -> {
            stepService.updateStep(1L, 99L, mockStepUpdateDto);
        });

        // Assert
        assertEquals("Geen afkorting gevonden met id 99", exception.getMessage());
        verify(stepRepository).findById(99L);
    }

    @Test
    void testgetStepsPatternFound() {
        //arrange
        when(patternRepository.findById(1L)).thenReturn(Optional.of(mockPattern));

        // Act
        List<StepResponseDto> steps = stepService.getSteps(1L);

        // Assert
        assertNotNull(steps);
        verify(patternRepository).findById(1L);
    }

    @Test
    void testGetStepsPatternNotFound() {
        // Arrange
        when(patternRepository.findById(99L)).thenReturn(Optional.empty());

        // Act
        Exception exception = assertThrows(RecordNotFoundException.class, () -> {
            stepService.getSteps(99L);
        });

        // Assert
        assertEquals("Geen Patroon gevonden met id 99", exception.getMessage());
        verify(patternRepository).findById(99L);
    }

}