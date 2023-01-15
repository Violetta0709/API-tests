# Automated API tests for [reqres.in](https://reqres.in/)

##	Content

- [Tools and technologies](#technologist-технологии-и-инструменты)
- [Implemented tests](#bookmark_tabs-реализованные-проверки)
- [Tests launch with terminal](#computer-запуск-тестов-из-терминала)
- [Tests launch with Jenkins](#-запуск-тестов-в-jenkins)
- [Tests result report with Allure Report](#-отчет-о-результатах-тестирования-в-Allure-report)

## Tools and technologies
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

## Implemented tests with Pojo and Lombok models, Specifications:

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

## <img width="4%" title="Jenkins" src="images/Jenkins.svg"> Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/Rest%20API/)

For test run need to click on button <code><strong>*Собрать*</strong></code>.

<p align="left">
  <img src="images/jenkins.png" alt="Jenkins" width="800">
</p>

After test run block <code><strong>*История сборок*</strong></code> opposite run number logo
*Allure Report* should appear, after click on it, page with html-report will be opened.

## <img width="4%" title="Allure Report" src="images/Allure.jpg"> Report with tests result with [Allure Report](https://jenkins.autotests.cloud/job/tmaksyutov_diplom_api/allure/)

<p align="left">
  <img src="images/screenshot/allure-report1.png" alt="allure-report1" width="900">
</p>

<p align="left">
  <img src="images/screenshot/allure-report.png" alt="allure-report" width="900">
</p>


