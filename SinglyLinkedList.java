package edu.desu.list;

public class SinglyLinkedList<T> {

    private Node<T> headNode;

    public SinglyLinkedList(){
        this.headNode = null;
    }

    public boolean isEmpty() {
        return headNode == null;
    }

    public void insertAtHead(T data){
        Node<T> previousNode = headNode;
        Node<T> node = new Node<>(data);
        node.setNextNode(previousNode);
        this.headNode = node;
    }

    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            headNode = newNode;
        } else {
            Node<T> temp = headNode;
            while (temp.hasNext()) {
                temp = temp.getNextNode();
            }
            temp.setNextNode(newNode);
        }

    }

    public void insertAfter(T existingData, T newData) {
        Node<T> temp = headNode;
        while (temp != null && !temp.getData().equals(existingData)) {
            temp = temp.getNextNode();
        }
        if (temp != null) {
            Node<T> newNode = new Node<>(newData);
            newNode.setNextNode(temp.getNextNode());
            temp.setNextNode(newNode);
        } else {
            throw new IllegalArgumentException("Element not found.");
        }
    }

    public void delete(T data) {
        if (isEmpty()) return;

        if (headNode.getData().equals(data)) {
            headNode = headNode.getNextNode();
            return;
        }

        Node<T> temp = headNode;
        while (temp.hasNext() && !temp.getNextNode().getData().equals(data)) {
            temp = temp.getNextNode();
        }

        if (temp.hasNext()) {
            temp.setNextNode(temp.getNextNode().getNextNode());
        } else {
            throw new IllegalArgumentException("Element not found.");
        }
    }

    public void deleteAtHead() {
        if (!isEmpty()) {
            headNode = headNode.getNextNode();
        }
    }

    public void deleteAtEnd() {
        if (isEmpty()) return;

        if (!headNode.hasNext()) {
            headNode = null;
            return;
        }

        Node<T> temp = headNode;
        while (temp.getNextNode().hasNext()) {
            temp = temp.getNextNode();
        }
        temp.setNextNode(null);
    }

    public boolean contains(T data) {
        Node<T> temp = headNode;
        while (temp != null) {
            if (temp.getData().equals(data)) return true;
            temp = temp.getNextNode();
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        Node<T> node = headNode;
        while (node != null) {
            data.append(node.getData().toString());
            if (node.hasNext()) {
                data.append(", ");
            }
            node = node.getNextNode();
        }
        return data.toString();
    }
}
