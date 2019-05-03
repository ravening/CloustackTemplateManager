package com.leaseweb.templatemanager.service;

import com.leaseweb.templatemanager.models.Platforms;
import com.leaseweb.templatemanager.repository.PlatformsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PlatformService {
    private PlatformsRepository platformsRepository;

    PlatformService(PlatformsRepository platformsRepository) {
        this.platformsRepository = platformsRepository;
    }

    public List<Platforms> getAllPlatforms() {
        return platformsRepository.findAll();
    }

    public Optional<Platforms> getPlatformById(Long id) {
        return platformsRepository.findById(id);
    }
}
