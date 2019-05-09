package com.leaseweb.templatemanager.service;

import com.leaseweb.templatemanager.models.TemplateView;
import com.leaseweb.templatemanager.repository.TemplateViewRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateViewService {
    @Autowired
    private TemplateViewRepository templateViewRepository;

    public List<TemplateView> getAllTemplateViews() {
        return templateViewRepository.findAll();
    }

    public Optional<TemplateView> getTemplateViewById(Long id) {
        Optional<TemplateView> tempalteView = templateViewRepository.findById(id);
        return tempalteView;
    }

    public List<TemplateView> getTemplatesByName(String name) {
        return templateViewRepository.findTemplateViewByNameContainsIgnoreCase(name);
    }

    public List<TemplateView> getTemplatesByTag(String tag) {
        return templateViewRepository.findTemplateViewByTagContainsIgnoreCase(tag);
    }

    public List<TemplateView> getTemplatesByOsdistro(String name) {
        return templateViewRepository.findTemplateViewByOsdistroContainsIgnoreCase(name);
    }

    public List<TemplateView> getTemplatesByOsversion(String name) {
        return templateViewRepository.findTemplateViewByOsversionContainsIgnoreCase(name);
    }

    public List<TemplateView> getTemplatesBySapid(String sapId) {
        return templateViewRepository.findTemplateViewByOsidSapContainsIgnoreCase(sapId);
    }

    public List<TemplateView> getTemplatesByCasid(String casId) {
        return templateViewRepository.findTemplateViewByOsidCasContainsIgnoreCase(casId);
    }

    public List<TemplateView> getTemplatesBySize(String size) {
        return templateViewRepository.findTemplateViewBySize(size);
    }

    public List<TemplateView> getTemplatesByVirtio(String name) {
        return templateViewRepository.findTemplateViewByVirtioContainsIgnoreCase(name);
    }
}
