def solution(board, k):
    ans = 0
    for i in range(0, len(board)):
        for j in range(0, len(board[i])):
            if i + j <= k:
                ans += board[i][j]
    return ans