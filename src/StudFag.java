public class StudFag {
    private int id;
    private int stdnr;
    private int fagid;
    private String kar;

    public StudFag(int id, int stdnr, int fagid, String kar) {
        this.id = id;
        this.stdnr = stdnr;
        this.fagid = fagid;
        this.kar = kar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStdnr() {
        return stdnr;
    }

    public void setStdnr(int stdnr) {
        this.stdnr = stdnr;
    }

    public int getFagid() {
        return fagid;
    }

    public void setFagid(int fagid) {
        this.fagid = fagid;
    }

    public String getKar() {
        return kar;
    }

    public void setKar(String kar) {
        this.kar = kar;
    }

    @Override
    public String toString() {
        return "StudFag{" +
                "id=" + id +
                ", stdnr=" + stdnr +
                ", fagid=" + fagid +
                ", kar='" + kar + '\'' +
                '}';
    }
}
