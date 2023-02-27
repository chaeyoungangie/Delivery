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

const Hr = styled.hr`
  background-color: #eee;
  border: none;
  height: 1px;
`;

const Order = (props) => {
  const navigate = useNavigate();
  const [products, setProducts] = useState([]);
 
  const handleFetchData = async () => {
    console.log("myorder in")
    console.log(props.token)
    const response = await 
      fetch("/api/v1/order/myorder", {
        method: "POST",
        headers: {
          'Content-type': 'application/json',
          'Authorization': 'Bearer ' + props.token
        },
        body: JSON.stringify ({
          token: props.token
      })
      })
      .then(res => res.json())
      .then(res => {
          console.log(res)
          console.log("myorder out")
          setProducts(arr => res)
          console.log(products)
      })
      .catch(err => { 
          console.log("get myorder error!")
          console.log(err) 
      });
  }

  useEffect(() => {
      handleFetchData();
  },[])
 
  return (
    <Container>
      <Navbar isAuthenticated={props.isAuthenticated} token={props.token} />
      <Announcement />
      <Wrapper>
        <Title>YOUR ORDERS</Title>
        <Top>
          <TopButton onClick={() => navigate("/")} >CONTINUE SHOPPING</TopButton>
          <TopTexts>
            <TopText>Order List({products.length})</TopText>
          </TopTexts>
          <TopButton type="filled"> 주문 확인용 </TopButton>
        </Top>
        <Bottom>
          <Info>
            { products.map((p) => (
                <Product key={p.orderid} >
                  <button onClick={() => navigate("/singleorder", {state:{item: p.orders_list}}) }> 주문번호: {p.orderid} </button>
                <Hr />
              </Product>
            ))}
          </Info>
        </Bottom>
      </Wrapper>
      <Footer />
    </Container>
  );
};

export default Order;