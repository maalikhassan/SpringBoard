package com.springboard.controller;

import com.springboard.dto.PackageDTO;
import com.springboard.service.PackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/package")
@CrossOrigin
@RequiredArgsConstructor
public class PackageController {

    private final PackageService packageService;

    @GetMapping("/get-all")
    public List<PackageDTO> getAllPackage(){
        return packageService.getAllPackage();
    }

    @GetMapping("/search/{id}")
    public PackageDTO searchPackageById(@PathVariable Integer id){
        return packageService.searchPackage(id);
    }

    @PostMapping("/add")
    public void addPackage(@RequestBody PackageDTO packageDTO){
        packageService.addPackage(packageDTO);
    }
    @PutMapping("/update")
    public void updatePackage(@RequestBody PackageDTO packageDTO){
        packageService.updatePackage(packageDTO);
    }
    @DeleteMapping("/delete/{id}")
    public void deletePackage(@PathVariable Integer id){
        packageService.deletePackage(id);
    }

}
