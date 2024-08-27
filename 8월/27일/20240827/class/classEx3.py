
# 클래스 변수
class Student :
    # 클래스 변수 : 모든 학생들의 학번을 관리
    next_id = 1

    def __init__(self, name) :
        self.name = name
        self.student_id = Student.next_id
        Student.next_id += 1 # 다음 학생 학번증

    def __str__(self) :
        return f"({self.student_id}번 이름 : {self.name})"
    
class StudentManager :
    # 학생들을 관리하는 리스트
    def __init__(self) :
        self.stuList = []

    def add_student(self, name) :
        stu = Student(name)
        self.stuList.append(stu)
        print(f"학생 추가됨 : {stu}")

    def remove_student(self, student_id) :
        for student in self.stuList :
            if student.student_id == student_id :
                self.stuList.remove(student)
                print(f"학생 삭제됨 : {student}")

    def find_student(self, student_id) :
        # 학생의 객체를 가지고와서
        # student_id를 이용해서 정보가 있으면 출력 없으면 없다
        for stu in self.stuList :
            if stu.student_id == student_id : 
                return stu
        return None

    def list_student(self) :
         # 학생목록을 출력!
        for stu in self.stuList:
            print(stu)


# 학생들 관리하는 클래스 객체 생성
ma = StudentManager()

# 학생들 추가하는 내용
ma.add_student("seo")
ma.add_student("hee")
ma.add_student("Bob")

# 학생의 목록
ma.list_student()
# 학생 삭제

    
stu1 = Student("seohee")
stu2 = Student("jihee")
stu3 = Student("Bob")

print(stu1)
print(stu2)
print(stu3)