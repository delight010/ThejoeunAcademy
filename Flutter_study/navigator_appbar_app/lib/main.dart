import 'package:flutter/material.dart';
import 'package:navigator_appbar_app/firstPage.dart';
import 'package:navigator_appbar_app/receivedMail.dart';
import 'package:navigator_appbar_app/sendMail.dart';

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
