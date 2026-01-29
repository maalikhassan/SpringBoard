package com.springboard.service;

import com.springboard.dto.CompanyDTO;
import com.springboard.entity.CompanyEntity;

import java.util.List;

public interface CompanyService {
    void addCompany(CompanyDTO companyDTO);
    void deleteCompany(Integer id);
    List<CompanyDTO> getAllCompany();
    CompanyDTO getCompanyById(Integer id);
    void updateCompany(CompanyDTO companyDTO);
}
