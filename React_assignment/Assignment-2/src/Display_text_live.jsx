//Q2.An Input field that displays the typed text live below it
//This component renders a controlled input field and displays the entered text below it in real-time.

import { useState } from "react";

function Display_text(){
    let [text,setText]=useState("");
    return (
        <>
        <input type="text" id="inp_text" value={text} onChange={e=>setText(e.target.value)}placeholder="enter your text"/>
        <p>{text}</p>
        </>
    )
}

export default Display_text;