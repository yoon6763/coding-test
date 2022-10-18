city_list = []

def add_city(city):
    city_list.append(city)


def print_city():
    for city in city_list:
        print("'{0}'".format(city[:3]), end=' ')


while True:
    city = input("도시를 추가하세요 (종료: exit) : ")
    if city == "exit":
        print_city()
        break

    add_city(city)
