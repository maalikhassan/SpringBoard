package com.springboard.controller;

import com.springboard.dto.CompanyDTO;
import com.springboard.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/get-all")
    public List<CompanyDTO> getAllCompany(){
        return companyService.getAllCompany();
    }

    @PostMapping("/add")
    public void addCompany(@RequestBody CompanyDTO companyDTO){
        companyService.addCompany(companyDTO);
    }
    @PutMapping("/update")
    public void updateCompany(@RequestBody CompanyDTO companyDTO){
        companyService.updateCompany(companyDTO);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCompany(@PathVariable Integer id){
        companyService.deleteCompany(id);
    }

    @GetMapping("/search/{id}")
    public CompanyDTO getCompanyById(@PathVariable Integer id){
        return companyService.getCompanyById(id);
    }



}
