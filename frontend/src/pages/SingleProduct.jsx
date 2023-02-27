import { useLocation } from 'react-router-dom';
import { Add, Remove } from "@material-ui/icons";
import styled from "styled-components";
import Navbar from '../components/Navbar';
import Announcement from '../components/Announcement';
import Footer from '../components/Footer';
import Review from '../components/Review';
import { useState } from 'react';

const Container = styled.div``;

const Wrapper = styled.div`
  padding: 50px;
  display: flex;
`;

const ImgContainer = styled.div`
  flex: 1;
`;

const Image = styled.img`
  width: 100%;
  height: 70vh;
  object-fit: cover;
`;

const InfoContainer = styled.div`
  flex: 1;
  padding: 10% 50px;
`;

const Title = styled.h1`
  font-weight: 200;
`;

const Desc = styled.p`
  margin: 20px 0px;
`;

const Price = styled.span`
  font-weight: 100;
  font-size: 40px;
`;

const AddContainer = styled.div`
  width: 50%;
  display: flex;
  align-items: center;
  justify-content: space-between;
`;

const AmountContainer = styled.div`
  display: flex;
  align-items: center;
  font-weight: 700;
`;

const Amount = styled.span`
  width: 30px;
  height: 30px;
  border-radius: 10px;
  border: 1px solid teal;
  display: flex;
  align-items: center;
  justify-content: center;
  margin: 0px 5px;
`;

const Button = styled.button`
  padding: 15px;
  border: 2px solid teal;
  background-color: white;
  cursor: pointer;
  font-weight: 500;
  &:hover{
      background-color: #f8f4f4;
  }
`;

const SingleProduct = (props) => {
    const location = useLocation();
    const item = location.state.item;
    console.log(item)
    const [count, setCount] = useState(1)

    const addCart = (e) => {
      e.preventDefault()
      if (props.token==null) {
        alert("장바구니 이용을 위해 로그인을 해주세요")
      } else {
        fetch("/api/v1/cart/add", {
          method: "POST",
          headers: {
              'Content-type': 'application/json',
              'Authorization': 'Bearer ' + props.token
          },
          body: JSON.stringify ({
              count: count,
              productid: item.id,
              token: props.token
          })
        })
        .then(res => {
            console.log(res)
        })
        .catch(err=> { 
            console.log("adding to cart failed")
            console.log(err) 
        });

      }
    }

    const addCount = () => { setCount(count+1) }
    const removeCount = () => { 
      if (count===1) { setCount(1) }
      else { setCount(count-1) }
    }

    return (
        <Container>
            <Navbar isAuthenticated={props.isAuthenticated} token={props.token} />
            <Announcement />
            <Wrapper>
                <ImgContainer>
                <Image src={item.imgPath} />
                </ImgContainer>
                <InfoContainer>
                <Title>{item.name}</Title>
                <Desc>
                    {/* description */}
                </Desc>
                <Price> {item.price}원 </Price>

                <AddContainer>
                    <AmountContainer>
                    <Remove onClick={ removeCount }/>
                    <Amount> {count} </Amount>
                    <Add onClick={ addCount }/>
                    </AmountContainer>
                    <Button onClick={ addCart }> 장바구니 담기 </Button>
                </AddContainer>
                </InfoContainer>
            </Wrapper>
            <Review />
            <Footer />
        </Container>
  );
};
  
export default SingleProduct;