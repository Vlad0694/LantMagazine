package LantDeMagazine;

import java.util.ArrayList;

public class ProductStock {
    private int nrProduse;
    private Produs produs;

    public ProductStock() {

    }

    public int getNrProduse() {
        return nrProduse;
    }

    public void setNrProduse(int nrProduse) {
        this.nrProduse = nrProduse;
    }

    public Produs getProdus() {
        return produs;
    }

    public void setProdus(Produs produs) {
        this.produs = produs;
    }

    @Override

    public String toString(){
        return this.produs +" "+ this.nrProduse;
    }
}

