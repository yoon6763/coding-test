def solution(command):
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    direction = 0
    x, y = 0, 0

    for cmd in command:
        if cmd == 'L':
            direction = (direction - 1) % 4
        if cmd == 'R':
            direction = (direction + 1) % 4
        if cmd == 'G':
            x = x + dx[direction]
            y = y + dy[direction]
        if cmd == 'B':
            x = x - dx[direction]
            y = y - dy[direction]

    return [x, y]
