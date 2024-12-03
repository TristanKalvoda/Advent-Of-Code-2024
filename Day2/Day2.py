from collections import Counter

lines = []
filename = "Day2/day2Input.txt"
thresholdMin = 1
thresholdMax = 3
results = []

def is_safe(line):
    safe = True
    increasing = False
    decreasing = False
    for j in range (len(lines[i])-1):
        # Any two adjacent levels differ by at least one and at most three.
        if abs(lines[i][j] - lines[i][j+1]) > thresholdMax:
            results.append("Unsafe")
            safe = False
            return False
        
        if abs(lines[i][j] - lines[i][j+1]) < thresholdMin:
            results.append("Unsafe")
            safe = False
            return False

        # Check if the levels are either all increasing or all decreasing
        if lines[i][j] < lines[i][j + 1]:
            increasing = True
        elif lines[i][j] > lines[i][j + 1]:
            decreasing = True
        
        # If both increasing and decreasing conditions are true, it's "unsafe"
        if increasing and decreasing:
            results.append("Unsafe")
            safe = False
            return False
    if safe:
        results.append("Safe")

with open(filename) as file:
    for line in file:
        line = line.strip()
        lines.append(list(map(int, line.split(" "))))

us = 0
for i in range(len(lines)):
    if is_safe(i) == False:
        us =+ 1

print(us)


print(Counter(results))