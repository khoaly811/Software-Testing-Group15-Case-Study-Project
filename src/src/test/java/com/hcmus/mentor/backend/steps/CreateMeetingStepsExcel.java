package com.hcmus.mentor.backend.steps;


import com.hcmus.mentor.backend.hooks.CommonHooks;
import io.cucumber.java.vi.Khi;
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

    @Và("cuộc họp sẽ được tạo với các thông tin sau tại file Excel {string}")
    public void assertInformation(String excelFilePath) throws InterruptedException, IOException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]"))).click();
        Thread.sleep(1000);
        List<Map<String, String>> expectedDataList = handler.readExcelData(excelFilePath);

        for (Map<String, String> expectedData : expectedDataList) {
            String expectedTitle = expectedData.get("Tiêu đề");
            String expectedDescription = expectedData.get("Mô tả");
            String expectedStartTime = handler.formatTime(expectedData.get("Thời gian bắt đầu"));
            String expectedEndTime = handler.formatTime(expectedData.get("Thời gian kết thúc"));
            String expectedDate = expectedData.get("Ngày");
            String expectedLocation = expectedData.get("Địa điểm");


            // Retrieve actual data from the application's UI
            String actualTitle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[1]/div[1]/input[1]"))).getAttribute("value");
            String actualDescription = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[2]/div[1]/textarea[1]"))).getText();
            String actualStartTime = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/input[1]"))).getAttribute("value");
            System.out.println("actualStartTime: " + actualStartTime);
            String actualEndTime = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/input[1]"))).getAttribute("value");
            String actualDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[3]/div[3]/div[1]/div[1]/input[1]"))).getAttribute("value");
            System.out.println("actualDate: " + actualDate);
            String actualLocation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[4]/div[1]/input[1]"))).getAttribute("value");
            // Assert the actual data matches the expected data
            // Ensure the date format matches
            actualDate = handler.formatDate(actualDate);
            expectedDate = handler.formatDate(expectedDate);

            Assert.assertEquals(actualTitle, expectedTitle);
            Assert.assertEquals(actualDescription, expectedDescription);
            Assert.assertEquals(actualStartTime, expectedStartTime);
            Assert.assertEquals(actualEndTime, expectedEndTime);
            Assert.assertEquals(actualDate, expectedDate);
            Assert.assertEquals(actualLocation, expectedLocation);
        }
    }
}
