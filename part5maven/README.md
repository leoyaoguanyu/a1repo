\# Part 5 (Maven) — Test Coverage \& AI (JaCoCo)



This folder contains the \*\*Task 5\*\* Maven project for SFWRENG 3S03 Assignment 1.



\## Project Structure

\- `src/main/java/com/example/shop/` — production code (shop system)

\- `src/test/java/com/example/shop/` — JUnit 5 test suite

\- `pom.xml` — Maven configuration (JUnit + JaCoCo)



\## Running the Project in Eclipse 



If you are using Eclipse:



\### Import the Maven Project

\- File → Import

\- Maven → Existing Maven Projects

\- Select the `part5maven` folder

\- Click Finish



\### Run Tests

Option A:

\- Right-click `part5maven`

\- Run As → Maven test



Option B:

\- Right-click any test class

\- Run As → JUnit Test



\### Generate JaCoCo Coverage Report

Right-click `part5maven` →

Run As → Maven build →

In Goals field enter:



&nbsp;   clean test jacoco:report



Click Run.



\### View Coverage Report

After the build finishes, open:



&nbsp;   part5maven/target/site/jacoco/index.html



Right-click the file →

Open With → Web Browser



This will display the full HTML coverage report.

