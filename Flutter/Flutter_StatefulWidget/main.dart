import 'package:flutter/material.dart' ;
// entry point for the app,
// the => operator is shorthand for {} when there is only one line of code
void main() => runApp(MyApp());
// the root widget of our application
class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        home: Scaffold(
        appBar: AppBar(
        title : Text("My Account") ,
    ),
          body: myLayoutWidget(),
        ) ,
      theme: ThemeData(primarySwatch: Colors.purple),
      debugShowCheckedModeBanner: false,

    ) ;
  }

}

class MoneyBox extends StatelessWidget {
  String title;
  double amount;
  Color color;
  double size;

  MoneyBox(this.title, this.amount, this.color, this.size);

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: const EdgeInsets.all(10.0),
      decoration: BoxDecoration(
          color: color, borderRadius: BorderRadius.circular(10)
      ),
      height: size,
      child: Row(
        children: [
          Text(
            title,
            style: TextStyle(fontSize: 30, color: Colors.white),
          ),
          Expanded(child: Text(
            amount.toString(),
            style: TextStyle(fontSize: 30, color: Colors.white),
            textAlign: TextAlign.right,
          ))
        ],
      ),

    );
  }
}
// replace this method with code in the examples below
Widget myLayoutWidget() {
  return Padding(padding: const EdgeInsets.all(10.0),
    child: Column(
      children: [
        MoneyBox('Balance', 100000, Colors.lightBlue, 120),
        SizedBox(height: 10,),
        MoneyBox('Balance', 50000, Colors.green, 100),
        SizedBox(height: 10,),
        MoneyBox('Balance', 40000, Colors.red, 100),
        SizedBox(height: 10,),
        MoneyBox('Balance', 3600, Colors.orange, 100),
        SizedBox(height: 10,),
      ],
    ),
  );

}
