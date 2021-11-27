package com.soon.cording.hashmap;


import java.util.LinkedList;

class HashMap {
    class Node {
        String key;
        String value;
        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    LinkedList<Node>[] data;
    HashMap(int size) {
        this.data = new LinkedList[size];
    }

    int getHashCode(String key) {
        int hashCode = 0;
        for(char c: key.toCharArray()) {
            hashCode+= c;
        }
        return hashCode;
    }

    int convertToIndex(int hashCode) {
        return hashCode & data.length;
    }

    Node searchKey(LinkedList<Node> list , String key) {
        if(list ==null) return null;
        for(Node node : list) {
            if(node.key.equals(key)) {
                return node;
            }
        }
        return null;
    }

    void put(String key, String value) {
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        LinkedList<Node> list = data[index];
        if(list==null) {
            list = new LinkedList<>();
            data[index] = list;
        }
        Node node = searchKey(list,key);

        if(node ==null) {
            list.addLast(new Node(key,value));
        }else {
            node.setValue(value);
        }
    }

    String get(String key) {
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        LinkedList<Node> list = data[index];
        Node node = searchKey(list,key);

        return node == null ? "Not found" : node.getValue();
    }

}

public class SoonHashMap {

    public static void main(String[] args) {
        HashMap hashMap = new HashMap(5);
        hashMap.put("A","알파벳 A");
        hashMap.put("B", "알파벳 B");

        System.out.println(hashMap.get("A"));
        System.out.println(hashMap.get("B"));
        System.out.println(hashMap.get("C"));
    }
}
