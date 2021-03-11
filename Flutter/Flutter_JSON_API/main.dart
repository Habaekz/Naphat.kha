import 'package:flutter/material.dart';
import 'dart:async';
import 'dart:convert';
import 'package:http/http.dart' as http;
import 'Product.dart';

int _index;
int _counter = 0;

final items = List<String>.generate(10, (i) => "Item $i");
int totalAmount = 0;
List picked = [
  false,
  false,
  false,
  false,
  false,
  false,
  false,
  false,
  false,
  false
];
final cart_product = [];
final cart_image = [];
final cart_price = [];
final num_ = [0,0,0,0,0,0,0,0,0,0];
var list;
// ignore: deprecated_member_use

void main() => runApp(MyApp(products: fetchProducts()));

List<Product> parseProducts(String responseBody) {
  final parsed = json.decode(responseBody).cast<Map<String, dynamic>>();
  print(parsed.map<Product>((json) =>Product.fromMap(json)).toList());
  return parsed.map<Product>((json) =>Product.fromMap(json)).toList();
}
Future<List<Product>> fetchProducts() async {
  final response = await http.get('http://192.168.0.163:8000/products.json');
  if (response.statusCode == 200) {
    return parseProducts(response.body);
  } else {
    throw Exception('Unable to fetch products from the REST API');
  }
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  final Future<List<Product>> products;
  MyApp({Key key, this.products}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    List<Widget> data = [];
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Habaekz Shop',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(title: 'Habaekz Shop', products: products),
    );
  }
}

class MyHomePage extends StatelessWidget {
  final String title;
  final Future<List<Product>> products;
  MyHomePage({Key key, this.title, this.products}) : super(key: key);
  var data;
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(title: Text("Product Navigation")),
        body: Center(
          child: FutureBuilder<List<Product>>(
            future: products, builder: (context, snapshot) {
            if (snapshot.hasError) print(snapshot.error);
            data = snapshot.data;
            return snapshot.hasData ? ProductBoxList(items : snapshot.data) :

            // return the ListView widget :
            Center(child: CircularProgressIndicator());
          },
          ),
        )
    );
  }

  // @override
  // _MyHomePageState createState() => _MyHomePageState(data);
}

class ProductBoxList extends StatelessWidget {
  final List<Product> items;
  ProductBoxList({Key key, this.items});

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
      itemCount: items.length,
      itemBuilder: (context, index) {
        return GestureDetector(
          child: ProductBox(item: items[index]),
          onTap: () {
            Navigator.push(
              context, MaterialPageRoute(
              builder: (context) => ProductPage(item: items[index]),
            ),
            );
          },
        );
      },
    );
  }
}
class ProductPage extends StatelessWidget {
  ProductPage({Key key, this.item}) : super(key: key);
  final Product item;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text(this.item.product),),
      body: Center(
        child: Container(
          padding: EdgeInsets.all(0),
          child: Column(
              mainAxisAlignment: MainAxisAlignment.start,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: <Widget>[
                Image.asset("assets/" + this.item.imagelist),
                Expanded(
                    child: Container(
                        padding: EdgeInsets.all(5),
                        child: Column(
                          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                          children: <Widget>[
                            Text(this.item.product, style:
                            TextStyle(fontWeight: FontWeight.bold)),
                            Text(this.item.description),
                            Text("Price: " + this.item.price.toString()),
                            RatingBox(),
                          ],
                        )
                    )
                )
              ]
          ),
        ),
      ),
    );
  }
}
class RatingBox extends StatefulWidget {
  @override
  _RatingBoxState createState() =>_RatingBoxState();
}
class _RatingBoxState extends State<RatingBox> {
  int _rating = 0;
  void _setRatingAsOne() {
    setState(() {
      _rating = 1;
    });
  }
  void _setRatingAsTwo() {
    setState(() {
      _rating = 2;
    });
  }
  void _setRatingAsThree() {
    setState(() {
      _rating = 3;
    });
  }
  Widget build(BuildContext context) {
    double _size = 20;
    print(_rating);
    return Row(
      mainAxisAlignment: MainAxisAlignment.end,
      crossAxisAlignment: CrossAxisAlignment.end,
      mainAxisSize: MainAxisSize.max,

      children: <Widget>[
        Container(
          padding: EdgeInsets.all(0),
          child: IconButton(
            icon: (
                _rating >= 1
                    ? Icon(Icons.star, size: _size,)
                    : Icon(Icons.star_border, size: _size,)
            ),
            color: Colors.red[500], onPressed: _setRatingAsOne, iconSize: _size,
          ),
        ),
        Container(
          padding: EdgeInsets.all(0),
          child: IconButton(
            icon: (
                _rating >= 2
                    ? Icon(Icons.star, size: _size,)
                    : Icon(Icons.star_border, size: _size,)
            ),
            color: Colors.red[500],
            onPressed: _setRatingAsTwo,
            iconSize: _size,
          ),
        ),
        Container(
          padding: EdgeInsets.all(0),
          child: IconButton(
            icon: (
                _rating >= 3 ?
                Icon(Icons.star, size: _size,)
                    : Icon(Icons.star_border, size: _size,)
            ),
            color: Colors.red[500],
            onPressed: _setRatingAsThree,
            iconSize: _size,
          ),
        ),
      ],
    );
  }
}
class ProductBox extends StatelessWidget {
  ProductBox({Key key, this.item}) : super(key: key);
  final Product item;

