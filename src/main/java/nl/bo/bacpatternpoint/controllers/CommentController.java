package nl.bo.bacpatternpoint.controllers;

import jakarta.validation.Valid;
import nl.bo.bacpatternpoint.dtos.CommentCreateDto;
import nl.bo.bacpatternpoint.dtos.CommentResponseDto;
import nl.bo.bacpatternpoint.dtos.CommentUpdateDto;
import nl.bo.bacpatternpoint.services.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/comments/{commentId}")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comments")
    public ResponseEntity<CommentResponseDto> createCommentByComment(@Valid @PathVariable Long commentId, @RequestBody CommentCreateDto commentCreateDto){
    CommentResponseDto commentResponseDto = commentService.createCommentByComment(commentId, commentCreateDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(commentResponseDto.getId()).toUri();
        return ResponseEntity.created(location).body(commentResponseDto);
    }

    @PutMapping
    public ResponseEntity<CommentResponseDto> updateComment(@Valid @PathVariable Long commentId, @RequestBody CommentUpdateDto commentUpdateDto){
        CommentResponseDto commentResponseDto = commentService.updateComment(commentId, commentUpdateDto);
        return ResponseEntity.ok(commentResponseDto);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId){
        boolean isDeleted = commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CommentResponseDto>> getCommentsForComment(@PathVariable Long commentId) {
        List<CommentResponseDto> comments = commentService.getCommentsForComment(commentId);
        return ResponseEntity.ok(comments);
    }



}
