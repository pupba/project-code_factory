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

class Benz(Car):
    def __init__(self,speed,boot,kind):
        super().__init__(speed,boot)
        self.__kind = kind
    def showKind(self):
        print("This Car is '{}'".format(self.__kind))
        
car = Benz(200,True,"Benz")
print(car.getSpeed(),"km",sep='')
car.setSpeed(1000)
print(car.getSpeed(),"km",sep='')
car.offBoot()
car.statusBoot()
car.showKind()
