package br.com.rhonline.security.web.dto;

import javax.validation.constraints.AssertTrue;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.rhonline.security.constraint.FieldMatch;

@FieldMatch.List({
    @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match"),
    @FieldMatch(first = "email", second = "confirmEmail", message = "The email fields must match")
})
public class UserRegistrationDto {
	@NotEmpty(message = "Campo nome não pode estar vazio.")
    private String firstName;

    @NotEmpty(message = "Campo sobrenome não pode estar vazio.")
    private String lastName;

    @NotEmpty(message = "informe uma senha.")
    private String password;

    @NotEmpty(message = "confirme a sua senha.")
    private String confirmPassword;

    @Email
    @NotEmpty(message = "O email deve ser informado.")
    private String email;

    @Email
    @NotEmpty(message = "Confirme seu email.")
    private String confirmEmail;

    @AssertTrue(message = "Leia e aceite o termo e condições.")
    private Boolean terms;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }

    public Boolean getTerms() {
        return terms;
    }

    public void setTerms(Boolean terms) {
        this.terms = terms;
    }
}
