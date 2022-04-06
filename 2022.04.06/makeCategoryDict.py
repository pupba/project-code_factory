# 카테고리 별 리스트 만들기
# ex) label : 동물
# 개, 고양이, 사자, 토끼
label = input("Label --> ")
data=[]
stop = 0
while(True):
    control = input("\"Do you want to stop input -> -1\"\nex "+label+"-> ")
    if control == "-1":
        break
    else: # append in list
        data.append(control)
dict = {label:list(set(data))}
print(dict)
