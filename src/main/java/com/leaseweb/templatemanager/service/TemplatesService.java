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

    public List<Templates> getTemplatesByTag(String tag) {
        return templatesRepository.findTemplatesByTagContainsIgnoreCase(tag);
    }

    public List<Templates> getTemplatesByOsdistro(String name) {
        return templatesRepository.findTemplatesByOsdistroContainsIgnoreCase(name);
    }

    public List<Templates> getTemplatesByOsversion(String name) {
        return templatesRepository.findTemplatesByOsversionContainsIgnoreCase(name);
    }

    public List<Templates> getTemplatesBySapid(String sapId) {
        return templatesRepository.findTemplatesByOsidSapContainsIgnoreCase(sapId);
    }

    public List<Templates> getTemplatesByCasid(String casId) {
        return templatesRepository.findTemplatesByOsidCasContainsIgnoreCase(casId);
    }

    public List<Templates> getTemplatesBySize(String size) {
        return templatesRepository.findTemplatesBySize(size);
    }

    public List<Templates> getTemplatesByVirtio(String name) {
        return templatesRepository.findTemplatesByVirtioContainsIgnoreCase(name);
    }
}
