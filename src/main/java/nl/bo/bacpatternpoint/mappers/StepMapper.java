package nl.bo.bacpatternpoint.mappers;

import nl.bo.bacpatternpoint.dtos.*;
import nl.bo.bacpatternpoint.models.Abbreviation;
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

    public static Abbreviation toEntity(AbbreviationUpdateDto abbreviationUpdateDto){
        Abbreviation abbreviation = new Abbreviation();
        abbreviation.setAbbreviated(abbreviationUpdateDto.getAbbreviated());
        abbreviation.setFull(abbreviationUpdateDto.getFull());
        return abbreviation;
    }

    public static List<AbbreviationResponseDto> toResponseDtoList(List<Abbreviation> abbreviations){
        return abbreviations.stream().map(AbbreviationMapper::toResponseDto).collect(Collectors.toList());
    }
}
