package ui.methods;

import org.openqa.selenium.WebDriver;

public interface SetUpParrel {
        WebDriver getDriver();

        default void open(String url) {
            getDriver().get(url);
        }

        default void refresh() {
            getDriver().navigate().refresh();
        }

        // ... other methods

}
