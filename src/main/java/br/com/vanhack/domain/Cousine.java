package br.com.vanhack.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = Cousine.ENTITY_NAME, schema = Cousine.SCHEMA_NAME)
public class Cousine implements Serializable {

	private static final long serialVersionUID = -4511042253109807009L;

	public static final String ENTITY_NAME = "COUSINE";
	public static final String SCHEMA_NAME = "public";

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "NAME", nullable = false, length = 100)
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "cousine", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Store> stores;

}
