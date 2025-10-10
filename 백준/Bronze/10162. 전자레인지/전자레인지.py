T = int(input())
A, B, C = 300, 60, 10
if T % 10 != 0:
    print(-1)
else:
    a = T // A
    T %= A
    b = T // B
    T %= B
    c = T // C
    print(a, b, c)