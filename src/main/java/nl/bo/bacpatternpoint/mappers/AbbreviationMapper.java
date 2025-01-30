package nl.bo.bacpatternpoint.mappers;

import nl.bo.bacpatternpoint.dtos.AbbreviationCreateDto;
import nl.bo.bacpatternpoint.dtos.AbbreviationResponseDto;
import nl.bo.bacpatternpoint.dtos.AbbreviationUpdateDto;
import nl.bo.bacpatternpoint.models.Abbreviation;

import java.util.List;
import java.util.stream.Collectors;

public class AbbreviationMapper {

    public static AbbreviationResponseDto toResponseDto(Abbreviation abbreviation){
        AbbreviationResponseDto dto = new AbbreviationResponseDto();
        dto.setId(abbreviation.getId());
        dto.setAbbreviated(abbreviation.getAbbreviated());
        dto.setFull(abbreviation.getFull());
        return dto;
    }

    public static Abbreviation toEntity(AbbreviationCreateDto abbreviationCreateDto){
        Abbreviation abbreviation = new Abbreviation();
        abbreviation.setAbbreviated(abbreviationCreateDto.getAbbreviated());
        abbreviation.setFull(abbreviationCreateDto.getFull());
        return abbreviation;
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
