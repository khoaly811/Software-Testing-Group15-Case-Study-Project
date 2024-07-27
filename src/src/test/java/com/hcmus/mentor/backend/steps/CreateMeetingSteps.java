package com.hcmus.mentor.backend.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.vi.Cho;
import io.cucumber.java.vi.Khi;
import io.cucumber.java.vi.Thì;
import io.cucumber.java.vi.Và;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class CreateMeetingSteps {

    WebDriver driver = null;
    WebDriverWait wait = null;
    private String popupXpath = "//div[@role='status']";

    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:3000");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

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
        Thread.sleep(1000);
    }
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
    @Khi("người dùng chọn Lịch hẹn, người dùng bấm dấu cộng để thêm 1 cuộc hẹn")
    public void openFormMeeting(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> dataList = dataTable.asMaps(String.class, String.class);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[7]/div[1]/div[1]/div[1]/div[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/button[2]"))).click();

        for (Map<String, String> data : dataList) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[1]/div[1]/input[1]"))).sendKeys(data.get("Tiêu đề"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[2]/div[1]/textarea[1]"))).sendKeys(data.get("Mô tả"));

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]"))).click();
            selectTime(data.get("Thời gian bắt đầu"));
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]"))).click();
            selectTime(data.get("Thời gian kết thúc"));
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']"))).click();

            // Select date
            selectDate(data.get("Ngày"));
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
    @Thì("màn hình sẽ xuất hiện thông báo rằng đã tạo lịch hẹn thành công")
    public void popupNotification() throws InterruptedException {
        String popupMessage = driver.findElement(By.xpath(popupXpath)).getText();
        Assert.assertEquals(popupMessage, "Tạo lịch hẹn thành công");
        System.out.println("popupMessage: " + popupMessage);
        Thread.sleep(1000);
    }
    @Và ("cuộc họp sẽ được tạo với các thông tin sau")
    public void assertInformation(DataTable dataTable) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]"))).click();
        Thread.sleep(1000);
        List<Map<String, String>> expectedDataList = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> expectedData : expectedDataList) {
            String expectedTitle = expectedData.get("Tiêu đề");
            String expectedDescription = expectedData.get("Mô tả");
            String expectedStartTime = formatTime(expectedData.get("Thời gian bắt đầu"));
            String expectedEndTime = formatTime(expectedData.get("Thời gian kết thúc"));
            String expectedDate = expectedData.get("Ngày");
            String expectedLocation = expectedData.get("Địa điểm");

            // Retrieve actual data from the application's UI
            String actualTitle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[1]/div[1]/input[1]"))).getAttribute("value");
            System.out.println("actualTitle: " + actualTitle);

            String actualDescription = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[2]/div[1]/textarea[1]"))).getText();
            String actualStartTime = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/input[1]"))).getAttribute("value");
            System.out.println("actualStartTime: " + actualStartTime);
            String actualEndTime = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/input[1]"))).getAttribute("value");
            String actualDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[3]/div[3]/div[1]/div[1]/input[1]"))).getAttribute("value");
            System.out.println("actualDate: " + actualDate);
            String actualLocation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[4]/div[1]/input[1]"))).getAttribute("value");

            // Ensure the date format matches
            actualDate = formatDate(actualDate);
            expectedDate = formatDate(expectedDate);

            // Compare actual data with expected data
            Assert.assertEquals(actualTitle, expectedTitle, "Title does not match");
            Assert.assertEquals(actualDescription, expectedDescription, "Description does not match");
            Assert.assertEquals(actualStartTime, expectedStartTime, "Start time does not match");
            Assert.assertEquals(actualEndTime, expectedEndTime, "End time does not match");
            Assert.assertEquals(actualDate, expectedDate, "Date does not match");
            Assert.assertEquals(actualLocation, expectedLocation, "Location does not match");
        }
    }
    private String formatDate(String date) {
        if (date == null || date.isEmpty()) {
            throw new IllegalArgumentException("Date string cannot be null or empty");
        }

        // Split the date string
        String[] dateParts = date.split("/");
        int day = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int year = Integer.parseInt(dateParts[2]);

        // Format day and month to ensure they are two digits
        String formattedDay = String.format("%02d", day);
        String formattedMonth = String.format("%02d", month);

        // Return the formatted date in "dd/MM/yyyy"
        return formattedDay + "/" + formattedMonth + "/" + year;
    }
    private String formatTime(String time) {
        if (time == null || time.isEmpty()) {
            throw new IllegalArgumentException("Time string cannot be null or empty");
        }

        String[] timeParts = time.split("[: ]");
        if (timeParts.length < 2) {
            throw new IllegalArgumentException("Time string is not in the expected format");
        }

        String hour = timeParts[0];
        String minute = timeParts[1];
        String period = timeParts.length > 2 ? timeParts[2] : ""; // Handle AM/PM if present

        // Format hour and minute to ensure they are two digits
        String formattedHour = String.format("%02d", Integer.parseInt(hour));
        String formattedMinute = String.format("%02d", Integer.parseInt(minute));

        // Return the formatted time with AM/PM
        return formattedHour + ":" + formattedMinute + " " + period;
    }

    private void selectTime(String time) throws InterruptedException {
        String[] timeParts = time.split("[: ]");
        String hour = timeParts[0];
        String minute = timeParts[1];
        String period = timeParts[2];

        // Click on the clock to select the hour
        WebElement clockElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")));
        clickClockPosition(clockElement, Integer.parseInt(hour), true);
        Thread.sleep(1000);
        // Click on the clock to select the minute
//        clockElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'MuiClock-squareMask css-de3exi-MuiClock-squareMask')]")));
        clickClockPosition(clockElement, Integer.parseInt(minute), false);

        // Click to select AM/PM
        if (period.equalsIgnoreCase("AM")) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]/span[1]"))).click();
        } else if (period.equalsIgnoreCase("PM")){
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/button[2]/span[1]"))).click();
        }
    }

    private void clickClockPosition(WebElement clockElement, int value, boolean isHour) {
        int clockRadius = clockElement.getSize().getWidth() / 2;
        int centerX = clockElement.getLocation().getX() + clockRadius;
        int centerY = clockElement.getLocation().getY() + clockRadius;

        double angle;
        if (isHour) {
            angle = Math.toRadians((value % 12) * 30); // 30 degrees for each hour
        } else {
            angle = Math.toRadians((value % 60) * 6); // 6 degrees for each minute
        }

        int xOffset = (int) (Math.sin(angle) * clockRadius);
        int yOffset = (int) (-Math.cos(angle) * clockRadius);

        new Actions(driver).moveToElement(clockElement, xOffset, yOffset).click().perform();
    }
    private void selectDate(String date) throws InterruptedException {
        // Expected date format: "d/MM/yyyy"
        String[] dateParts = date.split("/");
        String day = dateParts[0];
        String month = dateParts[1];
        String year = dateParts[2];

        // Map month number to month name (in English)
        String[] monthNames = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        String monthName = monthNames[Integer.parseInt(month) - 1];

        // Open the date picker
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/form[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/button[1]/*[name()='svg'][1]"))).click();
        Thread.sleep(1000);

        // Navigate to the correct month and year
        while (true) {
            String displayedMonthYear = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"))).getText();
            String displayedMonth = displayedMonthYear.split(" ")[0]; // This takes the first word, which is the month name
            String displayedYear = displayedMonthYear.split(" ")[1]; // This takes the second word, which is the year

            if (displayedMonth.equalsIgnoreCase(monthName) && displayedYear.equals(year)) {
                break;
            }
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/button[2]/*[name()='svg'][1]"))).click();
        }

        // Select the day
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='"+ day +"']"))).click();
        Thread.sleep(1000);
    }



    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
