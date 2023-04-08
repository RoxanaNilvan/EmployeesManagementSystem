public class Angajat {
    private int idAngajat;
    private String numeAngajat;
    private String prenumeAngajat;
    private boolean concediu;

    public Angajat(int idAngajat, String numeAngajat, String prenumeAngajat, boolean concediu) {
        this.idAngajat = idAngajat;
        this.numeAngajat = numeAngajat;
        this.prenumeAngajat = prenumeAngajat;
        this.concediu = concediu;
    }

    public int getIdAngajat() {
        return idAngajat;
    }

    public void setIdAngajat(int idAngajat) {
        this.idAngajat = idAngajat;
    }

    public String getNumeAngajat() {
        return numeAngajat;
    }

    public void setNumeAngajat(String numeAngajat) {
        this.numeAngajat = numeAngajat;
    }

    public String getPrenumeAngajat() {
        return prenumeAngajat;
    }

    public void setPrenumeAngajat(String prenumeAngajat) {
        this.prenumeAngajat = prenumeAngajat;
    }

    public boolean isConcediu() {
        return concediu;
    }

    public void setConcediu(boolean concediu) {
        this.concediu = concediu;
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "idAngajat=" + idAngajat +
                ", numeAngajat='" + numeAngajat + '\'' +
                ", prenumeAngajat='" + prenumeAngajat + '\'' +
                ", concediu=" + concediu +
                '}';
    }

}
