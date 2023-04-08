import java.util.ArrayList;

public class Companie {
    private String numeCompanie;
    private ArrayList<Angajat> listOfAngajati = new ArrayList<Angajat>();

    public Companie(String numeCompanie, ArrayList<Angajat> listOfAngajati) {
        this.numeCompanie = numeCompanie;
        this.listOfAngajati = listOfAngajati;
    }

    public String getNumeCompanie() {
        return numeCompanie;
    }

    public void setNumeCompanie(String numeCompanie) {
        this.numeCompanie = numeCompanie;
    }

    public ArrayList<Angajat> getListOfAngajati() {
        return listOfAngajati;
    }

    public void setListOfAngajati(ArrayList<Angajat> listOfAngajati) {
        this.listOfAngajati = listOfAngajati;
    }

    public void adaugaAngajat(Angajat s){
        listOfAngajati.add(s);
    }

    public void stergeAngajat(Angajat s){
        listOfAngajati.remove(s);
    }

    public void stergeAngajatCuUnId(int idAngajat){
        for(int i = 0; i < listOfAngajati.size(); i++){
            if(listOfAngajati.get(i).getIdAngajat() == idAngajat){
                listOfAngajati.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        return "Companie{" +
                "numeCompanie='" + numeCompanie + '\'' +
                ", listOfAngajati=" + listOfAngajati +
                '}';
    }
}
