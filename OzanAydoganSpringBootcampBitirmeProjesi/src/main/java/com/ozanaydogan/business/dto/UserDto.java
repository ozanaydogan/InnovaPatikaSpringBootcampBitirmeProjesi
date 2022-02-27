package com.ozanaydogan.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Double creditLimit;
    private Long citizenshipNumber;
    private Integer creditScore;
    private Boolean creditStatus;
    private Long phoneNumber;
    private Double salary;
    private String createdBy;
    private Date createdDate;
    private String updateBy;
    private Date updatedDate;
    private Date date;
    private String emailId;
}
