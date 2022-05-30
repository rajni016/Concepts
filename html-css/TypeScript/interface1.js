var himessage = /** @class */ (function () {
    function himessage() {
    }
    himessage.prototype.SayHi = function () {
        console.log("Same concept as java, where we need to interface method in the child class");
    };
    return himessage;
}());
var message = new himessage();
message.SayHi();
