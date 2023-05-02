Traveller SpringBoot Notes.txt
Spring Boot:
-------------

- open-source Java-based framework that is designed to simplify the process of building and deploying web applications.
- built on top of the popular Spring Framework
- It has set of pre-configured components and tools that make it easier to create standalone, production-ready applications
- It reduces the amount of configuration required to get a new application up and running
-  It includes an embedded web server (tomcat)
- It integrates with a wide range of third-party libraries and frameworks

-----------------------------------------------------------
@SpringBootApplication =  @Configuration + @EnableAutoConfiguration + @ComponentScan.

@Configuration: This annotation indicates that the class is a Spring configuration class, which can contain bean definitions and other configuration information.

@EnableAutoConfiguration: This annotation enables Spring Boot's auto-configuration feature, which automatically configures the application based on the dependencies and the environment.

@ComponentScan: This annotation tells Spring to scan the specified package and its sub-packages for Spring components, such as @Controller, @Service, and @Repository, and automatically register them as Spring beans.

By combining these three annotations, the @SpringBootApplication annotation provides a convenient way to configure and bootstrap a Spring Boot application.

----------------------------------------------------

@Configuration  Vs @Component

The @Configuration annotation is used to declare a class as a Spring configuration class, which defines how Spring beans are created and wired together. Configuration classes typically define one or more @Bean methods that create and configure Spring beans, as well as any necessary Spring configuration settings. These classes are used to replace XML-based configuration in Spring applications.
	@Configuration
	public class MyConfiguration {
 
  		 @Bean
   		public MyBean myBean() {
      			return new MyBean();
   		}
	}


The @Component annotation is used to declare a class as a Spring bean, without providing any specific configuration information. @Component is a general-purpose stereotype annotation that can be used with any class, and Spring will automatically detect and register it as a bean.

	@Component
	public class MyComponent {
   		 // class implementation
	}

the @Configuration annotation is used to define Spring configuration classes that provide specific configuration information, while the @Component annotation is used to declare general-purpose Spring beans that don't require any specific configuration.

____________________________________________________

SOA and Microservices:
SOA and Microservices are two different architectural styles that are used for building distributed systems. While SOA is better suited for large-scale enterprise systems, Microservices are better suited for smaller, more modular systems that require greater agility and flexibility. 

Scope: SOA is typically used for building large-scale enterprise systems, while Microservices are used for building smaller, more modular systems.

Architecture: SOA is a more monolithic architecture that relies on a centralized service registry and messaging middleware, while Microservices are a more decentralized architecture that relies on lightweight communication protocols such as REST.

Service granularity: SOA services tend to be larger and more complex, while Microservices are smaller, more focused services that are easier to develop, test, and deploy.

Deployment: SOA services are typically deployed on large, centralized servers, while Microservices can be deployed on smaller, more distributed servers or containers.

Technology: SOA is often associated with older, more established technologies such as ESBs and SOAP, while Microservices are often associated with newer, more lightweight technologies such as containers and RESTful APIs.

--------------------------------------------------
HTTP Methods

HTTP (Hypertext Transfer Protocol) defines several methods (also known as verbs) that indicate the desired action to be performed on a resource. 

POST    -- Create	--insert
GET	-- READ		--select	
PUT	-- Update	--update
DELETE  -- Delete	--delete



GET: Retrieves a resource from the server. This method is used to retrieve information from the server.

POST: Sends new data to the server to be processed. This method is used to submit data to the server, typically through a form submission.

PUT: Updates an existing resource on the server. This method is used to update an existing resource.

DELETE: Deletes a resource on the server. This method is used to delete a resource.

PATCH: Partially updates an existing resource on the server. This method is used to update a portion of an existing resource.

HEAD: Retrieves the headers of a resource from the server. This method is used to retrieve metadata about a resource.

OPTIONS: Returns the supported HTTP methods for a resource on the server. This method is used to retrieve information about the available methods for a resource.

-----------------------------------------

