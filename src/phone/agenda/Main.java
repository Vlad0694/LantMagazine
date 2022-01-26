package phone.agenda;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
       // System.out.println(" ===== Adding agenda content =====");

        Person p1 = new Person("Vlad Visinescu", "0754343542");

        Person p2 = new Person("Claudiu Ionescu", "0756734254");

        Person p3 = new Person("Ion Antonescu", "0234542");

        Person p4 = new Person("Vasile Cartarescu", "0743645437");

        agenda.addNumberInAgenda(p1);
        agenda.addNumberInAgenda(p2);
        agenda.addNumberInAgenda(p1);
        agenda.addNumberInAgenda(p3);
        agenda.addNumberInAgenda(p3);
        agenda.addNumberInAgenda(p4);
 //       agenda.removeNumberFromAgenda(p3);
        agenda.updatePhoneNumberInAgenda("Ion Antonescu", "123456789");
        agenda.updateNameOfPersonFromAgenda("0754343542", "Vlad Craciun");

        //print agenda content -- maybe here you need to add a new method to have acces to agenda content
        for(int i = 0; i < agenda.getAgendContent().size(); i++) {
           System.out.println(agenda.getAgendContent().get(i));
        }

        //remove a person from agenda
        //System.out.println(" ===== Printing agenda content =====");
        //print agenda content
        //System.out.println(" ===== Updating something in agenda =====");

        //update a phone number
        //update a phone name
        //System.out.println(" ===== Printing agenda content =====");
        // print agenda content
        //print agenda sorted
        System.out.println(agenda.getAgendaSortedByName());
    }
}
