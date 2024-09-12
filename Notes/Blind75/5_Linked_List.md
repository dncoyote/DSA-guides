# **Linked List**
## **Theory**

#### What is a Linked List
- In Array, values are stored in contiguous memory locations. Array is easy to traverse, but we cannot increase or decrease size.
- This is where a Linked List comes into the picture.
- Linked List is not stored in contiguous memory locations. They are stored in heap memory and their size can be increased and decreased anytime.
- With every data, the `next` value is stored.
- Starting point of Linked List is called as `head`.
- The `next` value of the last element(also called as `tail`)  is `null`.
- When a new value is to be stored
    - Add the value somewhere in the heap.
    - Update the `next` value of last element to the location of the new value.

#### Where is it used?
- In Data Structures, Linked List is used in Stacks and Queue.
- In real life, we use it in browser.

#### Struct/Class in C++ Java
```c++
int x =2;
int* y = &x;
cout<<y;
```
- Creates `x` somewhere in the heap memory and stores 2.
- Stores the memory location of `x` in `y`.

## **Reverse Linked List**
>
#### Brute - 
>Time Complexity - 

>Space Complexity - 
```java

```
#### Explanation

-

#### Steps

-

#### Optimal -
>Time Complexity - 

>Space Complexity - 

```java
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class ReverseLinkedListOptimal {
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    public ListNode reverseList(ListNode head) {
        // Initialize pointers
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next; // Store next node
            current.next = prev; // Reverse the link
            prev = current; // Move prev forward
            current = nextTemp; // Move current forward
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        ReverseLinkedListOptimal solution = new ReverseLinkedListOptimal();
        solution.printList(head);

        ListNode reversedHead = solution.reverseList(head);
        System.out.println("Reversed List:");
        solution.printList(reversedHead);
    }
}
```
#### Explanation

-

#### Steps

-

## **Merge Two sorted Linked List**
>
#### Brute - 
>Time Complexity - O(N1)+O(N2)+O(Nlog N)+O(N)

O(N1) - 1st Linked List
O(N2) - 2nd Linked List
O(N log N) - sort function
O(N) - create merge Linked List

>Space Complexity - O(N1)+O(N2)
```java

```
#### Explanation

- 

#### Steps

- Take 1st Linked list and store to array using while loop
- Take 2nd Linked List and store to same array using while loop.
- call Array.sort to sort.
- Convert array to Linked List

#### Optimal -
>Time Complexity - 

>Space Complexity - 

```java
public static ListNode mergeTwoSortedLinkedList(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode(Integer.MIN_VALUE);
        ListNode headNode = resultNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                resultNode.next = l1;
                l1 = l1.next;
            } else {
                resultNode.next = l2;
                l2 = l2.next;
            }
            resultNode = resultNode.next;
        }

        if (l1 == null) {
            resultNode.next = l2;
        } else if (l2 == null) {
            resultNode.next = l1;
        }
        return headNode.next;
    }
```
#### Explanation

-

#### Steps

-

## **Reorder Linked List**
>
#### Brute - 
>Time Complexity - 

>Space Complexity - 
```java

```
#### Explanation

- Convert Linked List to array.
- Add pointer on the beginning and at the end.

#### Steps

-

#### Optimal -
>Time Complexity - 

>Space Complexity - 

```java
ListNode reorderList(ListNode head) {
        // Find the middle of the List
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of list
        ListNode prev = null;
        ListNode current = slow;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        // reorder
        ListNode first = head;
        ListNode second = prev; // The head of the reversed second half
        while (second.next != null && first != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second; // Link from first half to second half
            second.next = temp1; // Link from second half to first half

            first = temp1; // Move forward in the first half
            second = temp2; // Move forward in the second half
        }
        return head;
    }
```
#### Explanation

-

#### Steps

-