package br.com.cotiinformatica;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.cotiinformatica.utils.WebDriverUtil;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class AcessarContaStepDefinitions {

	WebDriver driver;

	@Dado("Acessar a página de autenticação do sistema")
	public void acessar_a_página_de_autenticação_do_sistema() {

		driver = WebDriverUtil.getInstance();
		driver.manage().window().maximize();
		driver.get("http://usuariosweb.s3-website-us-east-1.amazonaws.com/acessar-conta");
	}

	@Dado("Informar o email {string}")
	public void informar_o_email(String email) {

		WebElement element = driver.findElement(By.xpath("/html/body/app-root/div/app-acessar-conta/div/div/div[1]/div/form/div[1]/input"));
		element.clear();
		element.sendKeys(email);
	}

	@Dado("Informar a senha {string}")
	public void informar_a_senha(String senha) {

		WebElement element = driver.findElement(By.xpath("/html/body/app-root/div/app-acessar-conta/div/div/div[1]/div/form/div[2]/input"));
		element.clear();
		element.sendKeys(senha);
	}

	@Quando("Solicitar a realização do acesso")
	public void solicitar_a_realização_do_acesso() {

		WebElement element = driver.findElement(By.xpath("/html/body/app-root/div/app-acessar-conta/div/div/div[1]/div/form/div[3]/input"));
		element.click();
		
		try {
			Thread.sleep(3000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Então("Sistema realiza a autenticação com sucesso")
	public void sistema_realiza_a_autenticação_com_sucesso() {

		assertEquals("http://usuariosweb.s3-website-us-east-1.amazonaws.com/dados-usuario", driver.getCurrentUrl());
		
		try {
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File("Acessar conta com sucesso.png"));		
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
	}

	@Então("Sistema informa que o acesso é negado")
	public void sistema_informa_que_o_acesso_é_negado() {

		WebElement element = driver.findElement(By.xpath("/html/body/app-root/div/app-acessar-conta/div/div/div[1]/div/div[2]/strong"));
		assertEquals("Usuário não encontrado. Acesso negado.", element.getText());
		
		try {
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File("Acesso negado.png"));		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
