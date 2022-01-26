package phone.agenda;
import java.util.ArrayList;

public class Agenda {
    private ArrayList<Person> agendContent = new ArrayList<>();

    /*
    this methdo should add a created person in agenda
    minimal checks should be don
        1. p has name
        2. p has phone number
    If one field is not defined, a message should be displayed and person is not added in agenda.
    Before adding the person in agenda, check that the number and name does not exists
     */
    public void addNumberInAgenda(Person p) {
        boolean found = false;
        for (int i = 0; i < agendContent.size(); i++) {
            if (agendContent.get(i).getName().equals(p.getName()) &&
                    (agendContent.get(i).getPhoneNumber().equals(p.getPhoneNumber()))) {
                found = true;
            }
        }
        if (found == false) {
            this.agendContent.add(p);
        } else {
            System.out.println("Persoana exista deja");
        }
    }

    /*
    Remove a person from agenda
    Minimal checks made for the person to be removed
        1. p has name
        2. p has phone number
     */
    public void removeNumberFromAgenda(Person p) {
        if (p.getName() != null && p.getPhoneNumber() != null) {
            for (int i = 0; i < agendContent.size(); i++) {
                if (agendContent.get(i).getPhoneNumber().equals(p.getPhoneNumber()) &&
                        agendContent.get(i).getName().equals(p.getName())) {
                    agendContent.remove(i);
                    break;
                }
            }
        }
    }

    public void updatePhoneNumberInAgenda(String name, String phonenumber) {
        for (int i = 0; i < agendContent.size(); i++) {
            if (agendContent.get(i).getName().equals(name)) {
                agendContent.get(i).setPhoneNumber(phonenumber);
                break;
            }
        }

    }

    public void updateNameOfPersonFromAgenda(String phonenumber, String name) {
        for (int i = 0; i < agendContent.size(); i++) {
            if (agendContent.get(i).getPhoneNumber().equals(phonenumber)) {
                agendContent.get(i).setName(name);
                break;
            }
        }
    }

    /*
    Return a NEW array list, that contains the agenda sorted by name
     */
    public ArrayList<Person> getAgendaSortedByName() {
        ArrayList<Person> agendToBeReturned = agendContent;
        Person counter;
        for (int i = 0; i < agendToBeReturned.size(); i++) {
            for (int j = i + 1; j < agendToBeReturned.size(); j++) {
                if (agendToBeReturned.get(i).getName().compareTo(agendToBeReturned.get(j).getName()) > 0) {
                    counter = agendToBeReturned.get(i);
                    agendToBeReturned.set(i, agendToBeReturned.get(j));
                    agendToBeReturned.set(j, counter);
                }
            }
        }
        return agendToBeReturned;
    }

    public ArrayList<Person> getAgendContent() {
    return this.agendContent;
    }
}



