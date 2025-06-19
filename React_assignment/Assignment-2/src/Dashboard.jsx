// this component demonstrates composition by rendering counter and toggele visibility component

import Counter from "./Counter";
import Toggle_visibility from "./VisibilityToggle";
function Dashboard(){
    return (
        <>
        <Counter></Counter>,
        <br />
        <Toggle_visibility></Toggle_visibility>
        </>
    );
}

export default Dashboard;