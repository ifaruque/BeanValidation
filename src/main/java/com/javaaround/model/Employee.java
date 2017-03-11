package com.javaaround.model;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;


@Data
public class Employee { 

    private int id;
    @NotNull
    @Size(max = 25,min = 5)  
    private String firstName;
    @DecimalMax(value = "50000.00")
    private Double salary; 

    @AssertTrue
    boolean active; 

    @Future
    Date arrageDate;

    @Past
    Date birthday;

}   