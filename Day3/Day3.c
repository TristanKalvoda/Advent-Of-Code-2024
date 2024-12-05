#include <stdio.h>
#include <stdlib.h>
#include <regex.h>

int main() {
    char filename[] = "Day3/day3Input.txt";
    FILE *fptr;
    char line[8192];
    regex_t regex;
    regmatch_t matches[3]; // Match structure for the whole pattern and two numbers

    // Compile Regex for the pattern "mul(X,Y)" where X and Y are 1-3 digits
    if (regcomp(&regex, "mul\\(([0-9]{1,3}),([0-9]{1,3})\\)", REG_EXTENDED) != 0) {
        perror("Regex Compilation Failure!");
        return 1;
    }

    // Open a file in read mode
    fptr = fopen(filename, "r");
    if (fptr == NULL) {
        perror("Error opening file\n");
        return 1;
    }

    int totalSum = 0;

    // Read the file line by line
    while (fgets(line, sizeof(line), fptr)) {
        // Scan the line for any valid "mul(X,Y)" patterns
        char *line_ptr = line; // pointer to the current position in the line
        while (regexec(&regex, line_ptr, 3, matches, 0) == 0) {
            // Extract the two numbers (X and Y)
            int num1 = atoi(&line_ptr[matches[1].rm_so]);
            int num2 = atoi(&line_ptr[matches[2].rm_so]);
            
            // Multiply and add to the sum
            totalSum += num1 * num2;
            
            // Move the pointer to the next part of the line after the current match
            line_ptr += matches[0].rm_eo;
        }
    }
    
    // Close File
    fclose(fptr);

    // Print finakl sum
    printf("Total sum of all multiplications: %d\n",totalSum);

    // Free the regex memory
    regfree(&regex);

    return 0;
}