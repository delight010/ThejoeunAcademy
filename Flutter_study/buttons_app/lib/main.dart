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
          title: Text('Buttons'),
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              TextButton(
                // TextButton
                onPressed: () {
                  // onPressed : 사용할 액션 (버튼 클릭)
                  print("Text Button");
                },
                onLongPress: () {
                  // 길게 클릭할 시
                  print("Long pressed text button");
                },
                child: Text(
                  'Text Button',
                  style: TextStyle(
                    fontSize: 20.0,
                  ),
                ),
                style: TextButton.styleFrom(
                  primary: Colors.red, // 버튼 글자 색 변경
                ),
              ),
              ElevatedButton(
                // ElevatedButton
                onPressed: () {
                  print("Elevated Button");
                },
                child: Text('Elevated Button'),
                style: ElevatedButton.styleFrom(
                  primary: Colors.orangeAccent, // 버튼 색깔 변경
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(20.0), // 테두리 둥글게
                  ),
                ),
              ),
              OutlinedButton(
                // OutlinedButton
                onPressed: () {
                  print('Outlined Button');
                },
                child: Text('Outlined Button'),
                style: OutlinedButton.styleFrom(
                    primary: Colors.green,
                    side: BorderSide(
                        // 테두리 설정
                        color: Colors.black87,
                        width: 2.0)),
              ),
              TextButton.icon(
                // TextButton.icon
                onPressed: () {
                  print('Icon Button');
                },
                icon: Icon(
                  Icons.home,
                  size: 30.0,
                ),
                label: Text('Go Home'),
                style: TextButton.styleFrom(
                  // TextButton Style
                  primary: Colors.purple,
                ),
              ),
              ElevatedButton.icon(
                // ElevatedButton.icon
                onPressed: () {
                  print('Elevated Icon');
                },
                icon: Icon(Icons.home, size: 20.0),
                label: Text('Go Home'),
                style: ElevatedButton.styleFrom(primary: Colors.black),
              ),
              OutlinedButton.icon(
                // OutlinedButton.icon
                onPressed: () {
                  print('Outlined Icon');
                },
                icon: Icon(
                  Icons.home,
                  size: 20.0,
                ),
                label: Text('Go Home'),
                style: OutlinedButton.styleFrom(
                  primary: Colors.pink[100],
                  //onSurface: Colors.pink
                ),
              ),
              ButtonBar(
                // Button Bar : 여러 개의 버튼을 넣을 수 있음
                alignment: MainAxisAlignment.center, // 가운데 정렬
                buttonPadding: EdgeInsets.all(20), // 간격
                children: [
                  TextButton(
                    onPressed: () {},
                    child: Text("Text Button"),
                  ),
                  ElevatedButton(
                    onPressed: () {},
                    child: Text('Elevated Button'),
                  ),
                ],
              )
            ],
          ),
        ));
  }
}
