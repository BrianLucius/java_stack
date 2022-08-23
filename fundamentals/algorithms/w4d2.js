class QueueNode {
    constructor(data) {
      this.data = data;
      this.next = null;
    }
  }
  
  class LinkedListQueue {
    constructor() {
      this.head = null;
      this.tail = null;
    }
  
    /**
   * Adds a new given item to the back of this queue.
   * - Time: O(1) constant.
   * - Space: O(1) constant.
   * @param {any} item The new item to add to the back.
   * @returns {this} So the method can be chained.
   */
    enqueue(item) {
      var node = new QueueNode(item);
      if(this.head == null){
        this.head = node;
        this.tail = node;
        return this;
      }else{
        this.tail.next= node;
        this.tail = node;
        return this;
      }
    }
  
    /**
     * Removes and returns the first item of this queue.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {any} The first item or undefined if empty.
     */
    dequeue() {
      if (this.head == null){
        return undefined;
      }else{
        let temp = this.head;
        this.head = this.head.next;
        temp.next = null;
        return temp;
      }
        
    }
  
    /**
     * Retrieves the first item without removing it.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {any} The first item or undefined if empty.
     */
    front() {
      return this.head.data
    }
  
    /**
     * Returns whether or not this queue is empty.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {boolean}
     */
    isEmpty() {
      if(!this.head){
        return true
      }else
        return false
    }
  
    /**
     * Retrieves the size of this queue.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {number} The length.
     */
    size() {
      let newQueue = new LinkedListQueue();
      let count = 0;
      
      while (!this.isEmpty()) {
        newQueue.enqueue(this.dequeue().data);
        count++;
      }
      while (!newQueue.isEmpty()) {
        this.enqueue(newQueue.dequeue().data);
      }
      return count;
    }
  
    
    queueToArray() {
        let temp = new LinkedListQueue();
        let output = ["Head->"]
        while(this.head) temp.enqueue(this.dequeue().data)
        while(temp.head){
            output.push(temp.head.data)
            this.enqueue(temp.dequeue().data)
        } 
        output.push("<-Tail")
        return output
    }
  }
  
  const queue = new LinkedListQueue();
  // comment out after enqueue is finished
   queue.enqueue(34).enqueue(78).enqueue(87).enqueue(34).enqueue(56).enqueue(15)
  // comment out after dequeue is finished
   console.log(queue.queueToArray())

   console.log("Size: ",queue.size());

   console.log(queue.queueToArray());