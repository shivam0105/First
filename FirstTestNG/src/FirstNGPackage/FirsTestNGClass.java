package FirstNGPackage;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class FirsTestNGClass {
	static String driverPath = "C:/Users/DELL PC/Desktop/chromedriver_win32/chromedriver.exe";
	String baseUrl="http://newtours.demoaut.com/mercuryregister.php";
	public WebDriver driver = new ChromeDriver();
	
	static{
		System.setProperty("webdriver.chrome.driver", driverPath);
	}
	
  @Test(priority=1)
  public void f() {
	  
	  
	  
	  driver.get(baseUrl);
	  
	 
	  
	  String expected="Register: Mercury Tours";
	  String actual=driver.getTitle();
	  System.out.println(driver.getTitle());
	  
	  Assert.assertEquals(expected, actual);
	  
  }
  @Test (priority=2)
  public void Register() {
	  String First_Name = "" ;
		
		try{
		//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
		String dburl ="jdbc:oracle:thin:@localhost:1521:orcl";
		//Database Username
		String userName="SYSTEM";
		//Database Password
		String password="Shreya13";
		//Query to Execute
		String query="select * from Credentials";
		
		//Load mysql jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Create Connection to DB
		Connection con = DriverManager.getConnection(dburl,userName,password);
		//Create Statement Object
		Statement stmt = con.createStatement();//you need to choose the correct package from  the suggestion because there may be a case when multiple packages can contain same class like in Statement class case so I chose package of sql rather than java beans package here
		// Execute the SQL Query. Store results in ResultSet
		ResultSet rs = stmt.executeQuery(query);
		
		// While Loop to iterate through all data and print results
		while(rs.next()){
			 First_Name = rs.getString(2);
			driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input")).sendKeys(First_Name);
			String Last_Name = rs.getString(3);
			driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td[2]/input")).sendKeys(Last_Name);
			String Phone = rs.getString(4);
			driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/input ")).sendKeys(Phone);
			String Email = rs.getString(5);
			driver.findElement(By.xpath("//*[@id='userName']")).sendKeys(Email);
			
			String Address = rs.getString(6);
			driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/input")).sendKeys(Address);
			String City = rs.getString(7);
			driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/input")).sendKeys(City);
			String State = rs.getString(8);
			driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/input")).sendKeys(State);
			String Postal_Code = rs.getString(9);
			driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[11]/td[2]/input")).sendKeys(Postal_Code);
			String Country = rs.getString(10);
			driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[12]/td[2]/select")).sendKeys(Country);
			String User_Name = rs.getString(11);
			driver.findElement(By.xpath("//*[@id='email']")).sendKeys(User_Name);
			String Password = rs.getString(12);
			driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[15]/td[2]/input")).sendKeys(Password);
			driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[16]/td[2]/input")).sendKeys(Password);
			//System.out.println(First_Name+" "+Last_Name);
		}
		
		// closing DB Connection
		con.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[18]/td/input")).click();
		
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'"+First_Name+"')]"));//this list will iterate through all texts present on the page and search for the string you have passed in he xpath in contains
		Assert.assertTrue("Text not found",list.size()>0);
	
  }
  
  @AfterClass
  public void after()
  {
	  driver.close();
  }
}
