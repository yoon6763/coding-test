f = open('./yesterday.txt', 'rt', encoding='UTF8')

lines = f.readlines()
print(lines)
print('"yesterday.txt"파일 안에는 총 {0}번의 yesterday가 있습니다.'.format(lines.count('yesterday')))
