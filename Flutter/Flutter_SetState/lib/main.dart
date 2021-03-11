import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    List<Widget> data = [];
    return MaterialApp(
      title: 'Habaekz Shop',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(title: 'Habaekz Shop'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);
  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _counter = 0;
  final items = List<String>.generate(10, (i) => "Item $i");
  int totalAmount = 0;
  List picked = [false, false, false, false, false,false, false, false, false, false];
  final foodList = ['anotherchair','box','card','chair','chris','desk','desks','dresser','dressers','otto2'];
  final imagelist = ['anotherchair.jpg','box.png','card.png','chair.jpg','chris.jpg','desk.png','desks.png','dresser.png','dressers.png','otto2.jpeg'];
  final price = [1299,1599,1899,1799,2599,3599,699,4599,3999,1999];

  pickToggle(index) {
    setState(() {
      picked[index] = !picked[index];
      getTotalAmount();
    });
  }

  getTotalAmount() {
    var count = 0;
    for (int i = 0; i < picked.length; i++) {
      if (picked[i]) {
        count = count + 1;
      }
      if (i == picked.length - 1) {
        setState(() {
          totalAmount = 0;
          for(int i = 0; i < picked.length; i++)
          {
            if (picked[i]) {
              totalAmount = totalAmount + price[i];
            }
          }
        });
      }
    }
  }
  void _incrementCounter() {
    setState(() {
      _counter++;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body:
      ListView.builder(
        itemCount: foodList.length,
        itemBuilder: (context, index) {
          return ListTile(
            leading: CircleAvatar(
              backgroundImage: AssetImage('assets/'+imagelist[index]),
            ),
            title: Text(foodList[index], style: TextStyle(fontSize: 16),),
              onTap: () {
                  pickToggle(index);
              },

            subtitle: Text('Price \$ ${price[index]} '),
              );
          },

      ),

      floatingActionButton: FloatingActionButton(
        onPressed: _incrementCounter,
        tooltip: 'Increment',
        child: Icon(Icons.add),
      ),

      bottomNavigationBar: Container(
          child: Container(
              height: 50.0,
              width: MediaQuery.of(context).size.width,
              color: Colors.white,
              child: Padding(
                padding: const EdgeInsets.only(left: 8.0, right: 8.0),
                child: Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: <Widget>[
                      Text('Total: \$'+ totalAmount.toString(),
                        style: TextStyle(
                          fontSize: 18,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                      SizedBox(width: 10.0),
                      Padding(
                        padding: const EdgeInsets.all(8.0),
                        child: RaisedButton(
                          onPressed: () {},
                          elevation: 0.5,
                          color: Colors.red,
                          child: Center(
                            child: Text(
                              'Pay Now',
                            ),
                          ),
                          textColor: Colors.white,
                        ),
                      )
                    ]),
              ))
      ),// This trailing comma makes auto-formatting nicer for build methods.
    );
  }
}
