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

public class RecuperarSenhaStepDefinitions {

	WebDriver driver;
	
	@Dado("Acessar a página de recuperação de senha")
	public void acessar_a_página_de_recuperação_de_senha() {

		driver = WebDriverUtil.getInstance();
		driver.manage().window().maximize();
		driver.get("http://usuariosweb.s3-website-us-east-1.amazonaws.com/recuperar-senha");
	}

	@Dado("Informar o email atual {string}")
	public void informar_o_email_atual(String emailAtual) {

		WebElement element = driver.findElement(By.xpath("/html/body/app-root/div/app-recuperar-senha/div/div/div[1]/div/form/div[1]/input"));
		element.clear();
		element.sendKeys(emailAtual);
	}

	@Quando("Confirmar a recuperação da senha")
	public void confirmar_a_recuperação_da_senha() {

		WebElement element = driver.findElement(By.xpath("/html/body/app-root/div/app-recuperar-senha/div/div/div[1]/div/form/div[2]/input"));
		element.click();
		
		try {
			Thread.sleep(6000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Então("Sistema realiza a recuperação da senha com sucesso")
	public void sistema_realiza_a_recuperação_da_senha_com_sucesso() {

		WebElement element = driver.findElement(By.xpath("/html/body/app-root/div/app-recuperar-senha/div/div/div[1]/div/div[2]/strong"));
		assertEquals("Recuperação de senha realizada com sucesso", element.getText());
		
		try {
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File("Recuperação de senha com sucesso.png"));		
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
	}

	@Então("Sistema informa que o email é inválido")
	public void sistema_informa_que_o_email_é_inválido() {

		WebElement element = driver.findElement(By.xpath("/html/body/app-root/div/app-recuperar-senha/div/div/div[1]/div/div[3]/strong"));
		assertEquals("Usuário não encontrado, verifique o email informado.", element.getText());
		
		try {
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File("Recuperação de senha inválida.png"));		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
