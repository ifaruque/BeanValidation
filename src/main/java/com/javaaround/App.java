package com.javaaround;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import com.javaaround.model.Employee;
import com.javaaround.model.EmployeeDetails;
import com.javaaround.model.EmployeeChecks;
import com.javaaround.model.EmployeeChecks2;
import com.javaaround.model.Address;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;
import java.lang.reflect.Method;
import javax.validation.executable.ExecutableValidator;
import javax.validation.groups.Default;
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
        //employee.setAge(18);
	 	employee.setEmail("shamim.ict0754@gmail.com");

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
			.validate(employee,EmployeeChecks2.class);
		if (constraints.isEmpty()) {
			System.out.print("valid data");
		}else{	
			for (ConstraintViolation<Employee> constraint : constraints) {
				System.out.println(constraint.getMessageTemplate() + constraint.getPropertyPath() + "  "
				+ constraint.getMessage());
			}
		}
		
		
    }
}
