# ✅ Week 1: Introduction to Spring & Spring Boot

---

## 1. What Is Spring?

Spring is a **Java framework that simplifies enterprise application development** by solving:

* Dependency Management
* Object Lifecycle Management
* Configuration Complexity
* Scalability & Testability

### ❌ Problem With Traditional Java (Tightly Coupled Code)

```java
class OrderService {
    private PaymentService paymentService = new PaymentService();
}
```

### 🔴 Issues in the Above Code

* Tight coupling
* Hard to test or mock
* No centralized object lifecycle
* Poor scalability
* Scattered object creation
* Violates SOLID principles

This approach becomes **dangerous at scale**, like in:

* Amazon Order Processing
* Instagram Feed Pipelines
* OpenAI API serving layers

---

## 2. JEE (Java Enterprise Edition) Problems

Before Spring, developers struggled with:

* Manual JDBC & ORM integration
* Heavy XML configuration
* Deployment complexity
* Repetitive boilerplate code
* Poor modularity

➡️ Spring was created to **simplify all of this**.

---

## 3. What Does Spring Provide?

Spring solves **Dependency Injection + Object Lifecycle + Modular Design**.

### Spring Ecosystem

* Spring Core (IoC, Beans)
* Spring Context
* Spring AOP
* Spring Web (MVC, WebSockets)
* Spring Data (JPA, JDBC, ORM)
* Spring Security
* Spring Kafka
* Spring Cloud
* Spring Integration
* Spring State Machine

---

## 4. History of Spring

| Year        | Event                           |
| ----------- | ------------------------------- |
| Early 2000s | Heavy J2EE, manual DI           |
| 2004        | Inversion of Control introduced |
| 2004–2017   | Maintained by VMware            |
| 2014        | Spring Boot Released            |

---

## 5. What Is Spring Boot?

> **Spring Boot = Spring Framework + Auto-Configuration + Embedded Server + Developer Tooling**

### ✅ Why Spring Boot Exists

* No XML configs
* Auto-configured dependencies
* Embedded Tomcat/Jetty
* Production-ready apps in minutes

---

## 6. Core Spring Concepts You Must Know

### ✅ Inversion of Control (IoC)

Spring **controls object creation**, not you.

---

### ✅ Dependency Injection (DI)

Types:

* Constructor Injection ✅ Preferred
* Setter Injection
* Field Injection ❌ Avoid in production

---

### ✅ Spring Beans

> A **Bean is a Java object managed by Spring IoC Container**.

```java
@Component
class PaymentService {}
```

Injected via:

```java
@Autowired
private PaymentService paymentService;
```

---

### ✅ Application Context (IoC Container)

Spring's Brain that:

* Creates Beans
* Injects Dependencies
* Manages Lifecycle
* Handles Scopes

---

### ✅ MVC Annotations

| Purpose   | Annotation        |
| --------- | ----------------- |
| API Layer | `@RestController` |
| Web Pages | `@Controller`     |
| Routing   | `@RequestMapping` |
| Services  | `@Service`        |
| DAO Layer | `@Repository`     |

---

## 7. Creating Beans Manually

```java
@Configuration
public class AppConfig {

    @Bean
    public PaymentService paymentService() {
        return new PaymentService();
    }
}
```

### ✅ Priority Order

```
@Configuration > @Component / @Service / @Controller
```

---

## 8. Bean Lifecycle

| Phase                | Description        |
| -------------------- | ------------------ |
| Creation             | Bean instantiated  |
| Dependency Injection | Dependencies wired |
| Initialization       | Post setup         |
| Usage                | Bean used          |
| Destruction          | Cleanup            |

### Lifecycle Hooks

```java
@PostConstruct
@PreDestroy
```

✅ Used heavily in:

* DB connection pools
* Kafka consumers
* Cache loaders

---

## 9. Bean Scopes

| Scope         | Use Case             |
| ------------- | -------------------- |
| `singleton`   | Default, services    |
| `prototype`   | New object each time |
| `request`     | One per HTTP request |
| `session`     | One per user         |
| `application` | Global config        |

---

## 10. Dependency Injection Example

❌ Tight Coupling

```java
class OrderService {
  private EmailService emailService = new EmailService();
}
```

✅ Loose Coupling (Constructor Injection)

```java
class OrderService {

  private final EmailService emailService;

  public OrderService(EmailService emailService){
    this.emailService = emailService;
  }
}
```

✅ Benefits:

* Immutable dependencies
* Easy Testing
* Flexible switching (Email → SMS → Push)

---

## 11. Multiple Bean Conflict Handling

If multiple beans exist:

| Strategy                 | Priority           |
| ------------------------ | ------------------ |
| Env Variable             | ✅ Highest          |
| `@ConditionalOnProperty` | ✅                  |
| `@Qualifier`             | ✅                  |
| `@Primary`               | ✅ Default fallback |

---

## 12. Spring Boot vs Spring Framework

| Feature    | Spring        | Spring Boot         |
| ---------- | ------------- | ------------------- |
| Setup      | Manual        | Auto-config         |
| Server     | External      | Embedded            |
| Config     | Heavy XML     | Zero XML            |
| Use Case   | Custom legacy | Modern apps         |
| Popularity | Medium        | ✅ Industry standard |

---

## 13. Project Setup Using Spring Initializr

* Visit: [https://start.spring.io](https://start.spring.io)
* Select:

  * Maven
  * Java
  * Spring Boot Version
  * Dependencies (Web, JPA, Security)

---

## 14. Spring Boot Project Structure

```
src/main/java    → Business Logic
src/main/resources → application.properties
src/test/java → Unit & Integration Tests
pom.xml → Dependency Manager
```

---

## 15. Real-World Production Mapping

| Concept     | Real-World Use         |
| ----------- | ---------------------- |
| Beans       | Microservices          |
| IoC         | Kubernetes Pod Control |
| DI          | Feature toggles        |
| Profiles    | Dev/Stage/Prod         |
| Auto Config | AWS Infra Boot         |

Used daily at:

* Amazon Seller APIs
* Instagram Backend
* OpenAI API Servers
* Netflix Streaming

---

## 16. What You Will Learn Next

* Auto Configuration & Internals
* Spring Application Context Flow
* Maven Build Tool
* REST API Design
* Schema Design
* Live Project: Airbnb Clone

---

# ✅ Revision Summary

* ✅ Spring removes manual object wiring
* ✅ Spring Boot removes all setup pain
* ✅ Beans + IoC = scalable architecture
* ✅ DI enables testable & modular systems
* ✅ Used in **billions of API calls daily**

---

If you want, next I can:

✅ Add **diagrams for IoC, Beans, MVC flow**
✅ Explain **Auto-Configuration Internals step-by-step**
✅ Convert this into **interview-ready Q&A format**
✅ Map this to **your Amazon production systems**


### Auto configuration, Application Context & Internal working of a Spring boot Application 

### Maven build tool 

### Tasks 

### Live coding & requirement gathering -> Schema design, Entity relationship, API's design of Airbub project