package com.leaseweb.templatemanager.controllers;

import com.leaseweb.templatemanager.exception.TemplateViewNotFoundException;
import com.leaseweb.templatemanager.models.TemplateView;
import com.leaseweb.templatemanager.service.TemplateViewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/templateview")
@Slf4j
@Api(value = "Template View Controller", description = "Endpoints to get template views")
public class TemplateViewController {
    @Autowired
    private TemplateViewService templateViewService;

    @GetMapping("/listall")
    public ResponseEntity<List<TemplateView>> getAllTemplates() {
        List<TemplateView> templateViews = templateViewService.getAllTemplateViews();

        return new ResponseEntity<>(templateViews, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<TemplateView> getTemplateViewById(@PathVariable("id") Long id) {
        Optional<TemplateView> tempalteView = templateViewService.getTemplateViewById(id);
        if (!tempalteView.isPresent()) {
            throw new TemplateViewNotFoundException("Unable to find the template view by id " + id);
        }

        return new ResponseEntity<>(tempalteView.get(), HttpStatus.OK);
    }

    @ApiOperation(value = "List templates by name", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the template"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Access is forbiddecd"),
            @ApiResponse(code = 404, message = "Unable to find the template")
    })
    @GetMapping("/name/{name}")
    public ResponseEntity<List<TemplateView>> getTemplatesViewByName(@PathVariable("name") String name) {
        log.info("Fetching the templates by name {}", name);
        List<TemplateView> templatesList = templateViewService.getTemplatesByName(name);

        return new ResponseEntity<>(templatesList, HttpStatus.OK);
    }

    @ApiOperation(value = "List templates by tag name", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the template"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Access is forbiddecd"),
            @ApiResponse(code = 404, message = "Unable to find the template")
    })
    @GetMapping("/tag/{tag}")
    public ResponseEntity<List<TemplateView>> getTemplatesByTag(@PathVariable("tag") String tag) {
        log.info("Fetching the templates by tag name {}", tag);
        List<TemplateView> templatesList = templateViewService.getTemplatesByTag(tag);

        return new ResponseEntity<>(templatesList, HttpStatus.OK);
    }

    @ApiOperation(value = "List templates by osdistro name", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the template"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Access is forbiddecd"),
            @ApiResponse(code = 404, message = "Unable to find the template")
    })
    @GetMapping("/osdistro/{name}")
    public ResponseEntity<List<TemplateView>> getTemplatesByOsdistro(@PathVariable("name") String name) {
        log.info("Fetching the templates by tag name {}", name);
        List<TemplateView> templatesList = templateViewService.getTemplatesByOsdistro(name);

        return new ResponseEntity<>(templatesList, HttpStatus.OK);
    }

    @ApiOperation(value = "List templates by osversion", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the template"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Access is forbiddecd"),
            @ApiResponse(code = 404, message = "Unable to find the template")
    })
    @GetMapping("/osversion/{name}")
    public ResponseEntity<List<TemplateView>> getTemplatesByOsversion(@PathVariable("name") String name) {
        log.info("Fetching the templates by tag name {}", name);
        List<TemplateView> templatesList = templateViewService.getTemplatesByOsversion(name);

        return new ResponseEntity<>(templatesList, HttpStatus.OK);
    }

    @ApiOperation(value = "List templates by SAP id", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the template"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Access is forbiddecd"),
            @ApiResponse(code = 404, message = "Unable to find the template")
    })
    @GetMapping("/sapid/{name}")
    public ResponseEntity<List<TemplateView>> getTemplatesBySapId(@PathVariable("name") String name) {
        log.info("Fetching the templates by sap id {}", name);
        List<TemplateView> templatesList = templateViewService.getTemplatesBySapid(name);

        return new ResponseEntity<>(templatesList, HttpStatus.OK);
    }

    @ApiOperation(value = "List templates by CAS id", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the template"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Access is forbiddecd"),
            @ApiResponse(code = 404, message = "Unable to find the template")
    })
    @GetMapping("/casid/{name}")
    public ResponseEntity<List<TemplateView>> getTemplatesByCasId(@PathVariable("name") String name) {
        log.info("Fetching the templates by cas id {}", name);
        List<TemplateView> templatesList = templateViewService.getTemplatesByCasid(name);

        return new ResponseEntity<>(templatesList, HttpStatus.OK);
    }

    @ApiOperation(value = "List templates by size", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the template"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Access is forbiddecd"),
            @ApiResponse(code = 404, message = "Unable to find the template")
    })
    @GetMapping("/size/{name}")
    public ResponseEntity<List<TemplateView>> getTemplatesBySize(@PathVariable("name") String name) {
        log.info("Fetching the templates by size {}", name);
        List<TemplateView> templatesList = templateViewService.getTemplatesBySize(name);

        return new ResponseEntity<>(templatesList, HttpStatus.OK);
    }

    @ApiOperation(value = "List templates by Virtio type", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the template"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Access is forbiddecd"),
            @ApiResponse(code = 404, message = "Unable to find the template")
    })
    @GetMapping("/virtio/{name}")
    public ResponseEntity<List<TemplateView>> getTemplatesByVirtio(@PathVariable("name") String name) {
        log.info("Fetching the templates by size {}", name);
        List<TemplateView> templatesList = templateViewService.getTemplatesByVirtio(name);

        return new ResponseEntity<>(templatesList, HttpStatus.OK);
    }

    @ApiOperation(value = "List templates which can autogrow", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the template"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Access is forbiddecd"),
            @ApiResponse(code = 404, message = "Unable to find the template")
    })
    @GetMapping("/autogrow")
    public ResponseEntity<List<TemplateView>> getAutoGrowTemplates() {
        log.info("Fetching the templates which can autogrow");
        List<TemplateView> templatesList = templateViewService.getAllTemplateViews();
        List<TemplateView> autoGrowTemplates = new ArrayList<>();

        autoGrowTemplates = templatesList
                .stream()
                .parallel()
                .filter(templates -> Integer.valueOf(templates.getGrow()) == 1)
                .collect(Collectors.toList());
        return new ResponseEntity<>(autoGrowTemplates, HttpStatus.OK);
    }
}
