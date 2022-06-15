import 'package:drawer_navigator_appbar_app/firstPage.dart';
import 'package:drawer_navigator_appbar_app/receivedMail.dart';
import 'package:drawer_navigator_appbar_app/sendMail.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      initialRoute: '/',
      routes: {
        '/': (context) {
          return FirstPage();
        },
        '/SendMail': (context) {
          return SendMail();
        },
        '/ReceivedMail': (context) {
          return ReceivedMail();
        },
      },
    );
  }
}
