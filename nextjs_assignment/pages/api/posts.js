const posts = [
  {
    "id": 1,
    "title": "Understanding JavaScript Closures",
    "content": "A closure is the combination of a function and the lexical environment within which that function was declared. Closures allow JavaScript functions to access variables from an enclosing scope, even after that scope has closed. This is useful for creating private data or functions with persistent state."
  },
  {
    "id": 2,
    "title": "Getting Started with React",
    "content": "React is a popular JavaScript library for building user interfaces. It uses a component-based architecture and a virtual DOM to efficiently update the UI when data changes. To get started with React, install Node.js, create a new project with Create React App, and build your first components."
  },
  {
    "id": 3,
    "title": "A Guide to CSS Flexbox",
    "content": "Flexbox is a CSS layout module that makes it easier to design flexible and responsive layout structures without using floats or positioning. With properties like justify-content, align-items, and flex-direction, you can align and distribute space among items in a container."
  },
  {
    "id": 4,
    "title": "Introduction to Next.js",
    "content": "Next.js is a React framework for building fast, production-ready web applications. It supports server-side rendering, static site generation, API routes, and more. To start with Next.js, use `npx create-next-app` and create your first pages in the pages directory."
  },
  {
    "id": 5,
    "title": "Understanding RESTful APIs",
    "content": "A RESTful API is an architectural style for building web services that use HTTP methods like GET, POST, PUT, and DELETE. REST APIs are stateless and provide a standardized way to create, read, update, and delete resources. Common response formats include JSON and XML."
  }
];

export default function handler(req, res) {
  if (req.method=='GET'){
  res.status(200).json(posts);
  }
  else{
    res.status(404).json({"error":"invalid method"});
  }
}
