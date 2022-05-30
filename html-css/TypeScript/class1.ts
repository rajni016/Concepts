import { class2 } from "./class2"

class class1{
    printmessage(){
        let cls2=new class2();// objecct creation for class-2
        console.log("this is class1 message")
        cls2.printmessage();
    }

}
let cls1=new class1();
cls1.printmessage();


// In java other file classes are exported by default, but in Ts we need to explicitly mention the export and import key words.
// class2 is imported
//  tsc class1.ts   tsc class2.ts node class1.js

