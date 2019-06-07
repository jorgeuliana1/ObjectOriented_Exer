package br.ufes.inf.prog3.jjmuliana.publication;

public abstract class EditorialPublication extends Publication {

    private String editor;

    public EditorialPublication(String title, String lang, String city, int p1, int p2, String editor) {
        super(title, lang, city, p1, p2);
        this.editor = editor;
    }

    public String getEditor() {
        return editor;
    }
}
