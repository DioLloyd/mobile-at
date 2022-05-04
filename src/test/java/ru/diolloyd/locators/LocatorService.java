package ru.diolloyd.locators;

import ru.diolloyd.locators.android.AndroidBottomNavigationBarLocators;
import ru.diolloyd.locators.android.AndroidFormsPageLocators;
import ru.diolloyd.locators.android.AndroidLoginPageLocators;
import ru.diolloyd.locators.android.AndroidMainPageLocators;
import ru.diolloyd.locators.android.AndroidSwipePageLocators;
import ru.diolloyd.locators.interfaces.BottomNavigationBarLocators;
import ru.diolloyd.locators.interfaces.FormsPageLocators;
import ru.diolloyd.locators.interfaces.LoginPageLocators;
import ru.diolloyd.locators.interfaces.MainPageLocators;
import ru.diolloyd.locators.interfaces.SwipePageLocators;
import ru.diolloyd.locators.ios.IOSBottomNavigationBarLocators;
import ru.diolloyd.locators.ios.IOSFormsPageLocators;
import ru.diolloyd.locators.ios.IOSLoginPageLocators;
import ru.diolloyd.locators.ios.IOSMainPageLocators;
import ru.diolloyd.locators.ios.IOSSwipePageLocators;

public class LocatorService {

    public static final BottomNavigationBarLocators BOTTOM_NAVIGATION_BAR_LOCATORS = getBottomNavigationBarLocators();

    public static final FormsPageLocators FORMS_PAGE_LOCATORS = getFormsPageLocators();

    public static final LoginPageLocators LOGIN_PAGE_LOCATORS = getLoginPageLocators();

    public static final MainPageLocators MAIN_PAGE_LOCATORS = getMainPageLocators();

    public static final SwipePageLocators SWIPE_PAGE_LOCATORS = getSwipePageLocators();

    private static SwipePageLocators getSwipePageLocators() {
        return System.getProperty("platform").equals("Android") ?
                new AndroidSwipePageLocators() : new IOSSwipePageLocators();
    }


    private static BottomNavigationBarLocators getBottomNavigationBarLocators() {
        return System.getProperty("platform").equals("Android") ?
                new AndroidBottomNavigationBarLocators() : new IOSBottomNavigationBarLocators();
    }

    private static FormsPageLocators getFormsPageLocators() {
        return System.getProperty("platform").equals("Android") ?
                new AndroidFormsPageLocators() : new IOSFormsPageLocators();
    }

    private static LoginPageLocators getLoginPageLocators() {
        return System.getProperty("platform").equals("Android") ?
                new AndroidLoginPageLocators() : new IOSLoginPageLocators();
    }

    private static MainPageLocators getMainPageLocators() {
        return System.getProperty("platform").equals("Android") ?
                new AndroidMainPageLocators() : new IOSMainPageLocators();
    }

}
