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

public class AlterarSenhaStepDefinitions {

	WebDriver driver;
	
	@Dado("Acessar a página de alteração de senha do usuário")
	public void acessar_a_página_de_alteração_de_senha_do_usuário() {

		driver = WebDriverUtil.getInstance();
		driver.manage().window().maximize();
		driver.get("http://usuariosweb.s3-website-us-east-1.amazonaws.com/dados-usuario");
		
		try {
			Thread.sleep(3000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Dado("Informar a senha atual {string}")
	public void informar_a_senha_atual(String senhaAtual) {

		WebElement element = driver.findElement(By.xpath("/html/body/app-root/div/app-dados-usuario/div/div/div/form/div[1]/div[1]/input"));
		element.clear();
		element.sendKeys(senhaAtual);
	}

	@Dado("Informar a nova senha {string}")
	public void informar_a_nova_senha(String novaSenha) {

		WebElement element = driver.findElement(By.xpath("/html/body/app-root/div/app-dados-usuario/div/div/div/form/div[1]/div[2]/input"));
		element.clear();
		element.sendKeys(novaSenha);
	}

	@Quando("Confirmar a atualização da senha")
	public void confirmar_a_atualização_da_senha() {

		WebElement element = driver.findElement(By.xpath("/html/body/app-root/div/app-dados-usuario/div/div/div/form/div[1]/div[3]/input"));
		element.click();
		
		try {
			Thread.sleep(3000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Então("Sistema informa que a senha foi atualizada com sucesso")
	public void sistema_informa_que_a_senha_foi_atualizada_com_sucesso() {

		WebElement element = driver.findElement(By.xpath("/html/body/app-root/div/app-dados-usuario/div/div/div/form/div[2]/strong"));
		assertEquals("Senha atualizada com sucesso.", element.getText());
		
		try {
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File("Senha atualizada com sucesso.png"));		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Então("Sistema informa que a senha atual é inválida")
	public void sistema_informa_que_a_senha_atual_é_inválida() {

		WebElement element = driver.findElement(By.xpath("/html/body/app-root/div/app-dados-usuario/div/div/div/form/div[2]/strong"));
		assertEquals("Usuário não encontrado, por favor verifique a senha atual informada.", element.getText());
		
		try {
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File("Senha atual inválida.png"));		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
