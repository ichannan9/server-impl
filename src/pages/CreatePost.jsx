import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axios";

export default function CreatePost() {
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      // 테스트: memberId는 백엔드에서 JWT로 꺼낼 때 임시로 1로 지정
      await api.post("/api/posts", {
        memberId: 1,
        title,
        content,
      });
      navigate("/posts");
    } catch {
      alert("게시글 작성에 실패했습니다.");
    }
  };

  return (
    <form onSubmit={handleSubmit} style={{ padding: 16 }}>
      <h2>새 게시글 작성</h2>
      <div>
        <label>제목:</label>
        <input
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          required
        />
      </div>
      <div>
        <label>내용:</label>
        <textarea
          value={content}
          onChange={(e) => setContent(e.target.value)}
          required
          rows={5}
          style={{ width: "100%" }}
        />
      </div>
      <button type="submit" style={{ marginTop: 8 }}>
        등록
      </button>
    </form>
  );
}
