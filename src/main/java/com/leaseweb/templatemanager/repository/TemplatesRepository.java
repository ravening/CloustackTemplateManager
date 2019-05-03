package com.leaseweb.templatemanager.repository;

import com.leaseweb.templatemanager.models.Templates;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplatesRepository extends JpaRepository<Templates, Long> {
    List<Templates> findTemplatesByNameContainsIgnoreCase(String name);
    List<Templates> findTemplatesByTagContainsIgnoreCase(String tag);
    List<Templates> findTemplatesByOsdistroContainsIgnoreCase(String name);
    List<Templates> findTemplatesByOsversionContainsIgnoreCase(String name);
    List<Templates> findTemplatesByOsidSapContainsIgnoreCase(String name);
    List<Templates> findTemplatesByOsidCasContainsIgnoreCase(String name);
    List<Templates> findTemplatesBySize(String size);
    List<Templates> findTemplatesByVirtioContainsIgnoreCase(String name);
}
