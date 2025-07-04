# Next.js Blog Project

A modern blog app built with [Next.js](https://nextjs.org), [Tailwind CSS](https://tailwindcss.com/), and [Jest](https://jestjs.io/).

---

## 🚀 Getting Started

1. **Install dependencies:**
   ```bash
   npm install
   ```

2. **Run the development server:**
   ```bash
   npm run dev
   ```
   Open [http://localhost:3000](http://localhost:3000) in your browser.

---

## 🗂️ Project Structure

```
nextjs_assignment/
├── component/
│   ├── PostDetail.js
│   └── PostList.js
├── pages/
│   ├── api/
│   │   └── posts.js
│   ├── index.js
│   └── posts.js
├── styles/
│   └── globals.css
├── tailwind.config.js
├── package.json
└── ...
```

---

## 📝 Features

- Blog posts API (`/api/posts`)
- Home page with navigation to blog
- Blog list with clickable post titles
- Modal post detail view
- Responsive, modern UI with Tailwind CSS
- Unit testing with Jest and Testing Library

---

## 🛠️ API Example

**GET `/api/posts`**

Returns a list of blog posts:
```json
[
  {
    "id": 1,
    "title": "Understanding JavaScript Closures",
    "content": "A closure is the combination of a function and the lexical environment within which that function was declared..."
  },
  ...
]
```

---

## 🎨 Styling

- Tailwind CSS is used for all styling.
- Utility classes are applied directly in component JSX.

---

## 🧪 Testing

- Run tests with:
  ```bash
  npm test
  ```
- Uses Jest and Testing Library for React component tests.

## Routes:-
- API - /api/posts - get all posts 
- / - base route for home page
- /posts - route for blogs main page

### Home Page
![Home Page](./public/Screenshot%20(1119).png)

### Blog Posts Page
![Posts Page](./public/Screenshot%20(1120).png)

### Post Detail Modal
![Posts Page](./public/Screenshot%20(1121).png)


### API RESPONSE
![Api response](./public/Screenshot%20(1122).png)
