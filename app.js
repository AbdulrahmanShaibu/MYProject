const path = require('path');
const express = require('express');
const ejs = require('ejs');
const bodyParser = require('body-parser');
const app = express();
 
 
// Server Listening
app.listen(3000, () => {
    console.log('Server is running at port 3000');
});

const mysql = require('mysql');
 
const connection=mysql.createConnection({
    host:'localhost',
    user:'root',
    password:'',
    database:'node_crud'
});
 
connection.connect(function(error){
    if(!!error) console.log(error);
    else console.log('Database Connected!');
}); 

//set views file
app.set('views',path.join(__dirname,'views'));
 
//set view engine
app.set('view engine', 'ejs');
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
 

app.get('/',(req, res) => {
    // res.send('CRUD Operation using NodeJS / ExpressJS / MySQL');
    let sql = "SELECT * FROM users";
    let query = connection.query(sql, (err, rows) => {
        if(err) throw err;
        res.render('user_index', {
            title : 'Student Enrollment',
            users : rows
        });
    });
});
// ...

// Retrieve form data from the database and send as JSON
app.get('/formData/api/v1', (req, res) => {
    let sql = "SELECT * FROM users";
    let query = connection.query(sql, (err, rows) => {
      if (err) throw err;
      res.json(rows);
    });
  });

  app.get('/admin/api/v1', (req, res) => {
    let sql = "SELECT * FROM admins";
    let query = connection.query(sql, (err, rows) => {
      if (err) throw err;
      res.json(rows);
    });
  });
  
  // ...
  
app.get('/add', (req, res) => {
    res.render('add_user', {
        title: 'Add Details'
    });
});

app.get('/home', (req, res) => {
    res.render('home', {
    });
});

app.get('/about', (req, res) => {
    res.render('about', {
    });
});
app.get('/login', (req, res) => {
    res.render('login', {
        title: 'Admin Login'
    });
});

app.post('/login', (req, res) => {
    let username = req.body.username;
    let password = req.body.password;

    let sql = "SELECT * FROM admins WHERE username = ? AND password = ?";
    let query = connection.query(sql, [username, password], (err, results) => {
        if (err) throw err;
        if (results.length === 1) {
            res.redirect('/home');
        } else {
            res.render('login', {
                title: 'Login as Admin',
                error: 'Invalid username or password'
            });
        }
    });
});

app.post('/save', (req, res) => {
    let data = {
        name: req.body.name,
        email: req.body.email,
        phone_no: req.body.phone_no
    };
    let sql = "INSERT INTO users SET ?";
    let query = connection.query(sql, data, (err, results) => {
        if (err) throw err;
        res.redirect('/');
    });
});

app.get('/edit/:id', (req, res) => {
    let userId = req.params.id;
    let sql = "SELECT * FROM users WHERE id = ?";
    let query = connection.query(sql, [userId], (err, result) => {
        if (err) throw err;
        res.render('edit_user', {
            title: 'Edit Student',
            user: result[0]
        });
    });
});

app.post('/update', (req, res) => {
    let userId = req.body.id;
    let updatedData = {
        name: req.body.name,
        email: req.body.email,
        phone_no: req.body.phone_no
    };
    let sql = "UPDATE users SET ? WHERE id = ?";
    let query = connection.query(sql, [updatedData, userId], (err, results) => {
        if (err) throw err;
        res.redirect('/');
    });
});

app.get('/delete/:id', (req, res) => {
    let userId = req.params.id;
    let sql = "DELETE FROM users WHERE id = ?";
    let query = connection.query(sql, [userId], (err, result) => {
        if (err) throw err;
        res.redirect('/');
    });
});



