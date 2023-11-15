public class Studerende {
    private int stdnr;
    private String fnavn;
    private String enavn;

    public Studerende(int stdnr, String fnavn, String enavn) {
        this.stdnr = stdnr;
        this.fnavn = fnavn;
        this.enavn = enavn;
    }

    public int getStdnr() {
        return stdnr;
    }

    public void setStdnr(int stdnr) {
        this.stdnr = stdnr;
    }

    public String getFnavn() {
        return fnavn;
    }

    public void setFnavn(String fnavn) {
        this.fnavn = fnavn;
    }

    public String getEnavn() {
        return enavn;
    }

    public void setEnavn(String enavn) {
        this.enavn = enavn;
    }

    @Override
    public String toString() {
        return "Studerende{" +
                "stdnr=" + stdnr +
                ", fnavn='" + fnavn + '\'' +
                ", enavn='" + enavn + '\'' +
                '}';
    }
}
