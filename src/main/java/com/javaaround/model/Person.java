package com.javaaround.model;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import lombok.Data;

@Data 
public class Person { 
	@NotEmpty
	private String name;

}	