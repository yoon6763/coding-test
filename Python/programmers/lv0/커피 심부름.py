def solution(order):
    ans = 0
    for menu in order:
        if menu == 'icecafelatte' or menu == 'cafelatteice' or menu == 'hotcafelatte' or menu == 'cafelattehot' or menu == 'cafelatte':
            ans += 5000
        else:
            ans += 4500

    return ans