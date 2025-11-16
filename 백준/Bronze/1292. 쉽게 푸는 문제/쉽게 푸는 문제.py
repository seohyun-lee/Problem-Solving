a, b = map(int, input().split())
num = 1
answer = 0
i = 1
for _ in range(1, b+1):
    if i >= b:
        answer += (b-a+1)*num
        break
    if i >= a:
        answer += (i-a+1)*num
        a = i+1
    num += 1
    i += num
print(answer)