URL  VS   URI

URI - the identifier of a resource on the Internet, 
URL - a specific type of URI that provides the LOCATION of the resource on the Internet.

All URLs are URIs, but not all URIs are URLs.
----------------
action based Vs resource based URI

Action-based URI:

	POST /createUser
	PUT /updateUser
	DELETE /deleteUser


Resource-based URI:(prefered)

	POST /users
	PUT /users/{id}
	DELETE /users/{id}

In the action-based URI approach, the URI is based on the action being performed on the user resource, such as creating, updating, or deleting a user. 

In the resource-based URI approach, the URI is based on the user resource itself, with the specific action being performed as a HTTP method

resource-based URIs are more widely used and recommended in RESTful web services
action-based URIs are more appropriate, such as for non-resource-based actions or for compatibility with existing APIs

___________________________________________

Spring Security

Why Spring Security
1) Challenging to implement with our custom code
2) Secure web apps with minimum configuration
3) Handles common security vulnarabilities like CSRF, CORS...
   Any new vulnarbility will be patched by security experts in spring
4) We can secure our pages, API, enfore roles, methodlevel security with minimum configuration
5) Supports various standards of security to implement authentication using un and pwd, JWT token , OAuth, OpenID etc...
-----------------------------------

=> Add Security dependency  - give u a default login page - (Not for production)
     username = user
     password = generated everytime when u run the project

=> Static username password(Not for production)
      spring.security.user.name=admin
      spring.security.user.password=admin 

=> Dynamic username password
      use InMemoryUserDetailsManager(Not for production)
      use Database to store the credentials(Real time production)

Internal work flow of Spring Security:
----------------------------------------

The major building blocks of Spring Security:
• "SecurityContextHolder", to provide access to the "SecurityContext".
• "SecurityContext", to hold the "Authentication" and possibly request-specific security
information.
• "Authentication", to represent the principal in a Spring Security-specific manner.
• "GrantedAuthority", to reflect the application-wide permissions granted to a principal.
• "UserDetails", to provide the necessary information to build an Authentication object from your
application's DAOs or other source source of security data.
• "UserDetailsService, to create a "UserDetails" when passed in a String-based username
(or certificate ID or the like).

_________________________________________________________________________________

package com.deeps.sprtravelsec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SprtravelsecApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprtravelsecApplication.class, args);
	}

}

***********************

package com.deeps.sprtravelsec.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "atbl_traveller")
public class Traveller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long travellerId;
	
	@Column(nullable = false,unique = true)
	private String travellerName;
	
	@Column(nullable = false)
	private String travellerPwd;
	
	@Column(nullable = false)
	private String roles;
	
	
}


-----
package com.deeps.sprtravelsec.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "atbl_local")
public class LocalTour {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long localid;
	
	@Column(nullable = false)
	private String location;
	
	@Column(nullable = false)
	private long noofpeople;	

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="travellercode", referencedColumnName="travellerId")
	private Traveller trtourist;
}
------------
package com.deeps.sprtravelsec.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "atbl_foreign")
public class ForeignTour {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long foreignId;

	@Column(nullable = false)
	private String country;

	@Column(nullable = false)
	private long noofpeople;

	@Column(nullable = false)
	private boolean isPassportValid;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "travellercode", referencedColumnName = "travellerId")
	private Traveller trtourist;

}


*******************************
package com.deeps.sprtravelsec.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.deeps.sprtravelsec.entity.Traveller;

@Repository
public interface TravellerRepository extends CrudRepository<Traveller, Long>{
	public Traveller findByTravellerName(String travellerName);
	public Traveller findByTravellerId(Long travelcode);
}
-----------
package com.deeps.sprtravelsec.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.deeps.sprtravelsec.entity.LocalTour;

@Repository
public interface LocalTourRepository extends JpaRepository<LocalTour, Long>{

}
------------
package com.deeps.sprtravelsec.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deeps.sprtravelsec.entity.ForeignTour;
@Repository
public interface ForeignTourRepository extends JpaRepository<ForeignTour, Long>{

}


