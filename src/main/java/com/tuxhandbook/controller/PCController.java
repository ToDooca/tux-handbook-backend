package com.tuxhandbook.controller;

import com.tuxhandbook.entity.PC;
import com.tuxhandbook.service.PCService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pcs")
@RequiredArgsConstructor
public class PCController {
    private final PCService pcService;

    @GetMapping
    @ApiOperation(value = "", nickname = "getAllPCs")
    public ResponseEntity<List<PC>> getAllPCs() {
        return ResponseEntity.ok(pcService.findAll());
    }

    @GetMapping("/{pcId}")
    @ApiOperation(value = "", nickname = "getPCById")
    public ResponseEntity<PC> getPCById(@PathVariable String pcId) {
        return ResponseEntity.ok(pcService.findById(Integer.parseInt(pcId)));
    }

    @PostMapping
    @ApiOperation(value = "", nickname = "savePC")
    public ResponseEntity<PC> savePC(@RequestBody PC pc) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pcService.save(pc));
    }

    @PostMapping
    @ApiOperation(value = "", nickname = "updatePC")
    public ResponseEntity<PC> updatePC(@RequestBody PC pc) {
        return ResponseEntity.ok(pcService.update(pc));
    }

    @DeleteMapping("/{pcId}")
    @ApiOperation(value = "", nickname = "deletePcById")
    public void deletePCById(@PathVariable Integer pcId) {
        pcService.deleteById(pcId);
    }
}
