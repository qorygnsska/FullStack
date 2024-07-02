import './App.css';
import Avartar from './components/Avartar';
import Profile from './components/Profile';
import pika from './image/img02.jpg';
import pika2 from './image/img03.jpg';
import pika3 from './image/img04.jpg';
import pika4 from './image/img05.jpg';

function App() {
  return (
    <div className="App">

      <Avartar image={pika4} isNew={true}/>

      <Profile image={pika} name='James Kim' title='프론트엔드 개발자' isNew={true}/>
      <Profile image={pika2} name='James Park' title='백엔드 개발자' isNew={true}/>
      <Profile image={pika3} name='James Bae' title='디엔드 개발자' isNew={false}/>
    
    </div>
  );
}

export default App;
