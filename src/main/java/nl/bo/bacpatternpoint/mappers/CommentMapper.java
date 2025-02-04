package nl.bo.bacpatternpoint.mappers;

import nl.bo.bacpatternpoint.dtos.CommentCreateDto;
import nl.bo.bacpatternpoint.dtos.CommentResponseDto;
import nl.bo.bacpatternpoint.dtos.CommentUpdateDto;
import nl.bo.bacpatternpoint.models.Comment;

import java.util.List;
import java.util.stream.Collectors;

public class CommentMapper {

    public static CommentResponseDto toResponseDto(Comment comment){
        CommentResponseDto dto = new CommentResponseDto();
        dto.setId(comment.getId());
        dto.setMessage(comment.getMessage());
        dto.setTimeStamp(comment.getTimeStamp());
        dto.setLikes(comment.getLikes());
        dto.setUsername(comment.getUser().getUsername());
        return dto;
    }

    public static Comment toEntity(CommentCreateDto commentCreateDto){
        Comment comment = new Comment();
        comment.setMessage(commentCreateDto.getMessage());
        return comment;
    }

    public static Comment toEntity(CommentUpdateDto commentUpdateDto){
        Comment comment = new Comment();
        comment.setMessage(comment.getMessage());
        return comment;
    }

    public static List<CommentResponseDto> toResponseDtoList(List<Comment> comments){
        return comments.stream().map(CommentMapper::toResponseDto).collect(Collectors.toList());
    }
}
