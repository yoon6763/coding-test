dic = {"kim": 12000, "lee": 11000, "han": 3000, "choi": 5000, "hwang": 18000}

for name, mileage in dic.items():
    print("아이디: {0}, 마일리지: {1}".format(name, mileage))

max_val = max(dic.values())

for key, value in dic.items():
    if max_val == value:
        print("{0}님이 {1}으로 가장 높은 점수입니다".format(key, value))
        break
