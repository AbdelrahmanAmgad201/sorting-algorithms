# Sorting Algorithms Project

## Overview
This project provides a command-line interface for sorting integer arrays using different sorting algorithms. Users can input an array directly or specify a file containing the array. The program then allows the selection of a sorting method, including:

- **O(n²) Sorts**: Bubble Sort
- **O(n log n) Sorts**: Merge Sort, Quick Sort
- **O(n) Sorts**: Counting Sort, Radix Sort (selected automatically based on array characteristics)

## Features
- Input an array manually or load it from a file.
- Choose a sorting algorithm from the menu.
- Automatically selects the optimal O(n) sorting algorithm (Counting Sort or Radix Sort) based on whether `k ≤ 10n`.
- Displays sorting steps if requested.

## Usage

### Input Methods
1. **Manual Entry**: Type the array in a single line, separating elements with commas.
2. **File Input**: Provide a file path containing the array.

### Sorting Options
From the operations menu, choose a sorting algorithm:
- `1` Simple Sort (Bubble Sort)
- `2` Efficient Sort (Merge Sort)
- `3` Efficient Sort (Quick Sort)
- `4` Non-Comparison Sort (Counting Sort or Radix Sort)

### Automatic Selection for O(n) Sorting
- If the range `k` (max value - min value) is `≤ 10n`, the program selects **Counting Sort**.
- Otherwise, it selects **Radix Sort**.

### Example Input
```
3,1,4,1,5,9,2,6,5,3
```



