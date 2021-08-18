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
  // 컨트롤러는 항목당 1개씩 계속 추가한다.
  TextEditingController textEditingController1 = TextEditingController();
  TextEditingController textEditingController2 = TextEditingController();

  //late String sum_str;
  int sum = 0;

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        // 아무 곳이나 눌렀을 경우, 키보드 닫기
        FocusScope.of(context).unfocus();
      },
      child: Scaffold(
        appBar: AppBar(
          title: Text("간단한 덧셈 계산기"),
        ),
        body: Center(
            child: Padding(
          padding: const EdgeInsets.all(20.0),
          child: Column(
            children: [
              Text("덧셈 결과 : $sum"),
              TextField(
                controller: textEditingController1,
                //decoration: InputDecoration(labelText: '숫자를 입력하세요'),
                keyboardType: TextInputType.number,
              ),
              TextField(
                controller: textEditingController2,
                //decoration: InputDecoration(labelText: '숫자를 입력하세요'),
                keyboardType: TextInputType.number,
              ),
              ElevatedButton(
                style: ButtonStyle(
                    backgroundColor: MaterialStateProperty.all(Colors.blue)),
                onPressed: () {
                  setState(() {
                    if (textEditingController1.text == '' ||
                        textEditingController2.text == '' ||
                        textEditingController1.text.isEmpty ||
                        textEditingController2.text.isEmpty) {
                      errorSnackBar(context);
                    } else {
                      sum = int.parse(textEditingController1.text) +
                          int.parse(textEditingController2.text);
                    }
                  });
                },
                child:
                    //------Row를 넣을 수 있음
                    Row(
                  children: [
                    Icon(Icons.add),
                    SizedBox(
                      width: 20,
                    ),
                    Text("덧셈 계산"),
                  ],
                ),
                //-----
              ),
            ],
          ),
        )),
      ),
    );
  }
}

void errorSnackBar(BuildContext context) {
  ScaffoldMessenger.of(context).showSnackBar(
    SnackBar(
      // 띄울 스낵바 설정
      content: Text('숫자를 입력하세요!'),
      duration: Duration(seconds: 2), // 2초간
      backgroundColor: Colors.red,
    ),
  );
}
