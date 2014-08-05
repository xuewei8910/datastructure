datastructure
=============

Heap vs Stack
=============

Stack

very fast access
don't have to explicitly de-allocate variables
space is managed efficiently by CPU, memory will not become fragmented
local variables only
limit on stack size (OS-dependent)
variables cannot be resized

Heap

variables can be accessed globally
no limit on memory size
(relatively) slower access
no guaranteed efficient use of space, memory may become fragmented over time as blocks of memory are allocated, then freed
you must manage memory (you're in charge of allocating and freeing variables)
variables can be resized

Processes vs Threads
===================

A process is an executing instance of an application.

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