********************************

package com.deeps.sprtravelsec.service;

import java.util.List;

import com.deeps.sprtravelsec.entity.ForeignTour;
import com.deeps.sprtravelsec.entity.LocalTour;
import com.deeps.sprtravelsec.entity.Traveller;

public interface TravellerService {
	public Traveller addTraveller(Traveller traveller);
	public List<Traveller> listAllTravellers();
	public LocalTour saveLocalTourRequest(LocalTour localTour);
	public ForeignTour saveForeignTourRequest(ForeignTour foreignTour);
	
}
---------
package com.deeps.sprtravelsec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deeps.sprtravelsec.entity.ForeignTour;
import com.deeps.sprtravelsec.entity.LocalTour;
import com.deeps.sprtravelsec.entity.Traveller;
import com.deeps.sprtravelsec.repo.ForeignTourRepository;
import com.deeps.sprtravelsec.repo.LocalTourRepository;
import com.deeps.sprtravelsec.repo.TravellerRepository;

@Service
public class TravellerServiceImpl implements TravellerService {

	@Autowired
	private TravellerRepository travellerRepository;
	@Autowired
	private LocalTourRepository localTourRepository;
	@Autowired
	private ForeignTourRepository foreignTourRepository;

	@Override
	public Traveller addTraveller(Traveller traveller) {

		return travellerRepository.save(traveller);
	}

	@Override
	public List<Traveller> listAllTravellers() {

		return (List<Traveller>) travellerRepository.findAll();
	}

	@Override
	public LocalTour saveLocalTourRequest(LocalTour localTour) {

		Traveller traveller = localTour.getTrtourist();
		localTour.setTrtourist(traveller);
		return localTourRepository.save(localTour);
	}

	@Override
	public ForeignTour saveForeignTourRequest(ForeignTour foreignTour) {
		System.out.println("-----------foreign Tour -------" +foreignTour);
		Traveller traveller = foreignTour.getTrtourist();
		foreignTour.setTrtourist(traveller);
		return foreignTourRepository.save(foreignTour);
	}

}

************************************************
package com.deeps.sprtravelsec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deeps.sprtravelsec.entity.ForeignTour;
import com.deeps.sprtravelsec.entity.LocalTour;
import com.deeps.sprtravelsec.entity.Traveller;
import com.deeps.sprtravelsec.repo.TravellerRepository;
import com.deeps.sprtravelsec.service.TravellerService;

@RestController

public class TravellerRestController {
	@Autowired
	TravellerService travellerService;

	@Autowired
	TravellerRepository travellerRepository;
	
	@GetMapping("/welcome")
	public String helloAppln() {
		return "Hi Traveller";
	}

	@PostMapping("/addtraveller")	
	public Traveller addTraveller(@RequestBody Traveller traveller) {
		return travellerService.addTraveller(traveller);
	}

	@GetMapping("/listtravellers")

	public List<Traveller> listAllTravellers() {

		return travellerService.listAllTravellers();
	}

	@PreAuthorize("hasAuthority('DC')")
	@PostMapping("/requestlocaltour")
	public LocalTour saveLocalTourRequest(@RequestBody LocalTour localTour) {
		return travellerService.saveLocalTourRequest(localTour);
	}

	@PreAuthorize("hasAuthority('FC')")
	@PostMapping("/requestforeigntour")
	
	public ForeignTour saveForeignTourRequest(@RequestBody ForeignTour foreignTour) {
		System.out.println("****** From Controller Foreign ******" + foreignTour);
		return travellerService.saveForeignTourRequest(foreignTour);
	}

	@GetMapping("/listtour")
	
	public String listTour() {
		return "Hi Welcome to Chennai";
	}
	/*
	 * @PostMapping("/error") public String fnError() { return "Error"; }
	 */

