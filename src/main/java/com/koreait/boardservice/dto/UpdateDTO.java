package com.koreait.boardservice.dto;

public class UpdateDTO {
    private String password;
    private String email;

    public UpdateDTO() {}
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
