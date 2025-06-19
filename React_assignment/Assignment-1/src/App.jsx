import { useState } from 'react'
import './App.css'
import Usercard from './UserCard'

function App() {
 let data={
  name:"chetan pal",
  email:"chetan@gmail.com",
  age:22
 }

  return (
    <>
      <Usercard user={data}></Usercard>
    </>
  )
}

export default App
