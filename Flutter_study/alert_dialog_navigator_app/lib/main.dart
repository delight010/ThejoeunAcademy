import 'package:alert_dialog_navigator_app/firstPage.dart';
import 'package:alert_dialog_navigator_app/secondPage.dart';
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
        '/SecondPage': (context) {
          return SecondPage();
        },
      },
    );
  }
}
