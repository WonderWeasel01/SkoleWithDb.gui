public class Fag {
    private int fagid;
    private  String fagnavn;

    public Fag(int fagid, String fagnavn) {
        this.fagid = fagid;
        this.fagnavn = fagnavn;
    }

    public int getFagid() {
        return fagid;
    }

    public void setFagid(int fagid) {
        this.fagid = fagid;
    }

    public String getFagnavn() {
        return fagnavn;
    }

    public void setFagnavn(String fagnavn) {
        this.fagnavn = fagnavn;
    }

    @Override
    public String toString() {
        return "Fag{" +
                "fagid=" + fagid +
                ", fagnavn='" + fagnavn + '\'' +
                '}';
    }
}
