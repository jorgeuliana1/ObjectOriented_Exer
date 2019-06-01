package br.ufes.inf.prog3.jjmuliana.publication;

public class EditorialPublication extends Publication {

    private String editor;

    public EditorialPublication(String title, String lang, String city, boolean p, int p1, int p2, String editor) {
        super(title, lang, city, p, p1, p2);
        this.editor = editor;
    }

    public String getEditor() {
        return editor;
    }
}
