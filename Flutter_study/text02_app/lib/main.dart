import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatelessWidget {
  const MyHomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Text with Column and Row"),
      ),
      body: Center(
        child: Column(
          // 행에 대한 정렬
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Row(
              // 열에 대한 정렬
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Icon(Icons.email_rounded),
                SizedBox(
                  width: 10,
                ),
                Text("James"),
              ],
            ),
            SizedBox(height: 20),
            Column(
              // 행에 대한 정렬
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Row(
                  // 행에 대한 정렬
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Icon(Icons.account_balance),
                    SizedBox(
                      width: 10,
                    ),
                    Text("Cathy"),
                  ],
                ),
                SizedBox(height: 20),
              ],
            ),
            Column(
              // 행에 대한 정렬
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Row(
                  // 행에 대한 정렬
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Icon(Icons.account_circle),
                    SizedBox(
                      width: 10,
                    ),
                    Text("Kenny"),
                  ],
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
