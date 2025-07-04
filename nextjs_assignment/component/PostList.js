export default function PostList({ posts, onSelect }) {
  return (
    <ul className="w-full space-y-4">
      {posts.map(post => (
        <li
          key={post.id}
          onClick={() => onSelect(post)}
          className="cursor-pointer px-6 py-4 bg-purple-100 hover:bg-purple-200 rounded-lg shadow transition font-semibold text-lg text-purple-800"
        >
          {post.title}
        </li>
      ))}
    </ul>
  );
}