  Widget build(BuildContext context) {
    return Container(
        padding: EdgeInsets.all(2), height: 140,
        child: Card(
          child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: <Widget>[
                Image.asset("assets/" + this.item.imagelist),
                Expanded(
                    child: Container(
                        padding: EdgeInsets.all(5),
                        child: Column(
                          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                          children: <Widget>[
                            Text(this.item.product, style:TextStyle(fontWeight: FontWeight.bold)),
                            Text(
                                this.item.description
                            ),
                            Text("Price: " + this.item.price.toString()),
                          ],
                        )
                    )
                )
              ]
          ),
        )
    );
  }
}
// class _MyHomePageState extends State<MyHomePage> {
//
//   final List<Product> items_;
//   _MyHomePageState(this.items_);
//   void _incrementCounter() {
//     setState(() {
//       _counter++;
//     });
//   }
//
//   Widget home_header() {
//     return GestureDetector(
//       //padding: EdgeInsets.symmetric(horizontal: 16, vertical: 10),
//       onTap: () {
//         Navigator.push(
//           context,
//           MaterialPageRoute(builder: (context) => ThirdRoute(items_)),
//         );
//       },
//       child: Row(
//         mainAxisAlignment: MainAxisAlignment.spaceBetween,
//         children: <Widget>[
//           Image.asset(
//             "assets/bag_button.jpg",
//             height: 34,
//             width: 34,
//           ),
//         ],
//       ),
//     );
//   }
//
//   @override
//   Widget build(BuildContext context) {
//     return Scaffold(
//       appBar: AppBar(
//           backgroundColor: Colors.white,
//           title: Text(
//             'Habaekz Shop',
//             style: TextStyle(
//                 fontWeight: FontWeight.w700, fontSize: 24, color: Colors.black),
//           ),
//           actions: <Widget>[
//             home_header(),
//           ]),
//       body: ListView.builder(
//         itemCount: items_.length,
//         itemBuilder: (context, index) {
//           return ListTile(
//             leading: CircleAvatar(
//               backgroundImage: AssetImage('assets/' + items_[index].imagelist),
//             ),
//             title: Text(
//               items_[index].product,
//               style: TextStyle(fontSize: 16),
//             ),
//             onTap: () {
//               _index = index;
//               Navigator.push(
//                 context,
//
//                 MaterialPageRoute(builder: (context) => add_minus(items_)),
//               );
//               //pickToggle(_index);
//             },
//             subtitle: Text('Price ${items_[index].price} Bath'),
//           );
//         },
//       ),
//
//       /*bottomNavigationBar: Container(
//           child: Container(
//               height: 50.0,
//               width: MediaQuery.of(context).size.width,
//               color: Colors.white,
//               child: Padding(
//                 padding: const EdgeInsets.only(left: 8.0, right: 8.0),
//                 /*child: Row(
//                     mainAxisAlignment: MainAxisAlignment.spaceBetween,
//                     children: <Widget>[
//                       Text('Total: \$'+ totalAmount.toString(),
//                         style: TextStyle(
//                           fontSize: 18,
//                           fontWeight: FontWeight.bold,
//                         ),
//                       ),
//                       SizedBox(width: 10.0),
//                       Padding(
//                         padding: const EdgeInsets.all(8.0),
//                         child: RaisedButton(
//                           onPressed: () {},
//                           elevation: 0.5,
//                           color: Colors.red,
//                           child: Center(
//                             child: Text(
//                               'Pay Now',
//                             ),
//                           ),
//                           textColor: Colors.white,
//                         ),
//                       )
//                     ]),*/
//               ))
//       ),*/ // This trailing comma makes auto-formatting nicer for build methods.
//     );
//   }
// }

