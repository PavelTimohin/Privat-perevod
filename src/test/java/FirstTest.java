import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;



public class FirstTest {
    @Test
    public void firstTest() {
        WebDriverManager.chromedriver().setup();
        Selenide.open("https://next.privat24.ua/money-transfer/card");

        Selenide.$("[class=\"sc-jwKygS bomYeY\"]").sendKeys("4552331448138217");
        Selenide.$("[data-qa-node=\"expiredebitSource\"]").sendKeys("05/24\n" +
                "\n");
        Selenide.$("[data-qa-node=\"cvvdebitSource\"]").sendKeys("926");

        Selenide.$("[data-qa-node=\"numberreceiver\"]").sendKeys("4004159115449003\n" +
                "\n");
        Selenide.$("[data-qa-node=\"amount\"]").sendKeys("123");
        Selenide.$("[class=\"sc-uJMKN dAwRmD\"]").click(); //нажать на выбор валюты
        Selenide.$("[class=\"sc-kafWEX hxoiUA\"]").click();//выбрать USD
        Selenide.$("[class=\"sc-VigVT eHZYiI\"]").click(); //нажать на перевод

//проверка перевода
        Selenide.$$("[data-qa-node=\"payer-card\"]").shouldHave(CollectionCondition.itemWithText("4552 0000 2211 8217"));
        Selenide.$$("[data-qa-node=\"payer-amount\"]").shouldHave(CollectionCondition.itemWithText("123 USD"));
        Selenide.$$("[data-qa-node=\"receiver-card\"]").shouldHave(CollectionCondition.itemWithText("4004 1591 8888 9003"));
        Selenide.$$("[data-qa-node=\"receiver-amount\"]").shouldHave(CollectionCondition.itemWithText("123 USD"));
        Selenide.$$("[data-qa-node=\"payer-currency\"]").shouldHave(CollectionCondition.itemWithText("5.41 USD"));
        Selenide.$$("[data-qa-node=\"receiver-currency\"]").shouldHave(CollectionCondition.itemWithText("0 USD"));
        Selenide.$$("[class=\"total_Gep8WAZQ3T\"]").shouldHave(CollectionCondition.itemWithText("Разом до списання 128.41 USD"));




    }
}