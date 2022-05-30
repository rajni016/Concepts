interface Hi{
    SayHi();
}
class himessage implements Hi{
    SayHi() {
      console.log("Same concept as java, where we need to implement interface method in the child class")
    }
    
}
let message=new himessage(); // object creation
message.SayHi();