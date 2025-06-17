# 🚀 Selenium Automation Framework

This Selenium automation project is built using a **Hybrid Framework**, integrating multiple best practices and design patterns to ensure flexibility, maintainability, and efficiency in test automation.

---

## 📌 Key Features and Components

### ✅ 1. Framework Type
- Implemented a **Hybrid Framework** combining:
  - **Page Object Model (POM)**
  - **Data-Driven Testing**
  
---

### 🧪 2. TestNG Integration
- Used `testng.xml` for:
  - Suite and test configuration
  - Grouping tests
  - Managing cross-browser execution
- Enabled **parallel execution** for faster test runs.

---

### 🧩 3. Design Patterns
- **Page Object Model (POM):** For separating test logic and UI interaction.
- **Factory Design Pattern:** Used `PageFactory` for initializing web elements and enhancing abstraction.

---

### 🌐 4. Cross-Browser Testing
- Supported browsers:
  - **Chrome**
  - **Firefox**
  - **Edge**
- Browser selection handled through parameters in `testng.xml`.

---

### 📊 5. Reporting
- Integrated **ChainTest**  for generating detailed and interactive test reports.
- Reports include:
  - Pass/fail status
  - Execution time
  - Screenshots on failure

---

### 📝 6. Logging
- Integrated **Log4j2** for:
  - Real-time logging of execution flow
  - Capturing errors and exceptions
  - Categorized log files with timestamps
