/* Another Hello World in the Browser */
const http = require("http");
const myServer = http.createServer(function (request,response) 
{
// Send the HTTP header
response.statusCode = 200; // HTTP Status: 200 : OK
response.setHeader("Content-Type", "text/plain");
response.write("Hello World!! in the Browser"); //Contents
response.end(); // End the response
});
// Logging in the console
console.log("Server running at http://localhost:8081/");
myServer.listen(8081);
