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

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key}) : super(key: key);

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  var switchValue = false;
  Color _color = Colors.blue;
  late Color _tempColor; // late : 나중에 값을 줄 예정
  // 혹은 nil값을 포함하도록
  // Color? _tempColor; 로 정의해도 된다.

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Changed Button color on Switch'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ElevatedButton(
              style: ButtonStyle(
                backgroundColor: MaterialStateProperty.all(_color),
              ),
              onPressed: () {},
              child: Text('Flutter'),
            ),
            Switch(
              // Switch bar 생성
              value: switchValue,
              onChanged: (value) {
                if (value == true) {
                  _tempColor = Colors.red;
                } else {
                  _tempColor = Colors.blue;
                }
                setState(() {
                  _color = _tempColor;
                  switchValue = value;
                });
              },
            )
          ],
        ),
      ),
    );
  }
}
