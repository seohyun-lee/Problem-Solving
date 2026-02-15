k = int(input().strip())
signs = input().split()

def ok(a, b, sign):
    if sign == '<':
        return a < b
    else:
        return a > b

def func(desc=False):
    visited = [False] * 10
    path = [0] * (k + 1)
    answer = None

    def dfs(idx):
        nonlocal answer
        if answer is not None:
            return
        if idx == k + 1:
            answer = ''.join(map(str, path))
            return
        nums = range(9, -1, -1) if desc else range(10)
        for d in nums:
            if visited[d]:
                continue
            if idx > 0 and not ok(path[idx - 1], d, signs[idx - 1]):
                continue
            visited[d] = True
            path[idx] = d
            dfs(idx + 1)
            visited[d] = False
    dfs(0)
    return answer

max_ans = func(desc=True)
min_ans = func(desc=False)
print(max_ans)
print(min_ans)
