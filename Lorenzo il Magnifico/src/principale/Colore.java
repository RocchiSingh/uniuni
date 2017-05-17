package principale;

/**
 * Created by ggnsingh on 15/05/2017.
 */
public enum Colore {

    RED("255, 59, 48"),
    GREEN("76, 217, 100"),
    PURPLE("88, 86, 214"),
    LIGHTBLUE ("52, 170, 220");
    private final String string;

    private Colore(final String string) {
        this.string = string;
    }



    public String getRGB() {
        return string;
    }

}
