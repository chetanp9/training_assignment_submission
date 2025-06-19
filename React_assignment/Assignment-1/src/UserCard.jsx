// usercard component for rendering some user info and pass some user info to userdetails as prop rendering

import UserDetails from "./UserDetails";
function Usercard({user}){
    return(
      <>
      <div id="usercard">
        <h2>Assignment-1</h2>
      <h2>{user.name}</h2>
      <UserDetails email={user.email} age={user.age}></UserDetails>
      </div>
      </>  
    );
}
export default Usercard;