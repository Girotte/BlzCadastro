package com.br;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import configurations.ConfigProperties;

public class Cadastro {

	static WebDriver driver;

	static int sleepTime = Integer.parseInt(ConfigProperties.getValue("sleepTime"));

	static String nome;
	static String sobrenome;
	static String apelido;
	static String cpf;
	static String nascimento;
	static String celular;
	static String email;
	static String senha;

	@BeforeClass
	public static void configTest() throws Exception {

		driver = null;
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();

		nome = "João";
		sobrenome = "Paulo";
		apelido = "Joãozinho";
		cpf = "89669459028";
		nascimento = "20031991";
		celular = "11988997754";
		email = "joaoribeirop@hotmail.com";
		senha = "joaojoao";

	}

	@Test
	public void runTest() throws InterruptedException {

		driver.get(ConfigProperties.getValue("url"));
		Thread.sleep(sleepTime);

		driver.findElement(By.cssSelector(".header-account-username-small")).click();
		Thread.sleep(sleepTime);

		driver.findElement(By.cssSelector(".btn-outline-secondary")).click();
		Thread.sleep(sleepTime);

		driver.findElement(By.cssSelector(".btn-outline-primary")).click();
		Thread.sleep(sleepTime);

		// E-mail
		WebElement ElementoNome = driver.findElement(By.cssSelector("#givenName"));
		ElementoNome.sendKeys(nome);

		WebElement ElementoSobrenome = driver.findElement(By.cssSelector("#familyName"));
		ElementoSobrenome.sendKeys(sobrenome);

		WebElement ElementoApelido = driver.findElement(By.cssSelector("#nickName"));
		ElementoApelido.sendKeys(apelido);

		WebElement ElementoCpf = driver.findElement(By.cssSelector("#cpf"));
		ElementoCpf.sendKeys(cpf);

		WebElement ElementoNascimento = driver.findElement(By.cssSelector("#birthDate"));
		ElementoNascimento.sendKeys(nascimento);

		WebElement ElementoCelular = driver.findElement(By.cssSelector("#telephone"));
		ElementoCelular.sendKeys(celular);

		WebElement ElementoEmail = driver.findElement(By.cssSelector("#email"));
		ElementoEmail.sendKeys(email);

		WebElement ElementoSenha = driver.findElement(By.cssSelector("#password"));
		ElementoSenha.sendKeys(senha);

		WebElement elementoRadio = driver.findElement(By.id("female"));
		elementoRadio.click();

		driver.findElement(By.cssSelector(".btn-primary")).click();
		Thread.sleep(sleepTime);

		String atualUsuario = driver.findElement(By.cssSelector(".header-account-username-small")).getText();
		assertTrue(atualUsuario.contains("Olá, Joãozinho"));

	}

	@AfterClass
	public static void finishTest() throws Exception {
		driver.quit();
	}

}