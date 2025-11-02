🧵 Multithreaded Producer–Consumer (Thread Synchronization in Java)
📘 Overview

This project demonstrates the Producer–Consumer problem using multithreading and thread synchronization in Java.
It shows how multiple threads can work together to produce and consume data efficiently while preventing race conditions and maintaining data consistency.
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🎯 Purpose

To understand and implement thread synchronization concepts using wait(), notify(), and synchronized methods in Java, ensuring proper coordination between producer and consumer threads.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🧩 Scope

This project helps explore concurrent programming, thread communication, and synchronization mechanisms that are essential in real-world applications like task scheduling, buffering, and data sharing.
--------------------------------------------------------------------------------------------------------------------------------------
⚙️ Technologies Used

Language: Java

Concepts: Multithreading, Thread Synchronization, Inter-thread Communication

IDE: (e.g., IntelliJ IDEA / Eclipse / VS Code )
------------------------------------------------------------------------------------------------------------------------------------------
🧠 Key Concepts

Thread Creation using Thread or Runnable interface

Shared Resource (Buffer) Handling

Synchronization using synchronized keyword

Inter-thread Communication with wait() and notify()
-----------------------------------------------------------------------------------------------------------------------------------------------
🧾 Code Explanation

The producer thread adds data to a shared buffer, and the consumer thread removes it.
Synchronization ensures that:

Producer waits when the buffer is full.

Consumer waits when the buffer is empty.
This coordination avoids data loss and inconsistency.
------------------------------------------------------------------------------------------------------------------------------------------------
🚀 How to Run

Clone the repository

git clone https://github.com/<your-username>/<repo-name>.git

-------------------------------------------------------------------------------------------------------------------------------------------------
Open the project in your preferred IDE

Compile and run the main file:

javac Main.java  
java Main
----------------------------------------------------------------------------------------------------------------------------------------------------
📊 Sample Output
Produced: 1  
Produced: 2  
Consumed: 1  
Produced: 3  
Consumed: 2  
Consumed: 3  
