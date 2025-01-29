package nl.bo.bacpatternpoint.services;

import jakarta.transaction.Transactional;
import nl.bo.bacpatternpoint.dtos.PatternCreateDto;
import nl.bo.bacpatternpoint.dtos.PatternResponseDto;
import nl.bo.bacpatternpoint.dtos.PatternUpdateDto;
import nl.bo.bacpatternpoint.dtos.PostResponseDto;
import nl.bo.bacpatternpoint.exception.RecordNotFoundException;
import nl.bo.bacpatternpoint.mappers.PatternMapper;
import nl.bo.bacpatternpoint.mappers.PostMapper;
import nl.bo.bacpatternpoint.models.Image;
import nl.bo.bacpatternpoint.models.Pattern;
import nl.bo.bacpatternpoint.models.Post;
import nl.bo.bacpatternpoint.repositories.PatternRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatternService {
    private final PatternRepository patternRepository;

    public PatternService(PatternRepository patternRepository) {
        this.patternRepository = patternRepository;
    }

    public PatternResponseDto createPattern(PatternCreateDto patternCreateDto){
        Pattern pattern = PatternMapper.toEntity(patternCreateDto);
        Pattern savedPattern = patternRepository.save(pattern);
        return PatternMapper.toResponseDto(savedPattern);
    }

    public PatternResponseDto updatePattern(Long id, PatternUpdateDto patternUpdateDto){
        Pattern pattern = patternRepository.findById(id).orElseThrow(()-> new RuntimeException("Geen patroon gevonde met id " + id));

        Pattern updatedPattern = PatternMapper.toEntity(patternUpdateDto);

        updatedPattern.setId(pattern.getId());
        Pattern savedPattern = patternRepository.save(updatedPattern);

        return PatternMapper.toResponseDto(savedPattern);
    }

    public PatternResponseDto getPatternById(Long id){
        Pattern pattern = patternRepository.findById(id).orElseThrow(() -> new RuntimeException("Geen patroon gevonden met id " + id));

        return PatternMapper.toResponseDto(pattern);
    }

    public List<PatternResponseDto> getPatterns(){
        List<Pattern> patterns = patternRepository.findAll();
        return PatternMapper.toResponseDtoList(patterns);
    }

    public boolean deletePattern(Long id){
        patternRepository.deleteById(id);
        return true;
    }


    @Transactional
    public Image getPatternImg(Long patternId) {

        Optional<Pattern> optionalPattern = patternRepository.findById(patternId);
        if(optionalPattern.isEmpty()){
            throw new RecordNotFoundException("Patroon met nummer " + patternId + " niet gevonden.");
        }


        return optionalPattern.get().getImage();
    }

    @Transactional
    public Pattern addImg(Long patternId, Image image) {
        Optional<Pattern> optionalPattern = patternRepository.findById(patternId);
        if(optionalPattern.isEmpty()){
            throw new RecordNotFoundException("Patroon met id " + patternId + " niet gevonden.");
        }
        Pattern pattern = optionalPattern.get();
        pattern.setImage(image);
        return patternRepository.save(pattern);
    }


}
