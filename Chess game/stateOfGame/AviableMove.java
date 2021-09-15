package stateOfGame;

/**
 * Aceasta clasa este folosita pentru a retine pozitia initiala a piesei,
 * unde x0 este linia, y0 este coloana. Iar x1 si y1 sunt linia si coloana,
 * pe care acesta piesa poate fi mutata.
 */
public class AviableMove {
    private Integer x0;
    private  Integer y0;
    private  Integer x1;
    private  Integer y1;

    /**
     *
     * @param x0 - linie initiala pe care se afla piesa;
     * @param y0 - coloana intiala pe care se afla piesa;
     * @param x1 - linia pe care urmeaza sa fie mutata piesa;
     * @param y1 - coloana pe care urmeaza sa fie mutata piesa;
     */
    public AviableMove(int x0, int y0, int x1, int y1) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }

    /**
     * Getteri si setteri pentru a returna o cordonata.
     */
    public Integer getX0() {
        return x0;
    }

    public Integer getY0() {
        return y0;
    }

    public Integer getX1() {
        return x1;
    }

    public Integer getY1() {
        return y1;
    }
}
