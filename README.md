# AdvancedSet
Summary

A Set ADT is a collection of distinct elements, based on the mathematics field of Set Theory.

Design

This Set ADT is written as an interface and implemented with a Sorted Array, Unsorted Array, and Sorted Linked List. The Sorted Array implementation is highly optimized with O(log n) insertion and deletion of elements via a binary search algorithm. Advanced set operations are supported: Union, Intersection, and Complement.

Union

The union method creates a set that contains all unique elements in the current set and parameter set

Intersection

The intersection method creates a set that contains all elements common to the current set and the parameter set.

Complement

The complement method creates a set that contains all elements in the current set but not in the parameter set.
