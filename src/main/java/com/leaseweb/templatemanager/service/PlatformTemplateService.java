package com.leaseweb.templatemanager.service;

import com.leaseweb.templatemanager.models.PlatformTemplates;
import com.leaseweb.templatemanager.repository.PlatformTemplatesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PlatformTemplateService {
    private PlatformTemplatesRepository platformTemplatesRepository;

    PlatformTemplateService(PlatformTemplatesRepository repository) {
        this.platformTemplatesRepository = repository;
    }

    public List<PlatformTemplates> getTemplatesByPlatformId(Long id) {
        return platformTemplatesRepository.findAllByPlatformId(id);
    }

    public List<PlatformTemplates> getTemplatesByTemplateId(Long id) {
        return platformTemplatesRepository.findAllByTemplateId(id);
    }

    public List<PlatformTemplates> getAllTemplates() {
        return platformTemplatesRepository.findAll();
    }

    public Optional<PlatformTemplates> getTemplateById(Long id) {
        return platformTemplatesRepository.findById(id);
    }
}
