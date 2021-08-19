import 'package:flutter/material.dart';
import 'package:listview3_app/flagItem.dart';

class SecondPage extends StatefulWidget {
  final List<Flag> list;

  const SecondPage({Key? key, required this.list}) : super(key: key);

  @override
  _SecondPageState createState() => _SecondPageState();
}

class _SecondPageState extends State<SecondPage> {
  final quizController = TextEditingController();
  final answerController = TextEditingController();
  var _imagePath;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("국가명 맞추기"),
      ),
      body: SingleChildScrollView(
        // ScrollView 생성
        child: Container(
          child: Padding(
            padding: const EdgeInsets.all(20.0),
            child: Column(
              children: [
                TextField(
                  controller: quizController,
                  decoration: InputDecoration(labelText: '문제를 입력하세요'),
                  keyboardType: TextInputType.text, // 키보드 자판
                ),
                TextField(
                  controller: answerController,
                  decoration: InputDecoration(labelText: '정답을 입력하세요'),
                  keyboardType: TextInputType.text, // 키보드 자판
                ),
                SizedBox(
                  height: 20,
                ),
                Container(
                  height: 100,
                  child: ListView(
                    // 리스트 뷰 생성
                    scrollDirection: Axis.horizontal, // 좌우로 움직이게함
                    children: [
                      GestureDetector(
                        child: Image.asset(
                          'images/korea.png',
                          width: 80,
                        ),
                        onTap: () {
                          // click 하면
                          _imagePath = "images/korea.png";
                        },
                      ),
                      GestureDetector(
                        child: Image.asset(
                          'images/china.png',
                          width: 80,
                        ),
                        onTap: () {
                          // click 하면
                          _imagePath = "images/china.png";
                        },
                      ),
                      GestureDetector(
                        child: Image.asset(
                          'images/america.png',
                          width: 80,
                        ),
                        onTap: () {
                          // click 하면
                          _imagePath = "images/america.png";
                        },
                      ),
                      GestureDetector(
                        child: Image.asset(
                          'images/greece.png',
                          width: 80,
                        ),
                        onTap: () {
                          // click 하면
                          _imagePath = "images/greece.png";
                        },
                      ),
                      GestureDetector(
                        child: Image.asset(
                          'images/turkey.png',
                          width: 80,
                        ),
                        onTap: () {
                          // click 하면
                          _imagePath = "images/turkey.png";
                        },
                      ),
                    ],
                  ),
                ),
                ElevatedButton(
                  style: ButtonStyle(
                      backgroundColor: MaterialStateProperty.all(Colors.blue)),
                  onPressed: () {
                    var flag = Flag(
                        // 입력받은 데이터로 Data 생성
                        quiz: quizController.text,
                        country: answerController.text,
                        imagePath: _imagePath);
                    // Alert 설정
                    AlertDialog dialog = AlertDialog(
                      title: Text("동물 추가하기"),
                      content: Text(
                        "문제는 ${flag.quiz} 입니다."
                        "정답은 ${flag.country} 입니다. \n"
                        "문제를 추가하시겠습니까?",
                        style: TextStyle(fontSize: 17),
                      ),
                      actions: [
                        ElevatedButton(
                          // alert 내부의 버튼 생성
                          style: ButtonStyle(
                              backgroundColor:
                                  MaterialStateProperty.all(Colors.red)),
                          onPressed: () {
                            widget.list.add(flag); // widget을 통해 list에 데이터 추가
                            quizController.text = '';
                            answerController.text = '';
                            Navigator.of(context).pop(); // alert 창 제거
                          },
                          child: Text("예"),
                        ),
                        ElevatedButton(
                          // alert 내부의 버튼 생성
                          style: ButtonStyle(
                              backgroundColor:
                                  MaterialStateProperty.all(Colors.blue)),
                          onPressed: () {
                            Navigator.of(context).pop(); // alert 창 제거
                          },
                          child: Text("아니오"),
                        ),
                      ],
                    );
                    // alert 띄우기
                    showDialog(
                        context: context,
                        builder: (BuildContext context) {
                          return dialog;
                        });
                  },
                  child: Text("문제 추가하기"),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }

  // --------------

}
