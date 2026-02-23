# SST28-LLD101: SOLID Principles Refactoring

Comprehensive refactoring of 6 low-level design exercises following SOLID principles.

## Repository Structure

```
SST28-LLD101/
└── SOLID/
    ├── ex01/src/     # SRP: Student Onboarding
    ├── ex02/src/     # SRP: Cafeteria Billing
    ├── ex03/src/     # OCP: Placement Eligibility
    ├── ex04/src/     # OCP: Hostel Fee Calculator
    ├── ex05/src/     # LSP: File Exporter
    ├── ex06/src/     # LSP: Notification Sender
    └── README.md
```

## Exercises

### Ex01 — SRP: Student Onboarding Registration
- **Demo:** `Demo01.java`
- **Refactoring:** Separated parsing, validation, persistence, and output concerns
- **Components:** InputParser, StudentValidator, StudentRepository (interface), RegistrationOutputHandler

### Ex02 — SRP: Campus Cafeteria Billing
- **Demo:** `Demo02.java`
- **Refactoring:** Extracted tax and discount logic into pluggable policies
- **Components:** TaxPolicy, DiscountPolicy, InvoicePrinter, InvoiceRepository

### Ex03 — OCP: Placement Eligibility Rules Engine
- **Demo:** `Demo03.java`
- **Refactoring:** Replaced if-else chain with rule pattern
- **Components:** EligibilityRule interface with DisciplinaryRule, CgrRule, AttendanceRule, CreditsRule

### Ex04 — OCP: Hostel Fee Calculator
- **Demo:** `Demo04.java`
- **Refactoring:** Removed switch-case statements using strategy pattern
- **Components:** RoomPricingStrategy, AddOnPricingStrategy, RoomTypeFactory

### Ex05 — LSP: File Exporter Hierarchy
- **Demo:** `Demo05.java`
- **Refactoring:** Enforced substitutability with ExportException contract
- **Components:** Exporter (contract-based), PdfExporter, CsvExporter, JsonExporter

### Ex06 — LSP: Notification Sender Inheritance
- **Demo:** `Demo06.java`
- **Refactoring:** Defined clear contract with proper exception handling
- **Components:** NotificationSender, EmailSender, SmsSender, WhatsAppSender

## How to Compile and Run

Each example can be compiled and run independently:

```bash
# Example 1
cd SOLID/ex01/src
javac *.java
java Demo01

# Example 2
cd ../../ex02/src
javac *.java
java Demo02

# ... (repeat for ex03 through ex06)
```

## SOLID Principles Applied

- **S**ingle Responsibility Principle (Ex01, Ex02)
- **O**pen/Closed Principle (Ex03, Ex04)
- **L**iskov Substitution Principle (Ex05, Ex06)
- **I**nterface Segregation Principle (Throughout)
- **D**ependency Inversion Principle (Throughout)

## Code Quality

✅ No external libraries  
✅ Default package structure  
✅ Natural, production-ready code  
✅ Full SOLID compliance  
✅ All original behavior preserved  
✅ Compile and run ready  

## Author Notes

All refactoring was done independently to achieve clean, maintainable code that follows SOLID principles while preserving the original behavior. Each exercise demonstrates practical application of design patterns and OOP principles.
