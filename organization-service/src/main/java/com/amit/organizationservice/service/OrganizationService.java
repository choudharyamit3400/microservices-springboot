package com.amit.organizationservice.service;

import com.amit.organizationservice.dto.OrganizationDto;

public interface OrganizationService {
	OrganizationDto saveOrganization(OrganizationDto organizationDto);

	OrganizationDto getOrganizationByCode(String organizationCode);
}
