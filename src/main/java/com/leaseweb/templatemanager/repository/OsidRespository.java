package com.leaseweb.templatemanager.repository;

import com.leaseweb.templatemanager.models.Osid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OsidRespository extends JpaRepository<Osid, Long> {
}
