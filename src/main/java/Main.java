import com.microsoft.playwright.*;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String email = "";
        final String password = "";
        final String emailForwardTo = "";

        try (Playwright playwright = Playwright.create()) {
            try (Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false))) {
                BrowserContext context = browser.newContext();
                Page page = context.newPage();
                page.navigate("http://mail.google.com/");
                page.locator("#identifierId").fill(email);
                page.locator(".VfPpkd-LgbsSe-OWXEXe-k8QpJ > div:nth-child(1)").click();
                page.locator("#password > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)").fill(password);
                page.locator("#passwordNext >> role=button[name=\"Next\"]").click();
                page.waitForTimeout(2000);
                page.navigate("https://mail.google.com/mail/u/0/#settings/fwdandpop");
                page.locator("#\\:3z > input:nth-child(1)").click();
                page.locator("#\\:3s").fill(emailForwardTo);
                Page popup = page.waitForPopup(() -> {
                    page.locator(".J-at1-auR").click();
                });
                popup.waitForLoadState();
                popup.locator("body > form:nth-child(3) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > input:nth-child(3)").click();
                page.locator(".J-at1-auR").click();
                page.locator("#\\:4e").fill("123456");
                page.locator("#\\:3y > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(2) > input:nth-child(2)").click();
                page.locator("#\\:3r").click();
                page.locator("#\\:3e").click();
            }
        }
    }
}