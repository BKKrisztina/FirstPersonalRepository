package application.models;

public class BlogTemplates {

    private int blogTemplateID;
    private String templateName;
    private FontColour fontColour;
    private FontType fontType;
    private byte[] backgroundImage;

    public BlogTemplates() {
    }

    public BlogTemplates(int blogTemplateID, String templateName, FontColour fontColour, FontType fontType, byte[] backgroundImage) {
        this.blogTemplateID = blogTemplateID;
        this.templateName = templateName;
        this.fontColour = fontColour;
        this.fontType = fontType;
        this.backgroundImage = backgroundImage;
    }
    public BlogTemplates(int blogTemplateID, String templateName, FontColour fontColour, FontType fontType) {
        this.blogTemplateID = blogTemplateID;
        this.templateName = templateName;
        this.fontColour = fontColour;
        this.fontType = fontType;

    }

    public int getBlogTemplateID() {
        return blogTemplateID;
    }

    public void setBlogTemplateID(int blogTemplateID) {
        this.blogTemplateID = blogTemplateID;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public FontColour getFontColour() {
        return fontColour;
    }

    public void setFontColour(FontColour fontColour) {
        this.fontColour = fontColour;
    }

    public FontType getFontType() {
        return fontType;
    }

    public void setFontType(FontType fontType) {
        this.fontType = fontType;
    }

    public byte[] getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(byte[] backgroundImage) {
        this.backgroundImage = backgroundImage;
    }
}
