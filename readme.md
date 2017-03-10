### Bean Validation ###
The Java API(`javax.validation.constraints`) for JavaBeans Validation (Bean Validation) provides a mechanism for validating application data.
Bean Validation specification JSR No 303 and introduce from jdk 6

Prior to JSR 303, you probably would have needed a bunch of if-else statements to achieve the bean validation.It saves lot of code.

reference implementation of 303 namely `Hibernate Validator`
 
### Warmup ###

1. create maven java project by following command

	`mvn archetype:generate -DgroupId=com.javaaround -DartifactId=Jpa -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false`

2. Update AppTest.java
	```java
	package com.javaaround;

	import org.junit.Test;;

	
	/**
	 * Unit test for simple App.
	 */
	public class AppTest {
	   @Test
	   public void AppTest( ){
	        App.main(null);
	   }
	}
	```

3. Update junit version at pom.xml

	```xml
	<version>4.8.1</version>
	```

4. Run app by following command

	`mvn clean package`


### Example Demo ###

1. Add hibernate-validator(provide also Bean Validator API) at pom.xml
	```xml
	<!-- 
	No need because it is included hibernate-validator
	<dependency>
	    <groupId>javax.validation</groupId>
	    <artifactId>validation-api</artifactId>
	    <version>1.1.0.Final</version>
	</dependency> 
	-->
	<dependency>
	    <groupId>org.hibernate</groupId>
	    <artifactId>hibernate-validator</artifactId>
	    <version>5.3.4.Final</version>
	</dependency>
	<!-- Needed by hibernate-validator to substitute params in messages: -->
	<dependency>
	    <groupId>org.glassfish.web</groupId>
	    <artifactId>javax.el</artifactId>
	    <version>2.2.4</version>
	    <scope>runtime</scope>
	</dependency>
	```

2. Create a bean(Employee.java)

	```java
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
	``` 

	Explantion :
 
	1. @NotNull :

		The value of the property must not be null.Unfortunately it doesn't check for empty string values.For this reason hibernate introduce two new contraints(not yet JPA)

		1. @NotEmpty : The value of the property must not be null && value not empty means if empty spaces then it is valid
		2. @NotBlank :  The value of the property must not be null && value not empty.trimming the value first and if empty spaces then it is invalid  


	2. @Size :

		If the field or property is a String, the size of the string is evaluated. If the property is a Collection, the size of the Collection is evaluated. If the property is a Map, the size of the Map is evaluated. If the property is an array, the size of the array is evaluated. Use one of the optional `max or min` elements to specify the boundaries.

	3. @DecimalMax :

		The value of the property must be a decimal value lower than or equal to the number in the value element.

	Note : if the class uses field access type, apply the Bean Validation constraint annotations on the class’s fields. If the class uses property access, apply the constraints on the getter methods.

3. Update App.java

	```java
	Employee employee = new Employee();
	employee.setId(122);
	employee.setSalary(60000.00);
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();
	Set<ConstraintViolation<Employee>> constraints = validator
		.validate(employee);
	if (constraints.isEmpty()) {
		System.out.print("valid data");
	}else{	
		for (ConstraintViolation<Employee> constraint : constraints) {
			System.out.println(constraint.getPropertyPath() + "  "
			+ constraint.getMessage());
		}
	}
	```

4. Run app

![Image of Nested](images/1.png) 