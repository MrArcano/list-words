package com.exercises.listwords.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Words {

    List <String> list;

    public Words(List<String> list) {
        this.list = list;
    }

    public void addWord(String s) {
        this.list.add(s);
    }

    public void removeWord(String s){
        this.list.remove(s);
    }

    public List<String> getList() {
        // Crea una nuova lista copiando l'originale
        List<String> newList = new ArrayList<>(this.list);

//        // metodo 1
//        newList.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
//        // metodo 2
//        newList.sort((o1,o2) -> o1.compareTo(o2));
//
//        // metodo 3
//        newList.sort(String::compareTo);

        // metodo 4
        Collections.sort(newList);

        return newList;
    }

    public void reset() {
        this.list.clear();
    }

}
