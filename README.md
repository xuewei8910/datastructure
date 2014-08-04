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