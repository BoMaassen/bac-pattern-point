package nl.bo.bacpatternpoint.services;

import nl.bo.bacpatternpoint.dtos.CommentCreateDto;
import nl.bo.bacpatternpoint.dtos.CommentResponseDto;
import nl.bo.bacpatternpoint.dtos.CommentUpdateDto;
import nl.bo.bacpatternpoint.exception.InvalidActionException;
import nl.bo.bacpatternpoint.exception.RecordNotFoundException;
import nl.bo.bacpatternpoint.mappers.CommentMapper;
import nl.bo.bacpatternpoint.models.Comment;
import nl.bo.bacpatternpoint.models.Pattern;
import nl.bo.bacpatternpoint.models.Post;
import nl.bo.bacpatternpoint.models.User;
import nl.bo.bacpatternpoint.repositories.CommentRepository;
import nl.bo.bacpatternpoint.repositories.PatternRepository;
import nl.bo.bacpatternpoint.repositories.PostRepository;
import nl.bo.bacpatternpoint.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final PatternRepository patternRepository;
    private final UserRepository userRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository, PatternRepository patternRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.patternRepository = patternRepository;
        this.userRepository = userRepository;
    }

    public CommentResponseDto createCommentByPost(Long postId, CommentCreateDto commentCreateDto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RecordNotFoundException("Post niet gevonden met id " + postId));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();

        User user = userRepository.findByUsername(currentUsername)
                .orElseThrow(() -> new UsernameNotFoundException("User niet gevonden met username " + currentUsername));

        Comment comment = CommentMapper.toEntity(commentCreateDto);
        comment.setPost(post);
        comment.setUser(user);
        Comment savedComment = commentRepository.save(comment);

        return CommentMapper.toResponseDto(savedComment);
    }

    public CommentResponseDto createCommentByPattern(Long patternId, CommentCreateDto commentCreateDto) {
        Pattern pattern = patternRepository.findById(patternId)
                .orElseThrow(() -> new RecordNotFoundException("Patroon niet gevonden met id " + patternId));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();

        User user = userRepository.findByUsername(currentUsername)
                .orElseThrow(() -> new UsernameNotFoundException("User niet gevonden met username " + currentUsername));

        Comment comment = CommentMapper.toEntity(commentCreateDto);
        comment.setPattern(pattern);
        comment.setUser(user);
        Comment savedComment = commentRepository.save(comment);

        return CommentMapper.toResponseDto(savedComment);
    }

    public CommentResponseDto createCommentByComment(Long commentId, CommentCreateDto commentCreateDto) {
        Comment parentComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RecordNotFoundException("Reactie niet gevonden met id " + commentId));

        if (parentComment.getParentComment() != null) {
            throw new InvalidActionException("Je kunt geen reactie plaatsen op een sub-comment.");
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();

        User user = userRepository.findByUsername(currentUsername)
                .orElseThrow(() -> new UsernameNotFoundException("User niet gevonden met username " + currentUsername));

        Comment newComment = CommentMapper.toEntity(commentCreateDto);
        newComment.setParentComment(parentComment);
        newComment.setUser(user);
        Comment savedComment = commentRepository.save(newComment);

        return CommentMapper.toResponseDto(savedComment);
    }

    public List<CommentResponseDto> getCommentsForComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new RecordNotFoundException("Geen comment gevonden met id " + commentId));

        List<Comment> comments = comment.getSubComments();

        return CommentMapper.toResponseDtoList(comments);
    }

    public List<CommentResponseDto> getCommentsForPattern(Long patternId) {
        Pattern pattern = patternRepository.findById(patternId).orElseThrow(() -> new RecordNotFoundException("Geen patroon gevonden met id " + patternId));

        List<Comment> comments = pattern.getComments();

        return CommentMapper.toResponseDtoList(comments);
    }

    public List<CommentResponseDto> getCommentsForPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RecordNotFoundException("Geen post gevonden met id " + postId));

        List<Comment> comments = post.getComments();

        return CommentMapper.toResponseDtoList(comments);
    }

    public CommentResponseDto updateComment(Long commentId, CommentUpdateDto commentUpdateDto) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RecordNotFoundException("Comment niet gevonden met id " + commentId));

        comment.setMessage(commentUpdateDto.getMessage());

        Comment updatedComment = commentRepository.save(comment);
        return CommentMapper.toResponseDto(updatedComment);
    }

    public boolean deleteComment(Long id) {
        commentRepository.deleteById(id);
        return true;
    }
}
