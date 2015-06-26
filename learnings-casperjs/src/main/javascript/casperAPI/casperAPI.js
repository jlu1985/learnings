var casper = require('casper').create({
    verbose: true
});

function printHtml(_casper) {
    _casper.then(function () {
        _casper.echo("Current url: " + _casper.getCurrentUrl());
        _casper.debugHTML();
    });

}

function gotoFormFromHome(_casper){
    _casper.thenClick("#aForm",function () {
        this.echo("clicked form");
        printHtml(_casper);
    });
    
    printHtml(_casper);
}

casper.start("http://casper.local", function (response) {
    this.echo("Opened http://casper.local " + this.getCurrentUrl());
   require('utils').dump(response);
});

casper.thenClick('#oneImportantLink',function () {
    this.echo("clicked on a link that has an ID: #oneImportantLink");
    printHtml(casper);
});

casper.thenClick("#homepage",function () {
    this.echo("clicked home");
    printHtml(casper);
});

gotoFormFromHome(casper);

casper.then(function(){
    this.echo("We are going to fill out the form by using fill()");
    this.fill("#contactForm",{
        "name": "Casper Rocks",
        "email": "oneLongEmail@a.com"
    }, true);
});

casper.then(function(){
    
    this.evaluate(function(){
        __utils__.echo("calling '__utils__.echo' in evaluate");
    });
    
    printHtml(casper);
});

casper.run();