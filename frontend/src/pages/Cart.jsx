import React from 'react'
import styled from "styled-components";
import Announcement from "../components/Announcement";
import Footer from "../components/Footer";
import { useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import Navbar from "../components/Navbar";

const Container = styled.div``;

const Wrapper = styled.div`
  padding: 20px;
`;

const Title = styled.h1`
  font-weight: 300;
  text-align: center;
`;

const Top = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 20px;
`;

const TopButton = styled.button`
  padding: 10px;
  font-weight: 600;
  cursor: pointer;
  border: ${(props) => props.type === "filled" && "none"};
  background-color: ${(props) =>
    props.type === "filled" ? "black" : "transparent"};
  color: ${(props) => props.type === "filled" && "white"};
`;

const TopTexts = styled.div`
`;
const TopText = styled.span`
  text-decoration: underline;
  cursor: pointer;
  margin: 0px 10px;
`;

const Bottom = styled.div`
  display: flex;
  justify-content: space-between;
`;

const Info = styled.div`
  flex: 3;
`;

const Product = styled.div`
  display: flex;
  justify-content: space-between;
`;

const ProductDetail = styled.div`
  flex: 2;
  display: flex;
`;

const Image = styled.img`
  width: 200px;
`;

const Details = styled.div`
  padding: 20px;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
`;

const ProductName = styled.span``;

const PriceDetail = styled.div`
  flex: 1;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`;

const ProductAmountContainer = styled.div`
  display: flex;
  align-items: center;
  margin-bottom: 20px;
`;

const ProductAmount = styled.div`
  font-size: 24px;
  margin: 5px;
`;

const ProductPrice = styled.div`
  font-size: 30px;
  font-weight: 200;
`;

const Summary = styled.div`
  flex: 1;
  border: 0.5px solid lightgray;
  border-radius: 10px;
  padding: 20px;
  height: 50vh;
`;

const SummaryTitle = styled.h1`
  font-weight: 200;
`;

const SummaryItem = styled.div`
  margin: 30px 0px;
  display: flex;
  justify-content: space-between;
  font-weight: ${(props) => props.type === "total" && "500"};
  font-size: ${(props) => props.type === "total" && "24px"};
`;

const SummaryItemText = styled.span``;

const SummaryItemPrice = styled.span``;

const Button = styled.button`
  width: 100%;
  padding: 10px;
  background-color: black;
  color: white;
  font-weight: 600;
`;

const Cart = (props) => {
  const navigate = useNavigate();
  const [products, setProducts] = useState([]);
  const [subtotal, setSubtotal] = useState(0);
  const [shipping, setShipping] = useState(3500);
  const [shippingdiscount, setShippingdiscount] = useState(0);
  const [total, setTotal] = useState(0);

  const handleFetchData = () => {
    fetch("/api/v1/cart/mycart", {
      method: "POST",
      headers: {
        'Content-type': 'application/json',
        'Authorization': 'Bearer ' + props.token
      },
      body: JSON.stringify ({
        token: props.token
    })
    })
    .then(res=>res.json())
    .then(res => {
      console.log("handle");
      console.log(res)
      setProducts(res)
      console.log(products)
      res.map((d) => {
        console.log(d)
        console.log(subtotal)
        setSubtotal(subtotal+(d.price*d.count))
      })
      if (subtotal > 50000) {
        setShipping(0)
        setShippingdiscount(3500)
      }
      console.log("total")
      console.log(total)
      setTotal(subtotal+shipping)
      console.log(total)
    })
    .then( () => {
      console.log("then")
      console.log(products)
    })
  }

  useEffect(() => {
      handleFetchData();
  },[])
 
  const checkout = (e) => {
    e.preventDefault()
    console.log(products)
    var temp = []
    products.map((p)=> {
      temp.push({
        "count": p.count,
        "productid": p.productid,
      })
    })
    console.log("temp : ")
    console.log(temp)
    fetch("/api/v1/cart/placeorder", {
      method: "POST",
      headers: {
        'Content-type': 'application/json',
        'Authorization': 'Bearer ' + props.token
      },
      body: JSON.stringify ({
        cartorder: temp,
        token: props.token
    })
    })
    .then(res => {
        alert("주문이 완료되었습니다!")
        navigate("/")
    })
    .catch(err=> { 
      alert("주문이 되지 않았습니다. 다시 시도해주세요")
    });

  }
 
  return (
    <Container>
      <Navbar isAuthenticated={props.isAuthenticated} token={props.token} />
      <Announcement />
      <Wrapper>
        <Title>YOUR BAG</Title>
        <Top>
          <TopButton onClick={() => navigate("/")} >CONTINUE SHOPPING</TopButton>
          <TopTexts>
            <TopText>Shopping Bag({products.length})</TopText>
          </TopTexts>
          <TopButton type="filled" onClick={checkout}>CHECKOUT NOW</TopButton>
        </Top>
        <Bottom>
          <Info>
            { products.map((p) => (
                <Product>
                <ProductDetail>
                  <Image src={p.img_path} alt="image" />
                  <Details>
                    <ProductName>
                      <b>Product:</b> {p.name}
                    </ProductName>
                  </Details>
                </ProductDetail>
                <PriceDetail>
                  <ProductAmountContainer>
                    {/* <Add /> */}
                    <ProductAmount> { p.count } </ProductAmount>
                    {/* <Remove /> */}
                  </ProductAmountContainer>
                  <ProductPrice> { p.price*p.count } won </ProductPrice>
                </PriceDetail>
              </Product>
            ))}
          </Info>
          <Summary>
            <SummaryTitle>ORDER SUMMARY</SummaryTitle>
            <SummaryItem>
              <SummaryItemText>Subtotal</SummaryItemText>
              <SummaryItemPrice>{subtotal} won </SummaryItemPrice>
            </SummaryItem>
            <SummaryItem>
              <SummaryItemText>Estimated Shipping</SummaryItemText>
              <SummaryItemPrice>{shipping} won</SummaryItemPrice>
            </SummaryItem>
            <SummaryItem>
              <SummaryItemText>Shipping Discount</SummaryItemText>
              <SummaryItemPrice> {shippingdiscount} won</SummaryItemPrice>
            </SummaryItem>
            <SummaryItem type="total">
              <SummaryItemText>Total</SummaryItemText>
              <SummaryItemPrice>{total} won</SummaryItemPrice>
            </SummaryItem>
            <Button onClick={ checkout }>CHECKOUT NOW</Button>
          </Summary>
        </Bottom>
      </Wrapper>
      <Footer />
    </Container>
  );
};

export default Cart;