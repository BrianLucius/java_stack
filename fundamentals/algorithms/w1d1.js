function totalCount(numArr){
    // Write a function to return the total of the array
    let total = 0;
    for (let i=0; i< numArr.length; i++) {
        total += numArr[i];
    }
    return total;
  }
  
  function printMessages(msgArr){
    // Write a function to display messages 
    for (message of msgArr) {
        console.log(message);
    }
  }
  
  var messagesPerDay = [5, 8, 6]
  var messages = [ "Please call back!", "Make sure you install jdk", "Help debug please!"]
  
  console.log(totalCount(messagesPerDay));
  
  printMessages(messages)
  
  
  console.log("Hello World")