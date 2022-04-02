# 반복문 연습 퀴즈

# 1~10까지 숫자를 담은 리스트를 만들고 출력하라
print(list(range(1,11)))

# 20 ~ 1 까지 출력하라 단! 한 줄에 숫자 10개씩
lineCount = 0
for i in reversed(range(1,21,1)):
    if lineCount == 10: 
        print("")
        lineCount =0
    print(i,end=" ")
    lineCount+=1
print("")

# 다음 리스트의 숫자들을 정수로 출력하라
l1 = ['1','2','3','4','5','6','7','8','9','10']
# 출력 예시-> 1 2 3 4 5 6 7 8 9 10
for i in map(int,l1):
    print(i, end=" ")
print("")

# l2 , l3 를 묶어서 출력하라
# 출력 -> 안녕 제시, 잘가 톰, 안녕 앨리스, 잘가 밥
l2 = ['안녕','잘가','안녕','잘가']
l3 = ['제시','톰','앨리스','밥']
for a,b in zip(l2,l3):
    print(a,b,end=", ")
print("")

# 다음 코드를 고쳐서 한 줄마다 a를 출력하고 
# a가 2일 때는 출력하지 말고
# a가 5일 때 반복문을 종료 시켜라
# 코드
a = 0
while(True):
    if a==2:
        a+=1
        continue
    elif a==5:
        break
    print(a)
    a+=1