package com.javaaround;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import com.javaaround.model.Employee;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        Employee employee = new Employee();
        employee.setAge(100);
	 	employee.setEmail("shamim.ict0754gmail.com");

		/*ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();*/
		Validator validator = Validation.byDefaultProvider()
		.configure()
		.messageInterpolator(
				new ResourceBundleMessageInterpolator(
						new PlatformResourceBundleLocator( "messages" )
				)
		)
		.buildValidatorFactory()
		.getValidator();

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
