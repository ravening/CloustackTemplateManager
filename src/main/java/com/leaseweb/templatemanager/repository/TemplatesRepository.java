package com.leaseweb.templatemanager.repository;

import com.leaseweb.templatemanager.models.Templates;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplatesRepository extends JpaRepository<Templates, Long> {
    List<Templates> findTemplatesByNameContainsIgnoreCase(String name);
}
