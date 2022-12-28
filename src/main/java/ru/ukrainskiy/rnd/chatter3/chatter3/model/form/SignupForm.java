package ru.ukrainskiy.rnd.chatter3.chatter3.model.form;

import java.util.Objects;

import jakarta.validation.constraints.NotBlank;

public class SignupForm {
    
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String email;


    public SignupForm() {
    }

    public SignupForm(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
 


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SignupForm)) {
            return false;
        }
        SignupForm signupForm = (SignupForm) o;
        return Objects.equals(username, signupForm.username) && Objects.equals(password, signupForm.password) && Objects.equals(email, signupForm.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, email);
    }


    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", email='" + getEmail() + "'" +
            "}";
    }


}
