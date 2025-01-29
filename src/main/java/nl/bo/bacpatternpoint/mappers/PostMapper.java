package nl.bo.bacpatternpoint.mappers;

import nl.bo.bacpatternpoint.dtos.PostCreateDto;
import nl.bo.bacpatternpoint.dtos.PostResponseDto;
import nl.bo.bacpatternpoint.dtos.PostUpdateDto;
import nl.bo.bacpatternpoint.models.Image;
import nl.bo.bacpatternpoint.models.Post;

import java.util.List;
import java.util.stream.Collectors;

public class PostMapper {

    public static PostResponseDto toResponseDto(Post post){
        PostResponseDto dto = new PostResponseDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setCategory(post.getCategory());
        dto.setDescription(post.getDescription());
        dto.setLikes(post.getLikes());
        dto.setDraft(post.isDraft());
        dto.setImage(post.getImage());
        return dto;
    }

    public static Post toEntity(PostCreateDto postCreateDto){
        Post post = new Post();
        post.setTitle(postCreateDto.getTitle());
        post.setCategory(postCreateDto.getCategory());
        post.setDescription(postCreateDto.getDescription());
        post.setDraft(postCreateDto.isDraft());
        return post;
    }

    public static Post toEntity(PostUpdateDto postUpdateDto){
        Post post = new Post();
        post.setTitle(postUpdateDto.getTitle());
        post.setCategory(postUpdateDto.getCategory());
        post.setDescription(postUpdateDto.getDescription());
        post.setDraft(postUpdateDto.isDraft());
        return post;
    }

    public static List<PostResponseDto> toResponseDtoList(List<Post> posts) {
        return posts.stream().map(PostMapper::toResponseDto).collect(Collectors.toList());
    }

}
