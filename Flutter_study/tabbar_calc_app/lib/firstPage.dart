import 'package:flutter/material.dart';

class FirstPage extends StatefulWidget {
  const FirstPage({Key? key}) : super(key: key);

  @override
  _FirstPageState createState() => _FirstPageState();
}

class _FirstPageState extends State<FirstPage> {
  TextEditingController textEditingController1 = TextEditingController();
  TextEditingController textEditingController2 = TextEditingController();

  int sum = 0;
  String textSum = ' ';

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        // 아무 곳이나 누를 경우, 키보드 닫기
        FocusScope.of(context).unfocus();
      },
      child: Scaffold(
        // appBar: AppBar(
        //   title: Text('덧셈 구하기'),
        //   centerTitle: false,
        // ),
        body: Center(
          child: Padding(
            padding: const EdgeInsets.all(20.0),
            child: Column(
              children: [
                TextField(
                  controller: textEditingController1,
                  decoration: InputDecoration(labelText: '첫번째 숫자를 입력하세요'),
                  keyboardType: TextInputType.number,
                ),
                TextField(
                  controller: textEditingController2,
                  decoration: InputDecoration(labelText: '두번째 숫자를 입력하세요'),
                  keyboardType: TextInputType.number,
                ),
                ElevatedButton(
                  style: ButtonStyle(
                    backgroundColor: MaterialStateProperty.all(Colors.blue),
                  ),
                  onPressed: () {
                    setState(() {
                      if (textEditingController1.text == '' ||
                          textEditingController2.text == '' ||
                          textEditingController1.text.isEmpty ||
                          textEditingController2.text.isEmpty) {
                        errorSnackBar(context);
                        textSum = " ";
                      } else {
                        sum = int.parse(textEditingController1.text) +
                            int.parse(textEditingController2.text);
                        textSum = "입력하신 숫자의 합은 $sum 입니다.";
                      }
                    });
                  },
                  child: Row(children: [
                    Icon(Icons.add),
                    SizedBox(
                      width: 20,
                    ),
                    Text("덧셈 계산"),
                  ]),
                ),
                SizedBox(
                  height: 50,
                ),
                Text(
                  "$textSum",
                  style: TextStyle(
                      fontSize: 20,
                      color: Colors.red,
                      fontWeight: FontWeight.bold),
                ),
              ],
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
      // 띄울 스낵바 설정
      content: Text('숫자를 입력하세요!'),
      duration: Duration(seconds: 2),
      backgroundColor: Colors.red,
    ),
  );
}