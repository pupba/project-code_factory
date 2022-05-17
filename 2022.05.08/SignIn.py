# 비밀번호 처리 문제
# SignInSystem 클래스
import sys
class SignInSystem:
    def __init__(self):
        self.__password = ''
        # 특수 문자 허용 된거 제외하고 제거
        self.specStrNot = ['*','(',')','_','-','=','+',
                        '/','\\','[',']','{','}',',',
                        '<','>','.',':',';','\'','\"']
        self.specStrOk = ['!','@','#','$','%','^','&','?']
    
    def saveTxt(self,txt):
        with open('pass.txt','at') as f:
            f.write('|')
            f.write(txt)
            print("저장 완료!")
    # encryption 메소드
    def encryption(self,password):
        try:
            self.__password = password
            # 대소문자 구분 안함
            pw = self.__password.upper() # 대문자로 변환
            # 영문, 숫자, 특수문자 합쳐서 15글자 내
            if len(pw) > 15:
                print("비밀번호는 15글자 이내입니다.")
                sys.exit(0)
            else:
                lpw = list(pw)
                for s in self.specStrNot:
                    if s in lpw:
                        print("{}를 사용할 수 없습니다.".format(s))
                        sys.exit(0)

                # !, @, #, $, %, ^, & ,? 특수문자만 허용
                # 특수문자는 반드시 1개이상쓰기
                count = 0
                for s in self.specStrOk:
                    if s in lpw:
                        count+=1
                if count == 0:
                    print("특수문자는 1개이상 포함되어야 합니다.")
                    sys.exit(0)
                else :
                    pwd = ''.join(lpw)
                    # 완성된 비밀번호는 pass.txt 파일로 만들어 저장
                    self.saveTxt(pwd)
        except SystemExit as e:
            print("종료합니다.")


#
# 비밀번호는 키보드에서 사용자가 입력
pwd = input("비밀번호를 입력해주세요 >> ")
# -실행 예시- 
# ex) a = SignInSystem()
# ex) a.encryption(비밀번호)
SIS = SignInSystem()
SIS.encryption(pwd)

try :
    with open('pass.txt','rt') as f:
        print(f.read())
except FileNotFoundError as e:
    print("파일이 없습니다.")
