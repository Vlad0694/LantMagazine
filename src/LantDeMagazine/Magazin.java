package LantDeMagazine;

import java.util.ArrayList;

public class Magazin {
    private ArrayList<ProductStock> StockOfProducts = new ArrayList<>();
    private String name;

    public String getName() {
        return name;
    }

    public void setStockOfProducts(ArrayList stockOfProducts) {

        StockOfProducts = stockOfProducts;
    }

    void addProdus(Produs produs, int nrProduse){
        if(produs.getDenumire()!=null && produs.getCategorie()!=null && produs.getPret()>0 && produs.getCodBare()>0 && produs.getTermenValabilitate()!=null){
            boolean b = false;
            for(int i = 0;  i < StockOfProducts.size(); i++){
                ProductStock produsIndiceI = StockOfProducts.get(i);
                if(produsIndiceI.getProdus().getCodBare() == produs.getCodBare()){
                    b = true;
                    produsIndiceI.setProdus(produs);
                    produsIndiceI.setNrProduse(produsIndiceI.getNrProduse()+1);
                }
            }

            if (!b){
                ProductStock productStock = new ProductStock();
                productStock.setProdus(produs);
                productStock.setNrProduse(nrProduse);
                StockOfProducts.add(productStock);
            }
        }
    }

    public ArrayList<ProductStock> getStockOfProducts() {
        return StockOfProducts;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void setName(String name) {

        this.name = name;
    }
}
