package com.hcmus.mentor.backend.steps;

import com.hcmus.mentor.backend.hooks.CommonHooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.vi.Cho;
import io.cucumber.java.vi.Khi;
import io.cucumber.java.vi.Thì;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.hcmus.mentor.backend.handlers.handler;
import java.util.List;
import java.util.Map;

public class CreateMeetingSteps{
    private final WebDriver driver = CommonHooks.driver;
    private final WebDriverWait wait = CommonHooks.wait;
    handler handler = new handler();
    private List<Map<String, String>> dataList;
    @Cho("người dùng đang ở trang Quản lý nhóm và di chuyển đến phần Nhắn tin")
    public void moveToMessage() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'/chat')]//li[contains(@class,'MuiListItem-root MuiListItem-padding css-1l9osrx-MuiListItem-root')]//div[contains(@class,'MuiBox-root css-v7ygw')]"))).click();

        Thread.sleep(1000);
    }

    @Cho("người dùng chọn nhóm và di chuyển đến cuộc trò chuyện chung")
    public void moveToConversation() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Nhóm Cucumber']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Cuộc trò chuyện chung']//div[1]"))).click();
        Thread.sleep(1000);
    }
    @Cho("người dùng chọn Lịch hẹn")
    public void clickAtMeeting() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[7]/div[1]/div[1]/div[1]/div[1]"))).click();
    }
    @Khi("một cuộc hẹn đã được tạo với các thông tin hợp lệ")
    public void createMeetingSuccessfully(DataTable dataTable) throws InterruptedException {
        if (dataList == null) {
            dataList = dataTable.asMaps(String.class, String.class);
        }
        for (Map<String, String> data : dataList) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/button[2]"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[1]/div[1]/input[1]"))).sendKeys(data.get("Tiêu đề"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[2]/div[1]/textarea[1]"))).sendKeys(data.get("Mô tả"));

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]"))).click();
            handler.selectTime(data.get("Thời gian bắt đầu"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]"))).click();
            handler.selectTime(data.get("Thời gian kết thúc"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']"))).click();

            handler.selectDateForMeeting(data.get("Ngày"));

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[4]/div[1]/input[1]"))).sendKeys(data.get("Địa điểm"));

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Tạo lịch hẹn')]"))).click();
            Thread.sleep(1000);
            popupSuccessfulNotification();

        }
    }
    @Thì("màn hình sẽ xuất hiện thông báo rằng đã tạo lịch hẹn thành công")
    public void popupSuccessfulNotification()  {
        String popupXpath = "//div[@role='status']";
        String popupMessage = driver.findElement(By.xpath(popupXpath)).getText();
        Assert.assertEquals(popupMessage, "Tạo lịch hẹn thành công");
    }
    @Khi("một cuộc hẹn được tạo nhưng vượt quá 255 kí tự ở 1 trong 3 trường Tiêu đề, Mô tả, Địa điểm")
    public void createMeetingExceed255Char(DataTable dataTable) throws InterruptedException {
        if (dataList == null) {
            dataList = dataTable.asMaps(String.class, String.class);
        }
        for (Map<String, String> data : dataList) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/button[2]"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[1]/div[1]/input[1]"))).sendKeys(data.get("Tiêu đề"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[2]/div[1]/textarea[1]"))).sendKeys(data.get("Mô tả"));

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]"))).click();
            handler.selectTime(data.get("Thời gian bắt đầu"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]"))).click();
            handler.selectTime(data.get("Thời gian kết thúc"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']"))).click();

            handler.selectDateForMeeting(data.get("Ngày"));

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[4]/div[1]/input[1]"))).sendKeys(data.get("Địa điểm"));

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Tạo lịch hẹn')]"))).click();
            Thread.sleep(1000);
            popupFailedNotification();

        }
    }
    @Thì("màn hình sẽ xuất hiện thông báo rằng đã tạo lịch hẹn thất bại")
    public void popupFailedNotification()  {
        String popupXpath = "//div[@role='status']";
        String popupMessage = driver.findElement(By.xpath(popupXpath)).getText();
        Assert.assertEquals(popupMessage, "Tạo lịch hẹn thất bại");
    }

    @Khi("một cuộc hẹn được tạo với trường Tiêu đề để trống")
    public void createMeetingWithoutTitle(DataTable dataTable) throws InterruptedException {
        if (dataList == null) {
            dataList = dataTable.asMaps(String.class, String.class);
        }
        for (Map<String, String> data : dataList) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/button[2]"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[2]/div[1]/textarea[1]"))).sendKeys(data.get("Mô tả"));

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]"))).click();
            handler.selectTime(data.get("Thời gian bắt đầu"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]"))).click();
            handler.selectTime(data.get("Thời gian kết thúc"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']"))).click();

            handler.selectDateForMeeting(data.get("Ngày"));

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[4]/div[1]/input[1]"))).sendKeys(data.get("Địa điểm"));

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Tạo lịch hẹn')]"))).click();
            Thread.sleep(1000);
            checkTitleError();

        }
    }
    @Thì("form tạo cuộc hẹn sẽ xuất hiện thông báo Vui lòng nhập tiêu đề")
    public void checkTitleError() {
        WebElement titleError = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[1]/p[1]"));
        Assert.assertEquals(titleError.getText(), "Vui lòng nhập tiêu đề");
    }
    @Khi("một cuộc hẹn được tạo với danh sách Người tham dự để trống")
    public void createMeetingWithoutAttendees(DataTable dataTable) throws InterruptedException {
        if (dataList == null) {
            dataList = dataTable.asMaps(String.class, String.class);
        }
        for (Map<String, String> data : dataList) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/button[2]"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[1]/div[1]/input[1]"))).sendKeys(data.get("Tiêu đề"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[2]/div[1]/textarea[1]"))).sendKeys(data.get("Mô tả"));

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]"))).click();
            handler.selectTime(data.get("Thời gian bắt đầu"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]"))).click();
            handler.selectTime(data.get("Thời gian kết thúc"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']"))).click();

            handler.selectDateForMeeting(data.get("Ngày"));

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[4]/div[1]/input[1]"))).sendKeys(data.get("Địa điểm"));
            // Empty list of attendees
            Actions builder = new Actions(driver);
            WebElement element = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[4]/button[2]/*[name()='svg'][1]"));
            builder.moveToElement(element).build().perform();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[4]/button[1]/*[name()='svg'][1]"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Tạo lịch hẹn')]"))).click();
            Thread.sleep(1000);
            emptyAttendeeListError();

        }
    }
    @Thì("form tạo cuộc hẹn sẽ xuất hiện thông báo Vui lòng chọn người tham gia lịch hẹn")
    public void emptyAttendeeListError() {
        WebElement attendeeList = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[5]/div[1]/div[1]/div[1]/p[1]"));
        Assert.assertEquals(attendeeList.getText(), "Vui lòng chọn người tham gia lịch hẹn");
    }
}
