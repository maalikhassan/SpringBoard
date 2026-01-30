package com.springboard.service.impl;

import com.springboard.dto.PackageDTO;
import com.springboard.entity.PackageEntity;
import com.springboard.repository.PackageRepository;
import com.springboard.service.PackageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PackageImpl implements PackageService {
    final PackageRepository packageRepository;
    final ModelMapper modelMapper;

    @Override
    public void addPackage(PackageDTO packageDTO) {
        PackageEntity packageEntity = modelMapper.map(packageDTO, PackageEntity.class);
        packageRepository.save(packageEntity);
    }
    @Override
    public void updatePackage(PackageDTO packageDTO) {
        PackageEntity packageEntity = modelMapper.map(packageDTO, PackageEntity.class);
        packageRepository.save(packageEntity);
    }
    @Override
    public void deletePackage(Integer id) {
        packageRepository.deleteById(id);
    }
    @Override
    public PackageDTO searchPackage(Integer id) {
        return modelMapper.map(packageRepository.findById(id),PackageDTO.class);
    }
    @Override
    public List<PackageDTO> getAllPackage(){
      List<PackageEntity> packageEntities = packageRepository.findAll();
        List<PackageDTO> packageDTOS = new ArrayList<>();
        packageEntities.forEach(packageEntity ->
        {
            PackageDTO packageDTO = modelMapper.map(packageEntity, PackageDTO.class);
            packageDTOS.add(packageDTO);
        });

        return packageDTOS;
    }
}
