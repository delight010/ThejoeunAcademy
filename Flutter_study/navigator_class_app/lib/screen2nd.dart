import 'package:flutter/material.dart';

class Screen2nd extends StatelessWidget {
  const Screen2nd({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Screen 2nd'),
        backgroundColor: Colors.red,
      ),
      body: Center(
        child: Text(
          'Screen2nd',
          style: TextStyle(fontSize: 20),
        ),
      ),
    );
  }
}
