package org.laboratories.lw2_var6;

import org.laboratories.lw2_var6.list.LinkedList;

public class Main {
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        linkedList.addLastObject(new Human("Abramov Gleb Arturovich", "Forest Lane", "050659878", 20));
        linkedList.addLastObject(new Human("Gushchin Nikolay Ivanovich", "Princess Boulevard", "0995645674", 19));
        linkedList.addLastObject(new Human("Isaeva Eva Kirillovna", "Pearl Lane", "067452465", 2019));
        linkedList.addLastObject(new Human("Konstantinov Ivan Ivanovich", "Apollo Lane", "0634565564", 29));
        linkedList.addLastObject(new Human("Nesterova Kira Alexandrovna", "Main Route", "09564646", 21));
        linkedList.addFirstObject(new Human("Lazarev Marat Glebovich", "Princess Boulevard", "050669878", 23));
        linkedList.addLastObject(new Human("Novikova Varvara Mikhailovna", "Forest Lane", "09615646", 26));
        linkedList.addLastObject(new Human("Prokhorov Georgy Artemovich", "Museum Street", "063564564", 27));
        linkedList.addLastObject(new Human("Semenov Ruslan Egorovich", "Campus Route", "06396865", 28));
        linkedList.addLastObject(new Human("Ageeva Kira Fedorovna", "Campus Route", "09665632", 10));

        linkedList.print();

        System.out.println();

        linkedList.getPhonesFromOperators("Vodafone");

        System.out.println();

        linkedList.getHumansWhichLiveTheSameStreet("princess boulevard");

        System.out.println();

        linkedList.addFirstObject(new Human("Semenova Alexandra Petrovna", "Gnida Street", "065856464", 10));
        linkedList.addLastObject(new Human("Semenov Alexandr Petrovich", "Gnida Street", "065856564", 11));
        linkedList.insertObject(2, new Human("P", "P", "00000000000", 10));

        linkedList.print();

        System.out.println(linkedList.contains(new Human("Semenov Alexandr Petrovich", "Gnida Street", "065856564", 11)));

        System.out.println(linkedList.getObject(5));

        System.out.println();

        linkedList.removeObject(5);
        linkedList.removeFirstObject();
        linkedList.removeLastObject();


        linkedList.print();

        System.out.println(linkedList.getSize());

        linkedList.clear();

        linkedList.print();
    }
}