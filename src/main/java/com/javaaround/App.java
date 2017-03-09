package com.javaaround;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import com.javaaround.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Employee employee = new Employee();
        employee.setId(122);
		//employee.setFirstName("Md.Shamim");
		employee.setSalary(60000.00);

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Employee>> constraints = validator
			.validate(employee);
		if (constraints.isEmpty()) {
			System.out.print("validation data");
		}else{	
			for (ConstraintViolation<Employee> constraint : constraints) {
				System.out.println(constraint.getPropertyPath() + "  "
				+ constraint.getMessage());
			}
		}
    }
}
