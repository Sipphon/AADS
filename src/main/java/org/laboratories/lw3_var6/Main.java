package org.laboratories.lw3_var6;

import org.laboratories.lw3_var6.list.DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Human> linkedList = new DoublyLinkedList<>();

        linkedList.add(new Human("Abramov Gleb Arturovich", "Forest Lane", "050659878", 20));
        linkedList.add(new Human("Gushchin Nikolay Ivanovich", "Princess Boulevard", "0995645674", 19));
        linkedList.add(new Human("Isaeva Eva Kirillovna", "Pearl Lane", "067452465", 2019));
        linkedList.add(new Human("Konstantinov Ivan Ivanovich", "Apollo Lane", "0634565564", 29));
        linkedList.add(new Human("Nesterova Kira Alexandrovna", "Main Route", "09564646", 21));
        linkedList.add(new Human("Lazarev Marat Glebovich", "Princess Boulevard", "050669878", 23));
        linkedList.add(new Human("Novikova Varvara Mikhailovna", "Forest Lane", "09615646", 26));
        linkedList.add(new Human("Prokhorov Georgy Artemovich", "Museum Street", "063564564", 27));
        linkedList.add(new Human("Semenov Ruslan Egorovich", "Campus Route", "06396865", 28));
        linkedList.add(new Human("Ageeva Kira Fedorovna", "Campus Route", "09665632", 10));

        linkedList.print();
        System.out.println();

        linkedList.addInFirstOddPosition(new Human("Semenova Alexandra Petrovna", "Gnida Street", "065856464", 10));
        linkedList.addInFirstOddPosition(new Human("Semenov Alexandr Petrovich", "Gnida Street", "065856564", 11));

       linkedList.addAtRandomOddPosition(new Human("GG","gg","54645646",0));

        linkedList.print();
        System.out.println(linkedList.contains(new Human("Semenov Alexandr Petrovich", "Gnida Street", "065856564", 11)));

        linkedList.remove(5);
        linkedList.print();
        System.out.println(linkedList.getSize());
    }
}
