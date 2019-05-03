package com.leaseweb.templatemanager.controllers;

import com.leaseweb.templatemanager.exception.PlatformNotFoundException;
import com.leaseweb.templatemanager.exception.PlatformTemplateNotFoundException;
import com.leaseweb.templatemanager.models.PlatformTemplates;
import com.leaseweb.templatemanager.models.Templates;
import com.leaseweb.templatemanager.service.PlatformTemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/platformtemplate")
@Api(value = "Templates controller", description = "API calls to get template details")
@Slf4j
public class PlatformTemplateController {
    @Autowired
    PlatformTemplateService platformTemplateService;

    @ApiOperation(value = "List all platform templates", response = List.class)
    @ApiResponse(code = 200, message = "Successfully retrieved all platform templates")
    @GetMapping("/listall")
    public ResponseEntity<List<PlatformTemplates>> getAllTemplates() {
        log.info("Fetching all the platform templates");
        List<PlatformTemplates> templatesList = platformTemplateService.getAllTemplates();
        return new ResponseEntity<>(templatesList, HttpStatus.OK);
    }

    @ApiOperation(value = "List all platform templates by template id", response = List.class)
    @ApiResponse(code = 200, message = "Successfully retrieved all platform templates")
    @GetMapping("/templateid/{id}")
    public ResponseEntity<List<PlatformTemplates>> getAllTemplatesByTemplateId(@PathVariable("id") Long id) {
        log.info("Fetching all the platform templates by template id {}", id);
        List<PlatformTemplates> templatesList = platformTemplateService.getTemplatesByTemplateId(id);
        return new ResponseEntity<>(templatesList, HttpStatus.OK);
    }

    @ApiOperation(value = "List all platform templates by platform id", response = List.class)
    @ApiResponse(code = 200, message = "Successfully retrieved all platform templates")
    @GetMapping("/platformid/{id}")
    public ResponseEntity<List<PlatformTemplates>> getAllTemplatesByPlatformId(@PathVariable("id") Long id) {
        log.info("Fetching all the platform templates by patform id {}", id);
        List<PlatformTemplates> templatesList = platformTemplateService.getTemplatesByPlatformId(id);
        return new ResponseEntity<>(templatesList, HttpStatus.OK);
    }

    @ApiOperation(value = "List all platform templates publicly available", response = List.class)
    @ApiResponse(code = 200, message = "Successfully retrieved all platform templates publicly available")
    @GetMapping("/public")
    public ResponseEntity<List<PlatformTemplates>> getAllPublicTemplates() {
        log.info("Fetching all the platform templates which are public");
        List<PlatformTemplates> templatesList = platformTemplateService.getAllTemplates();
        List<PlatformTemplates> publicTemplates = new ArrayList<>();

        publicTemplates = templatesList
                .stream()
                .parallel()
                .filter(templates -> Integer.valueOf(templates.getCsPublic()) == 1)
                .collect(Collectors.toList());

        return new ResponseEntity<>(publicTemplates, HttpStatus.OK);
    }

    @ApiOperation(value = "List all platform templates which are in ready state", response = List.class)
    @ApiResponse(code = 200, message = "Successfully retrieved all platform templates which are ready")
    @GetMapping("/ready")
    public ResponseEntity<List<PlatformTemplates>> getAllReadyTemplates() {
        log.info("Fetching all the platform templates which are public");
        List<PlatformTemplates> templatesList = platformTemplateService.getAllTemplates();
        List<PlatformTemplates> readyTemplates = new ArrayList<>();

        readyTemplates = templatesList
                .stream()
                .parallel()
                .filter(templates -> templates.getCsReady().equalsIgnoreCase("true"))
                .collect(Collectors.toList());

        return new ResponseEntity<>(readyTemplates, HttpStatus.OK);
    }

    @ApiOperation(value = "Get platform template with corresponding id", response = PlatformTemplates.class)
    @ApiResponse(code = 200, message = "Successfully retrieved platform template which matches id")
    @GetMapping("/id/{id}")
    public ResponseEntity<PlatformTemplates> getPlatformTemplateById(@PathVariable("id") Long id) {
        log.info("Fetching the platform template with id {}", id);
        Optional<PlatformTemplates> template = platformTemplateService.getTemplateById(id);
        if (!template.isPresent())
            throw new PlatformTemplateNotFoundException("Unable to find the platform template with id " + id);

        return new ResponseEntity<>(template.get(), HttpStatus.OK);
    }
}
