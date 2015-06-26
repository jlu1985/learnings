//getting an insance of casper
//var casper = require('casper').create();

//alternative
//var casper2 = new require('casper').Casper();

var casper = require('casper').create({
    logLevel: "debug",
    verbose: true

});

casper.start("http://casper.local", function () {
    this.echo(this.getHTML());
});

casper.then(function () {
    casper.click('#oneImportantLink');

});

casper.then(function () {
    this.echo(this.getHTML());
});

casper.run();