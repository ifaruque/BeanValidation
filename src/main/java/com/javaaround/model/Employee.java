package com.javaaround.model;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Employee { 
    private int id;

    @NotNull
    @Size(max = 25,min = 5)  
    private String firstName;
    @DecimalMax(value = "50000.00")
    private Double salary;  

    public int getId() {  
        return id;  
    }  
    public void setId(int id) {  
        this.id = id;  
    }  
    public String getFirstName() {  
        return firstName;  
    }  
    public void setFirstName(String firstName) {  
        this.firstName = firstName;  
    }  
    public Double getSalary() {  
        return salary;  
    }  
    public void setSalary(Double salary) {  
        this.salary = salary;  
    }  
}   