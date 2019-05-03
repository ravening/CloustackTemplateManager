package com.leaseweb.templatemanager.repository;

import com.leaseweb.templatemanager.models.Platforms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformsRepository extends JpaRepository<Platforms, Long> {
}
