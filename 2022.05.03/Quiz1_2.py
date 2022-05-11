# 문제1
animalList = list()
while True:
    animal = input("동물 이름 >> ")
    if animal == "그만":
        break
    else :
        animalList.appned(animal)
animalTuple = tuple(animalList)

# 문제2
animalDic = dict()
for idx,animal in enumerate(animalTuple):
    animalDic[idx] = animal
