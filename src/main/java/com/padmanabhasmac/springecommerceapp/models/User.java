package com.padmanabhasmac.springecommerceapp.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {

	@Id
	private String id;

	@NotEmpty
	private String firstName;

	private String lastName;

	@NotEmpty
	@Indexed(unique = true)
	@Email(message = "{errors.invalid_email}")
	private String emailId;

	@NotEmpty
	private String password;

	@DBRef(lazy = true)
	private List<Role> roles;
}
