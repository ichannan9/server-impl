package com.koreait.boardservice.dto;

public class SignupDTO {
    private String username;
    private String password;
    private String email;

    public SignupDTO() {}
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
