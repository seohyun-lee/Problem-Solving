N = int(input())
points = []
for _ in range(N):
    x, y = map(int, input().split())
    points.append((x, y))
points.sort()
for x, y in points:
    print(x, y)
