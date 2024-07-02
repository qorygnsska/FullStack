import {
  Button, Navbar
  , Container, Nav, Row, Col
} from 'react-bootstrap';
import './App.css';
import Dior from './images/dior2.png';
import Bag1 from './images/bag1.png';
import Bag2 from './images/bag2.png';
import Bag3 from './images/bag3.png';

function App() {


  return (
    <div className="App">

      <Navbar bg="dark"
        variant="dark">
        <Container>
          <Navbar.Brand href="#home">Navbar</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="#home">Home</Nav.Link>
            <Nav.Link href="#features">Features</Nav.Link>
            <Nav.Link href="#pricing">Pricing</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
      <img className='mainImg'
        src={Dior} />
      <div className="container">
        <div className="row">
          <Card name={Bag1}
            title='가방1'
            content='분홍 가방' />
          <Card name={Bag2}
            title='가방2'
            content='네이비 가방' />
          <Card name={Bag3}
            title='가방3'
            content='네이비 가방' />
        </div>

      </div>

    </div>
  );
}
function Card({ name, title, content }) {
  return (
    <div className="col-md-4">
      <img className="bagImg"
        src={name} />
      <h4>{title}</h4>
      <p>{content}</p>
    </div>
  )
}
export default App;


