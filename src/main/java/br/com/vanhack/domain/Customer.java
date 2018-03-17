package br.com.vanhack.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.vanhack.controller.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = Customer.ENTITY_NAME, schema = Customer.SCHEMA_NAME)
@NamedQueries({
		@NamedQuery(name = Customer.FIND_USER, query = " SELECT c FROM Customer c WHERE c.email = :email AND c.password = :password "), })

public class Customer implements Serializable {

	private static final long serialVersionUID = 4266773532706469086L;

	public static final String ENTITY_NAME = "CUSTOMER";
	public static final String SCHEMA_NAME = "public";

	public static final String FIND_USER = "Customer.find";

	@Id
	@Column(name = "ID", nullable = false, unique = true)
	private Integer id;

	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "DATE_CREATION", columnDefinition = "DATE")
	private LocalDate dateCreation;

	@Column(name = "PASSWORD")
	private String password;

	@JsonIgnore
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Order> orders;

	public Customer(UserDTO user) {
		this.email = user.getEmail();
		this.password = encondePassword(user.getPassword());
	}

	private String encondePassword(String pass) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(pass);
		return encodedPassword;
	}

}
