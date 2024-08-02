package com.hcmus.mentor.backend.steps;

import com.hcmus.mentor.backend.hooks.CommonHooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.vi.Cho;
import io.cucumber.java.vi.Khi;
import io.cucumber.java.vi.Thì;
import io.cucumber.java.vi.Và;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.hcmus.mentor.backend.handlers.handler;
import java.util.List;
import java.util.Map;

public class LockAccountSteps {
    private final WebDriver driver = CommonHooks.driver;
    private final WebDriverWait wait = CommonHooks.wait;
    handler handler = new handler();
    private List<Map<String, String>> dataList;

    @Cho("người dùng đi đến trang Quản lý tài khoản")
    public void clickAtAccountManagement() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/ul[1]/a[3]/li[1]"))).click();
        Thread.sleep(1000);

    }
    @Và("người dùng chọn 1 tài khoản để khóa")
    public void chooseToLock() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[6]/div[1]"))).click();
        Thread.sleep(1000);

    }
    @Khi("một tài khoản được khóa thành công")
    public void lockAccountSuccessfully() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/button[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Đồng ý')]"))).click();
        Thread.sleep(1000);
    }
    @Thì("màn hình hiện thông báo khóa tài khoản thành công")
    public void popupLocked() throws InterruptedException {
        String popupXpath = "//h2[@id='swal2-title']";
        String popupMessage = driver.findElement(By.xpath(popupXpath)).getText();
        Assert.assertEquals(popupMessage, "Khóa tài khoản thành công");
        Thread.sleep(2000);
    }
    @Và("trạng thái của tài khoản đó sẽ là bị khóa")
    public void checkLockedStatus() throws InterruptedException {
        String lockedStatusXpath = "//a[contains(text(),'Bị khóa')]";
        String lockedStatus = driver.findElement(By.xpath(lockedStatusXpath)).getText();
        Assert.assertEquals(lockedStatus, "Bị khóa");
        Thread.sleep(1000);
    }
    @Khi("người dùng mở khóa lại tài khoản đó")
    public void unlockAccount() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/button[1]"))).click();
        Thread.sleep(1000);
    }
    @Thì("màn hình hiện thông báo mở khóa tài khoản thành công")
    public void popupUnlocked() throws InterruptedException {
        String popupXpath = "//h2[@id='swal2-title']";
        String popupMessage = driver.findElement(By.xpath(popupXpath)).getText();
        Assert.assertEquals(popupMessage, "Mở khóa tài khoản thành công");
        Thread.sleep(2000);
    }
    @Và("trạng thái của tài khoản đó sẽ là hoạt động")
    public void checkUnlockedStatus() throws InterruptedException {
        String lockedStatusXpath = "//a[contains(text(),'Hoạt động')]";
        String lockedStatus = driver.findElement(By.xpath(lockedStatusXpath)).getText();
        Assert.assertEquals(lockedStatus, "Hoạt động");
        Thread.sleep(1000);
    }
}
