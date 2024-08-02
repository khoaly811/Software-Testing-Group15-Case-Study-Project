package com.hcmus.mentor.backend.steps;

import com.hcmus.mentor.backend.hooks.CommonHooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.vi.Cho;
import io.cucumber.java.vi.Khi;
import io.cucumber.java.vi.Thì;
import io.cucumber.java.vi.Và;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.hcmus.mentor.backend.handlers.handler;
import java.util.List;
import java.util.Map;

public class CreateChannelSteps{
    private final WebDriver driver = CommonHooks.driver;
    private final WebDriverWait wait = CommonHooks.wait;
    handler handler = new handler();
    private List<Map<String, String>> dataList;

    @Cho("người dùng di chuyển đến trang Nhắn tin nhóm")
    public void clickAtAccountManagement() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/a[1]/li[1]/div[1]"))).click();

    }
    @Và("người dùng chọn nhóm Nhóm Cucumber")
    public void chooseAddAcc(){
        driver.findElement(By.xpath("//button[@aria-label='Nhóm Cucumber']")).click();
    }
    @Khi("kênh được thêm với thông tin hợp lệ")
    public void createMeetingSuccessfully(DataTable dataTable) throws InterruptedException {
        if (dataList == null) {
            dataList = dataTable.asMaps(String.class, String.class);
        }
        for (Map<String, String> data : dataList) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/nav[1]/div[2]/button[1]/*[name()='svg'][1]"))).click();
            String tenKenh = data.get("Tên kênh");
            System.out.println(tenKenh);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[1]/div[1]/input[1]"))).sendKeys(data.get("Tên kênh"));


            System.out.println(data.get("Mô tả"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[2]/div[1]/input[1]"))).sendKeys(data.get("Mô tả"));

            String members = data.get("Thành viên");
            if(!members.equals("All")) {}

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[2]/button[2]"))).click();
            Thread.sleep(1000);
            popupSuccessfulNotification();
            Thread.sleep(1000);

        }
    }
    @Thì("màn hình sẽ xuất hiện thông báo rằng đã tạo kênh thành công")
    public void popupSuccessfulNotification()  {
        String popupXpath = "//span[@class='text-base']";
        String popupMessage = driver.findElement(By.xpath(popupXpath)).getText();
        System.out.println(popupMessage);
        Assert.assertTrue(popupMessage.contains("thành công"));
    }
//
}
