import 'package:drawer_navigator_appbar_app/receivedMail.dart';
import 'package:drawer_navigator_appbar_app/sendMail.dart';
import 'package:flutter/material.dart';

class FirstPage extends StatelessWidget {
  const FirstPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Mail"),
        centerTitle: true,
        actions: [
          IconButton(
            onPressed: () {
              print("AppBar 보낸 편지함 클릭");
              Navigator.pushNamed(context, '/SendMail');
            },
            icon: Icon(Icons.mail),
          ),
          IconButton(
            onPressed: () {
              print("AppBar 받은 편지함 클릭");
              Navigator.pushNamed(context, '/ReceivedMail');
            },
            icon: Icon(Icons.mail_outline),
          ),
        ],
      ),
      drawer: Drawer(
        child: ListView(
          children: [
            UserAccountsDrawerHeader(
              // 상단 UserAccountsDrawerHeader 설정
              currentAccountPicture: CircleAvatar(
                backgroundImage: AssetImage('images/picachu1.png'),
                backgroundColor: Colors.white,
              ),
              accountName: Text('Picachu'),
              accountEmail: Text('picachu@naver.com'),
              onDetailsPressed: () {
                // 이메일 옆의 삼각형(더보기)
                print("main page is clicked");
              },
              decoration: BoxDecoration(
                // 상단 프로필바 디자인 변경
                color: Colors.red[400],
                borderRadius: BorderRadius.only(
                  bottomLeft: Radius.circular(30),
                  bottomRight: Radius.circular(30),
                ),
              ),
            ),
            ListTile(
              leading: Icon(
                Icons.mail,
                color: Colors.blue,
              ),
              title: Text("보낸 편지함"),
              onTap: () {
                print('ListTile 보낸 편지함 is clicked');
                Navigator.push(context, MaterialPageRoute(builder: (context) {
                  return SendMail();
                }));
              },
            ),
            ListTile(
              leading: Icon(
                Icons.mail_outline,
                color: Colors.red,
              ),
              title: Text("받은 편지함"),
              onTap: () {
                print('ListTile 받은 편지함 is clicked');

                Navigator.push(context, MaterialPageRoute(builder: (context) {
                  return ReceivedMail();
                }));
              },
            ),
          ],
        ),
      ),
      body: Center(
        child: Column(
          children: [
            SizedBox(
              height: 300,
            ),
            ElevatedButton(
              style: ButtonStyle(
                backgroundColor: MaterialStateProperty.all(Colors.green),
              ),
              onPressed: () {
                print('FirstPage Send Mail Button is clicked');
                Navigator.pushNamed(context, '/SendMail');
              },
              child: Text('보낸 편지함'),
            ),
            ElevatedButton(
              style: ButtonStyle(
                backgroundColor: MaterialStateProperty.all(Colors.red),
              ),
              onPressed: () {
                print('FirstPage Received Mail Button is clicked');
                Navigator.pushNamed(context, '/ReceivedMail');
              },
              child: Text('받은 편지함'),
            ),
          ],
        ),
      ),
    );
  }
}
