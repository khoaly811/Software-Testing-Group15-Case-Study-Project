package com.hcmus.mentor.backend.handlers;

import com.hcmus.mentor.backend.hooks.CommonHooks;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class handler{
    private final WebDriver driver = CommonHooks.driver;
    private final WebDriverWait wait = CommonHooks.wait;
    public String formatDate(String date) {
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
    public String formatTime(String time) {
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

    public void selectTime(String time) throws InterruptedException {
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

    public void clickClockPosition(WebElement clockElement, int value, boolean isHour) {
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
    public void selectDateForMeeting(String date) throws InterruptedException {
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
    public void selectDateGroup(String date) throws InterruptedException {
        // Expected date format: "d/MM/yyyy"
        String[] dateParts = date.split("/");
        String day = dateParts[0];
        String month = dateParts[1];

        // Convert the target month to an integer
        int targetMonth = Integer.parseInt(month);

        // Map month names to their corresponding numerical values
        Map<String, Integer> monthNameToNumber = new HashMap<>();
        monthNameToNumber.put("January", 1);
        monthNameToNumber.put("February", 2);
        monthNameToNumber.put("March", 3);
        monthNameToNumber.put("April", 4);
        monthNameToNumber.put("May", 5);
        monthNameToNumber.put("June", 6);
        monthNameToNumber.put("July", 7);
        monthNameToNumber.put("August", 8);
        monthNameToNumber.put("September", 9);
        monthNameToNumber.put("October", 10);
        monthNameToNumber.put("November", 11);
        monthNameToNumber.put("December", 12);

        // Navigate to the correct month
        while (true) {
            String displayedMonthYear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"))).getText();
            String displayedMonth = displayedMonthYear.split(" ")[0]; // This takes the first word, which is the month name

            // Convert the displayed month to an integer
            int displayedMonthNumber = monthNameToNumber.get(displayedMonth);
            if (displayedMonthNumber != targetMonth) {
                if (targetMonth < displayedMonthNumber) {
                    // Click the previous month button
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]/*[name()='svg'][1]"))).click();
                } else {
                    // Click the next month button
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/button[2]/*[name()='svg'][1]"))).click();
                }
                Thread.sleep(500); // Wait for the calendar to update
            } else {
                break;
            }
        }
        // Select the day
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@role='gridcell'][normalize-space()='"+ day +"']"))).click();
        Thread.sleep(1000);
    }
    public void selectPermissions(String permissions) {
        // Open the dropdown menu
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[4]/div[1]/div[1]/div[1]")));
        dropdown.click();

        if (permissions.equalsIgnoreCase("Tất cả")) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[1]/ul[1]/li[1]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[1]/ul[1]/li[2]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[1]/ul[1]/li[3]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[1]/ul[1]/li[4]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[1]/ul[1]/li[5]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[1]/ul[1]/li[6]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[2]/button[1]"))).click();
        } else {
            String[] permissionList = permissions.split(", ");
            for (String permission : permissionList) {
                if (permission.equalsIgnoreCase("Quyền gửi file")){
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[1]/ul[1]/li[1]"))).click();
                }
                if (permission.equalsIgnoreCase("Quyền quản lí công việc")){
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[1]/ul[1]/li[2]"))).click();
                }
                if (permission.equalsIgnoreCase("Quyền quản lý lịch hẹn")){
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[1]/ul[1]/li[3]"))).click();
                }
                if (permission.equalsIgnoreCase("Quyền quản lý bảng tin")){
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[1]/ul[1]/li[4]"))).click();
                }
                if (permission.equalsIgnoreCase("Quyền quản lý câu hỏi thường gặp")){
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[1]/ul[1]/li[5]"))).click();
                }
                if (permission.equalsIgnoreCase("Quyền cài đặt nhóm")){
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[1]/ul[1]/li[6]"))).click();
                }
            }
            dropdown.click();
        }
    }

    public List<Map<String, String>> readExcelData(String filePath) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        List<Map<String, String>> dataList = new ArrayList<>();

        // Get header row
        Row headerRow = sheet.getRow(0);
        int numberOfColumns = headerRow.getPhysicalNumberOfCells();
        String[] headers = new String[numberOfColumns];

        for (int i = 0; i < numberOfColumns; i++) {
            headers[i] = headerRow.getCell(i).getStringCellValue();
        }

        DataFormatter dataFormatter = new DataFormatter();

        // Iterate over rows, skipping the header row
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row currentRow = sheet.getRow(i);
            Map<String, String> dataMap = new HashMap<>();

            for (int j = 0; j < numberOfColumns; j++) {
                Cell currentCell = currentRow.getCell(j);
                String cellValue;

                if (currentCell != null) {
                    cellValue = dataFormatter.formatCellValue(currentCell);
                    dataMap.put(headers[j], cellValue);
                }
            }
            dataList.add(dataMap);
        }

        workbook.close();
        file.close();
        return dataList;
    }
}
