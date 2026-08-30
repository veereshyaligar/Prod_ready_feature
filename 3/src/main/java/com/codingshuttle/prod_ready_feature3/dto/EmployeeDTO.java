package com.codingshuttle.prod_ready_feature3.dto;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long Id;

    private String name;


    private String email;


    private Integer age;


    private String role;


    private Double salary;

    private LocalDate dateOfJoining;

    private Boolean active;
}
