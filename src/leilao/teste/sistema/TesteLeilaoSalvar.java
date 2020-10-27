package leilao.teste.sistema;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLeilaoSalvar {

	private WebDriver browser;
		
	@Before
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		
		browser = new ChromeDriver();
	}
	
	@After
	public void end() {
		browser.close();
	}
	
	@Test
	public void salvarParticipante() {
		browser.get("http://localhost:8080/projeto-leilao/cadastro-leilao.html");
		
		WebElement descricao = browser.findElement(By.name("input-descricao"));
		WebElement dataCriacao = browser.findElement(By.name("input-data-criacao"));
		WebElement valorInicial = browser.findElement(By.name("input-valor-inicial"));
		WebElement situacao = browser.findElement(By.name("situacao"));
		WebElement btnSalvar = browser.findElement(By.name("btn-salva"));
		
		descricao.sendKeys("Teste Descricao");
		dataCriacao.sendKeys("Teste DataCriacao");
		valorInicial.sendKeys("300");
		situacao = browser.findElement(By.name("situacao"));
			
		try {
			
			Thread.sleep(5000);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		btnSalvar.click();
	}
	
	
	
}
