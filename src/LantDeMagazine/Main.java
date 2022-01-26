package LantDeMagazine;

import java.util.Scanner;

public class Main {

    public static final int MENIU_PRINCIPAL = 100;

    public static void main(String[] args) {
       // Person person = new Person("Claudiu", "Ionescu", 743);
        LantDeMagazine profi = new LantDeMagazine();

        Magazin magazinIasi = new Magazin();
        Magazin magazinSV = new Magazin();
        Magazin magazinCluj = new Magazin();

        profi.getProfi().add(magazinIasi);
        profi.getProfi().add(magazinCluj);
        profi.getProfi().add(magazinSV);


        Produs produs1 = new Produs(214561, "Lapte", "Lactate", 5.99, "05.02.2022");
        Produs produs2 = new Produs(234453, "Smantana", "Lactate", 12.50, "12.01.2022");
        Produs produs3 = new Produs(647862, "Paine", "Panificatie", 4.99, "02.01.2022");
        Produs produs4 = new Produs(543569, "Paste", "Panificatie", 11.49, "07.06.2022");
        Produs produs5 = new Produs(975456, "Banane", "Fructe", 5.00, "23.02.2022");
        Produs produs6 = new Produs(876784, "Kiwi", "Fructe", 9.99, "24.03.2022");
        Produs produs7 = new Produs(513275, "Salam Sasesc", "Carne", 14.50, "19.04.2022");
        Produs produs8 = new Produs(964641, "Carnati", "Carne", 10.00, "11.02.2023");

          magazinCluj.addProdus(produs1, 50);
          magazinCluj.addProdus(produs2, 25);
          magazinCluj.addProdus(produs3, 100);

        magazinIasi.addProdus(produs4, 150);
        magazinIasi.addProdus(produs5, 10);

        magazinSV.addProdus(produs6, 87);
        magazinSV.addProdus(produs7, 90);
        magazinSV.addProdus(produs8, 120);

        magazinCluj.setName("Magazin Cluj");
        magazinIasi.setName("Magazin Iasi");
        magazinSV.setName("Magazin SV");

        while (true) {
            System.out.println("Meniu");
            System.out.println("Introdu tip utilizator (AD/UT)");
            Scanner key = new Scanner(System.in);


            String next = key.nextLine();
            //final String next = readUserAndPassword();
            String valoareTastaturaMeniuMare = "99";

            if (next.equals("AD")) {
                System.out.println("Meniu administrator");
                System.out.println("1 - Afisare magazine");
                next = key.nextLine();
                //if - user a selectat magazin existent
                if (next.equals("1")) {
                    afisareMagazine(profi);
                }
                System.out.println("Selectare magazin: - Magazin Iasi - Magazin Cluj - Magazin SV ");
                String numeMagazinSelectat = key.nextLine();
                Magazin magazinSelectat = new Magazin();
                while (true) {
                    magazinSelectat = magazinSelectat(profi, numeMagazinSelectat, magazinSelectat);
                    afisareMeniuAD();
                    String MeniuAD = key.nextLine();

                    //ADAUGARE PRODUS
                    if (MeniuAD.equals("1")) {
                        int valoareCititiaDeLaTasta = adaugareProdus(magazinSelectat, key, numeMagazinSelectat, profi);
                        if (MENIU_PRINCIPAL == valoareCititiaDeLaTasta) {
                            System.out.println("Tastati 99 pentru meniul Principal");
                            valoareTastaturaMeniuMare = key.nextLine();
                            if (Integer.parseInt(valoareTastaturaMeniuMare) == 99) {
                                break;
                            }
                        }
                    }

                    //MODIFICARE PRODUS

                    if (MeniuAD.equals("2")) {
                        int valoareCititiaDeLaTasta = modificarePret(magazinSelectat, key);
                        if (MENIU_PRINCIPAL == valoareCititiaDeLaTasta) {
                            continue;
                        }
                        System.out.println("Tastati 99 pentru meniul Principal");
                        valoareTastaturaMeniuMare = key.nextLine();
                        if(Integer.parseInt(valoareTastaturaMeniuMare) == 99){
                            break;
                        }
                    }

                    //REMOVE PRODUS
                    if (MeniuAD.equals("3")) {
                        afisareProduseMagazin(magazinSelectat);
                        int valoareCititiaDeLaTasta = removeProdus(magazinSelectat, key);
                        if (MENIU_PRINCIPAL == valoareCititiaDeLaTasta) {
                            continue;
                        }
                        System.out.println("Tastati 99 pentru meniul Principal");
                        valoareTastaturaMeniuMare = key.nextLine();
                        if(Integer.parseInt(valoareTastaturaMeniuMare) == 99){
                            break;
                        }
                    }

                    //AFISARE PRODUSE
                    if (MeniuAD.equals("4")) {
                        int valoareCititiaDeLaTasta = afisareProduseTasta4(magazinSelectat, key);
                        if (MENIU_PRINCIPAL == valoareCititiaDeLaTasta) {
                            continue;
                        }
                        //System.out.println("Tastati 99 pentru meniul Principal");
                        //valoareTastaturaMeniuMare = key.nextLine();
                        if(valoareTastaturaMeniuMare.equals("99")){
                            break;
                        }
                    }

                    // Exit MeniuAD
                    if ((MeniuAD.equals("5"))) {
                       // valoareTastaturaMeniuMare = key.nextLine();
                        if(valoareTastaturaMeniuMare.equals("99")){
                            break;
                        }
                    }
                }
            } else if (next.equals("UT")) {
                Magazin magazinSelectat = new Magazin();
                System.out.println("Mgazinele disponibile sunt: ");
                afisareMagazine(profi);
                System.out.println("Tasteaza Magazin Iasi / Magazin Cluj / Magazin SV");
                String nextAlegeMagazin = key.nextLine();
                if (nextAlegeMagazin.equals("Magazin Iasi") || nextAlegeMagazin.equals("Magazin Cluj") || nextAlegeMagazin.equals("Magazin SV")) {
                    magazinSelectat = magazinSelectat(profi, nextAlegeMagazin, magazinSelectat);
                }
                String before = null;
                while(true) {
                    if(before == null || Integer.parseInt(before) == 2){
                        System.out.println("1 - Afisare produse");
                    }

                    if(before == null || Integer.parseInt(before) == 1) {
                        System.out.println("2 - Cumpara produs");
                    }
                    System.out.println("3 - Exit");
                    String meniuUT = key.nextLine();
                    if (meniuUT.equals("1")) {
                        afisareProduseMagazin(magazinSelectat);
                        before = meniuUT;
                    }

                    if (meniuUT.equals("2")) {
                        cumparareProdus(key, magazinSelectat);
                        // System.out.println("Tastati 99 pentru meniul Principal");
                        // valoareTastaturaMeniuMare = key.nextLine();
                        // if (Integer.parseInt(valoareTastaturaMeniuMare) == 99) {
                        System.out.println("Produsele ramase sunt: ");
                        afisareProduseMagazin(magazinSelectat);
                        before = meniuUT;

                    }
                    if(meniuUT.equals("3")){
                        break;
                    }
                }
                break;
            }
        }
    }


