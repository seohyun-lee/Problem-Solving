import sys

case_num = 1
while True:
    line = sys.stdin.readline().rstrip()
    if '-' in line:
        break
    stack = []
    count = 0
    for char in line:
        if char == '{':
            stack.append('{')
        else:
            if stack:
                stack.pop()
            else:
                count += 1
                stack.append('{')
    count += len(stack) // 2
    print(f"{case_num}. {count}")
    case_num += 1