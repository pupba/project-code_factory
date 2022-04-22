import random
n = int(input(" >> "))
sum = 0
count = 0
for i in range(n):
    rn = random.randrange(1, 51)
    if rn % 2 != 0:
        print(rn)
        sum += rn
        count += 1
print(sum/count)
