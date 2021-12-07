# complexity-of-sorting-algorithms
## Description
This program helps to compare of theoretical asymptotics of sorting algorithms with measurement results. You can plot graph for time dependence on array size. Also, remarkably, you can modify [Run.java](https://github.com/Veepro/complexity-of-sorting-algorithms/blob/main/src/main/java/Run.java) for testing others algorithms.

### Sorting algorithms comparison table

| Name           | Best             | Average          | Worst            | Memory  | Stable |
|----------------|------------------|------------------|------------------|---------|-------:|
| Quicksort      | O(nlogn)         | O(nlogn)         | O(n<sup>2</sup>) | O(logn) | No     |
| Insertion sort | O(n)             | O(n<sup>2</sup>) | O(n<sup>2</sup>) | O(1)    | Yes    |
| Selection sort | O(n<sup>2</sup>) | O(n<sup>2</sup>) | O(n<sup>2</sup>) | O(1)    | No     |
| Bubble sort    | O(n)             | O(n<sup>2</sup>) | O(n<sup>2</sup>) | O(1)    | Yes    |
| Heapsort       | O(nlogn)         | O(nlogn)         | O(nlogn)         | O(1)    | No     |

## List of technologies used:
- Swing (graphical interface)
- [XChart](https://github.com/knowm/XChart) (plotting)
- Maven

## Conclusion
To build graphs with correct scale lower size input data for slow algorithms and enlarge for fast algorithms.
