import React from 'react'
import styled from "styled-components";
import Announcement from "../components/Announcement";
import Footer from "../components/Footer";
import Navbar from "../components/Navbar";
import Product from "../components/Product";
import { useLocation } from 'react-router-dom';
import { useEffect, useState } from "react";

const Container = styled.div``;
const Title = styled.h1`
  margin: 20px;
`

const ProductList = (props) => {
  const location = useLocation();
  const item = location.state.item;
  const [products, setProducts] = useState([]);

  const handleFetchData = async () => {
    const response = await 
      fetch("/api/v1/product/findByCategoryId", {
        method: "POST",
        headers: {'Content-type': 'application/json'},
        body: JSON.stringify ({
          categoryid: item.id 
        })
      });
    const data = await response.json();
    setProducts(data)
  }

  useEffect(() => {
      handleFetchData();
  },[])

  return (
    <Container>
        <Navbar isAuthenticated={props.isAuthenticated} token={props.token} />
        <Announcement/>
        <Title>{item.title}</Title>
        <Product items={products} key={item.id}/>
        <Footer/>
    </Container>
  )
};

export default ProductList;