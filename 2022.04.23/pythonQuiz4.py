kinds = ['포유류', '양서류', '파충류']
animal = {}
for kind in kinds:
    tmp = []
    while(True):
        print("stop입력 시 저장 종료")
        name = input(kind+" 동물을 입력해주세요 >> ")
        if name == "stop":
            break
        else:
            tmp.append(name)
    animal[kind] = tmp
for kind in animal.keys():
    for name in animal[kind]:
        print("{}는 {}입니다.".format(name, kind))
