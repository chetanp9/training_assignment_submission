//A Visibility toggle for showing/hiding a paragraph
// component for toggle visibility , This component renders a button that toggles the visibility of a child component (Display_text).
// When the button is clicked, it shows or hides the Display_text component based on the current state.

import { useState } from "react";
import Display_text from "./Display_text_live";
function Toggle_visibility(){
  let [visible,setVisible]= useState(false);
  
  const setVisibility=()=>{
  setVisible(visible=>!visible)
  }
  return (
    <>
    <button id="btn" onClick={setVisibility}>{visible?'hide':'show'}Text</button>
    <br />
    {visible&& <Display_text></Display_text>}
    </>
  );
}

export default Toggle_visibility;