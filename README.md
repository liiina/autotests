# readme for autotests
1. Скачать проект
2. В классе BaseRunner прописать свои пути к selenium драйверам 
  example:
  System.setProperty("webdriver.chrome.driver", "/Users/lina/selenium drivers/chromedriver"); - для Chrome
  System.setProperty("webdriver.gecko.driver", "/Users/lina/selenium drivers/geckodriver"); - для Firefox
3. Добавить конфигурацию: Add configuration->Maven
  в Command line прописать -Dtest=TinkoffTest -Dbrowser=chrome verify - для запуска тестов в браузере Google Chrome
  или -Dtest=TinkoffTest -Dbrowser=firefox verify - для запуска тестов в браузере Mozilla Firefox
