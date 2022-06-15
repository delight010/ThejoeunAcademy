import 'package:flutter/material.dart';
import 'package:navigator_appbar_app/receivedMail.dart';
import 'package:navigator_appbar_app/sendMail.dart';

class FirstPage extends StatelessWidget {
  const FirstPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Navigator_AppBar"),
        actions: [
          IconButton(
            onPressed: () {
              print("AppBar 보낸 편지함을 클릭");
              Navigator.pushNamed(context, '/SendMail');
            },
            icon: Icon(Icons.mail),
          ),
          IconButton(
            onPressed: () {
              print("AppBar 받은 편지함을 클릭");
              Navigator.pushNamed(context, '/ReceivedMail');
            },
            icon: Icon(Icons.mail_outline),
          ),
        ],
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
                // Navigator를 통해 return 페이지로 이동
                Navigator.push(context, MaterialPageRoute(builder: (context) {
                  return SendMail();
                }));
              },
              child: Text("보낸 편지함"),
            ),
            ElevatedButton(
              style: ButtonStyle(
                backgroundColor: MaterialStateProperty.all(Colors.red),
              ),
              onPressed: () {
                // Navigator를 통해 return 페이지로 이동
                Navigator.push(context, MaterialPageRoute(builder: (context) {
                  return ReceivedMail();
                }));
              },
              child: Text("받은 편지함"),
            ),
          ],
        ),
      ),
    );
  }
}
