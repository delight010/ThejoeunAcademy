import 'dart:ffi';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
      title: 'Flutter Demo',
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
  TextEditingController _number1 = TextEditingController();
  TextEditingController _number2 = TextEditingController();
  TextEditingController? _add;
  TextEditingController? _sub;
  TextEditingController? _mul;
  TextEditingController? _div;

  String main = '환영 합니다!';

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _number1 = TextEditingController();
    _number2 = TextEditingController();
    _add = TextEditingController();
    _sub = TextEditingController();
    _mul = TextEditingController();
    _div = TextEditingController();
  }

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        // 아무 곳이나 누를 경우, 키보드 닫기
        FocusScope.of(context).unfocus();
      },
      child: CupertinoApp(
        home: CupertinoPageScaffold(
          child: Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Padding(
                  padding: const EdgeInsets.only(bottom: 50), // 한쪽에만 padding 추가
                  child: Text(
                    '두 개의 숫자 연산',
                    style: TextStyle(
                      fontSize: 25,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                ),
                Container(
                  child: Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        Container(child: Text("첫번째 숫자:"), width: 100),
                        Container(
                          child: CupertinoTextField(
                            controller: _number1,
                            keyboardType: TextInputType.number,
                            maxLines: 1,
                            placeholder: '숫자를 입력하세요!',
                            textAlign: TextAlign.right,
                          ),
                          width: 150,
                        ),
                      ],
                    ),
                  ),
                ),
                Container(
                  child: Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        Container(child: Text("두번째 숫자:"), width: 100),
                        Container(
                          child: CupertinoTextField(
                            controller: _number2,
                            keyboardType: TextInputType.number,
                            maxLines: 1,
                            placeholder: '숫자를 입력하세요!',
                            textAlign: TextAlign.right,
                          ),
                          width: 150,
                        ),
                      ],
                    ),
                  ),
                ),
                CupertinoButton(
                  child: Text('계산하기'),
                  onPressed: () {
                    setState(() {
                      if (_number1.text == '' ||
                          _number2.text == '' ||
                          _number1.text.isEmpty ||
                          _number2.text.isEmpty) {
                        main = '숫자를 입력하세요';
                      } else {
                        int num1 = int.parse(_number1.text);
                        int num2 = int.parse(_number2.text);
                        double double_result = double.parse(_number1.text) /
                            double.parse(_number2.text);
                        _add?.text = (num1 + num2).toString();
                        _sub?.text = (num1 - num2).toString();
                        _mul?.text = (num1 * num2).toString();
                        _div?.text = double_result.toString();
                        //(double.parse(_number1.text) / double.parse(_number2.text)).toString();
                        main = '계산이 완료 되었습니다';
                      }
                    });
                  },
                ),
                Container(
                  child: Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        Container(
                          child: Text('덧셈 결과:'),
                          width: 100,
                        ),
                        Container(
                          child: CupertinoTextField(
                            controller: _add,
                            keyboardType: TextInputType.number,
                            maxLines: 1,
                            readOnly: true,
                            textAlign: TextAlign.right,
                          ),
                          width: 150,
                        ),
                      ],
                    ),
                  ),
                ),
                Container(
                  child: Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        Container(
                          child: Text('뺄셈 결과:'),
                          width: 100,
                        ),
                        Container(
                          child: CupertinoTextField(
                            controller: _sub,
                            keyboardType: TextInputType.number,
                            maxLines: 1,
                            readOnly: true,
                            textAlign: TextAlign.right,
                          ),
                          width: 150,
                        ),
                      ],
                    ),
                  ),
                ),
                Container(
                  child: Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        Container(
                          child: Text('곱셈 결과:'),
                          width: 100,
                        ),
                        Container(
                          child: CupertinoTextField(
                            controller: _mul,
                            keyboardType: TextInputType.number,
                            maxLines: 1,
                            readOnly: true,
                            textAlign: TextAlign.right,
                          ),
                          width: 150,
                        ),
                      ],
                    ),
                  ),
                ),
                Container(
                  child: Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        Container(
                          child: Text('나눗셈 결과:'),
                          width: 100,
                        ),
                        Container(
                          child: CupertinoTextField(
                            controller: _sub,
                            keyboardType: TextInputType.text,
                            maxLines: 1,
                            readOnly: true,
                            textAlign: TextAlign.right,
                          ),
                          width: 150,
                        ),
                      ],
                    ),
                  ),
                ),
                SizedBox(
                  height: 50,
                ),
                Text(
                  main,
                  style: TextStyle(color: Colors.red),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
