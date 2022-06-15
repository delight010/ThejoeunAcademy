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
      backgroundColor: Colors.amber,
      appBar: AppBar(
        title: Text("영웅 Card"),
        backgroundColor: Colors.orange,
      ),
      body: Center(
        child: Column(
          children: [
            Padding(
              padding: const EdgeInsets.fromLTRB(100, 20, 100, 0),
              child: CircleAvatar(
                backgroundImage: AssetImage('images/lee.jpeg'),
                radius: 70,
              ),
            ),
            Divider(
              // 구분선
              height: 30.0,
              color: Colors.grey[700],
              thickness: 0.5,
            ),
            Row(
              children: [
                SizedBox(
                  width: 20,
                ),
                Column(
                  children: [
                    Text(
                      "성웅",
                      style: TextStyle(
                        color: Colors.white,
                        letterSpacing: 2.0,
                        fontSize: 20,
                      ),
                    ),
                  ],
                ),
              ],
            ),
            Row(
              children: [
                SizedBox(
                  width: 20,
                ),
                Text(
                  "이순신 장군",
                  style: TextStyle(
                      color: Colors.white,
                      letterSpacing: 2.0,
                      fontSize: 30,
                      fontWeight: FontWeight.bold),
                ),
              ],
            ),
            SizedBox(
              height: 20,
            ),
            Row(
              children: [
                SizedBox(
                  width: 20,
                ),
                Text(
                  "전적",
                  style: TextStyle(
                    color: Colors.white,
                    letterSpacing: 2.0,
                    fontSize: 20,
                  ),
                ),
              ],
            ),
            Row(
              children: [
                SizedBox(
                  width: 20,
                ),
                Text(
                  "62전 62승",
                  style: TextStyle(
                    color: Colors.orange[900],
                    letterSpacing: 2.0,
                    fontSize: 30,
                    fontWeight: FontWeight.bold,
                  ),
                ),
              ],
            ),
            SizedBox(
              height: 10,
            ),
            Row(
              children: [
                Column(
                  children: [
                    Padding(
                      padding: const EdgeInsets.fromLTRB(20, 5, 10, 3),
                      child: Icon(Icons.check_circle_outline),
                    ),
                    Padding(
                      padding: const EdgeInsets.fromLTRB(20, 5, 10, 3),
                      child: Icon(Icons.check_circle_outline),
                    ),
                    Padding(
                      padding: const EdgeInsets.fromLTRB(20, 5, 10, 3),
                      child: Icon(Icons.check_circle_outline),
                    ),
                    Padding(
                      padding: const EdgeInsets.fromLTRB(20, 5, 10, 3),
                      child: Icon(Icons.check_circle_outline),
                    ),
                    Padding(
                      padding: const EdgeInsets.fromLTRB(20, 5, 10, 3),
                      child: Icon(Icons.check_circle_outline),
                    ),
                    Padding(
                      padding: const EdgeInsets.fromLTRB(20, 5, 10, 3),
                      child: Icon(Icons.check_circle_outline),
                    ),
                    Padding(
                      padding: const EdgeInsets.fromLTRB(20, 5, 10, 3),
                      child: Icon(Icons.check_circle_outline),
                    ),
                  ],
                ),
                Column(
                  children: [
                    Padding(
                      padding: const EdgeInsets.fromLTRB(0, 10, 0, 2),
                      child: Text(
                        "옥포해전",
                        style: TextStyle(
                          fontSize: 17,
                        ),
                      ),
                    ),
                    Padding(
                      padding: const EdgeInsets.fromLTRB(17, 10, 0, 2),
                      child: Text(
                        "사천포해전",
                        style: TextStyle(
                          fontSize: 17,
                        ),
                      ),
                    ),
                    Padding(
                      padding: const EdgeInsets.fromLTRB(0, 10, 0, 2),
                      child: Text(
                        "당포해전",
                        style: TextStyle(
                          fontSize: 17,
                        ),
                      ),
                    ),
                    Padding(
                      padding: const EdgeInsets.fromLTRB(17, 10, 0, 2),
                      child: Text(
                        "한산도대첩",
                        style: TextStyle(
                          fontSize: 17,
                        ),
                      ),
                    ),
                    Padding(
                      padding: const EdgeInsets.fromLTRB(17, 10, 0, 2),
                      child: Text(
                        "부산포해전",
                        style: TextStyle(
                          fontSize: 17,
                        ),
                      ),
                    ),
                    Padding(
                      padding: const EdgeInsets.fromLTRB(0, 10, 0, 2),
                      child: Text(
                        "명랑해전",
                        style: TextStyle(
                          fontSize: 17,
                        ),
                      ),
                    ),
                    Padding(
                      padding: const EdgeInsets.fromLTRB(0, 10, 0, 2),
                      child: Text(
                        "노량해전",
                        style: TextStyle(
                          fontSize: 17,
                        ),
                      ),
                    ),
                  ],
                ),
              ],
            ),
            CircleAvatar(
              backgroundImage: AssetImage('images/turtle.gif'),
              radius: 50,
              backgroundColor: Colors.amber,
            ),
          ],
        ),
      ),
    );
  }
}
