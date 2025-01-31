package nl.bo.bacpatternpoint.controllers;

import nl.bo.bacpatternpoint.dtos.AbbreviationCreateDto;
import nl.bo.bacpatternpoint.dtos.AbbreviationResponseDto;
import nl.bo.bacpatternpoint.dtos.AbbreviationUpdateDto;
import nl.bo.bacpatternpoint.services.AbbreviationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/patterns/{patternId}/abbreviations")
public class AbbreviationController {

    private final AbbreviationService abbreviationService;

    public AbbreviationController(AbbreviationService abbreviationService) {
        this.abbreviationService = abbreviationService;
    }

    @PostMapping
    public ResponseEntity<List<AbbreviationResponseDto>> createAbbreviations(@PathVariable Long patternId, @RequestBody List<AbbreviationCreateDto> abbreviationCreateDtos) {
        List<AbbreviationResponseDto> abbreviationResponseDtos = abbreviationService.createAbbreviations(patternId, abbreviationCreateDtos);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(abbreviationResponseDtos.get(0).getId()).toUri();
        return ResponseEntity.created(location).body(abbreviationResponseDtos);
    }

    @PutMapping("/{abbreviationId}")
    public ResponseEntity<AbbreviationResponseDto> updateAbbreviaiton(@PathVariable Long patternId, @PathVariable Long abbreviationId, @RequestBody AbbreviationUpdateDto abbreviationUpdateDto) {
        AbbreviationResponseDto abbreviationResponseDto = abbreviationService.updateAbbreviation(patternId, abbreviationId, abbreviationUpdateDto);
        return ResponseEntity.ok(abbreviationResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<AbbreviationResponseDto>> getAbbreviations(@PathVariable Long patternId) {
        List<AbbreviationResponseDto> abbreviationResponseDtoList = abbreviationService.getAbbreviations(patternId);
        return ResponseEntity.ok(abbreviationResponseDtoList);
    }
}
