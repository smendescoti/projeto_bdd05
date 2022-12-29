package br.com.cotiinformatica;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

import br.com.cotiinformatica.utils.WebDriverUtil;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class CriarContaStepDefinitions {

	WebDriver driver;
	Faker faker = new Faker(new Locale("pt-BR"));
	
	@Dado("Acessar a página de criação de conta")
	public void acessar_a_página_de_criação_de_conta() {

		driver = WebDriverUtil.getInstance();
		driver.manage().window().maximize();
		driver.get("http://usuariosweb.s3-website-us-east-1.amazonaws.com/criar-conta");
	}

	@Dado("Informar o nome do usuário")
	public void informar_o_nome_do_usuário() {

		String nome = faker.name().fullName();
		
		WebElement element = driver.findElement(By.xpath("/html/body/app-root/div/app-criar-conta/div/div/div[1]/div/form/div[1]/input"));
		element.clear();
		element.sendKeys(nome);
	}

	@Dado("Informar o email do usuário")
	public void informar_o_email_do_usuário() {

		String email = faker.internet().emailAddress();
		
		WebElement element = driver.findElement(By.xpath("/html/body/app-root/div/app-criar-conta/div/div/div[1]/div/form/div[2]/input"));
		element.clear();
		element.sendKeys(email);
	}

	@Dado("Informar a senha do usuário")
	public void informar_a_senha_do_usuário() {

		String senha = faker.internet().password();
		
		WebElement element = driver.findElement(By.xpath("/html/body/app-root/div/app-criar-conta/div/div/div[1]/div/form/div[3]/input"));
		element.clear();
		element.sendKeys(senha);
		
		element = driver.findElement(By.xpath("/html/body/app-root/div/app-criar-conta/div/div/div[1]/div/form/div[4]/input"));
		element.clear();
		element.sendKeys(senha);
	}

	@Quando("Solicitar a criação da conta")
	public void solicitar_a_criação_da_conta() {

		WebElement element = driver.findElement(By.xpath("/html/body/app-root/div/app-criar-conta/div/div/div[1]/div/form/div[5]/input"));
		element.click();
		
		try {
			Thread.sleep(3000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Então("Sistema realiza o cadastro da conta com sucesso")
	public void sistema_realiza_o_cadastro_da_conta_com_sucesso() {

		WebElement element = driver.findElement(By.xpath("/html/body/app-root/div/app-criar-conta/div/div/div[1]/div/div[2]/strong"));
		assertEquals("Conta de usuário cadastrada com sucesso.", element.getText());
		
		try {
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File("Criação de conta com sucesso.png"));		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
