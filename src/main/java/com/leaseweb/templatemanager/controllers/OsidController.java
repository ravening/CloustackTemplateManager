package com.leaseweb.templatemanager.controllers;

import com.leaseweb.templatemanager.exception.OsidNotFoundException;
import com.leaseweb.templatemanager.models.Osid;
import com.leaseweb.templatemanager.service.OsidService;
import java.util.List;
import java.util.Optional;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/osid")
public class OsidController {
    @Autowired
    private OsidService osidService;

    @GetMapping("/listall")
    public ResponseEntity<List<Osid>> getAllOsid() {
        return new ResponseEntity<>(osidService.getAllOsid(),
                HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Osid> getOsidById(@PathVariable("id") Long id) {
        Optional<Osid> osid = osidService.getOsidById(id);
        if (!osid.isPresent()) {
            throw new OsidNotFoundException("Unable to find the osid by id " + id);
        }

        return new ResponseEntity<>(osid.get(), HttpStatus.OK);
    }
}
