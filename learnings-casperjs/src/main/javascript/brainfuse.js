casper.test.begin("Try login page",function(test){
    
    casper.start("http://dev.brainfuse.com/login/").then(function(){
       test.assertTitle("Login", "At login page");
        
       this.fill("#frmLogin",{
           "login_username":"helpnow2",
           "login_password":"brainfuse"
       },true) ;
        
    });
    
    casper.then(function(response){
        test.assertEquals(200, response.status,"Recieved 200 OK, We are not logged in");
        
    });
    
    casper.thenOpen("http://www.dev.brainfuse.com/login/signout.asp").
            then(function(response){
                
            });
        
    
    casper.run(function(){
        test.done();
    });
});
