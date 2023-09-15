str = input()

for i in range(0, len(str)):
    if str[i].isupper():
        print(str[i].lower(), end='')
    else:
        print(str[i].upper(), end='')
