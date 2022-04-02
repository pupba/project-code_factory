# 조건문 연습 퀴즈

# 다음 print문에서 다음이 나오게 하시오
# print("정답" if condition ==  ? else "떙!")
# 추가 설명 if 조건이 참이면 왼쪽 출력, 거짓이면 else문 다음 것 출력
# 1. "정답"이 나오게하시오
condition = True
print("정답" if condition ==  True else "떙!")
# 2. "땡"이 나오게 하시오
condition = True
print("정답" if condition ==  False else "떙!")

# 다음 식의 오류를 수정하시오
# a1 = 10
# if a1 == 10:
#     print(a1)
# else if a1 == 10:
#     print(a1)
a1 = 10
if a1 == 10:
    print(a1)
elif a1 == 10:
    print(a1)
    
# 다음에 답하시오
food = ['짜장면','탕수육','짬뽕','깐풍기']
# 1. food 리스트에 짜장면이 있는지 찾아라 있다면 "짜장면 좋아"를 출력
if "짜장면" in food : print("짜장면 좋아")
# 2. food 리스트에 치킨이 없는지 확인하라, 없다면 "없음" 출력
if '치킨' not in food : print("없음")
# 3. a2,a3가 같은지 판별하라 같다면 "같다 출력", 다르면 "다름" 출력
a2 = "짜장면"
a3 = "탕수육"
if a2 is a3:
    print("같음")
else :
    print("다름")
# 4. a2,a3가 다른지 판별하라 다르면 "다르다" 출력
if a2 is not a3:
    print("다름")
# 5. a4가 0보다 크고 10보다 작으면 "a4는 0보다 크고 10보다 작다."를 출력
a4 = 5
if 0<a4 and a4 < 10 : print("a4는 0보다 크고 10보다 작다.")