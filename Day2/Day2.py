lines = []
filename = "test.txt"

with open(filename) as file:
    for line in file:
        line = line.strip()
        lines.append(list(map(int, line.split(" "))))

print(lines)
