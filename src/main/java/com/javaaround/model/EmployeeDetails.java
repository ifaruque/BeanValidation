package com.javaaround.model;
import lombok.Data;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
@Data
public class EmployeeDetails { 
	private int id;
	@NotEmpty
	private String city;
	@NotNull
	private String fatherName;


}	