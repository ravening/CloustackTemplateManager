package com.leaseweb.templatemanager.repository;

import com.leaseweb.templatemanager.models.PlatformTemplates;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformTemplatesRepository extends JpaRepository<PlatformTemplates, Long> {
    List<PlatformTemplates> findAllByTemplateId(Long id);
    List<PlatformTemplates> findAllByPlatformId(Long id);
}
