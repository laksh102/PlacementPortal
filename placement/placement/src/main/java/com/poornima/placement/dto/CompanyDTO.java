package com.poornima.placement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CompanyDTO {
    private long company_id;

    private String company_name;
    private MultipartFile company_logo;
    private String visitDate;
    private int studentsPlaced;
    private String highestPackage;
    private String description;
    private List<String> interviewQuestions;

}
