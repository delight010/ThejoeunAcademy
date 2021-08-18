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
  TextEditingController textEditingController = TextEditingController();
  late String inputValue;

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        // 아무 곳이나 눌렀을 경우, 키보드 닫기
        FocusScope.of(context).unfocus();
      },
      child: Scaffold(
        appBar: AppBar(
          title: Text('Single Textfield'),
        ),
        body: Center(
          child: Padding(
            padding: const EdgeInsets.all(20.0),
            child: Column(
              children: [
                TextField(
                  controller: textEditingController,
                  decoration: InputDecoration(labelText: '글자를 입력하세요'),
                  keyboardType: TextInputType.text, // 키보드 자판
                ),
                ElevatedButton(
                  //style: ,
                  onPressed: () {
                    if (textEditingController.text == '' ||
                        textEditingController.text.isEmpty) {
                      errorSnackBar(context);
                    } else {
                      inputValue = textEditingController.text;
                      showSnackBar(context, inputValue);
                    }
                  },
                  child: Text('출력'),
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
      content: Text('글자를 입력하세요!'),
      duration: Duration(seconds: 2), // 2초간
      backgroundColor: Colors.red,
    ),
  );
}

void showSnackBar(BuildContext context, String inputValue) {
  ScaffoldMessenger.of(context).showSnackBar(
    SnackBar(
      // 띄울 스낵바 설정
      content: Text('입력한 글자는 $inputValue입니다.'),
      duration: Duration(seconds: 2), // 2초간
      backgroundColor: Colors.blue,
    ),
  );
}
