package com.springsecurity.secureapp.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.annotations.NaturalId;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "user")
public class User {
 
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  @NotBlank
	  @Size(max = 40)
	  private String firstname;
      
	  @NotBlank
	  @Size(max = 40)
	  private String lastname;
	  
	  @NotBlank
	  @Size(max = 15)
	  private String username;

	  @NaturalId
	  @Size(max = 40)
	  @Email
	  private String email;

	  @NotBlank
	  @Size(max = 100)
	  private String password;
}
