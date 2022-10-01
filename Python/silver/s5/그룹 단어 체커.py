num = int(input())

cnt = 0
for i in range(num):
    st = list(input())

    pnt = 0
    for k in range(len(st)-1):
        if st[pnt] == st[pnt + 1]:
            del st[pnt]
            pnt = pnt - 1
        pnt = pnt + 1

    check = False

    for k in range(len(st)):
        st2 = st[k+1:]
        if st[k] in st2:
            check = True
            break;

    if check == False:
        cnt = cnt + 1

print(cnt)