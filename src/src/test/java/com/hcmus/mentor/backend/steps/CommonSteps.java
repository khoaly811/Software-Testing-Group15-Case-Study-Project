package com.hcmus.mentor.backend.steps;
import com.hcmus.mentor.backend.hooks.CommonHooks;
import io.cucumber.java.vi.Cho;
import io.cucumber.java.vi.Và;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CommonSteps {
    protected WebDriver driver = CommonHooks.driver;
    protected org.openqa.selenium.support.ui.WebDriverWait wait = CommonHooks.wait;


    @Cho ("một người dùng di chuyển đến trang đăng nhập")
    public void moveToLoginPage() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Đăng nhập')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]"))).click();
        Thread.sleep(1000);
    }

    @Và ("người dùng đó nhập email và mật khẩu")
    public void logInMentorUS() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='identifierId']"))).sendKeys("ldkhoa21@clc.fitus.edu.vn");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Next')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='Passwd']"))).sendKeys("taokingucfan2k3");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Next')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Continue']"))).click();
        Thread.sleep(5000);
    }


}

