package br.ufes.inf.prog3.jjmuliana.publication;

public enum PublicationConst {
    ANNAL("anais"), BOOK("livro"), MAGAZINE("artjr"), MUSIC("partmu"), PERIODIC("artpe"),
    GENERIC("outro"), TRANSLATION("tradu");

    private String value;

    PublicationConst(String v) {
        value = v;
    }

    @Override
    public String toString() {
        return value;
    }
}
