line = ''
for _ in range(2 * int(input()) - 1):
    line += input()
print(eval(line.replace('/', '//')))
