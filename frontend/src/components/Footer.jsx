import styled from "styled-components";
import {
    MailOutline,
    Phone,
    Room,
  } from "@material-ui/icons";
import { useNavigate } from "react-router-dom";

const Container = styled.div`
  display: flex;
`
const Left = styled.div`
  flex: 1;
  display: flex;
  flex-direction: column;
  padding: 20px;
`
const Logo = styled.h1``;
const Desc = styled.p`
  margin: 20px 0px;
`
const Center = styled.div`
  flex: 1;
  padding: 20px;
`
const Title = styled.h3`
  margin-bottom: 30px;
`
const List = styled.ul`
  margin: 0;
  padding: 0;
  list-style: none;
  display: flex;
  flex-wrap: wrap;
`
const ListItem = styled.li`
  width: 50%;
  margin-bottom: 10px;
`
const Right = styled.div`
  flex: 1;
  padding: 20px;
`
const ContactItem = styled.div`
  margin-bottom: 20px;
  display: flex;
  align-items: center;
`

export default function Footer() {
  const navigate = useNavigate();
  return (
    <Container>
        <Left>
            <Logo>GGOGI.</Logo>
            <Desc>
            There are many variations of passages of Lorem Ipsum available, but
            the majority have suffered alteration in some form, by injected
            humour, or randomised words which don’t look even slightly believable.
            </Desc>
        </Left>
        <Center>
            <Title>Useful Links</Title>
            <List>
            <ListItem onClick={() => navigate("/")}>Home</ListItem>
            <ListItem>Salad</ListItem>
            <ListItem>Cart</ListItem>
            <ListItem>Rice</ListItem>
            <ListItem>My Account</ListItem>
            <ListItem>Bakery</ListItem>
            </List>
        </Center>
        <Right>
            <Title>Contact</Title>
            <ContactItem>
            <Room style={{marginRight:"10px"}}/> Seoul, South Korea
            </ContactItem>
            <ContactItem>
            <Phone style={{marginRight:"10px"}}/> +81 02 465 2342
            </ContactItem>
            <ContactItem>
            <MailOutline style={{marginRight:"10px"}} /> contact@ggogi.dev
            </ContactItem>
        </Right>

    </Container>
  )
}