    private static void afisareMagazine(LantDeMagazine profi) {
        for (int i = 0; i < profi.getProfi().size(); i++) {
            System.out.println(profi.getProfi().get(i));
        }
    }

    private static Magazin magazinSelectat(LantDeMagazine profi, String numeMagazinSelectat, Magazin magazinSelectat) {
        for (int i = 0; i < profi.getProfi().size(); i++) {
            if (numeMagazinSelectat.equalsIgnoreCase(profi.getProfi().get(i).getName())) {
                magazinSelectat = profi.getProfi().get(i);
                System.out.println("Aveti acces la " + magazinSelectat + " cu urmatorul meniu:");
            }
        }
        return magazinSelectat;
    }

    private static void cumparareProdus(Scanner key, Magazin magazinSelectat) {
        System.out.println("Alegeti produsul ales dupa nume");
        String produs_cumparat = key.nextLine();
        System.out.println("Numar de produse dorite");
        String nrProduseDorit = key.nextLine();
        boolean produsDevanzare = false;
        for (int i = 0; i < magazinSelectat.getStockOfProducts().size(); i++) {
            if (magazinSelectat.getStockOfProducts().get(i).getProdus().getDenumire().equals(produs_cumparat)) {
                System.out.println("Ati cumparat produsul: " + magazinSelectat.getStockOfProducts().get(i).getProdus().getDenumire());
                produsDevanzare = true;
                ProductStock produsIndiceI = magazinSelectat.getStockOfProducts().get(i);
                produsIndiceI.setNrProduse(produsIndiceI.getNrProduse() - Integer.parseInt(nrProduseDorit));

            }
        }
        if (!produsDevanzare) {
            System.out.println("Produsul nu mai este pe stock");
        }

    }

    private static void afisareMeniuAD() {
        System.out.println("1 - Adaugare produs");
        System.out.println("2 - Modificare produs");
        System.out.println("3 - Remove produs");
        System.out.println("4 - Afisare produse");
        System.out.println("5 - Exit");
    }

    static String readUserAndPassword () {
        Scanner key = new Scanner(System.in);
        final String user = key.nextLine();
        final String parola = key.nextLine();

        //read from file
        //if(file contains user + parola)
        {
            //read from file user type
            return "user type readed from file";
        }


    }

    public static Produs citireTastatura (Scanner key){
        System.out.println("Meniu Adaugare");
        System.out.println("Adauga denumire produs");
        String denumire_produs = key.nextLine();
        System.out.println("Adauga categorie produs");
        String categorie_produs = key.nextLine();
        System.out.println("Adaugare pret produs");
        String pret_produs = key.nextLine();
        System.out.println("Adaugare cod bare produs");
        String cod_bare = key.nextLine();
        System.out.println("Adaugare termen valabilitate produs");
        String termen_valabilitate = key.nextLine();
        // System.out.println("Adaugare numarul de produse");
        //  String nrproduse = key.nextLine();
        return new Produs(Integer.parseInt(cod_bare), denumire_produs, categorie_produs, Double.parseDouble(pret_produs), termen_valabilitate);
    }

