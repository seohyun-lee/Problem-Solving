word = input().strip()
n = len(word)
ans = None
for i in range(1, n-1):
    for j in range(i+1, n):
        candidate = word[:i][::-1] + word[i:j][::-1] + word[j:][::-1]
        if ans is None or candidate < ans:
            ans = candidate
print(ans)