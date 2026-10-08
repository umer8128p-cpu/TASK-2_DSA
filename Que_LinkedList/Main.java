import java.util.Scanner;
class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        next = null;
    }
}

class QueLinkedList {
    Node Head;

/// insert at the rear
/// 
     public void insert(int data){
         Node newNode = new Node(data);
         if(Head == null){
            Head = newNode;
            return;
         }
         Node current = Head;
         while (current.next != null) {
            current = current.next;
         }
         current.next = newNode;
     }

     /// Peek (View Top/front element)
/// 
     public void Peek(){
         if(Head == null){
            System.out.println("Empty List");
            return;
         }
       System.out.println("Top Element : " + Head.value);
     }

     /// IsEmpty 
/// 
     public void IsEmpty(){
         if(Head == null){
            System.out.println("Yes the List is Empty");
            return;
         }
          System.out.println("No the List is Not Empty");
     }


/// Delete from the front
/// 
     public void Delete(){
         if(Head == null){
            System.out.println("Empty List");
            return;
         }

          Head = Head.next;
     }
     


//// display all// transvers
    public void Display() {
        Node current = Head;
        
        while (current != null) {
            System.out.print(current.value+"\t");
            current = current.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {

        QueLinkedList list = new QueLinkedList();
        while (true) {
            System.out.println("\n1. Enqueue\n2. Dequeue\n3. Peek\n4. IsEmpty\n5. Display\n6. Exit");
            System.out.print("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to Enqueue: ");
                    int value = sc.nextInt();
                    list.insert(value);
                    break;
                case 2:
                    list.Delete();
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