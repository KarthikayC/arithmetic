# Infinite Precision Calculator in Java

A Java library for infinite-precision arithmetic on integers and floating-point numbers, capable of handling values that exceed the limits of Java's built-in numeric types.

## Overview

This library provides classes and methods to perform arithmetic operations (addition, subtraction, multiplication, and division) on numbers of arbitrary size and precision.

It is particularly useful when standard Java types (`int`, `long`, `float`, `double`) are insufficient due to overflow or rounding errors. Numbers are stored and operated on as `Strings`, and all calculations are done manually, digit-by-digit, simulating how a human would perform them.

## Features

- Arbitrary length integer arithmetic using the `AInteger` class
- Arbitrary length and precision floating-point arithmetic using the `AFloat` class
- Support for negative numbers
- CLI utility (`MyInfArith`)
- Python wrapper script (`codeRunner.py`)
- The aarithmetic.jar library which can be linked to any executable/library.

## Why This?

Standard Java types have limits:

| Type   | Min Value                        | Max Value                         |
|--------|----------------------------------|-----------------------------------|
| int    | -2,147,483,648                   | 2,147,483,647                     |
| long   | -9,223,372,036,854,775,808       | 9,223,372,036,854,775,807         |
| float  | ~1.4 × 10⁻⁴⁵                     | ~3.4 × 10³⁸                       |
| double | ~4.9 × 10⁻³²⁴                    | ~1.8 × 10³⁰⁸                      |

This library goes beyond these limits, enabling safe computation with any number size.

## Components

### AInteger

- Handles integer arithmetic
- Internally stores the number as a `String`
- Supports:
  - Addition
  - Subtraction
  - Multiplication
  - Division (integer division)
- Negative numbers fully supported

### AFloat

- Handles floating-point arithmetic
- Stores numbers as `String`, including integer and fractional parts together
- Supports:
  - Addition
  - Subtraction
  - Multiplication (with upto 30 digits precision)
  - Division (with upto 30 digits precision)
- Negative numbers fully supported

## Implementation

- Language: Java 23
- Build Tool: Ant
- Structure:
  - The source files are located in the `arbitraryarithmetic/` directory, namely AInteger.java and AFloat.java and aarithmetic.jar
  - The `build.xml`, `MyInfArith` and `codeRunner.py` files are located in the main repository

## Build and Execution

### How to build the package (.JAR):

- Execute - `ant clean` followed by `ant`

### Executing via MyInfArith:

- Compile - `javac MyInfArith.java`
- Execute - `java MyInfArith <int/float> <add/sub/mul/div> <operand1> <operand2>`

### Executing via codeRunner.py:

- Execute - `python codeRunner.py <int/float> <add/sub/mul/div> <operand1> <operand2>`

### Executing via aarbitraryarithmetic.jar:

- Compile - `javac -cp .:<add the absolute path to the .jar package here> <relative path to your desired file>`
- Execute - `java -cp .:<absolute path to .jar package> <relative path to your file>`

## Conclusion

### Key Learnings

- Learned how to represent and perform arithmetic on integers and floats without relying on primitive types, by storing values as strings and operating on them digit-wise.
- Gained experience in managing special cases such as negative numbers, zero handling, carry/borrow logic, and decimal alignment in floating-point operations.
- Became familiar with Java build tools such as Apache Ant and how to structure a project for clean builds and packaging into JAR files.
- Explored how to create Python wrapper scripts to streamline usage and testing of Java programs from the command line.

### Verification Approach

- A large number of test cases were manually designed and executed to verify correctness.
- Outputs were verified both by visual inspection and through automated comparison scripts to ensure correctness.

  
### Limitations

- Operations are performed digit-by-digit using strings, making them significantly slower than native types or optimized libraries.
- Some logic is duplicated across methods, especially for trimming zeros and aligning numbers.
- The logic for handling signs and zero edge cases is written separately for each operation.
- Extremely large inputs (~10^25 digits long) results in long wait-time (~10 minutes) for output. (Only for division and multiplication)
