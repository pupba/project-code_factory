# 함수를 작성하시오
# 1. 매개변수를 받지않고 "Hello Python"을 출력하는 함수 printhello
def printhello(): print("Hello Python")
# 2. 매개변수로 list를 받아서 그 요소들을 하나씩 출력하는 함수 printList
def printList(list): 
    for i in list:
        print(i)
# 3. 매개변수 a,b를 받아서 a+b를 리턴하는 함수 add
def add(a,b):
    return a+b
# 4. 매개변수를 몇개든 받을 수 있고 그 매개변수들을 모두 곱한 값을 리턴하는 함수 mul
def mul(*args):
    mul = args[0]
    control = 0
    for i in args:
        if control!=0:
            mul *= i
        else: control =1
    return mul
# 5. 매개변수를 a=?, b=? , c= ?로 받아 a+b*c를 리턴하는 함수 op
def op(**args):
    a = args['a']
    b = args['b']
    c = args['c']
    return a+b*c
# 6. range 함수와 같은 기능을 하는 함수 myRange 함수
def myRange(end,start=0,step=1):
    if start!= 0:
        tmp = start
        start = end
        end = tmp
    tmpList = []
    count = start
    while(True):
        tmpList.append(count)
        if count == end-1:
            break
        count+=step
    return tmpList
# 함수 사용
# 1. printhello 함수를 5번 출력하시오
for i in range(5):
    printhello()
# 2. printlist 함수를 호출하여 다음 리스트를 출력하시오
l1 = [1,2,3,4,5,6,7,8,9,10]
printList(l1)
# 3. add 함수를 호출하여 다음 연산을 하여 결과 값을 출력하시오
n1 = 10
n2 = 20
print(add(n1,n2))
# 4. 키보드에서 변수 5개를 입력받아 mul함수에 매개변수로 넘겨주고 리턴 값을 출력하시오
# 단, 변수를 입력 받을 때 공백 기준으로 한줄로 입력 받기
# 공백 기준으로 문자열을 잘라주는 메서드 split()
# "1 2 3 4".split() -> "1","2","3","4"
# 예시 -> 1 2 3 4 5
a,b,c,d,e = map(int,input("-> ").split())
print(mul(a,b,c,d,e))
# 5. 키보드에서 숫자 3개를 입력 받아 op함수를 호출하여 그 리턴값을 출력
a,b,c = map(int,input('-> ').split())
print(op(a=a,b=b,c=c))
# myRange 함수를 호출하여 1~10 까지 +2 씩 출력하시오 
for i in myRange(1,10,2):
    print(i)