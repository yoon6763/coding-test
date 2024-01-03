def solution(input_string):
    outsider = set()
    appear = set(input_string[0])
    pre = input_string[0]

    for i in range(1, len(input_string)):
        if pre != input_string[i]:
            if input_string[i] in appear:
                outsider.add(input_string[i])
            else:
                appear.add(input_string[i])
        pre = input_string[i]

    if len(outsider) == 0:
        return "N"
    else:
        return "".join(sorted(list(outsider)))