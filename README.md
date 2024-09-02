Basic project to execute backend focused test automation, created using Java, SpringBoot, Cucumber, WebClient and RestAssured.

Run from CucumberTestRunner:
br.dev.ibere.automation.backend.runner.CucumberTestRunner

You can also use the additional VM options:
-ea -Denv=dev -Dspring.profiles.active=dev

After the execution, you can generate Allure Reports (must have the tool installed):
allure generate

If you have a JAVA_HOME error, just set you JAVA_HOME environment variable to match the one used by the project.
