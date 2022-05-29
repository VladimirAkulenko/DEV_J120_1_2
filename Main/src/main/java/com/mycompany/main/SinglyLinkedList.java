/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author USER
 */
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

public class SinglyLinkedList <T> implements Iterable<T>{
    private Node first;

    // добавление значения в список
    public void addNode (T variable){
        Node node = new Node(variable);
        if(first == null){
            first=node;
            return;
        }
        Node temp = first;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next =node;
    }


    // добавление значения в начало списка
    public void addBeginningList (T variable){
        Node newNode = new Node(variable);
        newNode.date = variable;
        newNode.next = first;
        first =newNode;
    }

    // Извлечение значения из начала списка без его удаления из списка

    public T extractionBeginningList (){
        if (first != null)
            return (T) first.date;
        else
            throw new IllegalArgumentException("Список пуст");
    }
    // Извлечение значения из начала списка с удалением из списка
    public T extractionDeleteList () {
        if (first != null) {
            T firstDate = (T) first.date;
            first = first.next;
            return firstDate;
        }
        else
            throw new IllegalArgumentException("Список пуст");
    }

    // Добавление значения в конец списка
    public void addEndList (T variable){
        Node newNode = new Node(variable);
        if(first == null){
            first=newNode;
            return;
        }
        Node temp = first;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next =newNode;
    }

    //Извлечение значения из конца списка без его удаления
    public T extractionEndList (){
        if (first != null){
            Node temp = first;
            while (temp.next != null){
                temp = temp.next;}
            return (T) temp.date;
        }
        else
            throw new IllegalArgumentException("Список пуст");
    }

    //Извлечение значения из конца списка с удалением
    public T extractionEndDeleteList (){
        if (first != null && first.next == null) {
            T firstDate = (T) first.date;
            first = null;
            return firstDate;
        }
        else if(first != null && first.next != null){
            Node temp = first;
            Node tail= first;
            while (temp.next != null){
                tail = temp;
                temp = temp.next;
            }
            T newDate = (T) temp.date;
            temp = tail;
            temp.next= null;
            return newDate;
        }
        else
            throw new IllegalArgumentException("Список пуст");
    }

    // Определение, содержит ли список заданное значение, или нет
    public boolean setValueList (T variable){
        Node temp = first;
        boolean result = false;
        if(first == null)
            return false;
        else if (temp.next == null){
            return variable.equals(temp.date);
        }
        else
            while (temp.next != null){
                if(variable.equals(temp.date)){
                    result = true;
                    temp = temp.next;
                }
                else
                    temp = temp.next;
            }
        return  result;
    }


    // Определение, является ли список пустым, или нет
    public boolean emptyList (){
        if (first == null)
            System.out.println("Список пуст");
        return first == null;

    }

    // Печать всех значений списка
    public void print() {
        if (first == null) return;
        Node temp = first;
        System.out.println(temp.date);
        while (temp.next != null){
            temp = temp.next;
            System.out.println(temp.date);
        }
    }
    // Метод перебирает при помощи оператора «for-each»: содержимое списка от узла с
    // заданным значением до конца списка; если список заданного значения не содержит,
    // то ничего происходить не должно

    public void newForEach (T element, Consumer<? super T> operation){
        Objects.requireNonNull(operation);
        for (T t: this) {
            operation.accept(t);
            if (t.equals(element))
                break;
        }
    }
    // Метод перебирает при помощи оператора «for-each»: содержимое списка от головного
    // узла до узла с заданным значением; если список заданного значения не содержит,
    // то должно быть перебрано всё содержимое спис-ка
    public void newForEach (Consumer<? super T> operation, T elements){
        Objects.requireNonNull(operation);
        boolean b = false;
        for (T t: this) {
            if (t.equals(elements) == b)
                continue;
            b = true;
            operation.accept(t);
        }
    }


    @Override
    public Iterator iterator() {
        return new NewIterator <T>(first);
    }

    private class Node <T> {
        T date;
        Node next;

        Node(T variable){
            date = variable;
        }
    }
    class NewIterator <T> implements Iterator<T>{

        Node<T> tNode;

        public NewIterator(Node<T> tNode) {
            this.tNode = tNode;
        }

        @Override
        public boolean hasNext() {
            return tNode != null;
        }

        @Override
        public T next() {
            if (tNode == null) throw new NoSuchElementException();
            T result = (T) tNode.date;
            tNode = tNode.next;
            return result;
        }
    }

}
