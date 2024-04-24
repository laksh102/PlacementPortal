package com.poornima.placement.controller;


import com.poornima.placement.dto.CompanyDTO;
import com.poornima.placement.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> getAllCompanies() {
        List<CompanyDTO> companies = companyService.getAllCompanies();
        return ResponseEntity.ok(companies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable Long id) {
        CompanyDTO company = companyService.getCompanyById(id);
        return ResponseEntity.ok(company);
    }

    @PostMapping
    public ResponseEntity<CompanyDTO> addCompany(@RequestParam("logo") MultipartFile logo,
                                                 @RequestParam("name") String name,
                                                 @RequestParam("description") String description,
                                                 @RequestParam("visitDate") String visitDate,
                                                 @RequestParam("studentsPlaced") int studentsPlaced,
                                                 @RequestParam("package") double highestPackage,
                                                 @RequestParam("interviewQuestions") List<String> interviewQuestions) throws IOException {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setCompany_name(name);
        companyDTO.setDescription(description);
        companyDTO.setVisitDate(visitDate);
        companyDTO.setStudentsPlaced(studentsPlaced);
        companyDTO.setHighestPackage(String.valueOf(highestPackage));
        companyDTO.setInterviewQuestions(interviewQuestions);
//        companyDTO.setCompany_logo(logo.getBytes());

        CompanyDTO savedCompany = companyService.addCompany(companyDTO);
        return new ResponseEntity<>(savedCompany, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyDTO> updateCompany(@PathVariable Long id,
                                                    @RequestParam("logo") MultipartFile logo,
                                                    @RequestParam("name") String name,
                                                    @RequestParam("description") String description,
                                                    @RequestParam("visitDate") String visitDate,
                                                    @RequestParam("studentsPlaced") int studentsPlaced,
                                                    @RequestParam("package") double higestPackage,
                                                    @RequestParam("interviewQuestions") List<String> interviewQuestions) throws IOException {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setCompany_name(name);
        companyDTO.setDescription(description);
        companyDTO.setVisitDate(visitDate);
        companyDTO.setStudentsPlaced(studentsPlaced);
        companyDTO.setHighestPackage(String.valueOf(higestPackage));
        companyDTO.setInterviewQuestions(interviewQuestions);
//        companyDTO.setCompany_logo(logo.getBytes());

        CompanyDTO updatedCompany = companyService.updateCompany(id, companyDTO);
        return ResponseEntity.ok(updatedCompany);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }
}

