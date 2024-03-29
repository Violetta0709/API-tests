# Automated API tests for [reqres.in](https://reqres.in/)

## :white_circle:Content

- [Tools and technologies](#technologist-технологии-и-инструменты)
- [Implemented tests](#bookmark_tabs-реализованные-проверки)
- [Tests launch with terminal](#computer-запуск-тестов-из-терминала)
- [Tests launch with Jenkins](#-запуск-тестов-в-jenkins)
- [Tests result report with Allure Report](#-отчет-о-результатах-тестирования-в-Allure-report)

## :white_circle:Tools and technologies
<p  align="center">

<code><img width="5%" title="IntelliJ IDEA" src="images/Idea.svg"></code>
<code><img width="5%" title="Java" src="images/Java.svg"></code>
<code><img width="5%" title="Selenoid" src="images/RestAssured.svg"></code>
<code><img width="5%" title="Gradle" src="images/Gradle.svg"></code>
<code><img width="5%" title="Junit5" src="images/Junit5.svg"></code>
<code><img width="5%" title="GitHub" src="images/GitHub.svg"></code>
<code><img width="5%" title="Allure Report" src="images/Allure.svg"></code>
<code><img width="5%" title="Allure TestOps" src="images/Allure_TO.svg"></code>
<code><img width="5%" title="Jenkins" src="images/Jenkins.svg"></code>

</p>

## :white_circle:Implemented tests with Pojo and Lombok models, Specifications:

- New user creation
- Successfull registration
- Unsuccessfull registration
- User information update
- Login unsuccessfull

## Test launch with ternminal

### Local test launch

```bash
gradle clean test
```

## :white_circle:Tests run with [Jenkins](https://jenkins.autotests.cloud/job/Rest%20API/)

For test run click on button <code><strong>*Собрать*</strong></code>.

<p align="left">
  <img src="images/jenkins.png" alt="Jenkins" width="800">
</p>

After test run block <code><strong>*История сборок*</strong></code> opposite run number logo
*Allure Report* should appear, after click on it, page with html-report will be opened.

## :white_circle:Report with tests result with [Allure Report](https://jenkins.autotests.cloud/job/Rest%20API/allure/#suites/446f8008c5078c4d93dc274e5355d108)

<p align="left">
  <img src="images/Allure.jpg" alt="allure-report1" width="800">
</p>

<p align="left">
  <img src="images/Allure2.jpg" alt="allure-report" width="800">
</p>


