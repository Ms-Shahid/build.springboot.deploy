
## Week 1 : Introduction to Spring & Spring-boot
-------
### Introduction to Spring Framework 

Spring & SpringBoot



```
    class orderService{
        private PaymentService paymentService = new PaymentService();
    }
```


The problems with this code



No proper readability, interms of code uniqueness
Tigthly coupled system,
Hard to test / mock
Scattered object creation -> Managing the objects life cycles, injecting objects. 


----



#### JEE ( Java Entriprice Edition )

Insufficient JDBC(Java db connection ) & ORM (object relationship mapping) Integration 
scattered configuration 
deployment configuration & complexity 
Repetative coding or configurations 
----





Spring Framework


Spring Framework is a framework that solves the problem of dependency injection, where multiple instance of the objects are scattered across the application, Spring provides various frameworks, that can be used to solve the high scable, robuost problem.





There are many framework / ecosystem that spring framework provides



Spring Core : Spring core, spring Context, expression language, Beans
Spring Data integration : JDBC, ORM,
Spring AOP ( Aspect Objected programming ) :
Spring Web : Servelet, Web sockets


Along with Spring, -> SpringBoot


Spring Framework
Spring Boot
Spring cloud
Spring data
Spring Authentication
Spring Kafka
Spring security
Spring statemachine
Spring Integration


----------

History

- Early 2000, with JEE developers had to manually inject the -   
- dependencies & objects, leading to high maintaince ->
- 2004, Inversion of Control ( IOC ) -> core concept behind the Spring framework,
- 2004 - 2017 : VMware took the maintaince
- 2014 : Springboot released

------


`Spring Boot -> Spring framework + Auto configuration + Conversion + Tools`

Before proceeding with Springboot, understanding the Spring framework essentials & internals are crucial 

- Inversion of control (IOC) 
- Dependency Injection 
  - `@component`, `@Autowired`, `constrcutor-injection`, `setting-injection`
- Bean management : `@configuration`, `@Bean`
- Spring context ( Application Context )
- Spring MVC ( model view controller ) : `@controller`, `@RestController`, `@RequestMapping`


### Setting up A Spring Boot project

- IDE -> `start.io.spring` to create the spring boot project 
- File strcuture in Springboot project 
    - src/../mainApplication : contains the main file or business logic files 
    - src/resources : contains static content, templates & `application.properties` file for storing the important properties of the project like debugging, db's connection, ...
   - test/../testApplication : contains the testing files, unit, integration, functional 
  - pom.xml : Project object Model ( file for handling dependencies )


### Beans in Spring Framework

Beans -> A Java object(POJO's) managed by Spring 
These Beans are instantiated by Spring, Configured by Spring & managed throughout its lifecyle by spring 

> Beans form the backbone of a spring application & are the core bulding blocks that are wired together to create the application 

Spring bean will be injected via Dependency injection(DI), when we want to create the objects that should be managed by Spring.

For achiveing this, at the class( The object/instace needs to be created ) level should be annotated by `@Component`, the control of creating, managing, or even destroying the object life cycle will be take care by Spring bean.

And for making sure that, the `@Component` is been injected rightly, we have to describe it with `@AutoWired` during class instance calling.


-----

IOC Container 
. . 
- The Bean factory 
- Its a store which manages the beans, all the beans in a pool of beans 
- When the instance creation/depdency call comes, ( with `@Component`/`@Service`/`@Controller`/`@RestController` & `@AutoWired` or setter/constructor injection), its going to create the bean & with help of Depdency injection it will inject the depdency of bean to right class. 
- All these annotation`@Component`/`@Service`/`@Controller`/`@RestController` are sterotype meaning they are extending from same class 
- And with `@Bean`, we can manually create the Bean for the classes by injecting them
```
@Configuration
public class AppConfig {

    @Bean
    PaymentService paymentService(){
        return new PaymentService();
    }
}
```
- Here, the class, is annotated with `@Configuration`, which describes that, all the managment of `beans` will be created by this class 
- `@Bean`, tells to inject the depdency of paymentService manually using contructor dependency. 
- Priority = `Configuration` class > `@Component`/`@Service`/`@Controller`/`@RestController`

> NOTE : IOC container or Spring's(IOC) container or Application context all are same. 

##### Bean Life Cycle 

1. Bean creation : The spring conatiner ( Application context ) scans all the `@Componenet` & describes all the beans that needs to be created 
2. Dependency injection phase : Once the beans are created, these are injected to the class via the constructor or setter injection
3. Bean Initialization phase : It initialise all the dependency of the class & run that bean or code or triggers that class with all the required beans 
4. Bean is Used : Before the bean is been used, it runs a hook `postCreate` to trigger or check if the bean is used. 
5. Bean is destroyed : Once the dependency is been statisfied, the bean will be destroyed. 

These life cycle will be taken care by Spring IOC container or Application Context. 

** Bean Life Cyle methods **

1. `@PostConstruct` : This method is triggered when the bean is initialized & before its used 
2. `@PreDestroy` : This is called right before, bean is destoryed. 


** Bean Scopes **
|** |**|
|Scope| use-case |
|Singleton| only one instance of bean per app , useful for services, repositories |
|prototype(`@scope('prototype')`)| create new instance every time, useful for stateful objections, request data |
|request| one bean per HTTP request, useful for web apps only |
|application | one per ServerletContext, for Global config |
|session | one per user session, for shopping cart |


### Dependency Injection in Spring framework 



### Spring boot vs Spring Framework

### Auto configuration, Application Context & Internal working of a Spring boot Application 

### Maven build tool 

### Tasks 

### Live coding & requirement gathering -> Schema design, Entity relationship, API's design of Airbub project