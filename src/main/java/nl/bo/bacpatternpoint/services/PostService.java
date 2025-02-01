package nl.bo.bacpatternpoint.services;

import jakarta.transaction.Transactional;
import nl.bo.bacpatternpoint.dtos.*;
import nl.bo.bacpatternpoint.exception.RecordNotFoundException;
import nl.bo.bacpatternpoint.mappers.PostMapper;
import nl.bo.bacpatternpoint.models.Image;
import nl.bo.bacpatternpoint.models.Post;
import nl.bo.bacpatternpoint.models.User;
import nl.bo.bacpatternpoint.repositories.PostRepository;
import nl.bo.bacpatternpoint.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public PostResponseDto createPost(PostCreateDto postCreateDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();

        User user = userRepository.findByUsername(currentUsername)
                .orElseThrow(() -> new RuntimeException("User niet gevonden met username " + currentUsername));

        Post post = PostMapper.toEntity(postCreateDto);
        post.setUser(user);
        Post savedPost = postRepository.save(post);
        return PostMapper.toResponseDto(savedPost);
    }

    public PostResponseDto updatePost(Long id, PostUpdateDto postUpdateDto) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Geen post gevonden met id " + id));

        post.setTitle(postUpdateDto.getTitle());
        post.setCategory(postUpdateDto.getCategory());
        post.setDescription(postUpdateDto.getDescription());
        post.setDraft(postUpdateDto.isDraft());

        Post updatedPost = postRepository.save(post);

        return PostMapper.toResponseDto(updatedPost);

    }

    public PostResponseDto getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Geen post gevonden met id " + id));

        return PostMapper.toResponseDto(post);
    }

    public List<PostResponseDto> getPosts() {
        List<Post> posts = postRepository.findAll();
        return PostMapper.toResponseDtoList(posts);
    }

    public boolean deletePost(Long id) {
        postRepository.deleteById(id);

        return true;
    }

    @Transactional
    public Image getPostImg(Long postId) {

        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isEmpty()) {
            throw new RecordNotFoundException("Post met nummer " + postId + " niet gevonden.");
        }
        return optionalPost.get().getImage();
    }

    @Transactional
    public Post addImg(Long postId, Image image) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isEmpty()) {
            throw new RecordNotFoundException("Post met id " + postId + " niet gevonden.");
        }
        Post post = optionalPost.get();
        post.setImage(image);
        return postRepository.save(post);
    }
}