class ThirdRoute extends StatelessWidget {

  final List<Product> items_I;
  ThirdRoute(this.items_I);

  getTotalAmount() {
    var count = 0;
    for (int i = 0; i < picked.length; i++) {
      if (picked[i]) {
        count = count + 1;
      }
      if (i == picked.length - 1) {
        totalAmount = 0;
        for (int i = 0; i < picked.length; i++) {
          if (picked[i]) {
            totalAmount = totalAmount +  items_I[_index].price * num_[i];
          }
        }
      }
      ;
    }
  }

  clear(){
    for (int i = 0; i < cart_product.length; i++) {
      cart_product.clear();
      cart_image.clear();
      cart_price.clear();
    }
    for (int i = 0; i < num_.length; i++) {
      num_[i] = 0;
    }
    for (int i = 0; i < picked.length; i++) {
      picked[i] = false;
    }
  }

  pay(){
    num_[_index] = num_[_index] + 1;
  }

  check() {
    // for (int i = 0; i < picked.length; i++) {
      if (picked[_index]) {
        cart_product.add(items_I[_index].product);
        cart_image.add(items_I[_index].imagelist);
        cart_price.add(items_I[_index].price);
      }
    // }
  }

  @override
  Widget build(BuildContext context) {
    getTotalAmount();
    return Scaffold(
      appBar: AppBar(
          iconTheme: IconThemeData(
            color: Colors.black, //change your color here
          ),
          backgroundColor: Colors.white,
          title: Text(
            'Cart',
            style: TextStyle(
                fontWeight: FontWeight.w700, fontSize: 24, color: Colors.black),
          ),

          actions: <Widget>[]
      ),
      body: ListView.builder(
        itemCount: cart_product.length,
        itemBuilder: (context, index) {
          return ListTile(
            leading: CircleAvatar(
              backgroundImage: AssetImage('assets/' + cart_image[index]),
            ),
            title: Text(
              cart_product[index],
              style: TextStyle(fontSize: 16),
            ),

            subtitle: Text('Price ${cart_price[index]} Bath'),

            // onTap: () {
            // FloatingActionButton(
            //   onPressed: add,
            //   child: new Icon(Icons.add, color: Colors.black,),
            //   backgroundColor: Colors.white,
            // );
            // //pickToggle(_index);
            // },

          );

        },
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
                      Text(
                        'Total: \$' + totalAmount.toString(),
                        style: TextStyle(
                          fontSize: 18,
                          fontWeight: FontWeight.bold,
                        ),
                      ),

                      SizedBox(width: 10.0),
                      Padding(
                        padding: const EdgeInsets.all(8.0),
                        child: RaisedButton(
                          onPressed: () {
                            clear();
                            Navigator.pop(context);
                          },
                          elevation: 0.5,
                          color: Colors.red,
                          child: Center(
                            child: Text(
                              'Clear all',
                            ),
                          ),
                          textColor: Colors.white,
                        ),
                      )
                    ],
                ),

              ))),
    );
  }
}


