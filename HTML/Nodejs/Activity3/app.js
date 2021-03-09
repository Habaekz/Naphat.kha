const path = require('path');
const express = require('express');
const app = express();


        
        app.get('/',function(req,res){
            res.sendFile(path.join(__dirname+'/index.html'));
        });
        app.get('/bbq',function(req,res){
            res.sendFile(path.join(__dirname+'/bbq.html'));
        });
        app.get('/shabu',function(req,res){
            res.sendFile(path.join(__dirname+'/shabu.html'));
        });
        app.get('/*',function(req,res){
            res.sendFile(path.join(__dirname+'/error.html'));
        });
    
        



/* And more pages here :) */
app.listen(8081);
console.log('Running at Port 8081');