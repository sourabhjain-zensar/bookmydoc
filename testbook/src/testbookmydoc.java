import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class testbookmydoc extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setPlatform(Platform.LINUX);
	    capabilities.setBrowserName("firefox");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://10.44.120.145:8080/bookmydoc/admin_login.jsp");
		driver.findElement(By.name("id")).sendKeys("10000");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("login")).click();
		driver.get("http://10.44.120.145:8080/bookmydoc/create_doc.jsp");
		driver.findElement(By.name("Create Doctor")).click();
		driver.findElement(By.cssSelector("a[href='admin_home.jsp']")).click();
		driver.findElement(By.cssSelector("a[href='logout.jsp']")).click();
		driver.findElement(By.id("login")).click();
	}

}
