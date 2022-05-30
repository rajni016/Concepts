class Parent{
    printmessage(message){
        console.log(message);

    }

}
class child extends Parent{
    someAction(){
        this.printmessage("Two classes in same file");
    }
}
let childobj=new child()
childobj.someAction();