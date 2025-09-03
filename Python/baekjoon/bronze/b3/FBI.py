l = [input() for _ in range(5)]

t = ''
for i in range(len(l)):
    s = l[i]

    if s.find('FBI') >= 0:
        t += str(i + 1) + ' '

t = t.strip()

print('HE GOT AWAY!' if t == '' else t)
