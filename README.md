# ProducerConsumerSystem
Java console Producer-Consumer system with semaphores and an ASCII terminal dashboard. (COME 361 term project)


# Producer–Consumer (Java)

A console implementation of the classic Producer–Consumer problem using semaphores, with a live ASCII dashboard in the terminal. Made for our Operating Systems course project.

## How it works

- A **Producer** thread creates items and puts them into a shared bounded buffer.
- A **Consumer** thread takes items out of the buffer.
- Synchronization uses three semaphores:
  - `emptySlots`: counts free slots (starts at the buffer capacity)
  - `fullSlots`: counts filled slots (starts at 0)
  - `mutex`: makes sure only one thread touches the buffer at a time
- The ASCII dashboard prints the buffer state after every produce/consume action.

**Default settings:** buffer capacity = 5, total items = 10.

## Project structure

```
.
├── SharedBuffer.java   # bounded buffer + semaphores
├── Producer.java       # producer thread
├── Consumer.java       # consumer thread
├── Main.java           # creates the buffer, starts the threads
└── README.md
```

## Requirements

- JDK 11 or newer (check with `java -version` and `javac -version`)

## Compile

From the project folder:

```bash
javac *.java
```

## Run

```bash
java Main
```

You should see the dashboard update as items are produced and consumed, and the program exits once all 10 items have been consumed.

## Team

| Member | Module |
|--------|----------------|
| Büşra | `Producer.java` |
| Yalda | `Consumer.java` |
| Yağmur | `SharedBuffer.java`|

## Course

Operating Systems, Doğuş University
