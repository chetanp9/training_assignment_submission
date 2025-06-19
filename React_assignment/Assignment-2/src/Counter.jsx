//A Counter with Increment and Decrement buttons

import { useState } from "react"

function Counter(){
      let [counter,setCounter] =useState(0)
      let addcounter=()=>{
        setCounter(counter+1)
      }
      let subcounter=()=>{
        setCounter(counter-1)
      }
       return (
    <>
      <h1>Assignment-2</h1>
      <div id="count">Counter Value: {counter<0?"value can't go below zero":counter}</div>
      <button id="btn" onClick={addcounter}>Add</button>
      <br />
      <button id="btn"  onClick={subcounter}>Substract</button>
    </>
  )
}

export default Counter;
