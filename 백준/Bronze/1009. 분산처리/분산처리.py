t=int(input())
for i in range(t):
    a,b=map(int, input().split(" "))
    if a%10 == 0:
        print(10)
    else:
        c = b%4;
        if b%4 == 0:
            c = 4
        print((a%10)**c%10)