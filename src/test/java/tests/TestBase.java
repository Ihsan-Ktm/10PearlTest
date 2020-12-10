package tests;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import static com.codeborne.selenide.Selenide.*;

public class TestBase {
	
	static Properties prop = new Properties();
			
	public TestBase() {
		
		try {
			FileInputStream file = new FileInputStream("./src/test/resources/demoQA.properties");
			prop.load(file);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();				
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initilizeDemoqa() throws InterruptedException {
		open(prop.getProperty("demoQaUrl"));
		Thread.sleep(5000);
	}
}

