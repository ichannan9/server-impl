import React, { useEffect, useState } from "react";
import api from "../api/axios";

export default function PostList() {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    api
      .get("/api/posts")
      .then((res) => setPosts(res.data))
      .catch(console.error);
  }, []);

  return (
    <div style={{ padding: 16 }}>
      <h1>게시글 목록</h1>
      {posts.map((post) => (
        <div
          key={post.id}
          style={{ borderBottom: "1px solid #ddd", margin: "16px 0" }}
        >
          <h3>{post.title}</h3>
          <p>{post.content}</p>
          <small>{new Date(post.createdAt).toLocaleString()}</small>
        </div>
      ))}
    </div>
  );
}
