
# Practice Automation Testing

This project contains Selenium WebDriver tests for various functionalities on the [Practice Automation](https://practice-automation.com/) website. The tests are written in Java using the TestNG framework and follow the Page Object Model (POM) design pattern.

## Project Structure

- **src/main/java/com/practiceautomation/pages**: Contains Page Object Model (POM) classes for different sections of the website.
- **src/test/java/com/practiceautomation/tests**: Contains TestNG test classes for various functionalities.

## Features Tested

1. **Form Fields**: Tests for filling out and submitting form fields.
2. **Pop-ups**: Tests for handling alerts and confirmation pop-ups.
3. **Calendars**: Tests for selecting dates from calendar widgets.
4. **Modals**: Tests for interacting with simple and form modals.
5. **Tables**: Tests for extracting and validating data from tables.
6. **Window Operations**: Tests for handling multiple browser windows.
7. **File Upload and Download**: Tests for uploading and downloading files.
8. **IFrames**: Tests for interacting with elements within iframes.
9. **Sliders**: Tests for moving sliders to a specific position.

## Prerequisites

- Java JDK 8 or higher
- Maven
- IntelliJ IDEA (or any other IDE supporting Maven projects)
- Google Chrome (or any other supported browser)

## Setup

1. **Clone the repository:**

   ```sh
   git clone https://github.com/yourusername/practice-automation.git
   cd practice-automation
   ```

2. **Install dependencies:**

   ```sh
   mvn clean install
   ```

3. **Run tests:**

   You can run the tests using Maven:

   ```sh
   mvn test
   ```

   Or you can use the built-in test runner in your IDE.

## Reporting

TestNG generates HTML reports by default, which can be found in the `test-output` directory after running the tests.

## Contributing

Feel free to fork the repository and contribute by submitting a pull request. For major changes, please open an issue first to discuss what you would like to change.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

