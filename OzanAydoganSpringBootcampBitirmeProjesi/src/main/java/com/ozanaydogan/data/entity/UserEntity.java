package com.ozanaydogan.data.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@Log4j2
@Entity
@Table(name = "Users")
public class UserEntity  extends BaseEntity implements Serializable {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "citizenship_number",unique=true)
    private Long citizenshipNumber;

    @Column(name = "credit_score")
    private Integer creditScore;

    @Column(name = "credit_status")
    private Boolean creditStatus;

    @Column(name = "credit_limit")
    private Double creditLimit;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "email_id")
    private String emailId;


    public UserEntity(String firstName, String lastName, Long citizenshipNumber, Integer creditScore,
                      Boolean creditStatus, Double creditLimit, Long phoneNumber, Double salary, String emailId) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.citizenshipNumber = citizenshipNumber;
        this.creditScore = creditScore;
        this.creditStatus = creditStatus;
        this.creditLimit = creditLimit;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.emailId = emailId;
    }
}
