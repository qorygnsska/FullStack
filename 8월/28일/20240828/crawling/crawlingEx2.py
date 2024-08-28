import requests as re
from bs4 import BeautifulSoup
import time

class Naver:

    def __init__(self,title='', link1='',content=''):
        self.title = title
        self.link1 = link1
        self.content = content

    def __str__(self) :
        return f"제목 : {self.title} \n 링크 : {self.link1} \n 내용 : {self.content}"

class NaverBlogMa:

    def __init__(self):
        self.blogList = []
    # 추가

    # 삭제

    # 조회

    # 수정




# get요청 
# 입력하는 검색창 get요청을 하는 창이다!

resp = re.get('https://search.naver.com/search.naver?ssc=tab.blog.all&sm=tab_jum&query=참외')
print(resp.text)

soup = BeautifulSoup(resp.text,'html.parser')

# 찾기 
# bxList = soup.find_all('li',class_='bx')
#print(bxList)

# 첫번째 링크 텍스트 가져오기
title = soup.find_all('a', class_='title_link')[0].text
print(title)

# 첫번째 이미지 URL 가져오기
# imageUrl = soup.find_all('img')[2]['src']
# print(imageUrl)

# select()
#  css 선택자를 이용해서 다양하게 데이터를
#  찾아올 수있다.  클래스 ., id #,  a ,
#  태그명[속성]

# bxList = soup.select("li.bx")

# #print(bxList)
# for li in bxList:
#     # 양쪽 공백을 제거할 수있도록 속성값
#     # strip=True
#     print(li)
#     print(li.get_text(strip=True))

#     #time.sleep(2)

# title = soup.select('a.title_link')[0].text
# print(f"select() : {title}")

# img = soup.select('img')[2]['src']
# print(f"select() img : {img}")

naverList = []
title = soup.select('a.title_link')[0].text
link1 = soup.select('a.title_link')[0]['href']
img = soup.select('img')[2]['src']

# naver객체 생성
obj = Naver(title=title, link1 = link1, content = img)

# 리스트에 저장
naverList.append(obj)

print(naverList[0])