class add_minus extends StatefulWidget {
  final List<Product> items_;
  add_minus(this.items_);

  @override
  add_minus_ createState() => add_minus_(items_);
}

class add_minus_ extends State<add_minus> {
  final List<Product> items_;
  add_minus_(this.items_);

  @override
  add() {
    setState(() {

    });
  }
  minus() {


  }

  check() {
    // for (int i = 0; i < cart_product.length; i++) {
    //   cart_product.clear();
    //   cart_image.clear();
    //   cart_price.clear();
    // }
    //for (int i = 0; i < picked.length; i++) {
      if (picked[_index]) {
        cart_product.add(items_[_index].product);
        cart_image.add(items_[_index].imagelist);
        cart_price.add(items_[_index].price);
      }
    //}
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: ListView(
        children: <Widget>[
          header(context),
          section(),
          Container(
            height: 50.0,
            width: MediaQuery
                .of(context)
                .size
                .width,
            color: Colors.white,
            child: Center(
              child: new Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: <Widget>[
                  Text('${items_[_index].price} Bath'),
                  new FloatingActionButton(
                    onPressed: add(),
                    child: new Icon(Icons.add, color: Colors.black,),
                    backgroundColor: Colors.white,),

                  new Text('1',
                      style: new TextStyle(fontSize: 30.0)),

                  new FloatingActionButton(
                    onPressed: minus(),
                    child: new Icon(Icons.remove, color: Colors.black,),
                    backgroundColor: Colors.white,),
                ],
              ),
            ),
          ),
          Container(

          ),
          SizedBox(width: 10.0),
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: RaisedButton(
              onPressed: () {
                if(!picked[_index]){
                  picked[_index] = !picked[_index];
                }
                check();
                num_[_index]++;
                Navigator.pop(context);
              },
              elevation: 0.5,
              color: Colors.red,
              child: Center(
                child: Text(
                  'Pay Now',
                ),
              ),
              textColor: Colors.white,
            ),
          ),
        ],
      ),
    );
  }

  Widget header(BuildContext context) {
    return GestureDetector(
      //padding: EdgeInsets.symmetric(horizontal: 16, vertical: 10),
      onTap: () {
        Navigator.push(
          context,
          MaterialPageRoute(builder: (context) => ThirdRoute(items_)),
        );
      },
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          back(context),
          Head_point(),
          Image.asset(
            "assets/bag_button.jpg",
            height: 34,
            width: 34,
          ),
        ],
      ),
    );
  }

  Widget Head_point() {
    return GestureDetector(
        onTap: () {},
        child: Row(children: [
          Column(
            children: [
              Text(items_[_index].brand,
                  style: TextStyle(
                      fontWeight: FontWeight.w100, fontSize: 16)),
              Text(
                items_[_index].product,
                style: TextStyle(fontWeight: FontWeight.w700, fontSize: 15),
              )
            ],
          ),
        ]));
  }

  Widget back(BuildContext context) {
    return GestureDetector(
        onTap: () {
          Navigator.pop(context);
        },
        child: Row(children: [
          Image.asset(
            "assets/back_button.jpg",
            height: 34,
            width: 34,
          ),
        ]));
  }

  Widget hero() {
    return Container(
      child: Stack(
        children: [
          Positioned(
              bottom: 10,
              right: 20,
              child: FloatingActionButton(
                backgroundColor: Colors.white,
              ))
        ],
      ),
    );
  }

  Widget section() {
    return Container(
      padding: EdgeInsets.symmetric(vertical: 10, horizontal: 20),
      child: Column(
        children: <Widget>[
          Image.asset('assets/' + items_[_index].imagelist),
          Text(
            items_[_index].description,
            textAlign: TextAlign.justify,
            style: TextStyle(fontSize: 14, height: 1.5),
          ),
          SizedBox(height: 20),
          //property()
        ],
      ),
    );
  }

}



