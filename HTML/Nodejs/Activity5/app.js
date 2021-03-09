const express = require('express');
const app = express();
const path = require('path');
/* Router Module for handling routing */
const router = express.Router();
// Register the router
app.use(express.urlencoded({ extended: true }));
app.use('/', router);
// Handle GET: display form.html
router.get('/',function(req,res){
res.sendFile(path.join(__dirname+'/contactus.html')); 
});


/* Handle POST Form submitted): greet users */
router.post('/submit-form', function(req, res){
 /* Use name from the form to get the value */
 const name = req.body.name;
 const email = req.body.email;
 const txtMessage = req.body.txtMessage;
 console.log (`Form submitted by ${name}`);

 var html = "<style>div{background-color: gainsboro;}</style><body><div><h1>Thank you "+name+"!!</h1>"+"<br>"+"We will contact you via "+email+" within 3 business days."+"<br><br>"+"Your message: "+txtMessage+"<div></body>";
 
 res.send(html);
});
// Server listening
app.listen(8081, function () {
 console.log("Server listening at Port 8081");
});

