import React from 'react'
import Announcement from '../components/Announcement'
import Footer from '../components/Footer'
import Navbar from '../components/Navbar'
import UserAccount from '../components/UserAccount'


const Account = (props) => {
    return (
      <div>
        <Announcement/>
        <Navbar isAuthenticated={props.isAuthenticated} token={props.token} />
        <UserAccount token={props.token} />
        <Footer/>
      </div>
    )
  };
  
  export default Account;