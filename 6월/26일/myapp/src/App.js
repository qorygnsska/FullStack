// App.css 파일을 포함한다.
import './App.css';

function App() {
  // 변수생성
  const name = "kyo hoon";
  let name2 = "bae"
  var name3 = "kyo hoon2";
  return (
    // <> </>
    <div className="App">
      {/* JSX 문법을 사용할 때 변수값을 이용해서 데이터를 html 요소안에 넣을때는 {} */}
      <h1>Hello! {name}</h1>
      <h1>Hello! {name2}</h1>
      <h1>Hello! {name3}</h1>

      <p className='orange'>hello world!!</p>
      <div className="box1" style={{color:'pink', fontSize:'100px'}}>상자</div>

      <ul>
        <li>우유</li>
        <li>딸기</li>
        <li>바나나</li>
      </ul>
      <img src='data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBwgHBgkIBwgKCgkLDRYPDQwMDRsUFRAWIB0iIiAdHx8kKDQsJCYxJx8fLT0tMTU3Ojo6Iys/RD84QzQ5OjcBCgoKDQwNGg8PGjclHyU3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3N//AABEIALoAugMBEQACEQEDEQH/xAAcAAEAAgMBAQEAAAAAAAAAAAAABQcBBAYCAwj/xAA+EAABAwMCAwYEAgcHBQAAAAABAAIDBAURBiESMUEHExRRYYEicZGhMsEVIzNSYnLRJEJUgrGy8BZDU+Hx/8QAGwEBAAIDAQEAAAAAAAAAAAAAAAQFAQMGAgf/xAAxEQACAgIBAwIGAQMEAwEAAAAAAQIDBBESBSExE0EUIjJRYXEjgaGxQlKRwTPh8BX/2gAMAwEAAhEDEQA/ALxQBAEAQBAEAQBAEAQBAEAQBAEAQBAEAQBAEAQBAEAQBAEAQBAEAQBAEBjKAzlAYJwgNetuFHb4DPX1UNNCOckzwxv1KA0bfqmwXKXurferfUyZxwRVDHH6ZQEtnKAygCAIAgCAIAgCAIAgCAIAgCA+NTUw0kEk9TIyKGNpc+R7sBoHUlAcJVdotXWvcNM2N1ZA048XVS9zG7+XYk/ZR7cqml6m+5urx7LO8UeqLtFdSVLKfVVrNsEhIjqY5e9hd89gR9F6qyK7voZiymVf1GajtKiqeIaestbcv3Z3YhhP+Z35ApZfVX9bMQpss+lGlJqXW9UcwwWWhjPR4kmcPfIH2UOXVaF42So4Fr8nzNw1wdzebc3+Wj2+61vq9f8AtZ6//On/ALj41mptaWmlkrKiqstRBCOJ4fTPa4j0IcN+nuttPUq7ZqCi9s12YUq4uTZp0ttkvkrb1qbFVVzDiigcP1VOw8g1vn6qFm58+bhW9JErFxI8VOa7m5WaftFZHwT2+AjoWt4S3ywRuFChmXwe1IlSxqpLTRu6NulbZr/Dp24VUlVRVTHPoJpjmRjm7ujJ6jG4V/h5PxFe/deSoyaPRlpeCyFMIwQBAEAQBAEAQBAEAQBAEAQFddpMr7jfLPp5xPhHsfV1LQf2gYQGtPpnJ9lFzLpVUuUfJvxq1ZYkyCq7xNU1DrbpyKOSSMYkqHDEMA8tuZ9AqWGPGK9TIet+3u//AEWkrm36dK8f8I+tv01Swy+KuDnV9aR8U1QMgH+FvIBa7M2bXGtcY/ZHuvGinyn3ZNcseihknwOmEATYPE0MU8Top42yRu5tcMgr1GcovcXpmHFSWme9ui8mQgIC/wBwprdf9N1FXL3bIazvHvxnhZjBPy+IBXHSFpzb/BW9R1xSLehlZMxskT2vjcA5rmnIcD1CvCqPogCAIAgCAIAgCAIAgCAIAgKo7RsXnVtFQ2maSOrpad7K2ePlHG8ghmf3tjt/EomZbCqrc1v7IkY1c5z1H+pt2+hprdSspqOIRxsHIcyfMrmrbZ2y5Te2XlcIwjxj4Nlaz2EAQBAEAQBAfCooaSplEtRTRSyCN0XE9nF8B5t+RW2F1kO0Xo8SqhJ7aPGkLnJpe9R2Ksle+0VpJoJHnPcSdYyfI5GPf26LCyviId/qRS5WP6Mu3hlmD3U0imUAQBAEAQBAEAQBAEAQEPqu8x2CwVtzkGTCz9W3995IDR7khAcBpygko6Ay1b+8rqt3f1Mh5ue7fHyHJcvnZDutf2XgvsWlVVr7slFDJIQBAEAQBAEAQBAR9+twutrnptxKfihc3YseN2kHocqRi3OmxSRpyK1ZW0ztNDXl1+0zRV02PE8Hd1GBj9a3Z3yyd8eq6xPZz2tdifQBAEAQBAEAQBAEAQBAV72lzGsu9hsvNj5nVcw/hjG33P3UbMs9OiUjfjQ52xRjqSuUOgCAIAgCAIAgCAIAgHXmgM9mk3hb/qS08oxKysjHQCQEOx7tJ911WFY50Rb/AEc/kwUbWWEpRoCAIAgCAIAgCAIAgCArLUTu/wC02Yc/DWtjW+nG8k/7QqzqstUpfkn9PX8jZtZAyXHAXPLbLg+ElZSxjMlTCz+aQD81sVVj8RZ4dkF5Zr/py0942MXOkL3EANEzSc/Ve/hb9b4M8+vVvXLub60G0ICIul9FvqvDtt9bUv4Q7MMeW79M+al04nqx5OaX7I9uRweuLZp/9RXN/wCw03XH1eQ3/Vbvg6V9VqNXxNj8Vs3bTX3arqHivtBo4AzIkMzXEnPLAK0ZFNFcU67OTNtVls3qcNEsopICAJ7A19KvMfabIwcprQ4u+bZGAf7iui6W/wCDX5KbPX8uyyh6qyIJlAeeJAekAQBAEAQBAEAQFYXkFnabcgf+5boHD1Ac8Kq6sv4ov8/9Fh05/wAkj7V1HDX0slLUtLopBhwDi3b5jdUddkq5KUfKLWcFOLi/BExaQsEWwtzHHze9z8/UqU+oZD/1Ef4OheUbcFjtMLmvht1K1wOWuEY291rnlXyWpSZ7jRSu8UiRUY3hAZz6n2QEHcdU223XDwU7pOMYD3NblrCfNTaun3WV+oiLZl11z4snPUKESjCAIAgNfSrTL2myyAfDBaHNd83ysI/2ldF0pao3+Smz3/LosoKyIJymvtTT2CjghoAw19W5wiLxkMa3HE4jrjI+q1W2cEWHTsP4qx78Ir2HVWpaSbxQuz6gtOTDKwFjh5YA29lFV8t72dDPpONKGlHRbNpvVNcbTRXAyMiZVRhwbI4Ag9W/MFTVJNbOTtplXY4fYk2O4hkEEdCF6NR6QBAEAQBAEBXGtovB6+tFX/craSWmd6uaeNv5qB1KHLHf4eyZgzUbf2fVc0XZE6no6u4WaenoX8MriDjOOIA7jPqpWFZCq5Sn4I+TXKdbjDyaOh7XW2u3yxV47trn5jizngGPst3Ub67Zpw/qzXh1zri+Z0fRV5MMkEcwgMZ223QHP3XSdtuNz8fUSTMLsd5G1wDZMee23LorCjOtrhwitkWzDhZLkTzXsJw1zfkCobrmluSJfFo9LWYCAc9kB67MYvF3XUN534JZmUsJ82Rg5I/zOP2XV4cOFEUc/kz52tlgjZSTQVf2txlt6s8x/A6GZg+eW/1UTJT2joehSWpr9f8AZx5GWkeYUU6V9zUbQwhjRUfrSxvCOM5AHkPLckrO2zVClRXY7nsqr6inutRZzK59G6DvomEk904HBA8gc8vRSseTb0zn+tY8IpWJdy0W8lKOeMoAgCAIAgOO7ULfLU6eFwo2F1Xa5m1UYA3LQfjA/wAuT7LxOCnFxfuZjLjJSXsQ1LVR1dFFV0544pWB7cdcrk5VONjhLsdLW1NKSNfx0u+Im7HGMKesKprvIkKpa8i5XVlut/ipYnue4hkULOcjzsGhRoYzsu9OD8e5EyLI0x5M1rrp7W1TZaipLqSA8HH4KmyZseQfyzjoPkrurp1Nb3rbKezNsmteCE0Bpm/3ipqXGvr7ZSxt4XSuaSZH/utDuvUu/qpE8emf1RRojdZHxI6G+2u9aQibcJrg67WkOa2o72MNmh4jjiyObckZUO/p1U47gtMk05tkZfN3Rsz04qQyRr9i3bbbCqKMj0NxaL2uzSPENAGyBzn5APQLbZnOUWoo9yt2taNxV5pCAitRXF9FQd3SMdJXVTu5pYm/ie87bfLnlS8PHd1qXsvJGyblXX+SwNJ2Vmn7BR21pDnxRjvXjk+Q7uP1yupKEmEBx3ajbvGaZfUxjM1C8Tt26cnD6ErVdHlAsel3OvIS9pdirhI3g4+IcJGcqvOz2jFM6SsmENuhlq5s7MgaXb+p5Beoxb8Gq2+upbm9Fn9n+lJ7KyeuufD4+oaG92w5ELP3c+Z6/IKbVXwWzk+pZ/xMkofSjswMBbisMoAgCAIAgPL2B7XNeMtcMEHqEBU9RSu0ffnWuYOFqrXl9vmP4WOPOEnofL/7ip6lic/5YruixwshR+ST7Evtt5+SottlsQ+o3Opn2y5d06aK31rKiaNjcksB3IHXCsel2Rha1L3IWfCUq9r2O9h1dp2ej8Yy+W/uQ3JLqhoLfQgnIPpzXQlKQFs7TbVUXKqiuDTQ0Rd/YayUO4Kho2Jzjbf7LCkm9JmXFpbaNTXerLde7NPYLBM2vq6/ETnQglkTMjicXcuWffCxZbGqLlJnqFbsekeoIxDBFGDkMYG588BcfKXJt/c6OK4rR7WDIJABJOMeaJb7IEPVaoslNxB1fE9zQfhjy7PoCNlMrwMievl7EaWXTH3Jbs8tTrvUjVNzfE9zgWUFNG8OFO3q4/xn7f6dBjY0cetRj/Up77pXS5MsQKQaTKA162ljraWamnHFFK0sePMFYa2tHqEnCSkvY56l7PdMUxBFsbMR/iJHSD6E4WtUwRLn1HJmtOWv12OhpaOnpIxHSwRQsGwbGwNC2JJeCHKUpPcns+4GFkwZQBAEBgnAQHLax1jHpx0VNDTeLrZml7YuPhDW8uJx39duuFqstUCfg4EspvT0kael+0CK7VzbfcaPwNU/9mQ/jjkPlnAwfT7rFdyn2ZtzOlzx4809o7bmFuKsjr7ZqK+22aguUXewSD5Fp6EHoQm9ArWtiu2jiIbz3lfawcR3KNhLmDylb0/mVTl9NU3zq7MscfO4/LMk6Wpp6yETUszJY3DZzHZVJOEq3qS0y0jKM1teDTksVpkm759upjJnPFwBbVl3pa5M1+hVvfE3nwwyR93JDG+McmuYCB7LUrJJ8k+5s4R1rXYxDTwU7S2CGOJp5hjQ3P0WJTlPvJ7CjGPhH0xv+a8no8yPZEwvlcGMHNzjgLMYuT1HuYbS89jmqmQanuZoKec/omnaHVD4nft3H+5ny81ZQj8JVzkvnfj8EGTWTPgn8q8/knoLdQ08PdQ0kDGeQjCgzvsk+Tk9ktVQS0kRchfo+u/TtoYWUfEBcaOP8MjM/jaP3grbp+a5S9Kx/or8zGUVziW5TyxzwsmhcHxyNDmPB2cCMgq5Kw+iAIAgCAIAgCAFAQOrtQx6dtgqTH300jxHDFnHE4+Z8l4nNQWyViYryreCel7lRXm7Vl6vQr62njheYGxYidxAAEkc/wCZQZz5vZ1uFi/DR4J/k0q17oafv4iQ+nIlYfJwOQvEZaeyVbCMoNM/QlNJ3tNFJ++wO+oVmj5+1pn0WTB5e1r2lr2hzXDBB5FAUmLHDWal1BLb5pbWKetMMDKL4GtDQA7LRtuQTj1VXn5PpSUXFNMnYdPOLabTNsQaoptoaqgrmj/zMMTj7tyFXcsOfmLj/cm8cqHhpmfH6mbs6x0z/VlW3809LDfix/8ABn1Mn/Z/ceN1PJsyzUcRPWSqzj6ZWVVhrzNv+gdmS/8AR/ceF1PU7TXGio2n/DQl7vYu/osephwW1Fv9scMmXmSR7ZpKnc5s11nrK95GWeJlPAfkBsszzbIr5IqK/X/Z5hjQb+Z8mS9LSU1IwspaeKBpOSImBoP0UKdk7Hub2S4QjFfKjAq4HVj6MStNQ1gkdH1DScA/ZPTmo89dgpx5cd9xWQtqKSeF/KSNzT7hZqlxmmjFi3Bo6DswndUaGtJcSTHEYt/Jri0fYBdhvZzj7M6lDAQBAEAQBAEBg8kBx/aVY6m72eKWgiM1TRS962Ic3jGHAeuOi1XQco9ix6Xkxou+fw+xVbKmJznNJ7t7Th0b/hc0/IqA015OxjZGa2ns8V4ElHKziG7COaR87E+8WkXtpupbWaetlSw7S0kT+fLLRsrKPeKOCujxtlH8skl6NRg9EBVlTCbZr69UjxiOvDK2DyPw8Lx7EE+6p+rV7jGf2LLp09NwNfxlRHq40Ukp8LPRCSJnQPa4h32wq/04vE5pd0+/6JfOXxHB+GjtLRaWVdHLJNxAvOGEcx5qVhYMbqnKfv4NGXlyqsUY+3k37TZxRyOknw9/4W4G2PP3UvDwFTJyn3ZGycv1Eox7I81FgglqWysJjZnL2Dkfl5Jb02udnJPS+whm2RhxZvVdDFVUpp3NAaB8OB+E9FLtx4W18GiPVdOE+a8nGSxuikdG8Ycw4K5acHCTi/Y6CElKKkjnbv8A2PU9orG7NqeKkk992/fb3Uyj+TGsh9u5Ft+S+E/v2JqslbDSTzOIxHG532KiVLdiX5JNj1Bk/wBmEJg0LaQ4YL4jJ7OcSPsQuwS0c35OpQBAEAQBAEAQBAYcMhARlz0/ars7iuNvp53YxxPYOL6ry4xflG2vItr+iTRGs0Fplj+L9Ewu9HEkf6rz6UPsb/j8l9uZP0tNFSU0dPTRNihjaGsY0YDQOgWxJLsiLKUpNyl5Puh5MHdAcd2jWOpraKnutqjD7nbHd7Gzl3sfJ7Pccv8A2vFtatg4S9z3XNwmpI4S53GnqTY7/Su/VMqO6lB5sDxgh3lg4VHTRKCsx5e62v6FpZYpOFq+/ctjTrgbYwA5LXEH6qw6c94yIWatXMlFPIoQGCgOLvJabpU8PLi/IZXK52viJ6/+7F/if+GJyetBw26ln6w1sLwfk5bentOco/dP/B4zfoT/ACv8n0vfe3utZpq1v/tNSf7VKzfw0O3ET6not/TsRyn6s/C/yaczISjwj7lr0dNFR0sNNTMDIIY2xxsHJrQMAfRXxUn3QBAEAQBAEAQBAEAQBAEAQBAYIygKz1/oOolbWV2m2tPiRmroBsJCN+NnQO9Oq8SrjKSl7o9xm0tEh2e35tTbovEOw544JMjBbK3ZwP0VXRZ8NkSpl4fgnWwd9UbF5R3YcCrcrhlY2DSudxioYSScyH8LBzKi5WVCiO359kb6KJWy0vBxrnue4ufu5xyT6rl5Nt7ZfxSitI5/V8Zq6a325pcHVtxhgHDzALhkj5Ak+ysulR3e3+CFnvVWvyWTp7Tls09A6G2U4YZDxSyu+KSU+bnHc8yuh/BTEuBhAZQBAEAQBAEAQBAEAQBAEAQBAEBgtBQFW3mkGm9ZyxAcNvvRMsJ/usqB+Jvpkb/8Kq+p4/qV+ovKJ2Ddxlwfhk0b5PbKSSWSqDKeJpc4yDIaFWUZWSmoQeyfdjUP5pI+rb/WVMLXxzju3tDmuYzGQV6nn5P0t6PMMOjtJLZpSPdI4ue5zieZccqC5OT233JcYqPZHlYMmnp2n/Tuu2SgcVJZGElw5OqHjGPZufqui6ZRwq5vzL/BTZ9qlNRXsWdhWRBMoAgCAIAgCAIAgCAIAgCAIAgCAIAgIXVVhg1FZ5rfMeBx+OKUDeKQfhcP+cso1vyCph+kb3cGWK6w92La/NwOciZzT8GPQ7OVNbXDC5WR7uXj8fcs6pyydRfheTr2gNHCABjbAVI+/ctF+DKAiLxcpW1EFptQZLdqw8ELSdo/NzvkASrDBw/Xlyl9K/v+iHlZPpLS8lgaTsMGnLRHQxOMkpJknmPOWQ83H8vTC6NJJaRSt7JpZMBAEAQBAEAQBAEAQBAEAQBAEAQBART75SjUYsQbKavwvii4N+BrOItGTnmSDtjogNHT2on3a23S4yUwip6Opnih4X8RlZHsXemSCgOE0i10trdcZTxVFxnkqZXHmeJxx9lzfUrHK9r7di7wocak/uTaryYRt9urbXSBzGd7VTHu6eEc3v8A6BScWh3T0+yXd/o0X2+nHa8+xEWu0uodSaadJJ312qK4y1MuckgNy4D+EDKucK93Tlx7QXgrMqr04py8suxWRCCAIAgCAIAgCAIAgCAIAgCAIAgCAIDkqiiq4O02muMcEklHVWw08sjW5bE9jy4ZPTIf9kBq6Go5aOPUGna6CZkcVXJJHLwkNkhmLnDhd5jcFYByVtq26bkfYL65tJLTOc2nml+GOePOWua7l/zHRUnUMKbsdla2n5LbDyYqHCT8G1W6jtdNhkVSyrqHbR09K4SPeTyADcqFVhXWPXHX7JNmVXBb3si6al1K68Pr67TFynqw3hpI28LY4Wn+InGfmriWC/SVUJaXu/dlasqPPnNbfsdvo7StdBcnX7UJiNwLDHT08RyylYee/Vx6n5+al0UQojxiR7rpWy5M7dbjUEAQBAEAQBAEAQBAEAQBAEAQBAEAQGCMoBjYboDVrrZRXGLuq+lhqY+jZWBwCA+NtsVqtZzbrfTUzvOOMA/VASGPVAZCAIAgCAIAgCAIAgCAIAgCAIAgCAIAgCAIAgCAIAgCAIAgCAIAgCAIAgCAIAgCAIAgCAIAgCAIAgCAIAgCAIAgCAIAgCAIAgCAID//2Q=='/>

      

      {/*
        랜더링
        내가 작성한 코드를 사용자 화면에 보여주는 것을 의미한다.

        클라이언트 사이트 랜더링
        - 초기 페이지 시작할 때 html만 전달한다.
          나머지 콘텐츠(요소들) 자바스크립트가 만들어서 클라이언트(사용자의 브라우저)에서
          동적으로 보여질 수 있도록 하는 것!

        - 기본적으로 태그를 사용할 때 무조건 열고 닫기 하는 코드를 작성
          <input></input>
          <input />
          <br />

        - npm start 실행 시 웹 브라우저가 안 뜨면 localhost:3000/

        - css 꾸밈, 요소 선택을 할때
          className = "이름"

        JSX
        - 요소를 하나하나 만들어서 직접 저장
        - 코드가 너무 길어진다
        - 그래서 javaScript 확장한 문법으로 html 코드처럼 사용할 수 있음
        
        위에 문법을 사용하려면(JSX) 부모 요소로 감싸기 
        - 가상적인 공간을 만들어서 사용자가 요청하는 페이지를 만들어서 보내줌

        서버 사이드 랜더링
        - 서버가 html을 생성하여 클라이언트에 전달한다.
          사용자가 페이지를 요청할 때마다 서버가 최신 데이터를 바탕으로 html 생성해 응답
      */}
    </div>
  );
}

export default App;
