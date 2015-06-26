# Settings #
## HTTP Server ##
Static html files are located in src/main/resources/casperWeb. A simple python HTTP server can be used to quickly serve the static contents. Navigate to casperWeb in command prompt and enter python -m SimpleHTTPServer 80. 

## Navigation URL ##
A script files are currently hard coded to use http://casper.local. Modify host file to lookup localhost for the given url.