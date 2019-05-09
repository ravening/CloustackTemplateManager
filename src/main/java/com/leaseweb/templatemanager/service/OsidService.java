package com.leaseweb.templatemanager.service;

import com.leaseweb.templatemanager.models.Osid;
import com.leaseweb.templatemanager.repository.OsidRespository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OsidService {
    @Autowired
    private OsidRespository osidRespository;

    public List<Osid> getAllOsid() {
        return osidRespository.findAll();
    }

    public Optional<Osid> getOsidById(Long id) {
        Optional<Osid> osid = osidRespository.findById(id);
        return osid;
    }
}
