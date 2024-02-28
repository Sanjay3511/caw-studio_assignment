# Automated Test Instructions

This repository contains an automated test script written in Java using Selenium and TestNG. The script performs the following steps:

1. Navigates to a specified URL.
2. Clicks on the "Table Data" button to display an input text box.
3. Inserts predefined JSON data into the input text box.
4. Clicks on the "Refresh Table" button.
5. Populates the entered data into the table.
6. Asserts that the data stored matches the data populated in the UI table.

## Pre-requisites

Before running the automated test, ensure you have the following installed:

- Java Development Kit (JDK)
- Maven
- WebDriver compatible with your browser (ChromeDriver, GeckoDriver, etc.)

## Running the Test

Follow these steps to run the automated test:

1. Clone this repository to your local machine:

    ```bash
    git clone https://github.com/Sanjay3511/caw-studio_assignment.git
    ```

2. Navigate to the project directory:

    ```bash
    cd repository
    ```

3. Build the project using Maven:

    ```bash
    mvn clean install
    ```

4. Execute the test using Maven:

    ```bash
    mvn test
    ```

5. After the test execution is complete, view the test results in the console or in the TestNG report generated at `test-output/index.html`.

## Customization

- You can customize the URL, JSON data, and any other parameters in the test script located at `src/main/resources/data.json`.
- Modify the TestNG assertion to suit your specific requirements.
