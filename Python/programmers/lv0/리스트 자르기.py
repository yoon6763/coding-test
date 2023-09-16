def solution(n, slicer, num_list):
    if n == 1:
        return num_list[:slicer[1] + 1]
    elif n == 2:
        return num_list[slicer[0]:]
    elif n == 3:
        return num_list[slicer[0]:slicer[1] + 1]
    else:
        return num_list[slicer[0]:slicer[1] + 1:slicer[2]]
