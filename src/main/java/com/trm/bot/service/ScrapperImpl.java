package com.trm.bot.service;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.trm.bot.model.TRM;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ScrapperImpl implements Scrapper {
    private final Browser browser;
    private final BrowserContext context;
    private final Page page;
    public ScrapperImpl(){
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch();
        context = browser.newContext();
        page = browser.newPage();

    }
    @Override
    public TRM getCurrentExchange() {
            page.navigate("https://www.superfinanciera.gov.co/CargaDriver/index.jsp");
            String trm = page.locator("body > table > tbody > tr.filaPub4 > td:nth-child(3)").textContent();
            Float floatTrm = Float.parseFloat(trm.replace(",", ""));
            TRM exchange =TRM.builder()
                    .currentExchange(floatTrm)
                    .year(LocalDate.now().getYear())
                    .month(LocalDate.now().getMonthValue())
                    .day(LocalDate.now().getDayOfMonth())
                    .build();
            context.close();
        return exchange;
    }
}
