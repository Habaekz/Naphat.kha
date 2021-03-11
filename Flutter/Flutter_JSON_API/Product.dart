class Product {
  final String product;
  final String description;
  final int price;
  final String imagelist;
  final String brand;

  Product(this.brand,this.product, this.description, this.price, this.imagelist);
  factory Product.fromMap(Map<String, dynamic> json) {
    return Product(
      json['brand'],
      json['product'],
      json['description'],
      json['price'],
      json['imagelist'],
    );
  }
}


