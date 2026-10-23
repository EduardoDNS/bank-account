# Bank Account

A Java console application for practicing object-oriented programming and the design of banking-related business rules.

> **Learning project:** this repository is still being developed. The items listed as planned improvements are not necessarily implemented yet. This project is not intended for real financial transactions.

## Learning goals

- Model domain concepts such as `Account` and `Client`.
- Separate domain models from services that coordinate operations.
- Practice encapsulation, constructors, and package organization.
- Add validation to operations that affect account balances and credit limits.
- Build confidence with automated tests and, later, data persistence.

## Project structure

src/
└── main/
    └── java/
        ├── application/
        │   └── Main.java
        ├── model/
        │   ├── Account.java
        │   └── Client.java
        └── service/
            └── AccountService.java

## Planned functionality

- Create and retrieve accounts.
- Deposit and withdraw money.
- Transfer funds between accounts.
- Track the available loan limit.

The console menu and some business rules still need work before all of these operations can be considered fully implemented.

## Requirements

- A Java Development Kit (JDK).
- A Java IDE, or a terminal with `javac` and `java` available.

The exact Java version and build/run commands should be documented after they have been verified against the project's current configuration.

## Roadmap

- [ ] Fix the argument order used when creating accounts.
- [ ] Complete the interactive menu and connect it to the service layer.
- [ ] Prevent unvalidated direct changes to account balances and credit limits.
- [ ] Use `BigDecimal` for monetary values.
- [ ] Add unit tests for successful operations and invalid scenarios.
- [ ] Document verified compilation and execution commands.
- [ ] Learn SQL and introduce persistence in a later iteration.

## Project status

This is an educational project focused on Java fundamentals and incremental improvement. It is not production banking software and must not be used to handle real money.
