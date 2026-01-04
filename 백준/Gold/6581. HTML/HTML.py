import sys

tokens = sys.stdin.read().split()
out = []
cur = []
cur_len = 0

for tok in tokens:
    if tok == "<br>":
        out.append(" ".join(cur))
        cur = []
        cur_len = 0

    elif tok == "<hr>":
        if cur:
            out.append(" ".join(cur))
            cur = []
            cur_len = 0
        out.append("-" * 80)

    else:
        wlen = len(tok)
        if not cur:
            cur = [tok]
            cur_len = wlen
        else:
            if cur_len + 1 + wlen <= 80:
                cur.append(tok)
                cur_len += 1 + wlen
            else:
                out.append(" ".join(cur))
                cur = [tok]
                cur_len = wlen

if cur:
    out.append(" ".join(cur))

sys.stdout.write("\n".join(out) + "\n")
