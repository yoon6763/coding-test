import sys
input = sys.stdin.readline

N, M = map(int, input().split())
box = list(map(int, input().split()))
book = list(map(int, input().split()))

print(sum(box) - sum(book))