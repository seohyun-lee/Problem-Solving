from collections import deque
T = int(input())
for _ in range(T):
    N, M = map(int, input().split())
    priorities = list(map(int, input().split()))
    queue = deque()
    for i in range(N):
        queue.append((priorities[i], i))
    printed = 0
    while queue:
        cur_priority, cur_index = queue.popleft()
        if any(cur_priority < p for p, _ in queue):
            queue.append((cur_priority, cur_index))
        else:
            printed += 1
            if cur_index == M:
                print(printed)
                break
