# SeleniumFramework By Vijender Raika

## Overview
This framework is a simple, organized Selenium Java automation suite designed so anyone can understand and find code quickly.
It uses a clear package hierarchy and naming structure to separate responsibilities, which makes it easy to locate any class by its role.

Key features:
- Page Object Model (`pages`) for page locators and page actions
- Config-driven browser/environment selection (`config` and `src/test/resources`)
- Thread-safe `ThreadLocal<WebDriver>` execution in base setup
- Reusable helper utilities for waits, JavaScript, screenshots, reporting, and data access
- TestNG with groups, retries, and listener support
- Clean package hierarchy so developers can find classes by function

## Framework Hierarchy (How to Find Things)
Use this package structure as a map:
- `src/main/java/base` - core framework classes such as driver initialization, test base, and common utilities
- `src/main/java/config` - configuration reader and environment loader
- `src/main/java/constants` - reusable constant values for the framework
- `src/main/java/pages` - page object classes with locators and page-level actions
- `src/main/java/objectRepository` - page locators separated by page or section
- `src/main/java/services` - business flow helpers and reusable service methods
- `src/main/java/utils` - small utility helpers for waits, JavaScript execution, screenshots, file reading, and reporting
- `src/main/java/listeners` - TestNG listeners, retry logic, and reporting hooks
- `src/test/java/tests` - actual TestNG test classes and test scenarios
- `src/test/resources` - environment config files, test data, and property files

## Why This Hierarchy Helps
- If you need browser setup, look in `base`
- If you need a page locator, look in `pages` or `objectRepository`
- If you need environment values, look in `config` and `src/test/resources`
- If you need test logic, look in `tests`
- If you need reusable helpers, look in `utils` and `services`

## Setup
1. Install JDK 17 or later.
2. Install Maven.
3. Open the project root in your IDE.
4. Verify `src/test/resources/config.properties` contains the desired default values.

## Run Commands
Run all tests:
```bash
mvn clean test
```
Run a specific environment using system properties:
```bash
mvn clean test -Denv=qa -Dbrowser=chrome -Dheadless=false
```
Run only smoke tests:
```bash
mvn clean test -Denv=qa -Dbrowser=chrome -Dheadless=false -Dgroups=smoke
```
Run with Maven profile:
```bash
mvn clean test -Pqa -Dbrowser=chrome -Dheadless=false
```

## Notes
- Screenshots are stored in `target/screenshots`
- Logs are written to `logs/framework.log`
- Default environment files are under `src/test/resources`
- TestNG configuration is managed in `testng.xml`
