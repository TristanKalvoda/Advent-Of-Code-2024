from collections import Counter

lines = []
filename = "Day2/day2Input.txt"
thresholdMin = 1
thresholdMax = 3
results = []

def is_safe(line):
    increasing = False
    decreasing = False
    for j in range(len(line) - 1):
        # Any two adjacent levels differ by at least one and at most three.
        if abs(line[j] - line[j + 1]) > thresholdMax or abs(line[j] - line[j + 1]) < thresholdMin:
            return False

        # Check if the levels are either all increasing or all decreasing
        if line[j] < line[j + 1]:
            increasing = True
        elif line[j] > line[j + 1]:
            decreasing = True
        
        # If both increasing and decreasing conditions are true, it's "unsafe"
        if increasing and decreasing:
            return False
    return True

with open(filename) as file:
    for line in file:
        line = line.strip()
        lines.append(list(map(int, line.split(" "))))

# Process each line and check if removing any level makes it safe
for i in range(len(lines)):
    original_line = lines[i]
    safe = False

    # Check if the original line is safe
    if is_safe(original_line):
        results.append("Safe")
        continue

    for j in range(len(original_line)):
        modified_line = original_line[:j] + original_line[j+1:]
        if is_safe(modified_line):
            safe = True
            break
    if safe: 
        results.append("Safe")
    else:
        results.append("Unsafe")
        
print(Counter(results))