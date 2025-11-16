import sys

vowels = set("aeiou")

def is_acceptable(pw: str) -> bool:
    if not any(c in vowels for c in pw):
        return False
    v_cnt = 0
    c_cnt = 0
    prev = ""
    for c in pw:
        if c in vowels:
            v_cnt += 1
            c_cnt = 0
        else:
            c_cnt += 1
            v_cnt = 0
        if v_cnt == 3 or c_cnt == 3:
            return False
        if prev == c and c not in ('e', 'o'):
            return False
        prev = c
    return True

for line in sys.stdin:
    s = line.strip()
    if s == "end":
        break
    if is_acceptable(s):
        print(f"<{s}> is acceptable.")
    else:
        print(f"<{s}> is not acceptable.")
