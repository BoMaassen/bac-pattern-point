package nl.bo.bacpatternpoint.services;

import nl.bo.bacpatternpoint.dtos.CommentCreateDto;
import nl.bo.bacpatternpoint.dtos.CommentResponseDto;
import nl.bo.bacpatternpoint.dtos.CommentUpdateDto;
import nl.bo.bacpatternpoint.mappers.CommentMapper;
import nl.bo.bacpatternpoint.models.Comment;
import nl.bo.bacpatternpoint.models.Pattern;
import nl.bo.bacpatternpoint.models.Post;
import nl.bo.bacpatternpoint.repositories.CommentRepository;
import nl.bo.bacpatternpoint.repositories.PatternRepository;
import nl.bo.bacpatternpoint.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final PatternRepository patternRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository, PatternRepository patternRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.patternRepository = patternRepository;
    }


    public CommentResponseDto createCommentByPost(Long postId, CommentCreateDto commentCreateDto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post niet gevonden met id " + postId));

        Comment comment = CommentMapper.toEntity(commentCreateDto);
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);

        return CommentMapper.toResponseDto(savedComment);
    }

    public CommentResponseDto createCommentByPattern(Long patternId, CommentCreateDto commentCreateDto) {
        Pattern pattern = patternRepository.findById(patternId)
                .orElseThrow(() -> new RuntimeException("Patroon niet gevonden met id " + patternId));

        Comment comment = CommentMapper.toEntity(commentCreateDto);
        comment.setPattern(pattern);
        Comment savedComment = commentRepository.save(comment);

        return CommentMapper.toResponseDto(savedComment);
    }
    public CommentResponseDto createCommentByComment(Long commentId, CommentCreateDto commentCreateDto) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Reactie niet gevonden met id " + commentId));

        Comment newComment = CommentMapper.toEntity(commentCreateDto);
        comment.setComment(comment);
        Comment savedComment = commentRepository.save(newComment);

        return CommentMapper.toResponseDto(savedComment);
    }

    public List<CommentResponseDto> getCommentsForComment(Long commentId){
       Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new RuntimeException("Geen comment gevonden met id " + commentId));

        List<Comment> comments = comment.getComments();

        return CommentMapper.toResponseDtoList(comments);
    }

    public List<CommentResponseDto> getCommentsForPattern(Long patternId){
        Pattern pattern = patternRepository.findById(patternId).orElseThrow(() -> new RuntimeException("Geen patroon gevonden met id " + patternId));

        List<Comment> comments = pattern.getComments();

        return CommentMapper.toResponseDtoList(comments);
    }

    public List<CommentResponseDto> getCommentsForPost(Long postId){
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Geen post gevonden met id " + postId));

        List<Comment> comments = post.getComments();

        return CommentMapper.toResponseDtoList(comments);
    }

    public CommentResponseDto updateComment(Long commentId, CommentUpdateDto commentUpdateDto) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment niet gevonden met id " + commentId));

        comment.setMessage(commentUpdateDto.getMessage());

        Comment updatedComment = commentRepository.save(comment);
        return CommentMapper.toResponseDto(updatedComment);
    }

    public boolean deleteComment(Long id){
        commentRepository.deleteById(id);
        return true;
    }



}
