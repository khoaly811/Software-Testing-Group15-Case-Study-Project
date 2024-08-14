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

public class EditAccountSteps {
    private final WebDriver driver = CommonHooks.driver;
    private final WebDriverWait wait = CommonHooks.wait;
    handler handler = new handler();
    private List<Map<String, String>> dataList;

    @Cho("người dùng di chuyển đến trang Quản lý sửa tài khoản")
    public void clickAtAccountManagement() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/ul[1]/a[3]/li[1]"))).click();

    }
    @Và("người dùng chọn tài khoản để chỉnh")
    public void chooseAddAcc(){
    }
    @Khi("tài khoản được chỉnh sửa với thông tin hợp lệ")
    public void createMeetingSuccessfully(DataTable dataTable) throws InterruptedException {
        if (dataList == null) {
            dataList = dataTable.asMaps(String.class, String.class);
        }
        for (Map<String, String> data : dataList) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[7]/div[1]/div[1]/span[1]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/ul[1]/li[1]"))).click();
            String emailACC = data.get("Email");
            System.out.println(emailACC);
            if(!emailACC.equals("Empty")) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/input[1]"))).clear();
                Thread.sleep(100);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/input[1]"))).sendKeys(data.get("Email"));
            }

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[4]/div[1]/div[1]/input[1]"))).clear();
            Thread.sleep(100);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[4]/div[1]/div[1]/input[1]"))).sendKeys(data.get("Họ tên"));
            System.out.println(data.get("Họ tên"));

            String phoneACC = data.get("Số điên thoại");
            System.out.println(phoneACC);
            if(!phoneACC.equals("Empty")) {
                driver.findElement(By.xpath("//input[@placeholder='Nhập số điện thoại']")).clear();
                Thread.sleep(100);

                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[2]/div[1]/div[1]/input[1]"))).sendKeys(data.get("Số điên thoại"));
            }
            String genderACC = data.get("Giới tính");
            if(genderACC.equals("Nam")) {
                System.out.println(genderACC);
                driver.findElement(By.xpath("//input[@value='MALE']")).click();
            }
            if(genderACC.equals("Nữ")) {
                System.out.println(genderACC);
                driver.findElement(By.xpath("//input[@value='FEMALE']")).click();
            }


            String statusACC = data.get("Trạng thái");

            if(statusACC.equals("Hoạt động")) {
                System.out.println(statusACC);
                driver.findElement(By.xpath("//input[@value='true']")).click();
            }
            if(statusACC.equals("Khóa")) {
                System.out.println(statusACC);
                driver.findElement(By.xpath("//input[@value='false']")).click();
            }


            WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[7]/div[1]/div[1]/div[1]/div[1]/button[2]/*[name()='svg'][1]"))); // Replace with the actual XPath or other locator

            // Click the input field to open the dropdown
            inputField.click();
            String roleAcc = data.get("Vai trò");
            System.out.println(roleAcc);
            // Wait for the dropdown options to be visible
            WebElement dropdownOption; // Replace with the actual XPath of the dropdown option
            if(roleAcc.equals("Quản trị viên")){
                driver.findElement(By.xpath("//li[text()='Quản trị viên']")).click();
            }
            if(roleAcc.equals("Quản trị viên cấp cao")){
                driver.findElement(By.xpath("//li[text()='Quản trị viên cấp cao']")).click();

            }
            if(roleAcc.equals("Người dùng")){
                driver.findElement(By.xpath("//li[text()='Người dùng']")).click();

            }
            // Click the desired option

            Thread.sleep(2000); // Wait to see the selection
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[3]/button[1]/p[1]"))).click();
            Thread.sleep(1000);
            popupSuccessfulNotification();
            Thread.sleep(1000);

        }
    }

    @Khi("tài khoản được chỉnh sửa với thông tin không hợp lệ thiếu họ tên")
    public void createMeetingUnsuccessfullyName(DataTable dataTable) throws InterruptedException {
        if (dataList == null) {
            dataList = dataTable.asMaps(String.class, String.class);
        }
        for (Map<String, String> data : dataList) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[7]/div[1]/div[1]/span[1]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/ul[1]/li[1]"))).click();
            String emailACC = data.get("Email");
            System.out.println(emailACC);
            if(!emailACC.equals("Empty")) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/input[1]"))).clear();
                Thread.sleep(100);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/input[1]"))).sendKeys(data.get("Email"));
            }

            WebElement inputFieldName = driver.findElement(By.xpath("//input[@placeholder='Nhập họ tên']"));
    // Clear the text in the input field
            inputFieldName.clear();

            String phoneACC = data.get("Số điên thoại");
            System.out.println(phoneACC);
            if(!phoneACC.equals("Empty")) {
                driver.findElement(By.xpath("//input[@placeholder='Nhập số điện thoại']")).clear();
                Thread.sleep(100);

                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[2]/div[1]/div[1]/input[1]"))).sendKeys(data.get("Số điên thoại"));
            }
            String genderACC = data.get("Giới tính");
            if(genderACC.equals("Nam")) {
                System.out.println(genderACC);
                driver.findElement(By.xpath("//input[@value='MALE']")).click();
            }
            if(genderACC.equals("Nữ")) {
                System.out.println(genderACC);
                driver.findElement(By.xpath("//input[@value='FEMALE']")).click();
            }


            String statusACC = data.get("Trạng thái");

            if(statusACC.equals("Hoạt động")) {
                System.out.println(statusACC);
                driver.findElement(By.xpath("//input[@value='true']")).click();
            }
            if(statusACC.equals("Khóa")) {
                System.out.println(statusACC);
                driver.findElement(By.xpath("//input[@value='false']")).click();
            }


            WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[7]/div[1]/div[1]/div[1]/div[1]/button[2]/*[name()='svg'][1]"))); // Replace with the actual XPath or other locator

            // Click the input field to open the dropdown
            inputField.click();
            String roleAcc = data.get("Vai trò");
            System.out.println(roleAcc);
            // Wait for the dropdown options to be visible
            WebElement dropdownOption; // Replace with the actual XPath of the dropdown option
            if(roleAcc.equals("Quản trị viên")){
                driver.findElement(By.xpath("//li[text()='Quản trị viên']")).click();
            }
            if(roleAcc.equals("Quản trị viên cấp cao")){
                driver.findElement(By.xpath("//li[text()='Quản trị viên cấp cao']")).click();

            }
            if(roleAcc.equals("Người dùng")){
                driver.findElement(By.xpath("//li[text()='Người dùng']")).click();

            }
            // Click the desired option

//            Thread.sleep(2000); // Wait to see the selection
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[3]/button[1]/p[1]"))).click();
            Thread.sleep(1000);
            popupFailNotificationName();
            Thread.sleep(1000);

        }
    }

    @Khi("tài khoản được chỉnh sửa với thông tin không hợp lệ email")
    public void createMeetingUnsuccessfullyEmail(DataTable dataTable) throws InterruptedException {
        if (dataList == null) {
            dataList = dataTable.asMaps(String.class, String.class);
        }
        for (Map<String, String> data : dataList) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[7]/div[1]/div[1]/span[1]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/ul[1]/li[1]"))).click();
            String emailACC = data.get("Email");
            System.out.println(emailACC);
            if(!emailACC.equals("Empty")) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/input[1]"))).clear();
                Thread.sleep(100);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/input[1]"))).sendKeys(data.get("Email"));
            }

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[4]/div[1]/div[1]/input[1]"))).clear();
            Thread.sleep(100);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[4]/div[1]/div[1]/input[1]"))).sendKeys(data.get("Họ tên"));
            System.out.println(data.get("Họ tên"));

            String phoneACC = data.get("Số điên thoại");
            System.out.println(phoneACC);
            if(!phoneACC.equals("Empty")) {
                driver.findElement(By.xpath("//input[@placeholder='Nhập số điện thoại']")).clear();
                Thread.sleep(100);

                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[2]/div[1]/div[1]/input[1]"))).sendKeys(data.get("Số điên thoại"));
            }
            String genderACC = data.get("Giới tính");
            if(genderACC.equals("Nam")) {
                System.out.println(genderACC);
                driver.findElement(By.xpath("//input[@value='MALE']")).click();
            }
            if(genderACC.equals("Nữ")) {
                System.out.println(genderACC);
                driver.findElement(By.xpath("//input[@value='FEMALE']")).click();
            }


            String statusACC = data.get("Trạng thái");

            if(statusACC.equals("Hoạt động")) {
                System.out.println(statusACC);
                driver.findElement(By.xpath("//input[@value='true']")).click();
            }
            if(statusACC.equals("Khóa")) {
                System.out.println(statusACC);
                driver.findElement(By.xpath("//input[@value='false']")).click();
            }


            WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[7]/div[1]/div[1]/div[1]/div[1]/button[2]/*[name()='svg'][1]"))); // Replace with the actual XPath or other locator

            // Click the input field to open the dropdown
            inputField.click();
            String roleAcc = data.get("Vai trò");
            System.out.println(roleAcc);
            // Wait for the dropdown options to be visible
            WebElement dropdownOption; // Replace with the actual XPath of the dropdown option
            if(roleAcc.equals("Quản trị viên")){
                driver.findElement(By.xpath("//li[text()='Quản trị viên']")).click();
            }
            if(roleAcc.equals("Quản trị viên cấp cao")){
                driver.findElement(By.xpath("//li[text()='Quản trị viên cấp cao']")).click();

            }
            if(roleAcc.equals("Người dùng")){
                driver.findElement(By.xpath("//li[text()='Người dùng']")).click();

            }
            // Click the desired option

            Thread.sleep(2000); // Wait to see the selection
            //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[3]/button[1]/p[1]"))).click();
            Thread.sleep(1000);
            popupFailNotificationEmail();
            Thread.sleep(1000);

        }
    }

    @Khi("tài khoản được chỉnh sửa với thông tin không hợp lệ thiếu vai trò")
    public void createMeetingUnsuccessfullyVaiTro(DataTable dataTable) throws InterruptedException {
        if (dataList == null) {
            dataList = dataTable.asMaps(String.class, String.class);
        }
        for (Map<String, String> data : dataList) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[7]/div[1]/div[1]/span[1]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/ul[1]/li[1]"))).click();
            String emailACC = data.get("Email");
            System.out.println(emailACC);
            if(!emailACC.equals("Empty")) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/input[1]"))).clear();
                Thread.sleep(100);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/input[1]"))).sendKeys(data.get("Email"));
            }

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[4]/div[1]/div[1]/input[1]"))).clear();
            Thread.sleep(100);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[4]/div[1]/div[1]/input[1]"))).sendKeys(data.get("Họ tên"));
            System.out.println(data.get("Họ tên"));

            String phoneACC = data.get("Số điên thoại");
            System.out.println(phoneACC);
            if(!phoneACC.equals("Empty")) {
                driver.findElement(By.xpath("//input[@placeholder='Nhập số điện thoại']")).clear();
                Thread.sleep(100);

                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[2]/div[1]/div[1]/input[1]"))).sendKeys(data.get("Số điên thoại"));
            }
            String genderACC = data.get("Giới tính");
            if(genderACC.equals("Nam")) {
                System.out.println(genderACC);
                driver.findElement(By.xpath("//input[@value='MALE']")).click();
            }
            if(genderACC.equals("Nữ")) {
                System.out.println(genderACC);
                driver.findElement(By.xpath("//input[@value='FEMALE']")).click();
            }


            String statusACC = data.get("Trạng thái");

            if(statusACC.equals("Hoạt động")) {
                System.out.println(statusACC);
                driver.findElement(By.xpath("//input[@value='true']")).click();
            }
            if(statusACC.equals("Khóa")) {
                System.out.println(statusACC);
                driver.findElement(By.xpath("//input[@value='false']")).click();
            }


            WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[7]/div[1]/div[1]/div[1]/div[1]/button[2]/*[name()='svg'][1]"))); // Replace with the actual XPath or other locator

            // Click the input field to open the dropdown
            inputField.click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[7]/div[1]/div[1]/div[1]/div[1]/button[1]/*[name()='svg'][1]"))).click();

//            String roleAcc = data.get("Vai trò");
//            System.out.println(roleAcc);
//            // Wait for the dropdown options to be visible
//            WebElement dropdownOption; // Replace with the actual XPath of the dropdown option
//            if(roleAcc.equals("Quản trị viên")){
//                driver.findElement(By.xpath("//li[text()='Quản trị viên']")).click();
//            }
//            if(roleAcc.equals("Quản trị viên cấp cao")){
//                driver.findElement(By.xpath("//li[text()='Quản trị viên cấp cao']")).click();
//
//            }
//            if(roleAcc.equals("Người dùng")){
//                driver.findElement(By.xpath("//li[text()='Người dùng']")).click();
//
//            }
            // Click the desired option

            Thread.sleep(2000); // Wait to see the selection
            //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[3]/button[1]/p[1]"))).click();
            //Thread.sleep(1000);
            popupFailNotificationVaiTro();
            Thread.sleep(1000);

        }
    }

    @Thì("màn hình sẽ xuất hiện thông báo rằng đã chỉnh sửa tài khoản thành công")
    public void popupSuccessfulNotification()  {
        String popupXpath = "//h2[@id='swal2-title']";
        String popupMessage = driver.findElement(By.xpath(popupXpath)).getText();
        Assert.assertEquals(popupMessage, "Chỉnh sửa tài khoản thành công");
    }

    @Thì("màn hình sẽ xuất hiện thông báo rằng đã thiếu họ tên")
    public void popupFailNotificationName()  {
        WebElement valueError = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[4]/div[1]/p[1]"));
        Assert.assertEquals(valueError.getText(), "Họ tên không được rỗng");
    }

    @Thì("màn hình sẽ xuất hiện thông báo rằng email thêm không hợp lệ")
    public void popupFailNotificationEmail()  {
        WebElement valueError = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[1]/div[1]/p[1]"));
        Assert.assertEquals(valueError.getText(), "Email không hợp lệ");
    }
    @Thì("màn hình sẽ xuất hiện thông báo rằng đã chỉnh sửa tài khoản không thành công thiếu vai trò")
    public void popupFailNotificationVaiTro()  {
        WebElement valueError = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[7]/div[1]/div[1]/p[1]"));
        Assert.assertEquals(valueError.getText(), "Vui lòng chọn ít nhất 1 giá trị");
    }
//
}
