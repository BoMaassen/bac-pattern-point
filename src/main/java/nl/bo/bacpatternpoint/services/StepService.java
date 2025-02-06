package nl.bo.bacpatternpoint.services;

import nl.bo.bacpatternpoint.dtos.*;
import nl.bo.bacpatternpoint.exception.RecordNotFoundException;
import nl.bo.bacpatternpoint.mappers.StepMapper;
import nl.bo.bacpatternpoint.models.Pattern;
import nl.bo.bacpatternpoint.models.Step;
import nl.bo.bacpatternpoint.repositories.PatternRepository;
import nl.bo.bacpatternpoint.repositories.StepRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StepService {
    private final StepRepository stepRepository;
    private final PatternRepository patternRepository;

    public StepService(StepRepository stepRepository, PatternRepository patternRepository) {
        this.stepRepository = stepRepository;
        this.patternRepository = patternRepository;
    }

    public List<StepResponseDto> createSteps(Long patternId, List<StepCreateDto> stepCreateDtos) {
        Pattern pattern = patternRepository.findById(patternId).orElseThrow(() -> new RecordNotFoundException("Geen patroon gevonden met id " + patternId));

        List<Step> steps = StepMapper.toEntityListCreate(stepCreateDtos);
        for (Step step : steps) {
            step.setPattern(pattern);
        }
        List<Step> savedSteps = stepRepository.saveAll(steps);


        return StepMapper.toResponseDtoList(savedSteps);
    }

    public StepResponseDto updateStep(Long patternId, Long stepId, StepUpdateDto stepUpdateDto) {
        Step step = stepRepository.findById(stepId).orElseThrow(() -> new RecordNotFoundException("Geen afkorting gevonden met id " + stepId));

        Pattern pattern = patternRepository.findById(patternId).orElseThrow(() -> new RecordNotFoundException("Geen Patroon gevonden met id " + patternId));

        step.setTitle(stepUpdateDto.getTitle());
        step.setDescription(stepUpdateDto.getDescription());
        step.setPattern(pattern);

        Step savedStep = stepRepository.save(step);

        return StepMapper.toResponseDto(savedStep);

    }

    public List<StepResponseDto> getSteps(Long patternId) {
        Pattern pattern = patternRepository.findById(patternId).orElseThrow(() -> new RecordNotFoundException("Geen Patroon gevonden met id " + patternId));

        List<Step> steps = pattern.getSteps();

        return StepMapper.toResponseDtoList(steps);

    }
}
