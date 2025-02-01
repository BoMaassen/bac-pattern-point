package nl.bo.bacpatternpoint.controllers;

import nl.bo.bacpatternpoint.dtos.*;
import nl.bo.bacpatternpoint.services.StepService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/patterns/{patternId}/steps")
public class StepController {

    private final StepService stepService;

    public StepController(StepService stepService) {
        this.stepService = stepService;
    }

    @PostMapping
    public ResponseEntity<List<StepResponseDto>> createSteps(@PathVariable Long patternId, @RequestBody List<StepCreateDto> stepCreateDtos) {
        List<StepResponseDto> stepResponseDtos = stepService.createSteps(patternId, stepCreateDtos);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(stepResponseDtos.get(0).getId()).toUri();
        return ResponseEntity.created(location).body(stepResponseDtos);
    }

    @PutMapping("/{stepId}")
    public ResponseEntity<StepResponseDto> updateStep(@PathVariable Long patternId, @PathVariable Long stepId, @RequestBody StepUpdateDto stepUpdateDto) {
        StepResponseDto stepResponseDto = stepService.updateStep(patternId, stepId, stepUpdateDto);
        return ResponseEntity.ok(stepResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<StepResponseDto>> getSteps(@PathVariable Long patternId) {
        List<StepResponseDto> stepResponseDtoList = stepService.getSteps(patternId);
        return ResponseEntity.ok(stepResponseDtoList);
    }
}
