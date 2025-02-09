package nl.bo.bacpatternpoint.services;

import nl.bo.bacpatternpoint.dtos.*;
import nl.bo.bacpatternpoint.exception.RecordNotFoundException;
import nl.bo.bacpatternpoint.mappers.AbbreviationMapper;
import nl.bo.bacpatternpoint.models.Abbreviation;
import nl.bo.bacpatternpoint.models.Pattern;
import nl.bo.bacpatternpoint.repositories.AbbreviationRepository;
import nl.bo.bacpatternpoint.repositories.PatternRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AbbreviationService {

    private final AbbreviationRepository abbreviationRepository;
    private final PatternRepository patternRepository;

    public AbbreviationService(AbbreviationRepository abbreviationRepository, PatternRepository patternRepository) {
        this.abbreviationRepository = abbreviationRepository;
        this.patternRepository = patternRepository;
    }

    public List<AbbreviationResponseDto> createAbbreviations(Long patternId, List<AbbreviationCreateDto> abbreviationCreateDto){
       Pattern pattern = patternRepository.findById(patternId).orElseThrow(() -> new RecordNotFoundException("Geen patroon gevonden met id " + patternId));

        List<Abbreviation> abbreviations = AbbreviationMapper.toEntityListCreate(abbreviationCreateDto);
        for (Abbreviation abbreviation : abbreviations) {
            abbreviation.setPattern(pattern);
        }
        List<Abbreviation> savedAbbreviations = abbreviationRepository.saveAll(abbreviations);

        return AbbreviationMapper.toResponseDtoList(savedAbbreviations);
    }

    public AbbreviationResponseDto updateAbbreviation(Long patternId, Long abbreviationId, AbbreviationUpdateDto abbreviationUpdateDto){
        Abbreviation abbreviation = abbreviationRepository.findById(abbreviationId).orElseThrow(() -> new RecordNotFoundException("Geen afkorting gevonden met id " + abbreviationId));

        Pattern pattern = patternRepository.findById(patternId).orElseThrow(() -> new RecordNotFoundException("Geen Patroon gevonden met id " + patternId));

        abbreviation.setAbbreviated(abbreviationUpdateDto.getAbbreviated());
        abbreviation.setFullForm(abbreviationUpdateDto.getFullForm());
        abbreviation.setPattern(pattern);

        Abbreviation savedAbbreviation = abbreviationRepository.save(abbreviation);

        return AbbreviationMapper.toResponseDto(savedAbbreviation);
    }

    public List<AbbreviationResponseDto> getAbbreviations (Long patternId){
        Pattern pattern = patternRepository.findById(patternId).orElseThrow(() -> new RecordNotFoundException("Geen Patroon gevonden met id " + patternId));

        List<Abbreviation> abbreviations = pattern.getAbbreviations();

        return AbbreviationMapper.toResponseDtoList(abbreviations);
    }
}
