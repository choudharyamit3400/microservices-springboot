package com.amit.organizationservice.repository;

import com.amit.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
	Organization findByOrganizationCode(String organizationCode);
}
