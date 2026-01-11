s = input().rstrip()
bomb = input().rstrip()
m = len(bomb)
last = bomb[-1]
stack = []
for ch in s:
    stack.append(ch)
    if ch == last and len(stack) >= m:
        if ''.join(stack[-m:]) == bomb:
            del stack[-m:]
result = ''.join(stack)
print(result if result else "FRULA")