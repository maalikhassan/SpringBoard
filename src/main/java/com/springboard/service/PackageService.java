package com.springboard.service;

import com.springboard.dto.PackageDTO;
import java.util.List;

public interface PackageService {
    void addPackage(PackageDTO packageDTO);
    void updatePackage(PackageDTO packageDTO);
    void deletePackage(Integer id);
    PackageDTO searchPackage(Integer id);
    List<PackageDTO> getAllPackage();
}
