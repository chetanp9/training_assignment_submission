
import { useRouter } from "next/router";

export default function Home() {
  const router=useRouter();
  let gotopost=()=>{
    router.push('/posts');
  };
  return (
    <div className="min-h-screen flex flex-col items-center justify-center bg-gradient-to-br from-blue-100 to-purple-200">
      <div className="bg-white rounded-xl shadow-lg p-8 flex flex-col items-center">
        <h1 className="text-4xl font-bold mb-6 text-purple-700">Life is Enjoy</h1>
        <button
          onClick={gotopost}
          className="px-6 py-3 bg-purple-600 text-white rounded-lg shadow hover:bg-purple-700 transition font-semibold text-lg"
        >
          Go to Blogs
        </button>
      </div>
    </div>
  );
}
