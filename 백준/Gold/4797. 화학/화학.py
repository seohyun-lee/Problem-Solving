import sys
import re

def solve():
    lines = sys.stdin.readlines()
    for line in lines:
        line = line.strip()
        if not line:
            continue
        stack = [{}]
        i = 0
        n = len(line)
        
        while i < n:
            if line[i] == '(':
                stack.append({})
                i += 1
            elif line[i] == ')':
                i += 1
                start = i
                while i < n and line[i].isdigit():
                    i += 1
                multiplier = int(line[start:i]) if start < i else 1
                
                top = stack.pop()
                for element, count in top.items():
                    stack[-1][element] = stack[-1].get(element, 0) + count * multiplier
            else:
                start = i
                i += 1
                while i < n and line[i].islower():
                    i += 1
                element = line[start:i]
                
                start = i
                while i < n and line[i].isdigit():
                    i += 1
                count = int(line[start:i]) if start < i else 1
                
                stack[-1][element] = stack[-1].get(element, 0) + count
        
        result_dict = stack[0]
        sorted_elements = sorted(result_dict.keys())
        output = []
        for elem in sorted_elements:
            cnt = result_dict[elem]
            if cnt == 1:
                output.append(elem)
            else:
                output.append(f"{cnt}{elem}")
        
        print("+".join(output))
solve()