import sys

class Stack:
    def __init__(self):
        self.items = []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        if not self.is_empty():
            return self.items.pop()
        return -1

    def size(self):
        return len(self.items)

    def is_empty(self):
        return not self.items

    def top(self):
        if not self.is_empty():
            return self.items[-1]
        return -1

def solution():
    n = int(sys.stdin.readline())
    stack = Stack()
    
    for _ in range(n):
        command = sys.stdin.readline().split()
        cmd_type = command[0]
        if cmd_type == '1':
            stack.push(int(command[1]))
        elif cmd_type == '2':
            print(stack.pop())
        elif cmd_type == '3':
            print(stack.size())
        elif cmd_type == '4':
            print(1 if stack.is_empty() else 0)
        elif cmd_type == '5':
            print(stack.top())

if __name__ == "__main__":
    solution()