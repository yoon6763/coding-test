import random

answer = random.randrange(1, 101)

while True:
    input_n = int(input("숫자를 예측해보세요 (1~100) : "))
    if input_n > answer:
        print("숫자가 낮습니다.")
    elif input_n < answer:
        print("숫자가 높습니다.")
    else:
        print("정답입니다!!")
        break
