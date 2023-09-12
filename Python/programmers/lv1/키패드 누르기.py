def solution(numbers, hand):
    r = 10
    l = 12
    st = ""
    for i in numbers:
        if i in [1, 4, 7]:
            l = i
            st = st + "L"
        elif i in [3, 6, 9]:
            r = i
            st = st + "R"
        else:
            ix, iy = xy(i)
            lx, ly = xy(l)
            rx, ry = xy(r)


            if distance(rx, ry, ix, iy) < distance(lx, ly, ix, iy):
                r = i
                st = st + "R"
            elif distance(rx, ry, ix, iy) > distance(lx, ly, ix, iy):
                l = i
                st = st + "L"
            else:
                if hand == "right":
                    r = i
                    st = st + "R"
                else:
                    l = i
                    st = st + "L"

    return st

def distance(hx, hy, ix, iy):
    num = abs(hx - ix) + abs(hy - iy)
    return num

def xy(num):
    x = y = 0

    if num == 0:
        y = 3
        x = 1
    elif num <= 3:
        y = 0
        x = num - 1
    elif num <= 6:
        y = 1
        x = num - 3 - 1
    elif num <= 9:
        y = 2
        x = num - 6 - 1
    elif num == 11:
        y = 3
        x = 0
    else:
        y = 3
        x = 2
    return x, y