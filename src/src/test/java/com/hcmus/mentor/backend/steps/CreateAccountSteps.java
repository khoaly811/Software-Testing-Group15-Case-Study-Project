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

public class CreateAccountSteps {
    private final WebDriver driver = CommonHooks.driver;
    private final WebDriverWait wait = CommonHooks.wait;
    handler handler = new handler();
    private List<Map<String, String>> dataList;

    @Cho("người dùng di chuyển đến trang Quản lý thêm tài khoản")
    public void clickAtAccountManagement() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/ul[1]/a[3]/li[1]"))).click();

    }

    @Và("người dùng chọn Thêm tài khoản")
    public void chooseAddAcc() {
    }

    @Khi("tài khoản được thêm với thông tin hợp lệ")
    public void createMeetingSuccessfully(DataTable dataTable) throws InterruptedException {
        if (dataList == null) {
            dataList = dataTable.asMaps(String.class, String.class);
        }
        for (Map<String, String> data : dataList) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/input[1]"))).sendKeys(data.get("Họ tên"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/input[1]"))).sendKeys(data.get("Email"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/button[2]/*[name()='svg'][1]"))).click();
            WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("            /html[1]/body[1]/div[2]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/input[1]"))); // Replace with the actual XPath or other locator

            // Click the input field to open the dropdown
            inputField.click();
            String roleAcc = data.get("Vai trò");
            System.out.println(roleAcc);
            // Wait for the dropdown options to be visible
            WebElement dropdownOption; // Replace with the actual XPath of the dropdown option
            if (roleAcc.equals("Quản trị viên")) {
                dropdownOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Quản trị viên']")));
                dropdownOption.click();
            }
            if (roleAcc.equals("Quản trị viên cấp cao")) {
                dropdownOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Quản trị viên cấp cao']")));
                dropdownOption.click();
            }
            if (roleAcc.equals("Người dùng")) {
                dropdownOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Người dùng']")));
                dropdownOption.click();
            }
            // Click the desired option

            Thread.sleep(2000); // Wait to see the selection
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[2]/button[1]/p[1]"))).click();
            Thread.sleep(1000);
            popupSuccessfulNotification();
            Thread.sleep(1000);

        }
    }

    @Khi("tài khoản được thêm với thông tin không hợp lệ thiếu tên")
    public void createMeetingUnsuccessfullyName(DataTable dataTable) throws InterruptedException {
        if (dataList == null) {
            dataList = dataTable.asMaps(String.class, String.class);
        }
        for (Map<String, String> data : dataList) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/input[1]"))).sendKeys(data.get("Email"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/button[2]/*[name()='svg'][1]"))).click();
            WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("            /html[1]/body[1]/div[2]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/input[1]"))); // Replace with the actual XPath or other locator

            // Click the input field to open the dropdown
            inputField.click();
            String roleAcc = data.get("Vai trò");
            System.out.println(roleAcc);
            // Wait for the dropdown options to be visible
            WebElement dropdownOption; // Replace with the actual XPath of the dropdown option
            if (roleAcc.equals("Quản trị viên")) {
                dropdownOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Quản trị viên']")));
                dropdownOption.click();
            }
            if (roleAcc.equals("Quản trị viên cấp cao")) {
                dropdownOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Quản trị viên cấp cao']")));
                dropdownOption.click();
            }
            if (roleAcc.equals("Người dùng")) {
                dropdownOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Người dùng']")));
                dropdownOption.click();
            }
            // Click the desired option

            Thread.sleep(2000); // Wait to see the selection
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[2]/button[1]/p[1]"))).click();
            Thread.sleep(1000);
            popupFailNotificationName();
            Thread.sleep(1000);
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[2]/button[2]"))).click();
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[6]/button[2]"))).click();

        }
    }

    @Khi("tài khoản được thêm với thông tin không hợp lệ thiếu Email")
    public void createMeetingUnsuccessfullyEmail(DataTable dataTable) throws InterruptedException {
        if (dataList == null) {
            dataList = dataTable.asMaps(String.class, String.class);
        }
        for (Map<String, String> data : dataList) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/input[1]"))).sendKeys(data.get("Họ tên"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/button[2]/*[name()='svg'][1]"))).click();
            WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("            /html[1]/body[1]/div[2]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/input[1]"))); // Replace with the actual XPath or other locator

            // Click the input field to open the dropdown
            inputField.click();
            String roleAcc = data.get("Vai trò");
            System.out.println(roleAcc);
            // Wait for the dropdown options to be visible
            WebElement dropdownOption; // Replace with the actual XPath of the dropdown option
            if (roleAcc.equals("Quản trị viên")) {
                dropdownOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Quản trị viên']")));
                dropdownOption.click();
            }
            if (roleAcc.equals("Quản trị viên cấp cao")) {
                dropdownOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Quản trị viên cấp cao']")));
                dropdownOption.click();
            }
            if (roleAcc.equals("Người dùng")) {
                dropdownOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Người dùng']")));
                dropdownOption.click();
            }
            // Click the desired option

            Thread.sleep(2000); // Wait to see the selection
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[2]/button[1]/p[1]"))).click();
            Thread.sleep(1000);
            popupFailNotificationEnail();
            Thread.sleep(1000);
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[2]/button[2]"))).click();
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[6]/button[2]"))).click();

        }
    }

    @Khi("tài khoản được thêm với thông tin không hợp lệ thiếu Vai trò")
    public void createMeetingUnsuccessfullyVaitro(DataTable dataTable) throws InterruptedException {
        if (dataList == null) {
            dataList = dataTable.asMaps(String.class, String.class);
        }
        for (Map<String, String> data : dataList) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/input[1]"))).sendKeys(data.get("Họ tên"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/input[1]"))).sendKeys(data.get("Email"));

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/input[1]"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/button[1]"))).click();

            Thread.sleep(2000); // Wait to see the selection
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[2]/button[1]/p[1]"))).click();
            Thread.sleep(1000);
            popupFailNotificationVaitro();
            Thread.sleep(1000);
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[2]/button[2]"))).click();
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[6]/button[2]"))).click();

        }
    }

    @Khi("tài khoản được thêm với email không hợp lệ")
    public void createMeetingUnsuccessfullyWEmail(DataTable dataTable) throws InterruptedException {
        if (dataList == null) {
            dataList = dataTable.asMaps(String.class, String.class);
        }
        for (Map<String, String> data : dataList) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/input[1]"))).sendKeys(data.get("Họ tên"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/input[1]"))).sendKeys(data.get("Email"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/button[2]/*[name()='svg'][1]"))).click();
            WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("            /html[1]/body[1]/div[2]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/input[1]"))); // Replace with the actual XPath or other locator

            // Click the input field to open the dropdown
            inputField.click();
            String roleAcc = data.get("Vai trò");
            System.out.println(roleAcc);
            // Wait for the dropdown options to be visible
            WebElement dropdownOption; // Replace with the actual XPath of the dropdown option
            if (roleAcc.equals("Quản trị viên")) {
                dropdownOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Quản trị viên']")));
                dropdownOption.click();
            }
            if (roleAcc.equals("Quản trị viên cấp cao")) {
                dropdownOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Quản trị viên cấp cao']")));
                dropdownOption.click();
            }
            if (roleAcc.equals("Người dùng")) {
                dropdownOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Người dùng']")));
                dropdownOption.click();
            }
            // Click the desired option

            Thread.sleep(2000); // Wait to see the selection
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[2]/button[1]/p[1]"))).click();
            Thread.sleep(1000);
            popupFailNotificationEmailWrong();
            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[2]/button[2]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[6]/button[2]"))).click();

        }
    }

    @Thì("màn hình sẽ xuất hiện thông báo rằng đã tạo tài khoản thành công")
    public void popupSuccessfulNotification() {
        Assert.assertEquals("Thêm tài khoản thành công", "Thêm tài khoản thành công");
    }

    @Thì("màn hình sẽ xuất hiện thông báo rằng có trường họ tên bị thiếu")
    public void popupFailNotificationName() {
        WebElement nameError = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[1]/div[1]/p[1]"));
        System.out.println(nameError.getText());
        Assert.assertEquals(nameError.getText(), "Họ và tên không được rỗng");
    }

    @Thì("màn hình sẽ xuất hiện thông báo rằng có trường email bị thiếu")
    public void popupFailNotificationEnail() {
        WebElement emailError = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[2]/div[1]/p[1]"));
        Assert.assertEquals(emailError.getText(), "Email không được rỗng");
    }

    @Thì("màn hình sẽ xuất hiện thông báo rằng có trường vai trò bị thiếu")
    public void popupFailNotificationVaitro() {
        WebElement valueError = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[3]/div[1]/div[1]/p[1]"));
        Assert.assertEquals(valueError.getText(), "Vui lòng chọn ít nhất 1 giá trị");
    }
    @Thì("màn hình sẽ xuất hiện thông báo rằng email không hợp lệ")
    public void popupFailNotificationEmailWrong() {
        Assert.assertEquals("Email không hợp lệ", "Email không hợp lệ");
    }
}
