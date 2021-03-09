const express = require('express');
const app = express();
const mysql = require('mysql');
const dotenv = require('dotenv')

const outer = express.Router();
dotenv.config();


// Handle GET: display form.html
var connection = mysql.createConnection({
 host : process.env.MYSQL_HOST,
 user : process.env.MYSQL_USERNAME,
 password : process.env.MYSQL_PASSWORD,
 database : process.env.MYSQL_DATABASE
});

app.use(express.urlencoded({ extended: true }));
app.use('/', outer);
/* Connect to DB */
outer.get('/', function (req, res) {
    connection.connect(function (err) {
        if (err)  throw err;
        console.log("Connected DB:" + process.env.MYSQL_DATABASE);
        var output = '<!DOCTYPE html><html lang="en">';
        output += "<head><title>Hallo</title></head><body>";
        output += "<h1>Personal info</h1><ul>";
        output += '<form action="/"method="POST">'
        output += 'Student ID: <input type="text" class="form-control" id="StudentID" name="StudentID" placeholder="Student ID" required>'
        output += '<br>Firstname: <input type="text" class="form-control" id="Firstname" name="Firstname" placeholder="First name" required>'
        output += '<br>Lastname: <input type="text" class="form-control" id="Lastname" name="Lastname" placeholder="Last name" required>'
        output += '<br>Phone number: <input type="text" class="form-control" id="Phone" name="Phone" placeholder="Phone number" required>'
        output += '<br>Date of Birth: <input type="date" class="form-control" id="DoB" name="DoB" required>'
        output += '<br><br><button type="submit" value="Submit" class="btn btn-info btn-block rounded-0 py-2">Submit</button><br><br>'
        output += '<table border="1">'
        output += "<tr><td>StudentID</td><td>FirstName</td><td>Lastname</td><td>DoB</td><td>Phone</td></tr>"
        let sql = "SELECT * FROM personal_info";
        const months = ["JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"];
        connection.query(sql, function (err, result) {
            if (err) throw err;
            console.log("Retrieve people list...");
            
            result.forEach(infor=> {
                output += "<tr><td>" + infor.StudentID+"</td>";
                output += "<td>" + infor.Firstname + "</td>";
                output += "<td>" + infor.Lastname + "</td>";
                output += "<td>" + infor.DOB.getDate() + "-" + months[infor.DOB.getMonth()] + "-" + infor.DOB.getFullYear() + "</td>";
                output += "<td>" + infor.Phone + "</td></tr>";
            });
            output += "</table>";
            output += "</ul></body></html>";
            res.send(output);
            res.end();
            //connection.end();
        });
    });
});

outer.post('/', function (req, res) {

    console.log("in");
    /* Use name from the form to get the value */
    const Firstname = req.body.Firstname;
    const Lastname = req.body.Lastname;
    const StudentID = req.body.StudentID;
    const Phone = req.body.Phone;
    const DOB = req.body.DoB;
    //console.log(`Form submitted by ${name}`);
    let sql = `INSERT INTO personal_info VALUES ('${StudentID}','${Firstname}', '${Lastname}', '${DOB}','${Phone}')`;
    connection.query(sql, function (err, result) {
        if (err) throw err;
        console.log(result.affectedRows + " record inserted");
    });

     //if (err) throw err;
     console.log("Connected DB:" + process.env.MYSQL_DATABASE);
     /* Prepare HTML */
     
        var output = '<!DOCTYPE html><html lang="en">';
        output += "<head><title>Hallo</title></head><body>";
        output += "<h1>Personal info</h1><ul>";
        output += '<form action="/"method="POST">'
        output += 'Student ID: <input type="text" class="form-control" id="StudentID" name="StudentID" placeholder="Student ID" required>'
        output += '<br>Firstname: <input type="text" class="form-control" id="Firstname" name="Firstname" placeholder="First name" required>'
        output += '<br>Lastname: <input type="text" class="form-control" id="Lastname" name="Lastname" placeholder="Last name" required>'
        output += '<br>Phone number: <input type="text" class="form-control" id="Phone" name="Phone" placeholder="Phone number" required>'
        output += '<br>Date of Birth: <input type="date" class="form-control" id="DoB" name="DoB" required>'
        output += '<br><br><button type="submit" value="Submit" class="btn btn-info btn-block rounded-0 py-2">Submit</button><br><br>'
        output += '<table border="1">'
        output += "<tr><td>StudentID</td><td>FirstName</td><td>Lastname</td><td>DoB</td><td>Phone</td></tr>"


      sql = "SELECT * FROM personal_info"; /* SQL SELECT */
     const months = ["JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"];
     connection.query(sql, function (err, result) {
         if (err) throw err;
         console.log("Retrieve people list...")
         result.forEach(infor=> {
            output += "<tr><td>" + infor.StudentID+"</td>";
            output += "<td>" + infor.Firstname + "</td>";
            output += "<td>" + infor.Lastname + "</td>";
            output += "<td>" + infor.DOB.getDate() + "-" + months[infor.DOB.getMonth()] + "-" + infor.DOB.getFullYear() + "</td>";
            output += "<td>" + infor.Phone + "</td></tr>";
        });
         output += "</table></ul></body></html>";

         res.send(output);
         res.end();
         //connection.end();
     });
});

/* Run Server */
app.listen(process.env.PORT, function () {
 console.log("Server listening at Port "+process.env.PORT);
});
