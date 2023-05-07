public class Student {
    private String imie;
    private String nazwisko;
    private String PESEL;

    private int Index;

    public Student(String imie, String nazwisko, String PESEL, int index) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.PESEL = PESEL;
        Index = index;
    }

    @Override
    public String toString() {
        return "Imie: "+this.imie+" Nazwisko: "+ this.nazwisko+" PESEL: "+this.PESEL+" Index: "+this.Index;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public int getIndex() {
        return Index;
    }

    public void setIndex(int index) {
        Index = index;
    }
}
