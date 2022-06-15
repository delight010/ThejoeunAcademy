import 'package:flutter/material.dart';

class SendMail extends StatelessWidget {
  const SendMail({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Send Mail"),
        backgroundColor: Colors.green,
      ),
      body: Padding(
        padding: const EdgeInsets.fromLTRB(10, 50, 0, 0),
        child: Column(
          children: [
            Text("유비가 보낸 메일"),
            Text("장비과 보낸 메일"),
            Text("관우가 보낸 메일"),
          ],
        ),
      ),
    );
  }
}
