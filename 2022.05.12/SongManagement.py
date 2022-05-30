from itertools import count


class Song:
    def __init__(self,name,artist,year):
        self.__name = name
        self.__artist = artist
        self.__year = year
    def getName(self):
        return self.__name
    def getArtist(self):
        return self.__artist
    def getYear(self):
        return self.__year

class SongManagement:
    def __init__(self):
        self.__SongList = []
    def add(self):
        self.__SongList.append(Song(input("title: "),input("artist: "),input("year: ")))
    def delete(self,title):
        for i in self.__SongList:
            if i.getName() == title:
                idx = self.__SongList.index(i)
                del self.__SongList[idx]
                
    def chanage(self,title):
        for i in self.__SongList:
            if i.getName() == title:
                idx = self.__SongList.index(i)
                self.__SongList[idx] = Song(input("title: "),input("artist: "),input("year: "))
    def count(self):
        print("저장된 노래의 개수는 {}개 입니다.".format(len(self.__SongList)))
    def showAll(self):
        for song in self.__SongList:
            print("{} - {}, {}".format(song.getName(),song.getArtist(),song.getYear()))
    
    def run(self):
        while True:
            print("1. 추가")
            print("2. 삭제")
            print("3. 변경")
            print("4. 개수")
            print("5. 전체 보기")
            print("6. 종료")
            pick = int(input("숫자를 입력하세요 >> "))
            if pick == 1:
                self.add()
            elif pick == 2:
                self.delete(input("삭제할 곡 명"))
            elif pick == 3:
                self.change(input("바꿀 곡 명"))
            elif pick == 4:
                self.count()
            elif pick == 5:
                self.showAll()
            elif pick == 6:
                print("종료")
                break
            else :
                print("잘못 입력하셨습니다.")

app = SongManagement()

app.run()
