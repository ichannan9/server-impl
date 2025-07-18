import React, { createContext, useState, useContext } from "react";
import api from "../api/axios";

const AuthContext = createContext();
export const useAuth = () => useContext(AuthContext);

export function AuthProvider({ children }) {
  const [token, setToken] = useState(localStorage.getItem("token"));
  const [username, setUsername] = useState(localStorage.getItem("username"));

  const login = async (username, password) => {
    const res = await api.post("/api/users/login", { username, password });
    const token = res.data.token;
    localStorage.setItem("token", token);
    localStorage.setItem("username", username);
    setToken(token);
    setUsername(username);
  };

  const signup = async (username, password) => {
    await api.post("/api/users/signup", { username, password, role: "USER" });
  };

  const logout = () => {
    localStorage.removeItem("token");
    localStorage.removeItem("username");
    setToken(null);
    setUsername(null);
  };

  return (
    <AuthContext.Provider value={{ token, username, login, signup, logout }}>
      {children}
    </AuthContext.Provider>
  );
}
