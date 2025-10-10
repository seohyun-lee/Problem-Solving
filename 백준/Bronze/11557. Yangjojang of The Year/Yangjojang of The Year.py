T = int(input())
for _ in range(T):
    N = int(input())
    max_school, max_drink = "", 0
    for _ in range(N):
        S, L = input().split()
        L = int(L)
        if L > max_drink:
            max_drink = L
            max_school = S
    print(max_school)