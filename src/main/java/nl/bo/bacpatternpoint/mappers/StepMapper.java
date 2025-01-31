package nl.bo.bacpatternpoint.mappers;

import nl.bo.bacpatternpoint.dtos.*;
import nl.bo.bacpatternpoint.models.Step;

import java.util.List;
import java.util.stream.Collectors;

public class StepMapper {
    public static StepResponseDto toResponseDto(Step step){
        StepResponseDto dto = new StepResponseDto();
        dto.setId(step.getId());
        dto.setTitle(step.getTitle());
        dto.setDescription(step.getDescription());
        return dto;
    }

    public static Step toEntity(StepCreateDto stepCreateDto){
        Step step = new Step();
        step.setTitle(stepCreateDto.getTitle());
        step.setDescription(stepCreateDto.getDescription());
        return step;
    }

    public static Step toEntity(StepUpdateDto stepUpdateDto){
        Step step = new Step();
        step.setTitle(stepUpdateDto.getTitle());
        step.setDescription(stepUpdateDto.getDescription());
        return step;
    }

    public static List<StepResponseDto> toResponseDtoList(List<Step> steps){
        return steps.stream().map(StepMapper::toResponseDto).collect(Collectors.toList());
    }

    public static List<Step> toEntityListCreate(List<StepCreateDto> stepCreateDtos){
        return stepCreateDtos.stream().map(StepMapper::toEntity).collect(Collectors.toList());
    }

    public static List<Step> toEntityListUpdate(List<StepUpdateDto> stepUpdateDtos){
        return stepUpdateDtos.stream().map(StepMapper::toEntity).collect(Collectors.toList());
    }
}
