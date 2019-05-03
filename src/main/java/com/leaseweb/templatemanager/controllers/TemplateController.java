package com.leaseweb.templatemanager.controllers;

import com.leaseweb.templatemanager.exception.TemplateNotFoundException;
import com.leaseweb.templatemanager.models.Platforms;
import com.leaseweb.templatemanager.models.Templates;
import com.leaseweb.templatemanager.service.TemplatesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("/api/v1/templates")
@Api(value = "Templates controller", description = "API calls to get template details")
@Slf4j
public class TemplateController {
    @Autowired
    private TemplatesService templatesService;

    @ApiOperation(value = "List all tempalates", response = List.class)
    @ApiResponse(code = 200, message = "Successfully retrieved all templates")
    @GetMapping("/listall")
    public ResponseEntity<List<Templates>> getAllTemplates() {
        log.info("Fetching all the templates");
        List<Templates> templatesList = templatesService.getAllTemplates();
        return new ResponseEntity<>(templatesList, HttpStatus.OK);
    }

    @ApiOperation(value = "List template by id", response = Templates.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the template"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Access is forbiddecd"),
            @ApiResponse(code = 404, message = "Unable to find the template")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Templates> getTemplateById(@PathVariable("id") Long id) {
        log.info("Fetching the template with id {}", id);
        Optional<Templates> templates = templatesService.getTemplateById(id);
        if (!templates.isPresent()) {
            throw new TemplateNotFoundException("Unable to find the template with id " +id);
        }

        return ResponseEntity.status(HttpStatus.OK).body(templates.get());
    }

    @ApiOperation(value = "List templates by name", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the template"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Access is forbiddecd"),
            @ApiResponse(code = 404, message = "Unable to find the template")
    })
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Templates>> getTemplatesByName(@PathVariable("name") String name) {
        log.info("Fetching the templates by name {}", name);
        List<Templates> templatesList = templatesService.getTemplatesByName(name);

        return new ResponseEntity<>(templatesList, HttpStatus.OK);
    }
}
