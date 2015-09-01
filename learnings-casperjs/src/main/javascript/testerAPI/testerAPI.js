casper.test.begin("assert()", function(test){
    casper.start(  );
    test.assert(false,"Assert False",{doThrow:false});
    test.assertDoesntExist("h1");
    test.assert(true,"Assert True");
    
    casper.run(function(){
        test.done();
    });
    
});