import styled from "styled-components";
import Announcement from "../components/Announcement";
import Footer from "../components/Footer";
import { useLocation, useNavigate } from "react-router-dom";
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

const Button = styled.button`
  width: 100%;
  padding: 10px;
  background-color: black;
  color: white;
  font-weight: 600;
`;

const Hr = styled.hr`
  background-color: #eee;
  border: none;
  height: 1px;
`;

const SingleOrder = (props) => {
  const navigate = useNavigate();
  const location = useLocation();
  const [products, setProducts] = useState([]);

  useEffect(() => {
    console.log("single order in")
    setProducts(arr => location.state.item)
    console.log(products)
  },[])
 
  return (
    <Container>
      <Navbar isAuthenticated={props.isAuthenticated} token={props.token} />
      <Announcement />
      <Wrapper>
        <Title>YOUR ORDERS</Title>
        <Top>
          <TopButton onClick={() => navigate("/")} >CONTINUE SHOPPING</TopButton>
        </Top>
        <Bottom>
          <Info>
            { products.map((p) => (
                <Product>
                <ProductDetail>
                  <Image src="https://i.pinimg.com/originals/2d/af/f8/2daff8e0823e51dd752704a47d5b795c.png" />
                  <Details>
                    <ProductName>
                      <b>Product:</b> {p.name}
                    </ProductName>
                  </Details>
                </ProductDetail>
                <PriceDetail>
                  <ProductAmountContainer>
                    <ProductAmount> { p.count } </ProductAmount>
                  </ProductAmountContainer>
                  <ProductPrice> { p.price * p.count } won </ProductPrice>
                </PriceDetail>
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

export default SingleOrder;