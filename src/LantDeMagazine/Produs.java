package LantDeMagazine;

public class Produs {
    private int codBare;
    private String denumire;
    private String categorie;
    private double pret;
    private String termenValabilitate;
   // private int nrProduse;

    public Produs(int codBare, String denumire, String categorie, double pret, String termenValabilitate){
        this.codBare = codBare;
        this.denumire = denumire;
        this.categorie = categorie;
        this.pret = pret;
        this.termenValabilitate = termenValabilitate;
        //this.nrProduse = nrproduse;
    }

    public int getCodBare() {
        return codBare;
    }

    public String getDenumire() {
        return denumire;
    }

    public String getCategorie() {
        return categorie;
    }

    public double getPret() {
        return pret;
    }

    public String getTermenValabilitate() {
        return termenValabilitate;
    }

    public void setCodBare(int codBare) {
        this.codBare = codBare;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public void setTermenValabilitate(String termenValabilitate) {
        this.termenValabilitate = termenValabilitate;
    }

    @Override
    public String toString() {
        return  this.denumire +"  "+ this.categorie + "  " + this.pret + "  "+ this.codBare + "  " + this.termenValabilitate;
    }
}
