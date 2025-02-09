package nl.bo.bacpatternpoint.services;

import jakarta.transaction.Transactional;
import nl.bo.bacpatternpoint.dtos.*;
import nl.bo.bacpatternpoint.exception.RecordNotFoundException;
import nl.bo.bacpatternpoint.mappers.PatternMapper;
import nl.bo.bacpatternpoint.models.Image;
import nl.bo.bacpatternpoint.models.Pattern;
import nl.bo.bacpatternpoint.models.Post;
import nl.bo.bacpatternpoint.models.User;
import nl.bo.bacpatternpoint.repositories.PatternRepository;
import nl.bo.bacpatternpoint.repositories.PostRepository;
import nl.bo.bacpatternpoint.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PatternService {
    private final PatternRepository patternRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public PatternService(PatternRepository patternRepository, UserRepository userRepository, PostRepository postRepository) {
        this.patternRepository = patternRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public PatternResponseDto createPattern(Long postId, PatternCreateDto patternCreateDto){
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RecordNotFoundException("Post niet gevonden met id " + postId));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();

        User user = userRepository.findByUsername(currentUsername)
                .orElseThrow(() -> new RecordNotFoundException("User niet gevonden met username " + currentUsername));

        Pattern pattern = PatternMapper.toEntity(patternCreateDto);
        pattern.setPost(post);
        pattern.setUser(user);
        Pattern savedPattern = patternRepository.save(pattern);
        return PatternMapper.toResponseDto(savedPattern);
    }

    public PatternResponseDto updatePattern(Long id, PatternUpdateDto patternUpdateDto){
        Pattern pattern = patternRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("Geen patroon gevonde met id " + id));

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

        Pattern savedPattern = patternRepository.save(pattern);

        return PatternMapper.toResponseDto(savedPattern);
    }

    public PatternResponseDto getPatternById(Long id){
        Pattern pattern = patternRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Geen patroon gevonden met id " + id));

        return PatternMapper.toResponseDto(pattern);
    }

    @Transactional
    public List<PatternResponseDto> getPatternsForPost(Long postId){
        Optional<Post> optionalPost = postRepository.findById(postId);
        if(optionalPost.isEmpty()){
            throw new RecordNotFoundException("Post met nummer " + postId + " niet gevonden.");
        }

        List<Pattern> patterns = optionalPost.get().getPatterns();
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
