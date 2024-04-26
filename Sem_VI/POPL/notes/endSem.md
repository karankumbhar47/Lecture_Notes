
# Memory Layout for Arrays:
    - Arrays are typically stored contiguously in memory.
    - One-dimensional arrays have elements stored consecutively, with possible alignment constraints.
    - Arrays of records may have small holes between consecutive records.
    - Packed arrays have no holes between elements but may have holes within records.
    - Multidimensional arrays can be stored in row-major or column-major order.
        - Row-major: Consecutive memory locations hold elements with a difference of one in the final subscript.
        - Column-major: Consecutive memory locations hold elements with a difference of one in the initial subscript.

**Cached Line**
- A cache line refers to a fixed-size block of contiguous memory in the cache. When data is fetched from main memory into the cache, it is loaded into cache lines. These cache lines are typically much smaller than the total size of the cache but are designed to hold a portion of the data that is frequently accessed or likely to be accessed together.
- Cache Performance:
    -  The choice between row-major and column-major layout affects cache performance.
    -  Cache lines orientation differs for row-major and column-major layouts.
    -  Accessing elements in consecutive memory locations improves cache performance.
    -  Accessing elements across cache lines may lead to frequent cache misses and degrade performance, especially for large arrays.


**OOPS**
- Encapsulation in Java is a fundamental concept in object-oriented programming (OOP) that refers to the bundling of data and methods that operate on that data within a single unit, which is called a class in Java. Java Encapsulation is a way of hiding the implementation details of a class from outside access and only exposing a public interface that can be used to interact with the class.
