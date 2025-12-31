
## Module 2 : SpringBoot MVC and RestFul API's

### 2.1 Introduction to SpringBoot, MVC Architecture, Tomcat & Dispatcher Servlet

**Web Server**

Client -> API-> Server 

**MVC Architecture**

- Model 
- View
- Controller 

Client -> Controller ( Request processor, routes the client request to right endpoint) -> Model ( Table in db, handles the data ) -> View ( helps to convert Java object to client request format ( JSON, HTML ) ) -> Client Response 

**Spring MVC with REST API's**

Request -> Tomcat (web server) -> Dispatcher Servlet( handles routing & dispatches the request to hanlder ) -> Handler Mapping( like @GetMapping("/api/request/") ) -> Handler Adapter( invoke controller ) -> Controller ->  Service ( business logic ) -> Repositoty( data layer ) -> (controller returns POJO object ) Model (HTTP message converter, POJO -> JSON ) -> Dispatcher Servlet ( writes to HTTPServeletResponse ) -> web server -> Client response 

1. Tomcat : Web server to handle the request, it can be any server
2. Dispatcher Servlet : 
    a. It creates HttpServletRequest and HttpServletResponse objects
    b. It then delegates the request to hanldermapping ( like @GetMapping("/api/request/") )
    c. The controller method is invoked to handle this route.
3. Controller : takes the request & performs the validations of the api request, & get the data from repo and sends back to dispatcher servlet 
4. The reponse is converted to JSON/HTML using HTTPServletResponse -> sends to web server -> client  


### 2.2 The presentation Layer, DTO & Controllers

- Spring MVC provides an annotation-based programming model where `@Controller` & `@RestController` components use annotations to express request mappings, request input, exception handling & more..

The `@RestController` annotation is a shorthand for `@Controller` & `@ResponseBody` meaning all methods in the controller will return JSON/XML directly to the response body


### 2.3 The persistence Layer & JPA Repository 

**Java Persistence API - JPA**

JPA -> JPA Provider ( hibernate ) -> API JDBC -> Driver Connector or Driver PostgreSQL -> MYSQL or PostgreSQL 

Hibernate : JPA provider specification ( ORM Mapping : Object -> Tables )  
          and Java Persistance Query Language -> SQL Query 

JPQL ( Java Persistance Query Language )

`@Entity` -> Java Class convert this into Table name
Inside this `@Entity`, we can have table validations, before storing the data in db. 
- The primary key can be auto generated with `@GeneratedValue(strategy = GenerationType.AUTO)`

**Repository Layer**
- we can extend the interface with `JpaRepository<Entity-Name, Primary-key-type>` handles all the queires.

> Optional Type : Optional is a way of handling/dealing with NullPointerException. 

### 2.4 The service Layer, writing business logic 
- Service layer acts as a brige between the persistence layer & presentation layer ( hanlding user interaction )
- This layer contains the business logic

### 2.5 PUT, PATCH & DELETE Mapping in spring web MVC


**Reflections**
Reflections -> using reflections, we can go to any object & update the fields of that object. it works by inversely updating the field values.

`@JsonProperty("property-name")` : when you want json to handle the convertion of JSON -> JAVA object -> JSON 
`org.springframework.http.ResponseEntity` -> Used in controller to handle the status codes & return of the right status code in response  

### 2.6 Input Validation Annotations, Creating custom Annotation for validation 

The first point of contact for client is controller, which has the DTO as input, therefore, we need to validate the DTO firsts. 
At field level using `@NotNull(message="custom message")` to handle the inputs and while passing it at controller include `@Valid` 

