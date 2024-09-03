# **Linked List**
## **Theory**

#### What is a Linked List
- In Array, values are stored in contiguous memory locations. Array is easy to traverse, but we cannot increase or decrease size.
- This is where a Linked List comes into the picture.
- Linked List is not stored in contiguous memory locations. They are stored in heap memory and their size can be increased and decreased anytime.
- With every data, the `next` value is stored.
- Starting point of Linked List is called as `head`.
- The `next` value of the last element(also called as `tail`)  is `null`.
- When a new value is to be stored
    - Add the value somewhere in the heap.
    - Update the `next` value of last element to the location of the new value.

#### Where is it used?
- In Data Structures, Linked List is used in Stacks and Queue.
- In real life, we use it in browser.

#### Struct/Class in C++ Java
```c++
int x =2;
int* y = &x;
cout<<y;
```
- Creates `x` somewhere in the heap memory and stores 2.
- Stores the memory location of `x` in `y`.