	@GetMapping("/login")	
	public ResponseEntity<Traveller> loginrest(@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password) {
		System.out.println("*******This is a login rest controller ***********");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Traveller traveller = travellerRepository.findByTravellerName(auth.getName());
		System.out.println("After Login__________________"
				+ "send back to Angular or postman as response__________________" + traveller);
		return ResponseEntity.ok(traveller);
	}

}

**************************************
package com.deeps.sprtravelsec.config;

import java.util.Arrays;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity(debug = true)
@EnableMethodSecurity
@SuppressWarnings("unused")
public class TravellerSecurityConfig {

	@Autowired
	TravellerAuthProvider travellerAuthProvider;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests().requestMatchers("/welcome/**").permitAll()
		.requestMatchers("/login/**").permitAll()
				.requestMatchers("/listtour/**").permitAll()
				.requestMatchers("/v2/api-docs",
						"/v3/api-docs/**",
						"/swagger-resources/configuration/ui",  
						"/swagger-resources/configuration/security", 
						"/webjars/**",
						"/swagger-ui.html","/swagger-ui/**").permitAll()
				/*
				 *  Line 44 is very important
				 *  http://localhost:8183/swagger-ui/index.html
				 */			
				
				.requestMatchers("/requestlocaltour/**").authenticated()
				.requestMatchers("/requestforeigntour/**").authenticated()
				.requestMatchers("/addtraveller/**").authenticated()				
				.requestMatchers("/listtravellers/**").permitAll().and().httpBasic();
		http.cors();
		http.csrf().disable(); // 403forbidden error
		return http.build();
	}
	
	@Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*"); // this allows all origin
        config.addAllowedHeader("*"); // this allows all headers
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        config.setExposedHeaders(Arrays.asList("Authorization"));
        config.setMaxAge((long) 3600000);
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

	@Bean
	public AuthenticationManager authManager(HttpSecurity http) throws Exception {

		AuthenticationManagerBuilder authenticationManagerBuilder = http
				.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.authenticationProvider(travellerAuthProvider);
		return authenticationManagerBuilder.build();
	}

}
------------
package com.deeps.sprtravelsec.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.deeps.sprtravelsec.entity.Traveller;
import com.deeps.sprtravelsec.repo.TravellerRepository;

@Component
public class TravellerAuthProvider implements AuthenticationProvider {

	@Autowired
	TravellerRepository travellerRepository;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		Traveller traveller = travellerRepository.findByTravellerName(username);
		/*
		 * @Column(nullable = false,unique=true) private String travellername;
		 */
		System.out.println("Found Travel object" + traveller);
		if (traveller == null) {
			throw new StackOverflowError("No user got registered");
		} else if (pwd.equals(traveller.getTravellerPwd())) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(traveller.getRoles()));
			return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
		} else {
			System.out.println("I am a bad credentails");
			throw new StackOverflowError("Invalid Password");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {

		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
*******************************************************************
server.port=8183

# Oracle database properties
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:lotus
spring.datasource.username=system
spring.datasource.password=Manager1

# Hibernate properties

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.OracleDialect
spring.jpa.hibernate.ddl-auto=update


# Logging properties

logging.level.org.hibernate.SQL=DEBUG
logging.level.org.springframework.security=DEBUG
logging.level.org.springframework.web.FilterChainProxy=DEBUG;

server.error.include-stacktrace=always

#spring.security.user.name=admin
#spring.security.user.password=admin

*******************************************************************
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.0.6</version>
		<relativePath /> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.deeps</groupId>
	<artifactId>sprtravelsec</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>sprtravelsec</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>17</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jdbc</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>com.oracle.database.jdbc</groupId>
			<artifactId>ojdbc8</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>

		<!--Swagger Dependencies -->
		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.0.4</version>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>

	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-surefire-plugin</artifactId>
			</plugin>

		</plugins>
	</build>

</project>


***************************************************************************

http://localhost:8183/swagger-ui/index.html

https://start.spring.io/

https://bcrypt-generator.com/

https://www.base64encode.org/












