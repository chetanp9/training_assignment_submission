import { useState } from 'react';
import PostList from '../component/PostList';
import PostDetail from '../component/PostDetail';



export default function PostsPage({ posts }) {
  const [selectedPost, setSelectedPost] = useState(null);
  

  if (!posts) return ( <div className="flex items-center justify-center min-h-screen">
        <div className="animate-spin rounded-full h-12 w-12 border-b-2 border-purple-600"></div>
        <span className="ml-4 text-lg text-purple-700">Loading...</span>
      </div>); 

  return (
    <>
      <div className="min-h-screen flex flex-col items-center justify-center bg-gradient-to-br from-blue-100 to-purple-200">
      <main className="bg-white rounded-xl shadow-lg p-8 flex flex-col items-center max-w-2xl w-full">
        <h1 className="text-3xl font-bold mb-6 text-center text-purple-700">Blog Posts</h1>
        {posts && posts.length > 0 ? (
          <PostList posts={posts} onSelect={setSelectedPost} />
        ) : (
          <div className="text-gray-500 text-center">No posts found.</div>
        )}
        {selectedPost && (
          <div className="fixed inset-0 bg-purple-100 bg-opacity-40 flex items-center justify-center z-50">
            <div className="bg-white rounded-lg shadow-lg p-6 max-w-lg w-full">
              <PostDetail post={selectedPost} onClose={() => setSelectedPost(null)} />
            </div>
          </div>
        )}
      </main>
    </div>
    </>
  );
}

export async function getStaticProps() {
  const res = await fetch('http://localhost:3000/api/posts');
  const posts = await res.json();

  return {
    props: {
      posts,
    },
    revalidate: 10, 
  };
}
