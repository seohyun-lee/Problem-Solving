n = int(input().strip())
files = [input().strip() for _ in range(n)]
length = len(files[0])
pattern = []
for i in range(length):
    chars = {f[i] for f in files}
    if len(chars) == 1:
        pattern.append(chars.pop())
    else:
        pattern.append('?')
print(''.join(pattern))