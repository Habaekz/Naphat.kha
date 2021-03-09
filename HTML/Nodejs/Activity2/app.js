/* HTTP Module with Routing */
const http = require("http");
const fs = require("fs");
http.createServer((req, res)=> {
if(req.url === "/"){ /* Render the default page */
 fs.readFile("./index.html", function(err, data) {
 res.statusCode = 200;
 res.setHeader("Content-Type","text/html");
 res.write(data);
 res.end();
 });
 }
else if(req.url === "/shabu"){ /* Render the shabu page */
 fs.readFile("./shabu.html", function(err, data) {
 res.statusCode = 200;
 res.setHeader("Content-Type","text/html");
 res.write(data);
 res.end();
 });
 } /* Render the remaining pages */
else if(req.url === "/bbq"){ /* Render the shabu page */
    fs.readFile("./bbq.html", function(err, data) {
    res.statusCode = 200;
    res.setHeader("Content-Type","text/html");
    res.write(data);
    res.end();
    });
} 
else{
    res.statusCode = 404;
    res.write("404: Invalid meal...");
    res.end();
}
}

).listen(8081);