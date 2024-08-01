package com.hcmus.mentor.backend.steps;
import com.hcmus.mentor.backend.hooks.CommonHooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.vi.Cho;
import io.cucumber.java.vi.Khi;
import io.cucumber.java.vi.Thì;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.hcmus.mentor.backend.handlers.handler;
import org.testng.Assert;

import java.util.List;
import java.util.Map;
public class SearchGroupSteps {
    private final WebDriver driver = CommonHooks.driver;
    private final WebDriverWait wait = CommonHooks.wait;
    handler handler = new handler();
    private List<Map<String, String>> dataList;
    @Cho("người dùng đang ở trang Quản lý nhóm và bấm chọn thẻ Tìm kiếm")
    public void clickAtSearch() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]"))).click();
        Thread.sleep(1000);
    }
    @Cho("người dùng chọn tìm kiếm theo ngày bắt đầu và ngày kết thúc")
    public void searchByDates() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/input[1]"))).click();
        Thread.sleep(1000);
    }
    @Khi("một nhóm được tìm kiếm với các thông tin hợp lệ sau")
    public void searchGroup(DataTable dataTable) throws InterruptedException {
        if (dataList == null) {
            dataList = dataTable.asMaps(String.class, String.class);
        }
        for (Map<String, String> data : dataList) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]/*[name()='svg'][1]"))).click();
            handler.selectDateGroup(data.get("Ngày bắt đầu từ"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/button[1]/*[name()='svg'][1]"))).click();
            handler.selectDateGroup(data.get("Ngày bắt đầu đến"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]/*[name()='svg'][1]"))).click();
            handler.selectDateGroup(data.get("Ngày kết thúc từ"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/button[1]/*[name()='svg'][1]"))).click();
            handler.selectDateGroup(data.get("Ngày kết thúc đến"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]"))).click();
            Thread.sleep(1000);
        }
    }
    @Thì("người dùng thấy được các nhóm đã tìm kiếm")
    public void verifySearchedGroups() throws InterruptedException{
        String popupXpath = "/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/span[1]";
        String popupMessage = driver.findElement(By.xpath(popupXpath)).getText();
        Assert.assertNotEquals(popupMessage, "0");
    }
}
