package com.hcmus.mentor.backend.steps;


import com.hcmus.mentor.backend.hooks.CommonHooks;
import io.cucumber.java.vi.Khi;
import io.cucumber.java.vi.Thì;
import io.cucumber.java.vi.Và;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.hcmus.mentor.backend.handlers.handler;
import java.io.IOException;
import java.util.List;
import java.util.Map;



public class CreateMeetingStepsExcel {
    private final WebDriverWait wait = CommonHooks.wait;
    private final WebDriver driver = CommonHooks.driver;
    handler handler = new handler();
    @Khi("người dùng chọn Lịch hẹn, người dùng bấm dấu cộng để thêm cuộc hẹn {string}")
    public void openFormMeeting(String excelFilePath) throws InterruptedException, IOException {
        List<Map<String, String>> dataList = handler.readExcelData(excelFilePath);

        for (Map<String, String> data : dataList) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[7]/div[1]/div[1]/div[1]/div[1]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/button[2]"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[1]/div[1]/input[1]"))).sendKeys(data.get("Tiêu đề"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[2]/div[1]/textarea[1]"))).sendKeys(data.get("Mô tả"));

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]"))).click();
            handler.selectTime(data.get("Thời gian bắt đầu"));
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]"))).click();
            System.out.println(data.get("Thời gian kết thúc"));
            handler.selectTime(data.get("Thời gian kết thúc"));
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']"))).click();

            // Select date
            handler.selectDate(data.get("Ngày"));
            Thread.sleep(1000);
            // Enter location
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[4]/div[1]/input[1]"))).sendKeys(data.get("Địa điểm"));
            Thread.sleep(1000);
        }
    }
    @Và("người dùng bấm chọn Tạo lịch hẹn")
    public void clickButtonToCreate() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Tạo lịch hẹn')]"))).click();
        Thread.sleep(1000);
    }
    @Thì("màn hình sẽ xuất hiện thông báo đã tạo lịch hẹn thành công")
    public void popupNotifications()  {
        String popupXpath = "//div[@role='status']";
        String popupMessage = driver.findElement(By.xpath(popupXpath)).getText();
        Assert.assertEquals(popupMessage, "Tạo lịch hẹn thành công");
    }
}
