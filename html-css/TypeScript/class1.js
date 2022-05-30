"use strict";
exports.__esModule = true;
var class2_1 = require("./class2");
var class1 = /** @class */ (function () {
    function class1() {
    }
    class1.prototype.printmessage = function () {
        var cls2 = new class2_1.class2(); // objecct creation for class-2
        console.log("this is class1 message");
        cls2.printmessage();
    };
    return class1;
}());
var cls1 = new class1();
cls1.printmessage();
// In java other file classes are exported by default, but in Ts we need to explicitly mention the export and import key words.
// class2 is imported
//  tsc class1.ts   tsc class2.ts node class1.js
