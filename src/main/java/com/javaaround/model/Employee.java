package com.javaaround.model;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
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

    //Age can only be 2 digits long or less
    @Digits(integer=2, fraction=0,message="${integer  > 1 ? 's' : ''} must be {integer} digits long or less")
    private int age;

    @Pattern(regexp=".+@.+\\.[a-z]+",message="'${validatedValue}' invalid ")
    private String email;

}   