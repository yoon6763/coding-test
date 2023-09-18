import sys

# 책의 개수, 책의 더미 개수
n, k = map(int, sys.stdin.readline().rstrip().split())

for i in range(k):
    sys.stdin.readline() # 책 더미를 입력받지만 쓸 곳은 없으므로 그냥 입력만 받고 넘어감

    books = list(map(int, sys.stdin.readline().rstrip().split()))

    if books != sorted(books, reverse=True):
        print("No")
        exit(0)

print("Yes")