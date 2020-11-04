package leilao.teste.sistema;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteParticipanteSalvar {
	
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
		browser.get("http://localhost:8080/projeto-leilao/cadastro-participante.html");
		
		WebElement campoNome = browser.findElement(By.name("input-nome"));
		WebElement campoCpf = browser.findElement(By.name("input-cpf"));
		WebElement campoDataNascimento = browser.findElement(By.name("input-data-nascimento"));
		WebElement btnSalvar = browser.findElement(By.name("btn-salva"));
		
		campoNome.sendKeys("Teste Nome");
		campoCpf.sendKeys("Teste CPF");
		campoDataNascimento.sendKeys("27102020");
			
		try {
			
			Thread.sleep(5000);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		btnSalvar.click();
	}
		
}






























