import 'package:flutter/material.dart';
import 'package:login_app/secondPage.dart';

class FirstPage extends StatefulWidget {
  const FirstPage({Key? key}) : super(key: key);

  @override
  _FirstPageState createState() => _FirstPageState();
}

class _FirstPageState extends State<FirstPage> {
  TextEditingController id_textEditingController = TextEditingController();
  TextEditingController pw_textEditingController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Log In"),
      ),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(20),
          child: Column(
            //mainAxisAlignment: MainAxisAlignment.center,
            children: [
              CircleAvatar(
                backgroundImage: AssetImage('images/picachu1.png'),
                backgroundColor: Colors.white,
                radius: 80,
              ),
              TextField(
                controller: id_textEditingController,
                decoration: InputDecoration(labelText: '사용자 ID 입력하세요'),
                keyboardType: TextInputType.text,
              ),
              TextField(
                controller: pw_textEditingController,
                decoration: InputDecoration(labelText: '패스워드를 입력하세요'),
                keyboardType: TextInputType.number,
                obscureText: true,
              ),
              ElevatedButton(
                style: ButtonStyle(
                    backgroundColor: MaterialStateProperty.all(Colors.blue)),
                onPressed: () {
                  if (id_textEditingController.text == '' ||
                      pw_textEditingController.text == '' ||
                      id_textEditingController.text.isEmpty ||
                      pw_textEditingController.text.isEmpty) {
                    ScaffoldMessenger.of(context).showSnackBar(SnackBar(
                      content: Text("사용자ID와 암호를 입력하세요!"),
                      duration: Duration(seconds: 2),
                      backgroundColor: Colors.red,
                    ));
                  } else if (id_textEditingController.text != 'root' ||
                      pw_textEditingController.text != '1234') {
                    ScaffoldMessenger.of(context).showSnackBar(SnackBar(
                      content: Text("사용자ID와 암호가 맞지 않습니다!"),
                      duration: Duration(seconds: 2),
                      backgroundColor: Colors.blue,
                    ));
                  } else if (id_textEditingController.text == 'root' &&
                      pw_textEditingController.text == '1234') {
                    AlertDialog dialog = AlertDialog(
                      title: Text("환영 합니다!"),
                      content: Text("신분이 확인 되었습니다."),
                      actions: [
                        ElevatedButton(
                          style: ButtonStyle(
                            backgroundColor:
                                MaterialStateProperty.all(Colors.blue),
                          ),
                          onPressed: () async {
                            Navigator.of(context).pop();
                            Navigator.push(
                              context,
                              MaterialPageRoute(builder: (context) {
                                return SecondPage(
                                    id: id_textEditingController.text);
                              }),
                            );
                          },
                          child: Text("OK"),
                        ),
                      ],
                    );
                    showDialog(
                        context: context,
                        builder: (BuildContext context) {
                          return dialog;
                        });
                  }
                },
                child: Text("Log In"),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
