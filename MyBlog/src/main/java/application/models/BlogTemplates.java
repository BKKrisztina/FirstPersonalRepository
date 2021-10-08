package application.models;

import lombok.Getter;

/**
 * this class is to handle the SQL database 'MyBlog' blog_templates table data
 */
public class BlogTemplates {
    @Getter
    private int blogTemplateID;
    @Getter
    private String templateName;
    @Getter
    private FontColour fontColour;
    @Getter
    private FontType fontType;
    @Getter
    private byte[] backgroundImage;

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

}