| Validation Anotations        | description                           |
| ----------- | ------------------------------- |
| `@NotNull` |  The field can't be null         |
| `@NotEmpty`        | The field size is greater then zero & its not null |
| `@NotBlank`  | It shouldn't be null & its trimmed length is greater then zero           |
| `@Size(min = x, max = y, message = "..")`  | The field size must be within the range          |
| `@Max(value = maxValue, message = "...")`  | Max field length/size      |
| `@Min(value = minValue, message = "...")`  | Min field length/size      |
| `@Email(message = "...")`  | Valid email with domain check     |
| `@Pattern(regexp = "^$", message = "...")`  | Regex pattern matching     |
| `@Positive`  | Validate the field should be positive    |
| `@PositiveOrZero`  | Validate the field should be positive or Zero   |
| `@Past`  | The date is field is in past  |
| `@PastOrPresent`  | The date is field is in past or present  |
| `@Future`  | The date is field is in future  |
| `@FutureOrPresent`  | The date is field is in future or present  |
| `@Digits(integer = maxIntDigits, fraction = maxFactionDigits, message = "...")`  | The field has up to a specified number of integer & fraction digits  |
| `@DecimalMin`  | The field ensures that the number with value is not less than the specified minimum, allowing for decimal points |
| `@DecimalMax`  | The field  ensures that the number with value is not greater then specified maximum, allowing for decimal points |
| `@AssertTrue`  | The field  ensures that boolean is True |
| `@AssertFalse`  | The field  ensures that boolean is False |
| `@Valid`  | The field ensures that the input is valid |

#### Defining the custom annotations 

**Strcuture**

For creating the strcuture, define the `@interface` with 
```
@Retention(RetentionPolicy.RUNTIME) -> This annotation to be applied for what type of RetentionPolicy to be applied, -> {RUNTIME, SOURCE, CLASS}
@Target({ElementType.FIELD, ElementType.PARAMETER}) -> The annotation to be created, on what level these must be applied, -> {METHOD, FIELD, PARAMETER..}
public @interface UserRoleValidation {

    //The below 3 lines, leave as it is. 
    String message() default "{Role of User can be ADMIN or USER}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
```

**Logic**
```
public class className implements ConstraintValidator<classTobeValidated, FieldTobeValidated>{
    
    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext constraintValidatorContext) {

        List<String> roles = List.of("USER", "ADMIN");
        return roles.contains(inputRole);

    }
}
```

**Connecting annotations**
Add the `@Constraint(validatedBy = {UserRoleValidator.class})` at the `UserRoleValidation` class

### 2.7 Exception Handling in spring Boot web MVC 

**Benefits of Exception Handling**
- Prevent application crashed
- Provide user-friendly error response
- Facilitate debugging and maintenance
- Ensure consistent error handling across the application 

**Handling Exception**
- use `@ExceptionHanlder` to handle specific exception in controllers
- use `@RestControllerAdvice` for global exception handling
- Return appropriate HTTP status codes and error messages.
- use Custom error response class to provide strcuture error details.  

**Custom Exception**
```
@ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleUserNotFound(NoSuchElementException exception){
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }
```
- you can use this to handle the exception in the controller route request

- The best way to handle the exception at the global & individual request level is to create the exception in a package. 

### 2.8 Transforming API response in Spring Web MVC

- For handling the transforming Api response, need to implements `ResponseBodyAdvice<Object>`
```
@Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }
```
- supports, method helps to convert each & every api response. 
```
@Override
    public @Nullable Object beforeBodyWrite(@Nullable Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return null;
    }
```
- `` this gives us the object body, and we can transform this `object body` and retrain the body in any form. 


### 2.9 Refresher on Java 8 Lambda & Stream API

Lambda expressions with Functional Interfaces 
If a interface contains only one method -> Functional Interface 

Example : **Traditional way of working with interfaces/objects**
```
interface Walkable{
    int walk(int steps, int miles);
}

class WalkFast implements Walkable{

    @Override
    public int walk(int steps, int miles){
        System.out.println("You have walked " + steps + " and covered " + miles + " miles.");
        return steps * miles;
    }
}

class Main{

    public static void main(String[] args){
        Walkable walkFast = new WalkFast();
        walkFast.walk(10, 3);
    }
}
```

Example : **Functional Interface way**
```
interface Walkable{
    int walk(int steps, int miles);
}


class Main{

    public static void main(String[] args){
        
        Walkable walkFast = (steps, miles) -> {
            System.out.println("You have walked " + steps + " and covered " + miles + " miles.");
            return steps * miles;
        }
        walkFast.walk(4, 3);

        //OR
        Walkable walkFast2 = (steps, miles) -> steps * miles;
        walkFast2.walk( 4, 3 );
    }
}

```

**Streams**

```
List<String> fruits = List.of("Banana", "Apple", "Kiwi", "Mango");
Map<String, Integer> fruitsList = fruits
        .stream()
        .collect(Collectors.toMap(
            fruit -> fruit,
            fruit -> fruit.length()
        ));

Output => {Apple=5, Kiwi=4, Mango=5, Banana=6}



