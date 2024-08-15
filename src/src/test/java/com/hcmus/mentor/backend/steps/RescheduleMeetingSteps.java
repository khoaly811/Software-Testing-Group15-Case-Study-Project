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
public class RescheduleMeetingSteps {
    private final WebDriver driver = CommonHooks.driver;
    private final WebDriverWait wait = CommonHooks.wait;
    handler handler = new handler();
    private List<Map<String, String>> dataList;
    @Cho("người dùng đang ở trang Quản lý nhóm và đi đến phần Nhắn tin")
    public void moveToMessage() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/a[1]/li[1]/div[1]"))).click();
        Thread.sleep(1000);
    }

    @Cho("người dùng chọn nhóm và đi đến cuộc trò chuyện chung")
    public void moveToConversation() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Nhóm Cucumber 2']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Cuộc trò chuyện chung']//div[1]"))).click();
        Thread.sleep(1000);
    }
    @Cho("người dùng bấm chọn Mở lịch để dời lịch lẹn")
    public void openMeeting() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]"))).click();
    }
    @Khi("một cuộc hẹn được dời với các thông tin hợp lệ")
    public void rescheduleMeetingSuccessfully(DataTable dataTable) throws InterruptedException {
        if (dataList == null) {
            dataList = dataTable.asMaps(String.class, String.class);
        }
        for (Map<String, String> data : dataList) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]"))).click();
            handler.selectTime(data.get("Thời gian bắt đầu"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]"))).click();
            handler.selectTime(data.get("Thời gian kết thúc"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']"))).click();

            handler.selectDateForMeeting(data.get("Ngày"));

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Lưu lịch hẹn')]"))).click();
            Thread.sleep(1000);
            popupSuccessfulSaved();
            openMeeting();

        }
    }
    @Thì("màn hình sẽ xuất hiện thông báo rằng đã lưu lịch hẹn thành công")
    public void popupSuccessfulSaved() throws InterruptedException {
        String popupXpath = "//div[@role='status']";
        String popupMessage = driver.findElement(By.xpath(popupXpath)).getText();
        Assert.assertEquals(popupMessage, "Lưu lịch hẹn thành công");
    }
}
