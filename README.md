# Selenium QA Automation Framework (Smoke Test Suite)

## Overview

This repository contains a **UI test automation framework built with Java, Selenium WebDriver, and TestNG**.
The framework follows the **Page Object Model (POM)** design pattern to improve maintainability, scalability, and readability of UI tests.

It is designed to execute **smoke tests** against a web application and generate HTML test reports with screenshots for failures.

---

## Tech Stack

* **Java**
* **Selenium WebDriver**
* **TestNG**
* **Maven**
* **Page Object Model (POM)**

---

## Project Structure

```
src
 ├── main
 │   └── java/com/ef/smoke
 │        ├── base
 │        │     ├── BasePage.java
 │        │     ├── BaseTest.java
 │        │     └── ConfigReader.java
 │        │
 │        ├── components
 │        │     └── FooterComponent.java
 │        │
 │        ├── pages
 │        │     ├── HomePage.java
 │        │     ├── AboutPage.java
 │        │     ├── ServicesPage.java
 │        │     ├── ResearchPage.java
 │        │     ├── PrivacyPolicyPage.java
 │        │     └── TermsPage.java
 │        │
 │        └── utils
 │
 ├── test
 │   └── java/com/ef/smoke
 │        └── SmokeTests.java
 │
 └── resources
      ├── config.properties
      └── testng.xml

reports
 └── screenshots
      └── SmokeTestReport.html
```

---

## Framework Design

### Base Layer

Contains core framework classes used across tests.

* **BasePage**
  Contains common WebDriver actions used by all page objects.

* **BaseTest**
  Handles test setup and teardown (WebDriver initialization, browser setup).

* **ConfigReader**
  Reads configuration values from `config.properties`.

---

### Page Objects

Located in:

```
src/main/java/com/ef/smoke/pages
```

Each page object represents a page of the application and contains:

* Page locators
* Page actions
* Navigation methods

Example:

```
HomePage
AboutPage
ServicesPage
ResearchPage
```

---

### Components

Reusable UI sections of the site.

Example:

```
FooterComponent.java
```

Components allow reuse of elements shared across multiple pages.

---

### Tests

Located in:

```
src/test/java/com/ef/smoke
```

Example test class:

```
SmokeTests.java
```

These tests verify critical functionality such as:

* Page navigation
* Page loading
* Basic UI validations

---

## Configuration

Framework configuration is stored in:

```
src/test/resources/config.properties
```

Example configuration:

```
base.url=https://example.com
browser=chrome
timeout=10
```

---

## Running Tests

### 1. Clone Repository

```
git clone <repository-url>
cd <project-folder>
```

### 2. Install Dependencies

```
mvn clean install
```

### 3. Run Smoke Tests

```
mvn test
```

or run via TestNG:

```
testng.xml
```

---

## Test Reports

After execution, reports and screenshots are generated in:

```
/reports
```

These reports include:

* Test results
* Execution status
* Failure screenshots

---

## Key Features

* Page Object Model architecture
* Configurable test execution
* Centralized WebDriver management
* Reusable UI components
* Screenshot capture for failures
* Maven-based dependency management

---

## Future Improvements

* Parallel test execution
* CI/CD integration (GitHub Actions / Jenkins)
* Docker-based test execution
* Cross-browser testing support

---

## Author
Navdeep Kaur
QA Automation Framework created as a demonstration of UI automation architecture using Selenium and TestNG.
