package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest {

    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("DeviceName", "Pixel 2 API 30");
        dc.setCapability("udid", "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("platformVersion", "11");
        dc.setCapability("AppPackage", "com.google.android.calculator");
        dc.setCapability("AppActivity", "com.android.calculator2.Calculator");
        dc.setCapability("noReset", false);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, dc);
    }

    @AfterClass
    public void finish() {
        Utils.delay(3);
        driver.quit();
    }

    @Test
    public void testAdd() {
        MobileElement btnSatu = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_1");
        btnSatu.click();
        MobileElement btnAdd = (MobileElement) driver.findElementById("com.google.android.calculator:id/op_add");
        btnAdd.click();
        MobileElement btnDua = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
        btnDua.click();
        MobileElement btnSamaDengan = (MobileElement) driver.findElementById("com.google.android.calculator:id/eq");
        btnSamaDengan.click();
        MobileElement txtResult = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        String getTxtResult = txtResult.getText();
        System.out.println(getTxtResult);
        Assert.assertEquals(getTxtResult, "3");
    }

    // testSubtract, 3-4=-1
    @Test
    public void addTestSubtrek() {
        MobileElement btnTiga = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_3");
        btnTiga.click();
        MobileElement btnKurang = (MobileElement) driver.findElementById("com.google.android.calculator:id/op_sub");
        btnKurang.click();
        MobileElement btnEmpat = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_4");
        btnEmpat.click();
        MobileElement btnSamaDengan = (MobileElement) driver.findElementById("com.google.android.calculator:id/eq");
        btnSamaDengan.click();
        MobileElement txtResult = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        String getTxtResult = txtResult.getText();
        System.out.println(getTxtResult);
        Assert.assertEquals(getTxtResult, "−1");
    }


}
