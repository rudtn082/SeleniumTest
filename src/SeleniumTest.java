import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) {
        SeleniumTest selTest = new SeleniumTest();
        selTest.crawl();
    }

    //WebDriver
    //private WebDriver driver;
    public static WebDriver driver;
    private WebElement webElement;

    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String path = System.getProperty("user.dir");
    public static final String WEB_DRIVER_PATH = path + "/src/chromedriver.exe";

    //크롤링 할 URL
    private String base_url;

    public SeleniumTest() {
        super();

        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        //Driver SetUp
        try {
            driver = new ChromeDriver();
            base_url = "https://nid.naver.com/nidlogin.login?mode=form&url=https%3A%2F%2Fwww.naver.com";
        } catch (Exception e) {
            System.out.println(e.toString());
            return;
        }
    }

    public void crawl() {
        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
            driver.get(base_url);

            //iframe으로 구성된 곳은 해당 프레임으로 전환시킨다.
           // driver.switchTo().frame(driver.findElement(By.id("loginForm")));

            //iframe 내부에서 id 필드 탐색
            webElement = driver.findElement(By.id("id"));
            String daum_id ="id";
            webElement.sendKeys(daum_id);

            //iframe 내부에서 pw 필드 탐색
            webElement = driver.findElement(By.id("pw"));
            String daum_pw ="pw";
            webElement.sendKeys(daum_pw);


            //로그인 버튼 클릭
            webElement = driver.findElement(By.xpath("//input[@type='submit']"));
            webElement.click();


            Thread.sleep(20000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
    }
}
