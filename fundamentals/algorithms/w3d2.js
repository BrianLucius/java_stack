/**

 * Class to represent a MinHeap which is a Priority Queue optimized for fast
 * retrieval of the minimum value. It is implemented using an array but it is
 * best visualized as a tree structure where each 'node' has left and right
 * children except the 'node' may only have a left child.
 * - parent is located at: Math.floor(i / 2);
 * - left child is located at: i * 2
 * - right child is located at: i * 2 + 1
 */
 class MinHeap {

    constructor() {
      /**
       * 0th index not used, so null is a placeholder. Not using 0th index makes
       * calculating the left and right children's index cleaner.
       * This also effectively makes our array start at index 1.
       */
      this.heap = [null];
    }
  
    //returns the index of the left child
    idxOfLeftChild(i) {
      return i * 2;
    }
  
    //returns the index of the right child
    idxOfRightChild(i) {
      return i * 2 + 1;
    }
  
    /**
   * Extracts the min num from the heap and then re-orders the heap to
   * maintain order so the next min is ready to be extracted.
   * 1. Check if null
   * 2. Store heap[1] into temp
   * 3. Move heap[heap.length-1] value in heap to heap[1]
   * 4. Bubble down heap[1] with smallest child until correctly placed
   *
   * - Time: O(log n) logarithmic due to shiftDown.
   * - Space: O(1) constant.
   * @returns {?number} The min number or null if empty.
   */
    extract() {
        if (!this.heap) {
            return null;
          }
          let temp = this.heap[1];
          this.heap[1]= this.heap.pop()
          // this.heap[1]= this.heap[this.heap.length-1]; // moves last value in array to the top.
          let nodeToShift = 1
          let indexLeftChild = this.idxOfLeftChild(nodeToShift);
          let smallestChildIdx;
          while(indexLeftChild < this.heap.length){
            let indexOfRightChild = this.idxOfRightChild(nodeToShift);
            let isRightNull = indexOfRightChild > this.heap.length;
            
            if(isRightNull == false){
              if(this.heap[indexLeftChild] > this.heap[indexOfRightChild]){
              smallestChildIdx = indexOfRightChild;
              } else {
                smallestChildIdx= indexLeftChild;
              }
            } else {
              smallestChildIdx = indexLeftChild;
            }
            if(this.heap[nodeToShift] > this.heap[smallestChildIdx]){
              let tempSwap = this.heap[nodeToShift];
              this.heap[nodeToShift] = this.heap[smallestChildIdx];
              this.heap[smallestChildIdx] = tempSwap;
            }else{
              return temp;
            }
          nodeToShift = smallestChildIdx;
          indexLeftChild = this.idxOfLeftChild(nodeToShift);
          }
          return temp;
     }
  
  
  
  
    insert(num) {
      let idxNewNode = this.heap.length;
      this.heap.push(num);
      while (idxNewNode > 1) {
        const idxOfParent = Math.floor(idxNewNode / 2);
        const isParentSmallerOrEqual =
          this.heap[idxOfParent] <= this.heap[idxNewNode];
        // Parent is supposed to be smaller so ordering is complete.
        if (isParentSmallerOrEqual) {
          break;
        }
        [this.heap[idxNewNode], this.heap[idxOfParent]] = [this.heap[idxOfParent], this.heap[idxNewNode]];
        // after swapping the node is at idxOfParent now.
        idxNewNode = idxOfParent;
        // .push on array returns the new length
      }
      return this.heap.length - 1;
    }
  
    printHorizontalTree(parentIdx = 1, spaceCnt = 0, spaceIncr = 10) {
      if (parentIdx > this.heap.length - 1) {
        return;
      }
  
      spaceCnt += spaceIncr;
      this.printHorizontalTree(parentIdx * 2 + 1, spaceCnt);
  
      console.log(
        " ".repeat(spaceCnt < spaceIncr ? 0 : spaceCnt - spaceIncr) +
        `${this.heap[parentIdx]} (${parentIdx})`
      );
  
      this.printHorizontalTree(parentIdx * 2, spaceCnt);
    }
  }
  
  
  var heap = new MinHeap();
  
  const miniHeap = new MinHeap();
  miniHeap.insert(3)
  miniHeap.insert(45)
  miniHeap.insert(22)
  miniHeap.insert(21)
  miniHeap.insert(13)
  miniHeap.insert(78)
  miniHeap.insert(65)
  miniHeap.printHorizontalTree()

  console.log("Min value:" + miniHeap.extract(13));
  miniHeap.printHorizontalTree();