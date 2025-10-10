import sys
sys.setrecursionlimit(100000)

def ccw(a, b, c):
    return (b[0]-a[0])*(c[1]-a[1]) - (b[1]-a[1])*(c[0]-a[0])

def intersect(a1, a2, b1, b2):
    ab = ccw(a1, a2, b1) * ccw(a1, a2, b2)
    cd = ccw(b1, b2, a1) * ccw(b1, b2, a2)
    if ab == 0 and cd == 0:
        if a1 > a2: a1, a2 = a2, a1
        if b1 > b2: b1, b2 = b2, b1
        return a1 <= b2 and a2 >= b1
    return ab <= 0 and cd <= 0

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a, b = find(a), find(b)
    if a != b:
        parent[b] = a

def solution():
    global parent
    input = sys.stdin.readline
    T = int(input())
    polylines = []
    for _ in range(T):
        N = int(input())
        points = [tuple(map(int, input().split())) for _ in range(N)]
        if len(points) == 1:
            points.append(points[0])
        polylines.append(points)

    parent = [i for i in range(T)]

    for i in range(T):
        for j in range(i + 1, T):
            connected = False
            for k in range(1, len(polylines[i])):
                for l in range(1, len(polylines[j])):
                    if intersect(polylines[i][k-1], polylines[i][k],
                                 polylines[j][l-1], polylines[j][l]):
                        connected = True
                        break
                if connected:
                    break
            if connected:
                union(i, j)

    groups = set(find(i) for i in range(T))
    return len(groups)

print(solution())