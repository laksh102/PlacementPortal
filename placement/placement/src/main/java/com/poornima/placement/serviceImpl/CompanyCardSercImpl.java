package com.poornima.placement.serviceImpl;

import com.poornima.placement.dto.CompanyDTO;
import com.poornima.placement.entity.Company;
import com.poornima.placement.repository.CompanyCardRepo;
import com.poornima.placement.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CompanyCardSercImpl implements CompanyService {

    @Autowired
    private CompanyCardRepo companyCardRepo;


    @Override
    public List<CompanyDTO> getAllCompanies() {
        List<Company> companies = companyCardRepo.findAll();
        return companies.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public CompanyDTO getCompanyById(Long id) {
        Company company = companyCardRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + id));
        return convertToDTO(company);
    }

    @Override
    public CompanyDTO addCompany(CompanyDTO CompanyDTO) {
        Company company = convertToEntity(CompanyDTO);
        company.setCompanyId(generateCompanyId()); // Generate company ID
        Company savedCompany = companyCardRepo.save(company);
        return convertToDTO(savedCompany);
    }

    @Override
    public CompanyDTO updateCompany(Long id, CompanyDTO CompanyDTO) {
        Company existingCompany = companyCardRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + id));

        // Update existing company fields
        existingCompany.setName(CompanyDTO.getCompany_name());
        existingCompany.setDescription(CompanyDTO.getDescription());
        existingCompany.setVisitDate(CompanyDTO.getVisitDate());
        existingCompany.setStudentsPlaced(CompanyDTO.getStudentsPlaced());
        existingCompany.setHighestPackage(Double.parseDouble(CompanyDTO.getHighestPackage()));
        existingCompany.setInterviewQuestions(CompanyDTO.getInterviewQuestions());

        Company updatedCompany = companyCardRepo.save(existingCompany);
        return convertToDTO(updatedCompany);
    }

    @Override
    public void deleteCompany(Long id) {
        companyCardRepo.deleteById(id);
    }

    // Convert methods
    private Company convertToEntity(CompanyDTO CompanyDTO) {
        return null;
        // Convert CompanyDTO to Company entity
    }

    private CompanyDTO convertToDTO(Company company) {
        return null;
        // Convert Company entity to CompanyDTO
    }

    private String generateCompanyId() {
        return null;
        // Implement logic to generate unique company ID (e.g., using timestamp)
    }
}
