package com.example.ahmed.qusat.view;

import com.example.ahmed.qusat.model.User;

public interface LoginView {
    void OpenMain(String token);
    void WaitingEmail();
    void ErrorMessage();
}
