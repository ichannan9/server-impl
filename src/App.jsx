import React from "react";
import { Routes, Route, Navigate, Link } from "react-router-dom";
import { useAuth } from "./contexts/AuthContext";

import Login from "./pages/Login";
import Signup from "./pages/Signup";
import PostList from "./pages/PostList";
import CreatePost from "./pages/CreatePost";

export default function App() {
  const { token, username, logout } = useAuth();

  return (
    <div>
      <nav style={{ padding: 16, borderBottom: "1px solid #ccc" }}>
        <Link to="/posts" style={{ marginRight: 8 }}>
          글목록
        </Link>
        {token ? (
          <>
            <span style={{ margin: "0 8px" }}>안녕하세요, {username}님</span>
            <button onClick={logout} style={{ marginRight: 8 }}>
              로그아웃
            </button>
            <Link to="/create">새 글쓰기</Link>
          </>
        ) : (
          <>
            <Link to="/login" style={{ marginRight: 8 }}>
              로그인
            </Link>
            <Link to="/signup">회원가입</Link>
          </>
        )}
      </nav>

      <Routes>
        <Route path="/" element={<Navigate to="/posts" />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
        <Route path="/posts" element={<PostList />} />
        <Route
          path="/create"
          element={token ? <CreatePost /> : <Navigate to="/login" />}
        />
      </Routes>
    </div>
  );
}
