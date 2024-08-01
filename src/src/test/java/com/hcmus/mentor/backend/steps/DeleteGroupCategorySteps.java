package com.hcmus.mentor.backend.steps;
import com.hcmus.mentor.backend.hooks.CommonHooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.vi.Cho;
import io.cucumber.java.vi.Khi;
import io.cucumber.java.vi.Thì;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.hcmus.mentor.backend.handlers.handler;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class DeleteGroupCategorySteps {
    private final WebDriver driver = CommonHooks.driver;
    private final WebDriverWait wait = CommonHooks.wait;
    handler handler = new handler();
    private List<Map<String, String>> dataList;

    @Cho("người dùng đang ở trang Quản lý nhóm và di chuyển đến trang Quản lý loại nhóm")
    public void moveToGroupCategory() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/ul[1]/a[2]/li[1]/div[1]"))).click();
    }
    @Cho ("người dùng bấm chọn check box để xóa nhóm")
    public void clickAtCheckBox() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[6]/div[1]/input[1]"))).click();

    }
    @Khi ("một loại nhóm được xóa")
    public void createGroupCategory() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[2]/button[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Đồng ý')]"))).click();
        Thread.sleep(1000);
    }
    @Thì ("màn hình sẽ xuất hiện thông báo rằng đã xóa loại nhóm thành công")
    public void popupCategory() throws InterruptedException {
        String popupXpath = "/html[1]/body[1]/div[2]/div[1]/h2[1]";
        String popupMessage = driver.findElement(By.xpath(popupXpath)).getText();
        System.out.println(popupMessage);
        Assert.assertEquals(popupMessage, "Xóa loại nhóm thành công");
    }
}
