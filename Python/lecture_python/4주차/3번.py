class Car:
    def __init__(self, model, color, displacement):
        self.model = model
        self.color = color
        self.displacement = displacement

    def displayCar(self):
        print("모델명 : {0}, 색상 : {1}, 배기량 : {2}cc".format(self.model, self.color, self.displacement))


class ElectronicCar(Car):
    def __init__(self, model, color, batteryType):
        self.model = model
        self.color = color
        self.batteryType = batteryType

    def displayCar(self):
        print("모델명 : {0}, 색상 : {1}, 배터리 타입 : {2}".format(self.model, self.color, self.batteryType))


car = Car("자가용이 자가용", "블랙", 2000)
car.displayCar()

electronicCar = ElectronicCar("전기가 자가용", "화이트", "리튬")
electronicCar.displayCar()
