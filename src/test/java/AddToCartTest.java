import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddToCartTest {
    private WebDriver driver;
    private String path = "src/test/resources/chromedriver/chromedriver.exe";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximizing browser window
    }

    @Test
    public void testAddToCart() {
        // Naviguer vers la page d'accueil
        driver.get("https://ztrain-web.vercel.app/home");

        // Cliquez sur le bouton pour ouvrir la modal du produit
        WebElement productButton = driver.findElement(By.id("style_btn_add_cart__gTXM7"));
        productButton.click();


        // Trouver et cliquer sur le bouton "Ajouter au panier" dans la modal
        WebElement addToCartButtonModal = driver.findElement(By.id("style_btn_add_cart__gTXM7"));
        addToCartButtonModal.click();

        // Attendre que le message de succès s'affiche
        WebElement successMessage = driver.findElement(By.className("ant-notification-notice-success"));
        Assert.assertTrue(successMessage.isDisplayed(), "Le message de succès d'ajout au panier n'est pas affiché.");

        // Fermer la modal
        WebElement closeButton = driver.findElement(By.xpath("//div[@class='ant-notification-notice-success']//button[@class='ant-notification-notice-close']"));
        closeButton.click();

        // Trouver le bouton qui mène au panier sur la page d'accueil et cliquer dessus
        WebElement goToCartButton = driver.findElement(By.id("style_content_cart_wrapper__mqNbf"));
        goToCartButton.click();

        // Vérifier si la modal du panier affiche le produit ajouté
WebElement productNameElement = driver.findElement(By.xpath("//div[@class='style_card_body__EhpLW']//p[@class='style_productName__lrC3N' and text()='Chaise de Burea...']"));
Assert.assertTrue(productNameElement.isDisplayed(), "Le produit ajouté n'est pas affiché dans la modal du panier.");

       
        // Fermer la modal du panier
        WebElement closeCartModalButton = driver.findElement(By.xpath("//div[@class='ant-drawer-body']//button[@aria-label='Fermer']"));
        closeCartModalButton.click();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

