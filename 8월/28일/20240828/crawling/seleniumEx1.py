# 파일명: seleniumEx1.py
# 자동이용해서 데이터를 크롤링하거나
# 로그인 

# 1. 크롬드라이버를 설치하기 
#     회의록에 사이트 
# 2. 본인 크롬 버전 
#     크롬 확인 (도울말)
# 3. 크롬드라이버 exe 실행 파일을 현재 
#     파일과 같은 위치에 저장하기

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time 

# 1. py파일로 드라이버 가져오기 
#  Chrome('경로/파일명.exe')
#      같은 경로에 크롬드라이버가 있으면 ()
#      작성 안해도됨
driver = webdriver.Chrome()
#driver.get('https://www.google.co.kr/?hl=ko')
driver.get('https://www.instagram.com/')


# 위에 html 문서를 다 가져올 수있도록 조금 기다린다
time.sleep(3)
                                        # "input[name='username']"
# e = driver.find_element_by_css_selector('input[name="username"]')
#e = driver.find_element(By.CSS_SELECTOR, \
#                    'input[name="username"]')

#//*[@id="loginForm"]/div/div[1]/div/label/input
# /html/body/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div/section/main/article/div[2]/div[1]/div[2]/div/form/div/div[1]/div/label/input
e = driver.find_element(By.XPATH,'//*[@id="loginForm"]/div/div[1]/div/label/input')
e.send_keys('test')

e2 = driver.find_element(By.XPATH,'//*[@id="loginForm"]/div/div[2]/div/label/input')
e2.send_keys("test")

# 버튼을 클릭한다.
e2.send_keys(Keys.ENTER)


#print(e)



time.sleep(10)