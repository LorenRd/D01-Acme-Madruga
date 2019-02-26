package forms;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

import security.Authority;

public class AdministratorForm {

	// --- AdministratorAtributes ---------------------------------------------
	private int idAdministrator;

	public int getIdAdministrator() {
		return this.idAdministrator;
	}

	public void setIdAdministrator(final int idAdministrator) {
		this.idAdministrator = idAdministrator;
	}

	private String name;
	private String middleName;
	private String surname;
	private String photo;
	private String email;
	private String phone;
	private String address;

	// --- Getters y Setters ---------------------------------------

	@NotBlank
	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@NotBlank
	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(final String middleName) {
		this.middleName = middleName;
	}

	@NotBlank
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

	@URL
	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(final String photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(final String phone) {
		this.phone = phone;
	}

	@NotBlank
	public String getAddress() {
		return this.address;
	}

	public void setAddress(final String address) {
		this.address = address;
	}

	// --- UserAccountAtributes ---------------------------------------

	private String username;
	private String password;
	private Boolean legalConsentment;

	private Authority authority;

	// --- Getters y Setters ---------------------------------------

	@Size(min = 5, max = 32)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	@Size(min = 5, max = 32)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	// --- Others -------------------------------------------------

	private String passwordChecker;

	public String getPasswordChecker() {
		return this.passwordChecker;
	}

	public void setPasswordChecker(final String passwordChecker) {
		this.passwordChecker = passwordChecker;
	}

	public Boolean getLegalConsentment() {
		return this.legalConsentment;
	}

	public void setLegalConsentment(final Boolean legalConsentment) {
		this.legalConsentment = legalConsentment;
	}

	public Authority getAuthority() {
		return this.authority;
	}

	public void setAuthority(final Authority authority) {
		this.authority = authority;
	}
}
