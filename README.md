Deque with Sentinel Node in Java
===
Welcome to the Deque with Sentinel Node repository! This project showcases a robust implementation of a double-ended queue (deque) using a sentinel node in Java. By employing a sentinel node, this deque efficiently handles edge cases, ensuring smooth insertion and deletion of elements from both ends of the data structure.

Features
---
Double-Ended Queue: Supports efficient insertion and deletion of elements at both the front and back of the deque, making it highly versatile for various applications.
Sentinel Node: Utilizes a sentinel node to simplify boundary conditions, eliminate null checks, and provide a consistent structure for deque operations.
Java Implementation: Written in Java, this implementation leverages object-oriented principles for clean, maintainable, and easily integrable code.
Implementation Details
---
Sentinel Node
The sentinel node acts as a dummy node that simplifies the logic for adding and removing elements. It always points to the first and last elements of the deque, thus avoiding the need for special cases when the deque is empty or has only one element.

Core Methods
Constructor: Initializes an empty deque with a sentinel node that points to itself.
isEmpty(): Checks if the deque is empty.
size(): Returns the number of items in the deque.
addFirst(Item item): Adds an item to the front of the deque.
addLast(Item item): Adds an item to the back of the deque.
removeFirst(): Removes and returns the item from the front of the deque.
removeLast(): Removes and returns the item from the back of the deque.
iterator(): Returns an iterator to iterate over the items in the deque from front to back.
