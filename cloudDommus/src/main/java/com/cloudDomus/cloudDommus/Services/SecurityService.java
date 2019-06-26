package com.cloudDomus.cloudDommus.Services;


public interface SecurityService {
    String findLoggedInEmail();

    void autoLogin(String email, String password);
}
