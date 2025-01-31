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
        dto.setFileName(image.getTitle());
        dto.setUrl(image.getUrl());
        return dto;
    }

    public static Image createToEntity(ImageCreateDto imageCreateDto){
        Image image = new Image();
        image.setTitle(imageCreateDto.getFileName());
        image.setUrl(imageCreateDto.getUrl());
        return image;
    }

    public static Image updateToEntity(ImageUpdateDto imageUpdateDto){
        Image image = new Image();
        image.setTitle(imageUpdateDto.getFileName());
        image.setUrl(imageUpdateDto.getUrl());
        return image;
    }

    public static List<ImageResponseDto> toResponseDtoList(List<Image> images){
        return images.stream().map(ImageMapper::toResponseDto).collect(Collectors.toList());
    }

    public static List<Image> updateToEntityList(List<ImageUpdateDto> imageUpdateDtos){
        return imageUpdateDtos.stream().map(ImageMapper::updateToEntity).collect(Collectors.toList());
    }
}
