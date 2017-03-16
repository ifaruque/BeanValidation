package com.javaaround.model;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
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

    @Pattern(regexp=".+@.+\\.[a-z]+",message="{error.invalid_email}")
    @NotNull(message="{error.required}")
    private String email;

    public void printData(@NotNull @Size(min=5) String data){
        System.out.println("Data is::"+data);
    }
    @Valid
    private List<Address> addressList;
}   