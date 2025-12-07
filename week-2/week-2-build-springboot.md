
## Module 2 : SpringBoot MVC and RestFul API's

### 2.1 Introduction to SpringBoot, MVC Architecture, Tomcat & Dispatcher Servlet

**Web Server**

Client -API-> Server 

**MVC Architecture**


- Model 
- View
- Controller 

Client -> Controller ( Request processor, routes the client request to right endpoint) -> Model ( Table in db, handles the data ) -> View ( helps to convert Java object to client request format ( JSON, HTML ) ) -> Client Response 

**Spring MVC with REST API's**

Request -> Tomcat (web server) -> Dispatcher Servlet( handles routing & dispatches the request to hanlder ) -> Handler Mapping( like @GetMapping("/api/request/") ) -> Handler Adapter( invoke controller ) -> Controller ->  Service ( business logic ) -> Repositoty( data layer ) -> (controller returns POJO object ) Model (HTTP message converter, POJO -> JSON ) -> Dispatcher Servlet ( writes to HTTPServeletResponse ) -> web server -> Client response 

1. Tomcat : Web server to handle the request, it can be any server
2. Dispatcher Servlet : Hanldes the request from server & routes the request to right api request using hanalder mapping, then pass to controller layer 
3. Controller : takes the request & performs the validations of the api request, & get the data from repo and sends back to dispatcher servlet 
4. The reponse is converted to JSON/HTML using HTTPServletResponse -> sends to client 


### 2.2 The presentation Layer, DTO & Controllers

- Spring MVC provides an annotation-based programming model where `@Controller` & `@RestController` components use annotations to express request mappings, request input, exception handling & more..

The `@RestController` annotation is a shorthand for `@Controller` & `@ResponseBody` meaning all methods in the controller will return JSON/XML directly to the response body 


### 2.3 The persistence Layer & JPA Repository 

### 2.4 The service Layer, writing business logic 

### 2.5 PUT, PATCH & DELETE Mapping in spring web MVC

### 2.6 Input Validation Annotations, Creating custom Annotation for validation 

### 2.7 Exception Handling in spring Boot web MVC 

### 2.8 Transforming API response in Spring Web MVC

### 2.9 Refresher on Java 8 Lambda & Stream API

### 2.10 Spring web MVC tasks 

### 2.11 Setup Schema & Entity relationship for AirBnb Project 