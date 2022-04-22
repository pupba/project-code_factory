import random
rn = random.randrange(1, 50)
while(True):
    n = int(input(">> "))
    if n == rn:
        print("찾았습니다!")
        break
    elif n > rn:
        print("큽니다.")
    elif n < rn:
        print("작습니다.")
