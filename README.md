# data-structures-and-algorithms
This repo contains various code challenges from Code Fellows 301 JavaScript course as well as data structures and algorithims challenges from the Code Fellows 401 Java class.

# 301 JavaScript
all 301 JavaScript code challenges are within the code challenges/301 [folder](code-challenges/301)

# 401 Java Table of Contents
This table is organized by which day of class each challenge was assigned
1. [Array Reverse](401/src/main/java/ArrayReverse.java) - [Challenge Documentation](#array-reverse)
1. [Array Shift](401/src/main/java/ArrayShift.java) - [Challenge Documentation](#array-shift)


# 401 Challenge Documentation

## Array Reverse


### Challenge
Write a function that takes an array as an argument and returns an array that is the reverse of the original.

### Approach and Efficiency
The approach used for this challenge was using nested for loops to start from the end of the array and move one item to it's reveresed position each iteration. I'm not sure how to calculate efficiency based on Big O yet.

### Solution
![whiteboard solution image](401/assets/array_reverse.jpg)

## Array Shift


### Challenge
Write a function that takes an array and a value as arguments. It should return an array with the new value at the middle index

### Approach and Efficiency
The approach for this challenge was to take all the values in the original array before it's middle and add them to a new array that had a length 1 greater than the original, then insert the new value at the middle index, followed by taking the rest of the values in the original array and adding them to the new array at an index 1 higher than they were in the original. This approach could probably be more efficient, however with only limited knowledge of arrays in Java, this was the only workable idea I wound up with.

### Solution
![whiteboard solution image](401/assets/array_shift.jpg)
