def getIncline(x1, y1, x2, y2):
    return (y2 - y1) / (x2 - x1)

def solution(dots):
    # (0 - 1) (2 - 3)
    if getIncline(dots[0][0], dots[0][1], dots[1][0], dots[1][1]) == getIncline(dots[2][0], dots[2][1], dots[3][0], dots[3][1]):
        return 1

    # (0 - 2) (1 - 3)
    if getIncline(dots[0][0], dots[0][1], dots[2][0], dots[2][1]) == getIncline(dots[1][0], dots[1][1], dots[3][0], dots[3][1]):
        return 1
    
    # (0 - 3) (1 - 2)
    if getIncline(dots[0][0], dots[0][1], dots[3][0], dots[3][1]) == getIncline(dots[1][0], dots[1][1], dots[2][0], dots[2][1]):
        return 1

    return 0
