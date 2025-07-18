import { useState, useEffect, useContext } from "react";
import { useParams, useNavigate, Link } from "react-router-dom";
import { fetchPost, deletePost } from "../api";
import { AuthContext } from "../contexts/AuthContext";

export default function PostDetail() {
  const { id } = useParams();
  const navigate = useNavigate();
  const { user } = useContext(AuthContext);
  const [post, setPost] = useState(null);

  useEffect(() => {
    fetchPost(id)
      .then((res) => setPost(res.data))
      .catch((err) => console.error(err));
  }, [id]);

  if (!post) return <p>로딩 중…</p>;

  const isAuthor = user?.id === post.memberId;

  const handleDelete = async () => {
    if (window.confirm("정말 삭제하시겠습니까?")) {
      await deletePost(id);
      navigate("/");
    }
  };

  return (
    <div>
      <h2>{post.title}</h2>
      <p>{post.content}</p>
      <p>
        작성자: {post.memberId} | 작성일:{" "}
        {new Date(post.createdAt).toLocaleString()}
      </p>
      {isAuthor && (
        <>
          <Link to={`/posts/${id}/edit`}>
            <button>수정</button>
          </Link>
          <button onClick={handleDelete}>삭제</button>
        </>
      )}
      <button onClick={() => navigate(-1)}>뒤로</button>
    </div>
  );
}
