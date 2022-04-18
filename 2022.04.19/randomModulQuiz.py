import random
n = int(input("정수를 입력하세요 >> "))
if n >= 0:
    sum = 0
    for i in range(n):
        sum += random.randrange(0, 100)
    if 0 <= sum and sum <= 10:
        print("작네요")
    elif 11 <= sum and sum <= 50:
        print("보통이네요.")
    elif 51 <= sum:
        print("크네요")
else:
    print("양수를 입력해주세요!")
