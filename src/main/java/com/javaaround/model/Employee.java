package com.javaaround.model;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.URL;
import javax.validation.Valid;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;


@Data
public class Employee { 
    
    private int id;
    @Size(max = 25,min = 5)  
    private String firstName;
    @DecimalMax(value = "50000.00")
    private Double salary; 

    //Age can only be 2 digits long or less
    @Digits(integer=2, fraction=0)
    private int age;

    @Email
    private String email;
    @SafeHtml
    private String remarks;

    @URL
    private String profileLink;

}   