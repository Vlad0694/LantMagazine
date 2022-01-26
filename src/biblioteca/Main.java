package biblioteca;
    /*      1. O biblioteca care sa aiba o lista de carti
                a. Numarul de carti disponibile
                b. Carte :
                    i. Autor
                    ii. Nume
                    iii. isbn
                    iv. Gen
                        1) EX: SF, Police, Romantic samd
            1. Create 2 libraries
            a. Centrala
            b. Periferica
            2. Add carte in library
            3. Imprumut carte
            4. Retur carte
     */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Meniu");
        System.out.println("Introdu tip utilizator (AD/UT)");

        Library lib = new Library();
        Scanner key = new Scanner(System.in);
        while (true) {
            String next = key.next();
            if (next.equals("AD")) {
                System.out.println("Esti admin");
                System.out.println("Adauga carte?");
                while (true) {
                    String inputAdmin = key.next();
                    if (inputAdmin.equals("Yes")) {
                        System.out.println("Introdu date carte\n");
                        System.out.println("Introdu autor");
                        String autor = key.next();

                        System.out.println("Introdu titlu");
                        String titlu = key.next();

                        System.out.println("Introdu seria");
                        int isbn = key.nextInt();

                        System.out.println("Introdu genul");
                        String gen = key.next();
                        Book bookParameter = new Book(autor, titlu, isbn, gen);
                        System.out.println(bookParameter);
                    } else {
                        break;
                    }
                    System.out.println("Mai introduci ?");
                }
                for (int i = 0; i < lib.getRaft().size(); i++) {
                    System.out.println(lib.getRaft().get(i).getBook());
                }
                break;
            } else if (next.equals("UT")) {
                meniuUtilizator(lib, key);
                break;
            } else {
                System.out.println("Tip inexistent -- reintroduceti (AD/UT)");
            }
        }

        //testeleNoastre();
    }

    private static void testeleNoastre() {
        Library centrala = new Library();
        Library periferica = new Library();
        Book book = new Book("Tudor Arghezi", "Prima carte a lui Arghezi", 1, "Drama");
        Book book_2 = new Book("Eminem", "Prima carte a lui Eminem", 2, "Rap");

        centrala.addBook(book_2);
        periferica.addBook(book);
        periferica.addBook(book_2);
        periferica.addBook(book_2);
        Book book_3 = new Book("Eminescu", "Somnoroase pasarel", 2, "Rap");
        periferica.addBook(book_3);


        periferica.borrow(book_2);
        periferica.borrow(book_2);
        periferica.borrow(book_2);
        periferica.borrow(book_2);
        periferica.borrow(book_2);

        final Book book1 = new Book("ASB", "ASD", 2, "ASDD");
        periferica.borrow(book1);
        periferica.returnBook(book_2);
        periferica.returnBook(book1);
    }

    private static void extracted(Library centrala, Library periferica) {
        System.out.println("introdu comanda");
        System.out.println("1. Adauga carte");
        System.out.println("2. Imprumut carte");

        Scanner scanner = new Scanner(System.in);
        final int nrComanda = scanner.nextInt();

        if (nrComanda == 1) {
            System.out.println("introdu autor carte");

            final String autor = scanner.next();

            Book book = new Book(autor, "Prima carte a lui Arghezi", 1, "Drama");

            System.out.println("cate exemplare?");
            final int noOfbooks = scanner.nextInt();

            periferica.addBook(book);

        }
        Book book_2 = new Book("Eminem", "Prima carte a lui Eminem", 1, "Rap");

        centrala.addBook(book_2);
    }

    private static void meniuUtilizator(Library lib, Scanner key) {
        System.out.println("Esti utilizator");

        System.out.println("Meniu utilizator");
        System.out.println("Alegeti actiunea ! (1 / 2 / 3)");
        System.out.println("1 - Afisare carti disponibile pentru imprumut");
        System.out.println("2 - Imprumut carte");
        System.out.println("3 - Returnati carte");
      //  final String comanda = key.nextLine();
        while (true) {
                final int comanda = key.nextInt();
                if (comanda == 1){
                    //TODO -- afisare lista caryi dosponibile
                    System.out.println("Lista de carti este urmatoarea:");
                }
                else if (comanda == 2) {
                    //TODO  -- adaugare functionalitate imprumut carte
                    System.out.println("Imprumutati o carte");
                } else if (comanda == 3) {
                    //TODO  -- adaugare functionalitate retur carte
                    System.out.println("Ati ales 3, returnati o carte");
                } else if (comanda == 4) {
                    break;
                } else {
                    System.out.println("comanda gresita -- reintroduceti");
                    System.out.println("introduceti 4 - pentru a iesi");
                }
                System.out.println("Mai doriti sa introduceti o noua comanda?");
                String comanda_reintroduusa = key.nextLine();
                if (!"YES".equals(comanda_reintroduusa)) {
                    break;
                } else {
                    System.out.println("1 - Imprumut");
                    System.out.println("2 - Retur");
                }
            }
        }
    }