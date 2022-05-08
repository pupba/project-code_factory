class Car:
    def __init__(self,speed,boot):
        self.__speed = speed
        self.__boot = boot
    
    def onBoot(self):
        self.__boot = True

    def offBoot(self):
        self.__boot = False
    
    def statusBoot(self):
        print("Now Car's Status ---> ",end=" ")
        if self.__boot == True:
            print("ON")
        else :
            print("OFF")
    
    def getSpeed(self):
        return self.__speed
    
    def setSpeed(self,speed):
        self.__speed = speed
        
car1 = Car(100,True)
print(car1.getSpeed())
car1.setSpeed(200)
print(car1.getSpeed())
car1.statusBoot()
car1.offBoot()
car1.statusBoot()
car1.onBoot()
car1.statusBoot()
