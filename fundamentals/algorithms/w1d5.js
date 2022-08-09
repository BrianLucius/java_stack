// class Node 
class ListNode {
    constructor(data) {
      this.data = data;
      this.next = null;
    }
  }
  
  // class SLL - Singly Linked List
  class SLL {
    constructor() {
      this.head = null;
    }
  
    insertAtBack(data) {
      var newNode = new ListNode(data);
      if (this.head) {
        var runner = this.head;
        while (runner.next) {
          runner = runner.next;
        }
        runner.next = newNode;
      } else {
        this.head = newNode;
      }
    }
    //given
    printList() {
      if (!this.head) {
        console.log("Empty list");
        return
      }
      var runner = this.head;
      while (runner) {
        console.log(runner.data);
        runner = runner.next;
      }
    }
    /**
     * Retrieves the data of the second to last node in this list.
     * - Time: O(?).
     * - Space: O(?).
     * @returns {any} The data of the second to last node or null if there is no
     *    second to last node.
     */
    secondToLast() { }
  
    /**
     * Removes the node that has the matching given val as it's data.
     * - Time: O(?).
     * - Space: O(?).
     * @param {any} val The value to compare to the node's data to find the
     *    node to be removed.
     * @returns {boolean} Indicates if a node was removed or not.
     */
    removeVal(val) { }
  
    // EXTRA
    /**
     * Inserts a new node before a node that has the given value as its data.
     * - Time: O(?).
     * - Space: O(?).
     * @param {any} newVal The value to use for the new node that is being added.
     * @param {any} targetVal The value to use to find the node that the newVal
     *    should be inserted in front of.
     * @returns {boolean} To indicate whether the node was pre-pended or not.
     */
    prepend(newVal, targetVal) { }
  
  }
  
  var emptyList = new SLL();
  
  var list1 = new SLL();
  list2.insertAtBack(1);
  list2.insertAtBack(2);
  
  var list2 = new SLL();
  list2.insertAtBack(1);
  list2.insertAtBack(2);
  list2.insertAtBack(3);
  //       HEAD
  // list2: (1) --> (2) --> (3) --> null
  
  // 1) secondToLast()
  console.log(list1.secondToLast()) // print: 1
  console.log(list2.secondToLast()) // print: 2
  console.log(emptyList.secondToLast())//print: null
  
  // 2) removeVal()
  // list1.removeVal(1)
  // list1.printList() // print:  (2) -->  null
  // list2.removeVal(2)
  // list2.printList() // print: (1) --> (3) --> null
  
  
  // 3) prepend()
  // list1.prepend(2,54)
  // list1.printList() // print: (54) --> (2) -->  null
  // list2.prepend(3,76)
  // list1.printList() // print:(1) --> (76) --> (3)-->null
  
  