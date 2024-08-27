
# 연산자 오버로딩
# 객체에서 연산을 할 때 사용하는 기법
class Point :
    def __init__(self, x, y) :
        self.x = x
        self.y = y

    def __add__(self, other) :
        return Point(self.x + other.x, self.y + other.y)
    
    def __str__(self) :
        return f"Point({self.x}, {self.y})"
    

 # 객체 생성
p1 = Point(1, 2)
p2 = Point(3, 4)

# + 연산자 오버로딩 (__add__ 자동으로 호출)
p3 = p1 + p2 # p1.__add__(p2)

print(p3)

a = 2
b = 10

c = a.__add__(b)

d = a.__sub__(b)
print("차 : ", d)

e = a.__mul__(b)
print("곱 : ", e)

f = a.__truediv__(b) # /
print("몫 : ", f)

g = a.__floordiv__(b) # //
print("몫 정수 : ", g)


# __mod__(self, other): % 연산자
# __pow__(self, other): ** 연산자
# __eq__(self, other): == 연산자
# __ne__(self, other): != 연산자
# __lt__(self, other): < 연산자
# __le__(self, other): <= 연산자
# __gt__(self, other): > 연산자
# __ge__(self, other): >= 연산자


class Person :
    def __init__(self, id1, pw) :
        self.pw = pw
    
    def __eq__(self, other) :

          #instance of 자바!비슷하다.
        # Person 클래스의 인스턴스이거나
        # 상속관계를 같는 Person 관계 있으면
        # 데이터를 비교하고 관계 없으면 비교 안함!
        if isinstance(other, Person) :
            return self.id1 == other.id1 and self.pw == other.pw
        return False
    
    def __str__(self) :
        return f"Person({self.id1}, {self.pw})"
    
person1 = Person("서희", "서희")
person2 = Person("익준", "익준")

print(person1 == person2)