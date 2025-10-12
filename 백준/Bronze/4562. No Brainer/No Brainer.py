n = int(input())
for _ in range(n):
    x, y = map(int, input().split())
    if x >= y:
        print("MMM BRAINS")
    else:
        print("NO BRAINS")