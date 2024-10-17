# WebServer
A simple web server implementation in Java that includes three types of servers:
1. **Single-threaded server** – handles one client at a time.
2. **Multi-threaded server** – creates a new thread for each client connection.
3. **Thread-pool server** – uses a thread pool to manage client connections efficiently.

## Features
- **Single-threaded Server**: Handles one client request at a time. This server is simple but may become a bottleneck under heavy load.
- **Multi-threaded Server**: A new thread is spawned for each client connection, allowing multiple clients to be served simultaneously.
- **Thread-pool Server**: Manages client connections using a pool of threads, which reduces the overhead of constantly creating and destroying threads.

## Technologies Used
- Java
- Networking (Java Sockets)
- Threading and Concurrency (Executors, Thread Pool)
