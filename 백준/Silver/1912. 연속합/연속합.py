n = int(input())
arr = list(map(int, input().split()))
current = arr[0]
answer = arr[0]
for i in range(1, n):
    current = max(arr[i], current + arr[i])
    answer = max(answer, current)
print(answer)
