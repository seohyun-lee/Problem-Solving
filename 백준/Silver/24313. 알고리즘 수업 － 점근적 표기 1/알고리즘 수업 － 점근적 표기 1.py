a1, a0 = input().split()
a1 = int(a1)
a0 = int(a0)
c = int(input())
n0 = int(input())
if a1 > c:
    print(0)
elif a1*n0+a0 <= c*n0:
    print(1)
else:
    print(0)