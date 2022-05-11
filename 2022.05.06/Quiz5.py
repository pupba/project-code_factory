# 문제5
path = './test.txt'
with open(path,'wt') as f:
    while True:
        text = input(">> ")
        if text == "그만" : 
            break
        else : 
            text+="\n"
            f.writelines(text)
file = ""
with open(path,'rt') as f:
    file = f.read()
print(file)
