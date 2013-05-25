package andr.lexibook.mylittlestory.lrrh.model;

import java.io.Serializable;

/**
 * User: rain
 * Date: 5/13/13
 * Time: 10:53 AM
 */
public class ReadMode implements Serializable {

    private static final long serialVersionUID = 1L;
    private boolean isFirst;
    private boolean isAuto;
    private String lang;

    public ReadMode() {
        this.setFirst(true);
        this.setAuto(true);
        this.setLang("English");
    }

    public ReadMode(boolean isFirst, boolean isAuto, String lang) {
        this.isFirst = isFirst;
        this.isAuto = isAuto;
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public boolean isAuto() {
        return isAuto;
    }

    public void setAuto(boolean auto) {
        isAuto = auto;
    }
}
