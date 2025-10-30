def draw_star(n):
    if n == 3:
        return ["***", "* *", "***"]

    stars = draw_star(n // 3)
    pattern = []

    for s in stars:
        pattern.append(s * 3)
    for s in stars:
        pattern.append(s + " " * (n // 3) + s)
    for s in stars:
        pattern.append(s * 3)

    return pattern


n = int(input())
print("\n".join(draw_star(n)))