    private static void afisareProduseMagazin (Magazin magazinSelectat){
        System.out.println("Produsele disponibile pentru " + magazinSelectat + " sunt:");
        for (int i = 0; i < magazinSelectat.getStockOfProducts().size(); i++) {
            System.out.println(magazinSelectat.getStockOfProducts().get(i));
        }
    }

    private static int modificarePret (Magazin magazinSelectat, Scanner key){
        afisareProduseMagazin(magazinSelectat);
        String nextCodBare;
        while (true) {
            System.out.println(" Selectati produsul dorit dupa cod_bare");
            nextCodBare = key.nextLine();
            for (int i = 0; i < magazinSelectat.getStockOfProducts().size(); i++) {
                if (Integer.parseInt(nextCodBare) == (magazinSelectat.getStockOfProducts().get(i).getProdus().getCodBare())) {
                    Produs produsGasit = magazinSelectat.getStockOfProducts().get(i).getProdus();
                    System.out.println("Produsul ales este: " + produsGasit);
                    System.out.println("Schimbati pretul cu unul nou");
                    String nextNewPrice = key.nextLine();
                    produsGasit.setPret(Double.parseDouble(nextNewPrice));
                    System.out.println("Noul produs este " + produsGasit);
                }
            }
            System.out.println("Tastati '1' pentru o noua medificare de produs ");
            System.out.println("Tastati 100 pentru Meniu Administrator");
            nextCodBare = key.nextLine();
            if (1 != Integer.parseInt(nextCodBare)) {
                break;
            }

        }
        return Integer.parseInt(nextCodBare);
    }

    private static int adaugareProdus (Magazin magazinSelectat, Scanner key, String
            numeMagazinSelectat, LantDeMagazine profi) {
        String next;
        while (true) {
            Produs produsAdaugat = citireTastatura(key);
            System.out.println("Produsul adaugat este " + produsAdaugat);
            for (int i = 0; i < profi.getProfi().size(); i++) {
                if (profi.getProfi().get(i).getName().equals(numeMagazinSelectat)) {
                    magazinSelectat = profi.getProfi().get(i);
                    magazinSelectat.addProdus(produsAdaugat, 1);
                }
            }
            System.out.println("Tastati 1 pentru a aduaga un nou produs");
            System.out.println("Tastati 100 pentru Meniu Administrator");
            next = key.nextLine();
            if (1 != Integer.parseInt(next)) {
                break;
            }
        }
        return Integer.parseInt(next);
    }

    private static int removeProdus(Magazin magazinSelectat, Scanner key){
        String next;
        while(true) {
            System.out.println("Alegeti produsul pe care doriti sa-l stergeti prin introducerea codului de bare");
            System.out.println("Introduceti codul de bare");
            int cod_bare_cautat =Integer.parseInt( key.nextLine());
            boolean produs_cautat = false;
            //  Produs produs_remove = null;
            for (int i = 0; i < magazinSelectat.getStockOfProducts().size(); i++) {
                if (cod_bare_cautat == (magazinSelectat.getStockOfProducts().get(i).getProdus().getCodBare())) {
                    System.out.println("Produsule eliminat este : " + magazinSelectat.getStockOfProducts().get(i).getProdus());
                    // produs_remove = magazinSelectat.getStockOfProducts().get(i).getProdus();
                    produs_cautat = true;
                    magazinSelectat.getStockOfProducts().remove(i);
                    afisareProduseMagazin(magazinSelectat);
                    break;
                }
            }
            if (!produs_cautat) {
                System.out.println("Produsul cautat nu corespunde nici unui cod de bare");
            }else {
                System.out.println("Mai doriti sa eleminati un alt produs? Tastati 1 pentru a reincerca");
                System.out.println("Tastati 100 pentru a va intoarce la MENIU ADMINISTRATOR");
            }
            next = key.nextLine();
            if(1 != Integer.parseInt(next)){
                break;
            }
        }
        return Integer.parseInt(next);
    }

    private static int afisareProduseTasta4(Magazin magazinSelectat, Scanner key){
        String MeniuAD;
        while(true) {
            afisareProduseMagazin(magazinSelectat);
            System.out.println(" Tastati 100 - MENIU ADMINISTRATOR");
            System.out.println("Tastati 5 - EXIT");
            MeniuAD = key.nextLine();

            if(Integer.parseInt(MeniuAD) == 100){
                break;
            }
            else{
                return Integer.parseInt(MeniuAD);
            }
        }
        return Integer.parseInt(MeniuAD);
    }

}

//TODO tratez toate exceptiile sa nu crape
//TODO serializare