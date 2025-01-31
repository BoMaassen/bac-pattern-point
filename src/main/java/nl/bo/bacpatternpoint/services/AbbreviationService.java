package nl.bo.bacpatternpoint.services;

import nl.bo.bacpatternpoint.dtos.*;
import nl.bo.bacpatternpoint.mappers.AbbreviationMapper;
import nl.bo.bacpatternpoint.models.Abbreviation;
import nl.bo.bacpatternpoint.models.Pattern;
import nl.bo.bacpatternpoint.repositories.AbbreviationRepository;
import nl.bo.bacpatternpoint.repositories.PatternRepository;

import java.util.List;
import java.util.Optional;


public class AbbreviationService {

    private final AbbreviationRepository abbreviationRepository;
    private final PatternRepository patternRepository;

    public AbbreviationService(AbbreviationRepository abbreviationRepository, PatternRepository patternRepository) {
        this.abbreviationRepository = abbreviationRepository;
        this.patternRepository = patternRepository;
    }

    public AbbreviationResponseDto createAbbreviation(Long patternId, AbbreviationCreateDto abbreviationCreateDto){
       Pattern pattern = patternRepository.findById(patternId).orElseThrow(() -> new RuntimeException("Geen patroon gevonden met id " + patternId));

        Abbreviation abbreviation = AbbreviationMapper.toEntity(abbreviationCreateDto);
        abbreviation.setPattern(pattern);

        Abbreviation savedAbbreviation = abbreviationRepository.save(abbreviation);

        return AbbreviationMapper.toResponseDto(savedAbbreviation);
    }

    public AbbreviationResponseDto updateAbbreviation(Long patternId, Long abbreviationId, AbbreviationUpdateDto abbreviationUpdateDto){
        Abbreviation abbreviation = abbreviationRepository.findById(abbreviationId).orElseThrow(() -> new RuntimeException("Geen afkorting gevonden met id " + abbreviationId));

        Pattern pattern = patternRepository.findById(patternId).orElseThrow(() -> new RuntimeException("Geen Patroon gevonden met id " + patternId));

        Abbreviation updatedAbbreviation = AbbreviationMapper.toEntity(abbreviationUpdateDto);

        updatedAbbreviation.setId(abbreviation.getId());
        updatedAbbreviation.setPattern(pattern);

        Abbreviation savedAbbreviation = abbreviationRepository.save(updatedAbbreviation);

        return AbbreviationMapper.toResponseDto(savedAbbreviation);

    }

    public List<AbbreviationResponseDto> getAbbreviations (Long patternId){
        Pattern pattern = patternRepository.findById(patternId).orElseThrow(() -> new RuntimeException("Geen Patroon gevonden met id " + patternId));

        List<Abbreviation> abbreviations = pattern.getAbbreviations();

        return AbbreviationMapper.toResponseDtoList(abbreviations);

    }






}
