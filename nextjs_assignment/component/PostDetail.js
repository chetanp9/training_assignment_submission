export default function PostDetail({ post, onClose }) {
  return (
    <div className="flex flex-col items-center  rounded-lg p-6">
      <h2 className="text-2xl font-bold mb-2 text-purple-700">{post.title}</h2>
      <p className="mb-4 text-gray-700">{post.content}</p>
      <button
        onClick={onClose}
        className="px-4 py-2 bg-purple-600 text-white rounded-lg shadow hover:bg-purple-700 transition font-semibold"
      >
        Close
      </button>
    </div>
  )
} 