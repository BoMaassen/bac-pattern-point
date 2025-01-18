package nl.bo.bacpatternpoint.mappers;

import nl.bo.bacpatternpoint.dtos.ImageCreateDto;
import nl.bo.bacpatternpoint.dtos.ImageResponseDto;
import nl.bo.bacpatternpoint.dtos.ImageUpdateDto;
import nl.bo.bacpatternpoint.models.Image;

import java.util.List;
import java.util.stream.Collectors;

public class ImageMapper {

    public static ImageResponseDto toResponseDto(Image image){
        ImageResponseDto dto = new ImageResponseDto();
        dto.setId(image.getId());
        dto.setFileName(image.getFileName());
        dto.setUrl(image.getUrl());
        return dto;
    }

    public static Image toEntity(ImageCreateDto imageCreateDto){
        Image image = new Image();
        image.setFileName(imageCreateDto.getFileName());
        image.setUrl(imageCreateDto.getUrl());
        return image;
    }

    public static Image toEntity(ImageUpdateDto imageUpdateDto){
        Image image = new Image();
        image.setFileName(imageUpdateDto.getFileName());
        image.setUrl(imageUpdateDto.getUrl());
        return image;
    }

    public static List<ImageResponseDto> toResponseDtoList(List<Image> images){
        return images.stream().map(ImageMapper::toResponseDto).collect(Collectors.toList());
    }

}
