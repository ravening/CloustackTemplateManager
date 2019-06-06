package com.leaseweb.templatemanager.controllers;

import com.leaseweb.templatemanager.exception.PlatformNotFoundException;
import com.leaseweb.templatemanager.models.Platforms;
import com.leaseweb.templatemanager.service.PlatformService;
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
@RequestMapping("/api/v1/platforms")
@Api(value = "Platform controller", description = "API calls to get platform details")
@Slf4j
public class PlatformsController {
    @Autowired
    PlatformService platformService;

    @ApiOperation(value = "List all platforms", response = List.class)
    @ApiResponse(code = 200, message = "Successfully retrieved all platforms")
    @GetMapping("/listall")
    public ResponseEntity<List<Platforms>> getAllPlatforms() {
        log.info("Fetching all the platfom");
        List<Platforms> platforms = platformService.getAllPlatforms();
        return new ResponseEntity<>(platforms, HttpStatus.OK);
    }

    @ApiOperation(value = "List platform by id", response = Platforms.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the platform"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Access is forbiddecd"),
            @ApiResponse(code = 404, message = "Unable to find the platform")
    })
    @GetMapping("/id/{id}")
    public ResponseEntity<Platforms> getPlatformById(@PathVariable("id") Long id) {
        log.info("Fetching the platform with id {}", id);
        Optional<Platforms> platforms = platformService.getPlatformById(id);
        if (!platforms.isPresent()) {
            throw new PlatformNotFoundException("Unable to find the platform with id " + id);
        }

        return ResponseEntity.status(HttpStatus.OK).body(platforms.get());
    }
}
