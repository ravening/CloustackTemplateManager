package com.leaseweb.templatemanager.repository;

import com.leaseweb.templatemanager.models.TemplateView;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateViewRepository extends JpaRepository<TemplateView, Long> {
    List<TemplateView> findTemplateViewByNameContainsIgnoreCase(String name);
    List<TemplateView> findTemplateViewByTagContainsIgnoreCase(String tag);
    List<TemplateView> findTemplateViewByOsdistroContainsIgnoreCase(String name);
    List<TemplateView> findTemplateViewByOsversionContainsIgnoreCase(String name);
    List<TemplateView> findTemplateViewByOsidSapContainsIgnoreCase(String name);
    List<TemplateView> findTemplateViewByOsidCasContainsIgnoreCase(String name);
    List<TemplateView> findTemplateViewBySize(String size);
    List<TemplateView> findTemplateViewByVirtioContainsIgnoreCase(String name);
}
