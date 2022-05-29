/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.main;

/**
 *
 * @author USER
 */
public class Main {

    public static void main(String[] args) {
        SinglyLinkedList<String> listString = new SinglyLinkedList<>();
        listString.addNode("Александр");
        listString.addNode("Борис");
        listString.addNode("Владимир");
        listString.addNode("Григорий");
        listString.print();

        SinglyLinkedList<Integer> listInt = new SinglyLinkedList<>();
        listInt.addNode(1);
        listInt.addNode(2);
        listInt.addBeginningList(3);
        listInt.addEndList(6);
        listInt.print();

        for (Integer t: listInt) {
            System.out.println(t);

        }
        
        for (Integer t: listInt) {
            System.out.println(t);
            if(t.equals(10))
            break;
        }
        listInt.newForEach(3,System.out::println);
    }
}
