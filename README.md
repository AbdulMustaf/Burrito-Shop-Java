# My Burrito Shop Lab

## Overview
The **My Burrito Shop Lab** project is a Java-based simulation of a burrito shop. The system allows users to manage orders, make burritos, ring out transactions, and handle dirty dishes. The project is interactive, allowing users to perform shop operations using a console-based menu.

---

## Features

### Core Functionalities:
1. **Take a Burrito Order**:
   - Customers can specify the size, protein, rice, beans, toppings, and guacamole preference for their burrito order.
   - Orders are added to a queue for processing.

2. **Make a Burrito Order**:
   - Burritos from the queue are prepared, adding dirty dishes to the dishwashing queue.

3. **Ring Out a Burrito Order**:
   - Charges customers for their burrito orders, calculates the price, and adds the transaction to the sales records.

4. **Wash Next Dish**:
   - Washes a single dirty dish from the queue.

5. **Wash All Dishes**:
   - Washes all dirty dishes in one action.

6. **Close For the Day**:
   - Closes the shop after ensuring there are no pending orders, transactions, or dirty dishes.

---

## How to Run

### Prerequisites:
- **Java Development Kit (JDK)** 8 or later.

### Steps:
1. Clone the repository or copy the source files.
2. Compile the code:
   ```bash
   javac MyBurritoShopLab.java BurritoShop.java BurritoLab4.java
