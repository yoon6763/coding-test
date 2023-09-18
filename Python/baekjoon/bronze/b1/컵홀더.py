n = int(input())
line = input()
llCount = line.count("LL") - 1
if llCount < 0: llCount = 0

print(n - llCount)
