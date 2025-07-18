import { useState, useEffect, useContext } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { fetchPost, updatePost } from "../api";
import { AuthContext } from "../contexts/AuthContext";

export default function EditPost() {
  const { id } = useParams();
  const navigate = useNavigate();
  const { user } = useContext(AuthContext);
  const [form, setForm] = useState({ title: "", content: "" });
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchPost(id)
      .then((res) => {
        const p = res.data;
        if (user?.id !== p.memberId) {
          alert("본인 글만 수정할 수 있습니다.");
          navigate(-1);
          return;
        }
        setForm({ title: p.title, content: p.content });
        setLoading(false);
      })
      .catch((err) => console.error(err));
  }, [id, user, navigate]);

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await updatePost(id, form);
      navigate(`/posts/${id}`);
    } catch (err) {
      alert("수정 실패: " + err.message);
    }
  };

  if (loading) return <p>로딩 중…</p>;

  return (
    <form onSubmit={handleSubmit}>
      <h2>게시글 수정</h2>
      <input
        name="title"
        placeholder="제목"
        value={form.title}
        onChange={handleChange}
      />
      <textarea
        name="content"
        placeholder="내용"
        rows={10}
        value={form.content}
        onChange={handleChange}
      />
      <button type="submit">저장</button>
      <button type="button" onClick={() => navigate(-1)}>
        취소
      </button>
    </form>
  );
}
