# GitHub Submission Guide

## Your GitHub Repository Setup Instructions

Since the repository is already connected to another account, follow these steps to submit your own copy:

### Option 1: Create a New Repository (Recommended)

1. **Create a new repository on GitHub:**
   - Go to https://github.com/new
   - Repository name: `SST28-LLD101`
   - Description: "SOLID Principles Refactoring - Ex01-Ex06"
   - Choose Public (to allow viewing)
   - Click "Create repository"

2. **Update your local repository remote:**
   ```powershell
   cd C:\Users\Admin\Desktop\SST28-LLD101
   git remote remove origin
   git remote add origin https://github.com/YOUR_USERNAME/SST28-LLD101.git
   git branch -M main
   git push -u origin main
   ```
   Replace `YOUR_USERNAME` with your actual GitHub username.

3. **Verify the push:**
   ```powershell
   git remote -v
   git log --oneline -1
   ```

### Option 2: Fork the Existing Repository

1. **Go to:** https://github.com/kshitijmishra23/SST28-LLD101
2. **Click "Fork"** in the top-right corner
3. **Update your local remote:**
   ```powershell
   cd C:\Users\Admin\Desktop\SST28-LLD101
   git remote remove origin
   git remote add origin https://github.com/YOUR_USERNAME/SST28-LLD101.git
   git push -u origin main
   ```

## Submission Checklist

✅ **Repository Structure:**
```
SST28-LLD101/
├── SOLID/
│   ├── Ex1/src/     → Demo01.java + other files
│   ├── Ex2/src/     → Demo02.java + other files
│   ├── Ex3/src/     → Demo03.java + other files
│   ├── Ex4/src/     → Demo04.java + other files
│   ├── Ex5/src/     → Demo05.java + other files
│   ├── Ex6/src/     → Demo06.java + other files
└── README.md
```

✅ **Compilation Verification:**
For each exercise, verify it compiles:
```powershell
cd SOLID/Ex1/src
javac *.java
java Demo01
```

✅ **GitHub Settings:**
- Repository is PUBLIC
- README.md is present in root
- All source files (.java) are committed
- Demo01.java through Demo06.java are present

## What's Included in Your Submission

### Ex01 — SRP: Student Onboarding
- Components: InputParser, StudentValidator, StudentRepository, RegistrationOutputHandler
- Key Refactor: Separated concerns (parsing, validation, persistence, output)

### Ex02 — SRP: Cafeteria Billing  
- Components: TaxPolicy, DiscountPolicy, InvoicePrinter, InvoiceRepository
- Key Refactor: Extracted tax and discount logic into pluggable implementations

### Ex03 — OCP: Placement Eligibility
- Components: EligibilityRule interface with 4 concrete rules
- Key Refactor: Replaced if-else chain with rule-based composition

### Ex04 — OCP: Hostel Fee Calculator
- Components: RoomPricingStrategy, AddOnPricingStrategy, RoomTypeFactory
- Key Refactor: Removed switch-case statements using strategy pattern

### Ex05 — LSP: File Exporter Hierarchy
- Components: Exporter (contract-based), PdfExporter, CsvExporter, JsonExporter
- Key Refactor: Enforced substitutability with consistent exception handling

### Ex06 — LSP: Notification Sender Inheritance
- Components: NotificationSender, EmailSender, SmsSender, WhatsAppSender
- Key Refactor: Defined clear contract with proper validation and exception handling

## Final Submission

Once you've pushed to your GitHub repository, submit the link in the format:
```
https://github.com/YOUR_USERNAME/SST28-LLD101
```

All 6 exercises are included with:
- ✅ Full SOLID compliance
- ✅ Compile-ready source code
- ✅ Original behavior preserved
- ✅ Demo01.java through Demo06.java entry points
- ✅ No external libraries
- ✅ Complete documentation
