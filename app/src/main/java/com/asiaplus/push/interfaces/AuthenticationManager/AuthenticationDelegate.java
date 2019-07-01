package com.asiaplus.push.interfaces.AuthenticationManager;

public interface AuthenticationDelegate {
    void didLoginSuccessfully();
    void didReceiveErrorOnLogin();
}
