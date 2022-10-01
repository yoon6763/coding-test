import sys

while(True):
    str = sys.stdin.readline().rstrip()

    if str == '':
        break;

    a,b = map(int,str.split())

    print(a+b)