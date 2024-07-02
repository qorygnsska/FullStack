import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
// 부트스트랩 라이브러리 포함
import 'bootstrap/dist/css/bootstrap.min.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import Main from './Main';

// 항상 외부 라이브러리는 위에 작성
// 내가 직접 만드는 파일들을 아래쪽!
// 선언을 해야 스타일이나 파일들이 동작한다.

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
