package com.springboard.service.impl;

import com.springboard.dto.CompanyDTO;
import com.springboard.entity.CompanyEntity;
import com.springboard.repository.CompanyRepository;
import com.springboard.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyImpl implements CompanyService {
    final CompanyRepository companyRepository;
    final ModelMapper modelMapper;

    @Override
    public void addCompany(CompanyDTO companyDTO) {
        CompanyEntity companyEntity = modelMapper.map(companyDTO, CompanyEntity.class);
        companyRepository.save(companyEntity);
    }

    @Override
    public void updateCompany(CompanyDTO companyDTO) {
        CompanyEntity companyEntity = modelMapper.map(companyDTO, CompanyEntity.class);
        companyRepository.save(companyEntity);
    }

    @Override
    public void deleteCompany(Integer id) {

        companyRepository.deleteById(id);
    }

    @Override
    public List<CompanyDTO> getAllCompany() {

        List<CompanyEntity> companyEntities = companyRepository.findAll();
        List<CompanyDTO> companyDTOS = new ArrayList<>();
        companyEntities.forEach(companyEntity ->
        {
            CompanyDTO companyDTO = modelMapper.map(companyEntity, CompanyDTO.class);
            companyDTOS.add(companyDTO);
        });

        return companyDTOS;
    }

    @Override
    public CompanyDTO getCompanyById(Integer id) {
        return modelMapper.map(companyRepository.findById(id), CompanyDTO.class);
    }




}
