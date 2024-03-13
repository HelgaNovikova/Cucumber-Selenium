package utils;

public final class ContactUsPageXpaths {
    private ContactUsPageXpaths() {
    }

    public static final String FIRST_NAME_INPUT = "//input[@name='first_name']";
    public static final String LAST_NAME_INPUT = "//input[@name='last_name']";
    public static final String EMAIL_INPUT = "//input[@name='email']";
    public static final String PHONE_INPUT = "//input[@name='phone']";
    public static final String MESSAGE_INPUT = "//*[@name='message']";
    public static final String SUBMIT_BUTTON = "//button[@type='submit']";
    public static final String IFRAME = "//iframe[@class='contact-us']";
}
