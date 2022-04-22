start = int(input("start >>"))
end = int(input("end >>"))
sum = 0
count = 0
for i in range(start, end+1):
    if i % 2 == 0:
        sum += i
        count +=1
print(sum/count)
