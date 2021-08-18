import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
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
  TextEditingController textEditingController1 = TextEditingController();
  TextEditingController textEditingController2 = TextEditingController();
  TextEditingController add_textEditingController = TextEditingController();
  TextEditingController sub_textEditingController = TextEditingController();
  TextEditingController mul_textEditingController = TextEditingController();
  TextEditingController div_textEditingController = TextEditingController();

  int num1 = 0;
  int num2 = 0;

  int addResult = 0;
  int subResult = 0;
  int mulResult = 0;
  double divResult = 0.0;

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        // 키보드 내리기
        FocusScope.of(context).unfocus();
      },
      child: Scaffold(
        appBar: AppBar(
          title: Text("간단한 계산기"),
        ),
        body: SingleChildScrollView(
          // ScrollView 설정 (SingleChildScrollView)
          child: Center(
            child: Padding(
              padding: const EdgeInsets.all(10.0),
              child: Column(
                children: [
                  TextField(
                    controller: textEditingController1,
                    decoration: InputDecoration(labelText: '첫번째 숫자를 입력하세요'),
                    keyboardType: TextInputType.number,
                  ),
                  SizedBox(
                    height: 15,
                  ),
                  TextField(
                    controller: textEditingController2,
                    decoration: InputDecoration(labelText: '두번째 숫자를 입력하세요'),
                    keyboardType: TextInputType.number,
                  ),
                  SizedBox(
                    height: 15,
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      ElevatedButton(
                          onPressed: () {
                            setState(() {
                              if (textEditingController1.text == '' ||
                                  textEditingController2.text == '' ||
                                  textEditingController1.text.isEmpty ||
                                  textEditingController2.text.isEmpty) {
                                errorSnackBar(context);

                                FocusScope.of(context).unfocus();
                              } else if (textEditingController1.text == '0' ||
                                  textEditingController2.text == '0') {
                                zeroSnackBar(context);

                                FocusScope.of(context).unfocus();
                              } else {
                                num1 = int.parse(textEditingController1.text);
                                num2 = int.parse(textEditingController2.text);

                                addResult = num1 + num2;
                                subResult = num1 - num2;
                                mulResult = num1 * num2;
                                divResult = num1.toDouble() / num2.toDouble();

                                add_textEditingController.text =
                                    addResult.toString();
                                sub_textEditingController.text =
                                    subResult.toString();
                                mul_textEditingController.text =
                                    mulResult.toString();
                                div_textEditingController.text =
                                    divResult.toString();

                                FocusScope.of(context).unfocus();
                              }
                            });
                          },
                          child: Text('계산하기')),
                      SizedBox(
                        width: 30,
                      ),
                      ElevatedButton(
                        onPressed: () {
                          setState(() {
                            textEditingController1.text = '';
                            textEditingController2.text = '';
                            add_textEditingController.text = '';
                            sub_textEditingController.text = '';
                            mul_textEditingController.text = '';
                            div_textEditingController.text = '';
                            FocusScope.of(context).unfocus();
                          });
                        },
                        child: Text('지우기'),
                        style: ButtonStyle(
                          backgroundColor:
                              MaterialStateProperty.all(Colors.red),
                        ),
                      ),
                    ],
                  ),
                  SizedBox(
                    height: 15,
                  ),
                  TextField(
                    controller: add_textEditingController,
                    decoration: InputDecoration(labelText: '덧셈결과'),
                    // 입력이 아닐 시, readOnly: true 설정
                    readOnly: true,
                  ),
                  SizedBox(
                    height: 15,
                  ),
                  TextField(
                    controller: sub_textEditingController,
                    decoration: InputDecoration(labelText: '뺄셈결과'),
                    // 입력이 아닐 시, readOnly: true 설정
                    readOnly: true,
                  ),
                  SizedBox(
                    height: 15,
                  ),
                  TextField(
                    controller: mul_textEditingController,
                    decoration: InputDecoration(labelText: '곱셈결과'),
                    // 입력이 아닐 시, readOnly: true 설정
                    readOnly: true,
                  ),
                  SizedBox(
                    height: 15,
                  ),
                  TextField(
                    controller: div_textEditingController,
                    decoration: InputDecoration(labelText: '나눗셈결과'),
                    // 입력이 아닐 시, readOnly: true 설정
                    readOnly: true,
                  ),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}

void errorSnackBar(BuildContext context) {
  ScaffoldMessenger.of(context).showSnackBar(
    SnackBar(
      content: Text('숫자를 입력하세요!'),
      duration: Duration(seconds: 2),
      backgroundColor: Colors.red,
    ),
  );
}

void zeroSnackBar(BuildContext context) {
  ScaffoldMessenger.of(context).showSnackBar(
    SnackBar(
      content: Text('0은 입력할 수 없습니다!'),
      duration: Duration(seconds: 2),
      backgroundColor: Colors.red,
    ),
  );
}
