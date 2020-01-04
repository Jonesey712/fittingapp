package com.monique.models.forms;

import javax.validation.constraints.NotNull;

public class RegisterForm extends LoginForm{

    @NotNull(message = "Passwords to not match")
    private String verifyPassword;

    public RegisterForm(){

    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
        checkPasswordForRegistration();
    }


    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPasswordForRegistration();
    }

    private void checkPasswordForRegistration() {
        if (!getPassword().equals(verifyPassword)) {
            verifyPassword = null;
        }
    }
}
