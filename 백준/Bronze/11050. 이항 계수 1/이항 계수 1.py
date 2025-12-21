n, k = map(int, input().split())
sum=1
for i in range(1, k+1):
    sum = (sum * (n+1-i) / i)
print(int(sum))