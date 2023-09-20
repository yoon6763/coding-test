def solution(keyinput, board):
    n = board[0] // 2
    m = board[1] // 2
    x = 0
    y = 0

    for key in keyinput:
        if key == 'up' and y != m:
            y += 1
        elif key == 'down' and y != -m:
            y -= 1
        elif key == 'left' and x != -n:
            x -= 1
        elif key == 'right' and x != n:
            x += 1

    return [x, y]
