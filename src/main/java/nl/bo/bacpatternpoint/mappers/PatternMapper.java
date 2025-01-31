package nl.bo.bacpatternpoint.mappers;

import nl.bo.bacpatternpoint.dtos.*;
import nl.bo.bacpatternpoint.models.Pattern;
import java.util.List;
import java.util.stream.Collectors;

public class PatternMapper {
    public static PatternResponseDto toResponseDto(Pattern pattern){
        PatternResponseDto dto = new PatternResponseDto();
        dto.setId(pattern.getId());
        dto.setTitle(pattern.getTitle());
        dto.setLevel(pattern.getLevel());
        dto.setDescription(pattern.getDescription());
        dto.setHookSize(pattern.getHookSize());
        dto.setAmountOfYarn(pattern.getAmountOfYarn());
        dto.setTypeYarn(pattern.getTypeYarn());
        dto.setScissor(pattern.isScissor());
        dto.setDarningNeedle(pattern.isDarningNeedle());
        dto.setMeasuringTape(pattern.isMeasuringTape());
        dto.setLength(pattern.getLength());
        dto.setWidth(pattern.getWidth());
        dto.setImage(pattern.getImage());
        dto.setAbbreviations(AbbreviationMapper.toResponseDtoList(pattern.getAbbreviations()));
        dto.setSteps(StepMapper.toResponseDtoList(pattern.getSteps()));
        return dto;
    }

    public static Pattern toEntity(PatternCreateDto patternCreateDto){
        Pattern pattern = new Pattern();
        pattern.setTitle(patternCreateDto.getTitle());
        pattern.setLevel(patternCreateDto.getLevel());
        pattern.setDescription(patternCreateDto.getDescription());
        pattern.setHookSize(patternCreateDto.getHookSize());
        pattern.setAmountOfYarn(patternCreateDto.getAmountOfYarn());
        pattern.setTypeYarn(patternCreateDto.getTypeYarn());
        pattern.setScissor(patternCreateDto.isScissor());
        pattern.setDarningNeedle(patternCreateDto.isDarningNeedle());
        pattern.setMeasuringTape(patternCreateDto.isMeasuringTape());
        pattern.setLength(patternCreateDto.getLength());
        pattern.setWidth(patternCreateDto.getWidth());
        return pattern;
    }

    public static Pattern toEntity(PatternUpdateDto patternUpdateDto){
        Pattern pattern = new Pattern();
        pattern.setTitle(patternUpdateDto.getTitle());
        pattern.setLevel(patternUpdateDto.getLevel());
        pattern.setDescription(patternUpdateDto.getDescription());
        pattern.setHookSize(patternUpdateDto.getHookSize());
        pattern.setAmountOfYarn(patternUpdateDto.getAmountOfYarn());
        pattern.setTypeYarn(patternUpdateDto.getTypeYarn());
        pattern.setScissor(patternUpdateDto.isScissor());
        pattern.setDarningNeedle(patternUpdateDto.isDarningNeedle());
        pattern.setMeasuringTape(patternUpdateDto.isMeasuringTape());
        pattern.setLength(patternUpdateDto.getLength());
        pattern.setWidth(patternUpdateDto.getWidth());

        return pattern;
    }

    public static List<PatternResponseDto> toResponseDtoList(List<Pattern> patterns){
        return patterns.stream().map(PatternMapper::toResponseDto).collect(Collectors.toList());
    }

}
