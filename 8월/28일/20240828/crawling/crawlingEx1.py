# 웹 크롤링 하기 위한 라이브러리!
# pip install selenium
# pip install bs4
# pip install requests

# import requests
# import bs4
# import selenium

import requests
from bs4 import BeautifulSoup
import time # 시간과 관련된 라이브러리

# BeautifulSoup
# 크롤링을 하기 쉽게 도와주는 라이브러리
# 웹 페이지의 데이터를 추출 위해 html이나 
#   xml문서를 파싱하여 구조화된 데이터를 만들 수있다. 

# 내가 원하는 웹 사이트 접속
html = requests.get("https://www.naver.com/")
time.sleep(2)
soup = BeautifulSoup(html.text, 'html.parser')

print(soup)
# 데이터를 검색할 수 있는 메서드
# find(), find_all(), select()

title = soup.title
print(f"타이틀 : {title}")

# 첫번째 링크 가져올 수 있도록 작성
# link1 = soup.find('a')
# print(type(link1))
# print(f"첫번째 링크 : {link1.get('href')}")

# 네이버에서 모든 링크를 가져오기 
# href 속성 값만 출력!
# find_all(태그)
# find_all, find() 메서드는 반환값이 
# Tag객체로 반환되고 여러개는 Tag객체 리스트로
# 반환된다.
# 만약 비어있다면 빈 리스트 반환된다. 
# 비어있는 값을 확인할 때는 비었는지 확인하는 not,
# len()으로 간단히 비교할 쉬있다.
all_link = soup.find_all('a')
if len(all_link) != 0 :
    for index, link2 in enumerate(all_link, start=1) :
        print(f"{index}. {link2.get('href')}")
    

# 요청을 하면 html에 응답이 온다.
# html 내용을 가져올 때 content
# 데이터의 원본을 그대로 가져온다
# 이진 파일 데이터를 다룰 때 유용
# 텍스트 말고 이미지, 파일
# print(html.content)
# html.text.replace("_ or / or \ ", '')

# 모든 내용은 텍스트로 반환
# html.text
# HTML 이나 JSON 등의 텍스트 데이터를 분석하거나 출력하기 위해 사용
# print(html.text[:100])

