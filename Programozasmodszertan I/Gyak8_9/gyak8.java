package gyak8;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class gyak8 {

    public static void main(String[] args) throws InvalidDayException {

        //PriorityQueue és Comparable interfész

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(20);
        pq.offer(35);
        pq.offer(10);
        pq.offer(5);

        System.out.println(pq.peek());
        pq.poll();
        System.out.println(pq.peek());

        class Node implements Comparable<Node>{
            int row;
            int col;
            int cost;

            public Node(int row, int col, int cost) {
                this.row = row;
                this.col = col;
                this.cost = cost;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "row=" + row +
                        ", col=" + col +
                        ", cost=" + cost +
                        '}';
            }

            @Override
            public int compareTo(Node other) {
                return this.cost - other.cost;
            }
        }

        Node node1 = new Node(0,0,2);
        Node node2 = new Node(1,0,1);
        Node node3 = new Node(2,1,0);
        Node node4 = new Node(3,4,5);

        PriorityQueue<Node> pqNode = new PriorityQueue<>();
        pqNode.offer(node1);
        pqNode.offer(node2);
        pqNode.offer(node3);
        pqNode.offer(node4);

        System.out.println(pqNode.peek());
        pqNode.poll();
        System.out.println(pqNode.peek());

        //Másik megvalósítás

        class Node2{
            int row;
            int col;
            int cost;

            public Node2(int row, int col, int cost) {
                this.row = row;
                this.col = col;
                this.cost = cost;
            }

            @Override
            public String toString() {
                return "Node2{" +
                        "row=" + row +
                        ", col=" + col +
                        ", cost=" + cost +
                        '}';
            }
        }

        PriorityQueue<Node2> pqNode2 = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));

        Node2 node5 = new Node2(0,0,0);
        Node2 node6 = new Node2(1,0,2);
        Node2 node7 = new Node2(3,1,1);
        Node2 node8 = new Node2(4,2,5);

        pqNode2.offer(node5);
        pqNode2.offer(node6);
        pqNode2.offer(node7);
        pqNode2.offer(node8);

        System.out.println(pqNode2.peek());
        pqNode2.poll();
        System.out.println(pqNode2.peek());


        //Saját kivételosztály

        reserveDay(9);


    }

    static void reserveDay(int day) throws InvalidDayException {

        if(day < 1 || day > 7){
            throw new InvalidDayException("Nincs ilyen nap.");
        }
        if(day == 6 || day == 7){
            throw new DayOutOfBoundsException("Hétvégére nem tudsz foglalni.");
        }

        switch(day){
            case 1:
                System.out.println("Hétfő");
                break;
            case 2:
                System.out.println("Kedd");
                break;
            case 3:
                System.out.println("Szerda");
                break;
            case 4:
                System.out.println("Csütörtök");
                break;
            case 5:
                System.out.println("Péntek");
        }

    }

}
