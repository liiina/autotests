import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertEquals;

public class TinkoffTest extends BaseRunner {

    @Test
    public void errorMessagesChecking() {
        driver.get(baseUrl);
        driver.findElement(By.name("fio")).click();
        driver.findElement(By.name("fio")).clear();
        driver.findElement(By.name("fio")).sendKeys("1");
        driver.findElement(By.name("fio")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Фамилия, имя и отчество'])[1]/following::div[3]")).click();
        assertEquals("Недостаточно информации. Введите фамилию, имя и отчество через пробел (Например: Иванов Иван Алексеевич)", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Фамилия, имя и отчество'])[1]/following::div[3]")).getText());
        driver.findElement(By.name("phone_mobile")).click();
        driver.findElement(By.name("phone_mobile")).clear();
        driver.findElement(By.name("phone_mobile")).sendKeys("+7(1");
        driver.findElement(By.name("phone_mobile")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Контактный телефон'])[1]/following::div[2]")).click();
        assertEquals("Номер телефона должен состоять из 10 цифр, начиная с кода оператора", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Контактный телефон'])[1]/following::div[2]")).getText());
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("1");
        driver.findElement(By.name("email")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Электронная почта'])[1]/following::div[3]")).click();
        assertEquals("Введите корректный адрес эл. почты", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Электронная почта'])[1]/following::div[3]")).getText());
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Гражданство'])[1]/following::span[1]")).click();
    }

    @Test
    public void googleRedirect() {
        driver.get("https://www.google.com/search?q=%D0%BC%D0%BE%D0%B1%D0%B0%D0%B9%D0%BB+%D1%82%D0%B8%D0%BD%D1%8C%D0%BA%D0%BE%D1%84%D1%84&oq=%D0%BC%D0%BE%D0%B1%D0%B0%D0%B9%D0%BB+%D1%82%D0%B8%D0%BD%D1%8C%D0%BA%D0%BE%D1%84%D1%84&aqs=chrome..69i57j69i61j0l4.7044j0j8&sourceid=chrome&ie=UTF-8");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Похожие запросы'])[1]/following::h3[1]")).click();
        assertEquals("Тарифы Тинькофф Мобайла", driver.getTitle());
        driver.findElement(By.xpath(".//*[@href=\"https://www.tinkoff.ru/mobile-operator/tariffs/\"]"));
        driver.navigate().refresh();
    }

    @Test
    public void equalsMskKrs() {
        driver.get(baseUrl);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Точки продаж'])[1]/following::div[13]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Город'])[1]/following::div[5]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Точки продаж'])[1]/following::div[9]")).click();
        assertEquals("Москва и Московская область", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Точки продаж'])[1]/following::div[13]")).getText());
        driver.navigate().refresh();
        assertEquals("Москва и Московская область", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Точки продаж'])[1]/following::div[13]")).getText());
        String priceMsc = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Общая цена: 316 \u20BD'])[1]/following::h3[1]")).getText();

        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Точки продаж'])[1]/following::div[13]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Краснодарский кр.'])[1]/following::div[2]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Выберите пакеты услуг'])[1]/following::h3[1]")).click();
        String priceKrs = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Общая цена: 296 \u20BD'])[1]/following::h3[1]")).getText();
        assertEquals(priceMsc, priceKrs);
    }

    @Test
    public void buttonPresence() {
        driver.get(baseUrl);
        driver.findElement(By.name("fio")).clear();
        driver.findElement(By.name("fio")).sendKeys("Спирина Лина Сергеевна");
        driver.findElement(By.name("phone_mobile")).click();
        driver.findElement(By.name("phone_mobile")).sendKeys("9200049943");
        driver.findElement(By.cssSelector("svg.LoaderRound__svg__vlZE.LoaderRound__svg_coverParent_omksn")).click();
        assertEquals("Заказать доставку", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Комментарий для представителя'])[1]/following::span[5]")).getText());
    }
}

