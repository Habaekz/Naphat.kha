import 'package:flutter/material.dart';
import 'package:location_service/datamodels/class_location.dart';
import 'package:location_service/datamodels/user_location.dart';
import 'package:provider/provider.dart';
import 'dart:math';

class HomeView extends StatelessWidget {
  const HomeView({Key key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    var userLocation = Provider.of<UserLocation>(context);

    // ClassLocation can provided from difference device
    ClassLocation _classLocation = ClassLocation(
      // Case 'Can Check in/out'
      latitude: userLocation.latitude+0.0001,//latitude for case 10 meter
      longitude: userLocation.longitude+0.0001//longitude for case 10 meter

      // Case 'Can't Check in/out'
      //Latitude: userLocation.latitude+3,//latitude for case 10 meter
      //longitude: userLocation.longitude+3//longitude for case 10 meter
    );
    const R = 6371e3; // metres
    var lat = userLocation.latitude;
    var long = userLocation.longitude;
    var v1 = lat * pi/180; // φ, λ in radians
    var v2 = _classLocation.latitude * pi/180;
    var v3 = (_classLocation.latitude-lat) * pi/180;
    var v4 = (_classLocation.longitude-long) * pi/180;
    var a = asin(v3/2) * asin(v3/2) + acos(v1) * acos(v2) * asin(v4/2) * asin(v4/2);
    var c = 2 * atan2(sqrt(a), sqrt(1-a));

    var d = R * c; // in metres
    var textt = '';

    if(d>50 || d.isNaN) {
      textt = 'Can\'t check in/out';
    }
    else {
      textt = 'Can check in/out';
    }
    return Scaffold(
      body: Center(
        child:
        Text(
            'Your Location is:\n\n\n Lat: ${userLocation.latitude}, Long: ${userLocation.longitude}\n\n\n Class Location is:\n\n\n Lat: ${_classLocation.latitude}, Long: ${_classLocation.longitude}\n\n\n Distance: $d meter\n\n\n $textt'),
        ),
    );
  }
}
