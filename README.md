datastructure
=============

Heap vs Stack
=============

In a multi-threaded application, each thread will have its own stack. But, all the different threads will share the heap

object can be stored on the stack. If you create an object inside a function without using the “new” operator then this will create and store the object on the stack, and not on the heap.

Once a function call runs to completion, any data on the stack created specifically for that function call will automatically be deleted. Any data on the heap will remain there until it’s manually deleted by the programmer.

The stack is set to a fixed size, size of the heap is managed by the operating system

The stack is much faster than the heap


Processes vs Threads
===================

1. Threads are easier to create than processes since they
don't require a separate address space.

2. Multithreading requires careful programming since threads
share data strucures that should only be modified by one thread
at a time.  Unlike threads, processes don't share the same
address space.

3.  Threads are considered lightweight because they use far
less resources than processes.

4.  Processes are independent of each other.  Threads, since they
share the same address space are interdependent, so caution
must be taken so that different threads don't step on each other.
This is really another way of stating #2 above.

5.  A process can consist of multiple threads.

Dynamic Binding
================
1. Static binding in Java occurs during Compile time while Dynamic binding occurs during Runtime.

2. private, final and static methods and variables uses static binding and bonded by compiler while virtual methods are
bonded during runtime based upon runtime object.

3. Static binding uses Type(Class in Java)  information for binding while Dynamic binding uses Object to resolve binding.

3. Overloaded methods are bonded using static binding while overridden methods are bonded using dynamic binding at
runtime. Here is an example which will help you to understand both static and dynamic binding in Java.

Generic
========================
generic programming is a style of computer programming in which algorithms are written in terms of types to-be-specified-later that are then instantiated when needed for specific types provided as parameters.

Permits writing common functions or types that differ only in the set of types on which they operate when used, thus reducing duplication;

Stronger type checks at compile time to ensure type-safty.
Enabling programmers to implement generic algorithms.

Polymorphism
=====================
one name, many forms

OOP Principle
=====================
Encapsulation
Hide unnecessary details in our classes and provide a clear and simple interface for working with them.

Inheritance
Class hierarchies improve code readability and enable the reuse of functionality.

Abstraction
We will learn how to work through abstractions: to deal with objects considering their important characteristics and ignore all other details.

Polymorphism
Work in the same manner with different objects, which define a specific implementation of some abstract behavior.