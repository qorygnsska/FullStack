import Home from './Home';
import './App.css';
import { Routes, Route, Link, useNavigate } from 'react-router-dom';
import About from './About';
import Content from './Content';

function App() {
  // 페이지를 이동하는 함수!
  //  뒤로가기, 앞으로 이동하기 
  //  navigate('페이지명')
  //  navigete(숫자)   -1 뒤로가기 2 앞으로 2번 이동
  let navigate = useNavigate();
  return (
    <div className="App">
      <h2>App.js</h2>

      <nav>
        <ul>
          {/* 유저들이 url을 직접 입력 안하니
          버튼을 눌렀을 때 이동할 수있는 것! */}
          <li><Link to='/'>Main</Link></li>
          <li><Link to='/home'>Home</Link></li>
          <li><Link to='/about'>About</Link></li>
          <li><Link to='/content'>Content</Link></li>

        </ul>
      </nav>
      
      {/* 서브 경로 페이지 안에 새로운 페이지 추가 */}

      <Routes>
        <Route path='/home' element={<Home />}>
            <Route path='member' element={<div>멤버들</div>}/>
        </Route>
      </Routes>

      <Routes>
        <Route path='/about' element={<About />} />
        <Route path='/content' element={<Content />} />
        <Route path='*' element={<div>없는 페이지임!</div>} />

      </Routes>

      {/* html 처럼 여러개의 페이지로
      나누고 싶을 경우에는 
      react-router-dom 외부라이브러리
      다운을 받아서 쓴다.
      npm install react-router-dom@6

      index.js 
      라우터를 사용한다 파일을 포함

        <Routes>
          <Route path='/home' 
                 element={<Home />}/>
          <Route path='/about' 
                 element={<About />}/>
          <Route path='/content' 
                 element={<Content />}/>

          <Route path='*' 
                 element={<div>없는 페이지임!</div>} />
      </Routes>


      */}



    </div>
  );
}

export default App;
