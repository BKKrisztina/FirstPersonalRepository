package application.models;
/**
 * this enum is for the SQL database 'MyBlog' font_type enum in blog_templates table
 */
public enum FontType {
    ABADI_MT_CONDENSED_LIGHT,
    ALBERTUS_EXTRA_BOLD,
    ALBERTUS_MEDIUM,
    ANTIQUE_OLIVE,
    ARIAL,
    ARIAL_BLACK,
    ARIAL_MT,
    ARIAL_NARROW,
    BAZOOKA,
    BOOK_ANTIQUA,
    BOOKMAN_OLD_STYLE,
    BOULDER,
    CALISTO_MT,
    CALLIGRAPHER,
    CENTURY_GOTHIC,
    CENTURY_SCHOOLBOOK,
    CEZANNE,
    CG_OMEGA,
    CG_TIMES,
    CHARLESWORTH,
    CHAUCER,
    CLARENDON_CONDENSED,
    COMIC_SANS_MS,
    COPPERPLATE_GOTHIC_BOLD,
    COPPERPLATE_GOTHIC_LIGHT,
    CORNERSTONE,
    CORONET,
    COURIER,
    COURIERNEW,
    CUCKOO,
    DAUPHIN,
    DENMARK,
    FRANSISCAN,
    GARAMOND,
    GENEVA,
    HAETTENSCHWEILER,
    HEATHER,
    HELVETICA,
    HERALD,
    IMPACT,
    JESTER,
    LETTER_GOTHIC,
    LITHOGRAPH,
    LITHOGRAPH_LIGHT,
    LONG_ISLAND,
    LUCIDA_CONSOLE,
    LUCIDA_HANDWRITING,
    LUCIDA_SANS,
    LUCIDA_SANS_UNICODE,
    MARIGOLD,
    MARKET,
    MATISSE_ITC,
    MS_LINEDRAW,
    NEWS_GOTHICMT,
    OCR_A_EXTENDED,
    OLD_CENTURY,
    PEGASUS,
    PICKWICK,
    POSTER,
    PYTHAGORAS,
    SCEPTRE,
    SHERWOOD,
    SIGNBOARD,
    SOCKET,
    STEAMER,
    STORYBOOK,
    SUBWAY,
    TAHOMA,
    TECHNICAL,
    TELETYPE,
    TEMPUS_SANS_ITC,
    TIMES,
    TIMES_NEW_ROMAN,
    TIMES_NEW_ROMAN_PS,
    TREBUCHETMS,
    TRISTAN,
    TUBULAR,
    UNICORN,
    UNIVERS,
    UNIVERS_CONDENSED,
    VAGABOND,
    VERDANA,
    WESTMINSTER;

    public static FontType find(String name) {
        for (FontType fontType : FontType.values()) {
            if (fontType.toString().replace("_", " ").equalsIgnoreCase(name)) {
                return fontType;
            }
        }
        return FontType.TIMES_NEW_ROMAN;
    }

    public int getDBIndex() {
        return ordinal() + 1;
    }
}
