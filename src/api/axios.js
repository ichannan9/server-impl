import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:8080",
  headers: { "Content-Type": "application/json" },
});

api.interceptors.request.use((config) => {
  const skipAuth =
    config.url.endsWith("/api/users/login") ||
    config.url.endsWith("/api/users/signup");
  const token = localStorage.getItem("token");
  if (token && !skipAuth) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

export default api;
