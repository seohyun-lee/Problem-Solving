N, M = map(int, input().split())

sequence = []

def backtrack(depth):
    if depth == M:
        print(' '.join(map(str, sequence)))
        return
    for i in range(1, N+1):
        sequence.append(i)
        backtrack(depth+1)
        sequence.pop()

backtrack(0)
