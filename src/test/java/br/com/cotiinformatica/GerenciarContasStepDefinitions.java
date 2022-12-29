package br.com.cotiinformatica;

import java.io.File;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

import br.com.cotiinformatica.utils.WebDriverUtil;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class GerenciarContasStepDefinitions {

	WebDriver driver;
	Faker faker = new Faker(new Locale("pt-BR"));
	
	@Dado("Acessar a página de cadastro de contas")
	public void acessar_a_página_de_cadastro_de_contas() {

		driver = WebDriverUtil.getInstance();
		driver.manage().window().maximize();
		driver.get("http://usuariosweb.s3-website-us-east-1.amazonaws.com/contas");
		
		WebElement element = driver.findElement(By.xpath("/html/body/app-root/div/app-contas/div[1]/div/div/div/div[2]/button"));
		element.click();
		
		try {
			Thread.sleep(3000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Dado("Informar o nome da conta {string}")
	public void informar_o_nome_da_conta(String nomeConta) {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"modal_cadastro\"]/div/div/div[2]/form/div[1]/div[1]/input"));
		element.clear();
		element.sendKeys(nomeConta);
	}

	@Dado("Informar o valor da conta {string}")
	public void informar_o_valor_da_conta(String valorConta) {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"modal_cadastro\"]/div/div/div[2]/form/div[1]/div[2]/input"));
		element.clear();
		element.sendKeys(valorConta);
	}

	@Dado("Informar a data da conta {string}")
	public void informar_a_data_da_conta(String dataConta) {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"modal_cadastro\"]/div/div/div[2]/form/div[1]/div[3]/input"));
		element.clear();
		element.sendKeys(dataConta);
	}

	@Dado("Selecionar o tipo da conta {string}")
	public void selecionar_o_tipo_da_conta(String tipoConta) {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"modal_cadastro\"]/div/div/div[2]/form/div[2]/div[1]/select"));
		Select select = new Select(element);
		select.selectByVisibleText(tipoConta);
	}

	@Dado("Selecionar a categoria da conta {string}")
	public void selecionar_a_categoria_da_conta(String categoriaConta) {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"modal_cadastro\"]/div/div/div[2]/form/div[2]/div[2]/select"));
		Select select = new Select(element);
		select.selectByVisibleText(categoriaConta);
	}

	@Dado("Informar as observações")
	public void informar_as_observações() {

		String observacoes = faker.lorem().paragraph();
		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"modal_cadastro\"]/div/div/div[2]/form/div[3]/div/textarea"));
		element.clear();
		element.sendKeys(observacoes);
	}

	@Quando("Confirmar a realização do cadastro da conta")
	public void confirmar_a_realização_do_cadastro_da_conta() {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"modal_cadastro\"]/div/div/div[2]/form/div[4]/div/input"));
		element.click();
		
		try {
			Thread.sleep(3000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Então("Sistema informa que a conta foi criada com sucesso")
	public void sistema_informa_que_a_conta_foi_criada_com_sucesso() {

		Alert alert = driver.switchTo().alert();
		alert.accept();		
		
		try {
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File("Conta cadastrada com sucesso.png"));		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Dado("Selecionar uma conta já cadastrada para edição")
	public void selecionar_uma_conta_já_cadastrada_para_edição() {

		WebElement element = driver.findElement(By.xpath("/html/body/app-root/div/app-contas/div[1]/div/div/table/tbody/tr[1]/td[7]/button[1]"));
		element.click();
		
		try {
			Thread.sleep(3000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Dado("Alterar o nome da conta")
	public void alterar_o_nome_da_conta() {

		String nomeConta = "Conta teste";
		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"modal_edicao\"]/div/div/div[2]/form/div[1]/div[1]/input"));
		element.clear();
		element.sendKeys(nomeConta);
	}

	@Dado("Alterar o valor da conta")
	public void alterar_o_valor_da_conta() {

		String valorConta = "150";
		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"modal_edicao\"]/div/div/div[2]/form/div[1]/div[2]/input"));
		element.clear();
		element.sendKeys(valorConta);
	}

	@Dado("Alterar a data da conta")
	public void alterar_a_data_da_conta() {

		String dataConta = "10/01/2023";
		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"modal_edicao\"]/div/div/div[2]/form/div[1]/div[3]/input"));
		element.clear();
		element.sendKeys(dataConta);
	}

	@Dado("Alterar o tipo da conta")
	public void alterar_o_tipo_da_conta() {
		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"modal_edicao\"]/div/div/div[2]/form/div[2]/div[1]/select"));
		Select select = new Select(element);
		select.deselectByIndex(1);
	}

	@Dado("ALterar a categoria da conta")
	public void a_lterar_a_categoria_da_conta() {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"modal_edicao\"]/div/div/div[2]/form/div[2]/div[2]/select"));
		Select select = new Select(element);
		select.deselectByIndex(1);
	}

	@Dado("Alterar as observações")
	public void alterar_as_observações() {

		String observacoes = "Observações Teste";
		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"modal_edicao\"]/div/div/div[2]/form/div[3]/div/textarea"));
		element.clear();
		element.sendKeys(observacoes);
	}

	@Quando("Confirmar a atualização da conta")
	public void confirmar_a_atualização_da_conta() {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"modal_edicao\"]/div/div/div[2]/form/div[4]/div/input"));
		element.click();
		
		try {
			Thread.sleep(3000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Então("Sistema informa que a conta foi atualizada com sucesso")
	public void sistema_informa_que_a_conta_foi_atualizada_com_sucesso() {
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		try {
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File("Conta atualizada com sucesso.png"));		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Dado("Selecionar uma conta já cadastrada para exclusão")
	public void selecionar_uma_conta_já_cadastrada_para_exclusão() {

		WebElement element = driver.findElement(By.xpath("/html/body/app-root/div/app-contas/div[1]/div/div/table/tbody/tr[1]/td[7]/button[2]"));
		element.click();
		
		try {
			Thread.sleep(3000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Quando("Confirmar a exclusão da conta")
	public void confirmar_a_exclusão_da_conta() {

		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		try {
			Thread.sleep(3000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Então("Sistema informa que a conta foi excluída com sucesso")
	public void sistema_informa_que_a_conta_foi_excluída_com_sucesso() {

		Alert alert = driver.switchTo().alert();
		alert.accept();		
		
		try {
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File("Conta excluída com sucesso.png"));		
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
		
	}

}
