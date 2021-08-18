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
        title: Text("Drawer App"),
        centerTitle: true, // Android는 이걸 설정해야 가운데정렬이 됨
        actions: [
          IconButton(
              onPressed: () {
                print("Shopping cart is clicked");
              },
              icon: Icon(Icons.shopping_cart)),
          IconButton(
              onPressed: () {
                print("Search is clicked");
              },
              icon: Icon(Icons.search)),
        ],
      ),
      drawer: Drawer(
        child: ListView(children: [
          UserAccountsDrawerHeader(
            // 상단 UserAccountsDrawerHeader 설정
            currentAccountPicture: CircleAvatar(
              backgroundImage: AssetImage('images/picachu1.png'),
              backgroundColor: Colors.white,
            ),
            otherAccountsPictures: [
              CircleAvatar(
                backgroundImage: AssetImage('images/picachu2.png'),
                backgroundColor: Colors.white,
              ),
              CircleAvatar(
                backgroundImage: AssetImage('images/picachu3.png'),
                backgroundColor: Colors.white,
              ),
            ],
            accountName: Text('Picachu'),
            accountEmail: Text('pickchu@naver.com'),
            onDetailsPressed: () {
              // 이메일 옆의 삼각형(더보기)
              print("main page is clicked");
            },
            decoration: BoxDecoration(
              // background 디자인 변경
              color: Colors.red[400],
              borderRadius: BorderRadius.only(
                bottomLeft: Radius.circular(40.0),
                bottomRight: Radius.circular(40.0),
              ),
            ),
          ),
          ListTile(
            leading: Icon(
              Icons.home,
              color: Colors.black,
            ),
            title: Text('Home'),
            onTap: () {
              print('Home is clicked');
            },
          ),
          ListTile(
            leading: Icon(
              Icons.settings,
              color: Colors.black,
            ),
            title: Text('설정'),
            onTap: () {
              print('Setting is clicked');
            },
          ),
          ListTile(
            leading: Icon(
              Icons.message_sharp,
              color: Colors.red,
            ),
            title: Text('자주 묻는 질문'),
            onTap: () {
              print('자주 묻는 질문 is clicked');
            },
          ),
        ]),
      ), // 왼쪽 메뉴바(Drawer)
    );
  }
}
