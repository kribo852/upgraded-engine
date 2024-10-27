# upgraded-engine
A project that simulates time of a workflow, like in a factory or a process with multiple steps.

To route output work-items, add a list with several handover coworkers to a 
coworker. 

To count items for a finish condition, use a counter. 

To run the example, use ./gradlew run

An example of a flow as a graph:

A -> B
B -> C

C -> D
C -> E
C -> F

D -> Counter
E -> Counter
F -> Counter


