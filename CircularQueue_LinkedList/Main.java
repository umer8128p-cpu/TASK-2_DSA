import java.util.Scanner;
class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        next = null;
    }
}

class CircularQueLinkedList {
    Node rear = null;

/// insert at the rear
/// 
     public void enqueue(int data){
         Node newNode = new Node(data);
         if(rear == null){
            rear = newNode;
            rear.next = rear;
            return;
         }
         newNode.next = rear.next;
         rear.next = newNode;
         rear = newNode;
     }

     /// Peek (View Top/front element)
/// 
     public void Peek(){
         if(rear == null){
            System.out.println("Empty List");
            return;
         }
       System.out.println("Top Element : " + rear.next.value);
     }

     /// IsEmpty 
/// 
     public void IsEmpty(){
         if(rear == null){
            System.out.println("Yes the List is Empty");
            return;
         }
          System.out.println("No the List is Not Empty");
     }


/// Delete from the front
/// 
     public void Dequeue(){
         if(rear == null){
            System.out.println("Empty List");
            return;
         }
          if(rear.next == rear){
            rear = null;
            return;
          }
          rear.next = rear.next.next;
     }
     


//// display all// transvers
    public void Display() {
        Node current = rear.next;
        
        do{
            System.out.print(current.value+"\t");
            current = current.next;
        } while (current != rear.next);
    }
}

public class Main {
    public static void main(String[] args) {

        CircularQueLinkedList list = new CircularQueLinkedList();
        while (true) {
            System.out.println("\n1. Enqueue\n2. Dequeue\n3. Peek\n4. IsEmpty\n5. Display\n6. Exit");
            System.out.print("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to Enqueue: ");
                    int value = sc.nextInt();
                    list.enqueue(value);
                    break;
                case 2:
                    list.Dequeue();
                    break;
                case 3:
                    list.Peek();
                    break;
                case 4:
                    list.IsEmpty();
                    break;
                case 5:
                    list.Display();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    sc.close();
            }
        }
    


    }
}