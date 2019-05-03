package com.leaseweb.templatemanager.service;

import com.leaseweb.templatemanager.models.Templates;
import com.leaseweb.templatemanager.repository.TemplatesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class TemplatesService {
    private TemplatesRepository templatesRepository;

    TemplatesService(TemplatesRepository templatesRepository) {
        this.templatesRepository = templatesRepository;
    }

    public List<Templates> getAllTemplates() {
        return templatesRepository.findAll();
    }

    public Optional<Templates> getTemplateById(Long id) {
        return templatesRepository.findById(id);
    }

    public List<Templates> getTemplatesByName(String name) {
        return templatesRepository.findTemplatesByNameContainsIgnoreCase(name);
    }
}
