def solution(lines):
    answer = 0
    deep = [0] * 202

    for line in lines:
        (start, end) = line

        for i in range(start, end):
            deep[i + 100] += 1

    return sum([1 for i in deep if i > 1])