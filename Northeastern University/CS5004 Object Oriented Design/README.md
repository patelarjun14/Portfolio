# CS5004 Object-Oriented Design

In this course, you will find six different assignments (assignments 4-9) that showcase Arjun's capabilities in Java and object-oriented design. Additionally, you may review the midterm, final exam, and labs to gain a better understanding of Arjun's proficiency. Below, Arjun has provided a summary of his assignments:

## Assignment 4

### Problem 1: Implementing CourseCatalog

**Objective:** Implement a mutable course catalog (ADT) for a university course registration system.

**Key Operations:**
- Add, remove, check existence, find index, count, and more.

**Implementation:**
- Interface-based ADT, equals, hashCode, and immutability.

**Constraints:**
- No built-in Java collections allowed, except for arrays.

### Problem 2: Design and Implementation of a Queue

**Objective:** Create a FIFO queue with operations like add, remove, check emptiness, and more.

**Key Operations:**
- Create, add, remove, check existence, and size.

**Implementation:**
- equals, hashCode, and immutability.

**Constraints:**
- No built-in Java collections allowed, except for arrays.

**Skills Highlighted:**
- ADTs, Object-Oriented Design, Immutable Data Structures.
- Method Implementation, Thorough Testing, UML Diagrams.
- Java Programming Proficiency.

---

## Assignment 5

### Problem 1: Donation Tracking System for Non-Profits

**Objective:** Create a system to track donations for non-profit organizations.

**Donation Types:**
- One-time donations, monthly donations, pledges.

**NonProfit Class:**
- Tracks organization name and all donations.
- getTotalDonationsForYear: Calculate the total donations for a specified year.
- Handling future donation types without modifying the NonProfit class.

### Problem 2: Library Catalog System

**Objective:** Develop a system to manage a library's collection of books and music.

**Item Information:**
- Creator (individual or group), title, release year.

**Creators:**
- Authors, Recording Artists, Bands.

**Items:**
- Books (with Authors), Music (with Recording Artists or Bands).

**Catalog Class:**
- Stores and manages the collection.
- Search Methods: Keyword search, author search, artist search.

**Skills Highlighted:**
- Object-Oriented Design.
- Overloading and Polymorphism.
- Date Handling (LocalDateTime).
- Search Functionality Implementation.
- Future-Proofing for New Donation Types or Item Categories.

---

## Assignment 6

### Problem 1: Immutable Priority Queue (PQ) Implementation

**Objective:** Create an immutable Priority Queue (PQ) data structure.

**Priority Queue Elements:**
- Each element has a priority (integer) and a value (string).

**Supported Operations:**
- createEmpty, isEmpty, add, peek, pop.

**Handling Equal Priorities:**
- Handle situations where multiple elements have the same priority.

**Underlying Data Structure:**
- Recursive implementation.

### Problem 2: Bag-of-Words Model (BagOfWords) Implementation

**Objective:** Develop an immutable Bag-of-Words model data structure.

**Bag-of-Words Elements:**
- Holds strings (words) with duplicates and no word order.

**Supported Operations:**
- emptyBagOfWords, isEmpty, size, add, contains.

**Equality Check:**
- Implement equals considering the order of words doesn't matter.

**Underlying Data Structure:**
- Recursive implementation.

**Skills Highlighted:**
- Recursive Data Structure Implementation.
- Immutable Data Structure Design.
- Priority Queue Handling with Equal Priorities.
- Multiset Handling in Bag-of-Words Model.
- Testing of ADTs.

---

## Assignment 7

### Problem: Generic Form Input Validation and Processing

**Objective:** Create a generic class for form fields and implement various input validators.

**GitHub Collaboration:**
- Use GitHub branches for group collaboration.

**Field Class Features:**
- label, value, required, validator.

**UpdateValue(input):**
- Update field's value if input is valid.

**isFilled():**
- Determine if the field is filled based on requirements.

**Validators:**
- Password Validator: Minimum/maximum length, lowercase/uppercase letters, digits, no spaces.
- Phone Validator: Digits only, specific length.
- Number Validator: Numeric format, min/max values, decimal places.
- FreeText Validator: Max lines and characters per line.
- RadioButton Validator: Boolean (not null).
- CheckBox Validator: Boolean (can be null).

**Generics:**
- Implement generic classes for Field and Validators.

**Use Java's Character class for password validation.**

**Skills Highlighted:**
- Generic Class Implementation.
- Input Validation for Various Field Types.
- Collaboration using GitHub Branches.
- Form Field Handling and Validation.
- Inheritance in Design.

---

## Assignment 8

### Problem: Insurance Company Communication Automation

**Objective:** Create a program to automate communication with customers about a data breach.

**Command Line Interface:**
- Accept command line arguments for generating email and letter messages.

**Input Data:**
- Read client information from a CSV file and generate personalized messages.

**Template Processing:**
- Replace placeholders in email and letter templates with client-specific data.

**Valid Combinations:**
- Enforce valid combinations of command line arguments.

**Error Handling:**
- Provide informative error messages for invalid inputs.

**Flexibility:**
- Accommodate any CSV file and template structure.

**Testing:**
- Write test classes for program components.

**Javadoc:**
- Document classes and methods.

**UML Diagram:**
- Provide a UML class diagram for the program design.

**Skills Highlighted:**
- Command Line Argument Parsing.
- CSV File Parsing.
- Text Template Processing.
- Error Handling and Validation.
- File I/O in Java.
- Design Documentation (UML Class Diagram).
- Testing Java Programs.

---

## Assignment 9

### Problem: TODO Application

**Objective:** Build a command-line TODO application with improved modularity and design patterns.

**Code Reuse:**
- Reuse relevant code from Assignment 8 for command-line parsing and file reading/writing.

**CSV File Format:**
- The CSV file has 6 columns: id, text, completed, due, priority, and category.

**Todo Data Structure:**
- A Todo consists of text, completed status, due date, priority, and category. Some fields are optional.

**Functionality:**
- The system must support adding new todos, completing todos, and displaying todos.

**Modularity:**
- Design the application with improved modularity.

**MV* Architecture:**
- Implement a design pattern to achieve separation of concerns.

**Sortable Custom Objects:**
- Implement sorting for todos.

**Design Patterns:**
- Use design patterns to solve common problems.

**Testing:**
- Write test classes for program components.

**Javadoc:**
- Document classes and methods.

**Design Patterns Description:**
- Include a brief write-up of the design pattern(s) used, where, and why.

**Skills Highlighted:**
- Refactoring and Modularity.
- MV* Architecture (e.g., MVC or MVP).
- Design Patterns (e.g., Observer, Factory, Singleton).
- Sorting in Java.
- Code Reuse and Extensibility.
- Testing Java Programs.
