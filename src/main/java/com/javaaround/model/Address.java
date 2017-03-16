package com.javaaround.model;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import lombok.Data;

@Data 
public class Address { 
	@NotEmpty
	private String street;
	@NotEmpty
	private String city;
	@NotNull
	private String postcode;

}	