// rfc
import React from 'react'
import Announcement from '../components/Announcement'
import Categories from '../components/Categories'
import Footer from '../components/Footer'
import Navbar from '../components/Navbar'
import Slider from '../components/Slider'

const Home = (props) => {
  return (
    <div>
      <Announcement/>
      <Navbar isAuthenticated={props.isAuthenticated} token={props.token} />
      <Slider/>
      <Categories/>
      <Footer/>
      
    </div>
  )
};
export default Home;

