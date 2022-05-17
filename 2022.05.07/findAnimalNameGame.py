animals = """1캥거루 2토끼 3강아지 4고양이 5코알라 6고릴라 7원숭이 8고래 9낙타 10뱀
11물개 12쥐 13소 14말 15돼지 16거북이 17악어 18호랑이 19표범 20치타
21늑대 22여우 23스컹크 24두더지 25돌고래 26도마뱀 27독소리 28바다표범 29가재
30랍스타 31원앙 32까마귀 33오리 34앵무새 35부엉이 36참새 37꾀꼬리 38나비
39잠자리 40이구아나 41카멜레온 42개미핥기 43거미 44잉어 45곰 46펭귄 47거위
48박쥐 49병아리 50닭 51멧돼지 52갈매기 53코뿔소 54사슴 55코끼리 56하마
57다람쥐 58가오리 59미어캣 60코브라 61자라 62두꺼비 63까치 64복어 65문어
66오징어 67쭈꾸미 68해파리 69오리너구리 70너구리 71양 72꿩 73개구리
74메추라기 75살모사 76매미 77하늘소 78매 79망둥어 80말똥구리 81벌 82산양
83비둘기 84풍뎅이 85산양 86딱따구리 87등에 88두루미 89달팽이 90다슬기
91노루 92오솔개 93누에 94아나콘다 95남생이 96뻐꾸기 97낙지 98제비 99사자
100검은꼬리잭토끼"""

import re
n= list(range(1,101))
for i in n:
    animals = re.sub(str(i),"",animals)
animals = re.sub("['0','00']","",animals)

with open('./text.txt','wt') as f:
    f.write(animals)
k = []
with open('./text.txt','rt') as f:
    for i in range(11):
        k+=f.readline().strip().split(" ")
animals = k

#-------------------------------------Animal name data processing------------------------------------------------------------

import random as r

class Game:
    def __init__(self,animals):
        self.animal = animals[r.randint(0,98)]
    def run(self):
        life = 10
        while life > 0:
            if self.animal == input("동물이름 >> "):
                print("맞췄습니다.")
                break
            else : 
                print("힌트! >> '",self.animal[0],"'로 시작합니다.")
                life-=1
                if life ==0:
                    print("정답은 '{}'입니다.".format(self.animal))
                else :
                    print("틀렸습니다.\n 남은 목숨 >> {}".format(life))
            

g = Game(animals)
g.run()
