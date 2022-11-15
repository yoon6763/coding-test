class Human:
    def walk(self):
        print("천천히 걷습니다!")


class Athlete(Human):
    def walk(self):
        print("빠르게 걷습니다")

athlete = Athlete()
athlete.walk()