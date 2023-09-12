def solution(strings, n):
    strings = sorted(sorted(strings), key=lambda strings: strings[n])
    return strings