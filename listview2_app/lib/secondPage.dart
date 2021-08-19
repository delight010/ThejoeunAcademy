import 'package:flutter/material.dart';
import 'package:listview2_app/animalItem.dart';

class SecondPage extends StatefulWidget {
  final List<Animal> list;

  const SecondPage({Key? key, required this.list}) : super(key: key);

  @override
  _SecondPageState createState() => _SecondPageState();
}

class _SecondPageState extends State<SecondPage> {
  final nameController = TextEditingController();
  int _radioValue = 0;
  bool flyExist = false;
  var _imagePath;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Animal Check"),
      ),
      body: SingleChildScrollView(
        // ScrollView 생성
        child: Container(
          child: Padding(
            padding: const EdgeInsets.all(20.0),
            child: Column(
              children: [
                TextField(
                  controller: nameController,
                  keyboardType: TextInputType.text,
                  maxLines: 1,
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceAround, // 균등 간격
                  children: [
                    Radio(
                      // 라디오 버튼 생성
                      value: 0, // 번호
                      groupValue: _radioValue,
                      onChanged: _radioChange, // 클릭하게되면 실행
                    ),
                    Text("양서류"),
                    Radio(
                      value: 2, // 번호
                      groupValue: _radioValue,
                      onChanged: _radioChange, // 클릭하게되면 실행
                    ),
                    Text("파충류"),
                    Radio(
                      value: 3, // 번호
                      groupValue: _radioValue,
                      onChanged: _radioChange, // 클릭하게되면 실행
                    ),
                    Text("포유류"),
                  ],
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Text("날 수 있나요?"),
                    Checkbox(
                        // 체크박스 생성
                        value: flyExist,
                        onChanged: (check) {
                          setState(() {
                            flyExist = check!;
                          });
                        })
                  ],
                ),
                Container(
                  height: 100,
                  child: ListView(
                    // 리스트 뷰 생성
                    scrollDirection: Axis.horizontal, // 좌우로 움직이게 함
                    children: [
                      GestureDetector(
                        child: Image.asset(
                          'images/cow.png',
                          width: 80,
                        ),
                        onTap: () {
                          // click 하면
                          _imagePath = "images/cow.png";
                        },
                      ),
                      GestureDetector(
                        child: Image.asset(
                          'images/pig.png',
                          width: 80,
                        ),
                        onTap: () {
                          // click 하면
                          _imagePath = "images/pig.png";
                        },
                      ),
                      GestureDetector(
                        child: Image.asset(
                          'images/cat.png',
                          width: 80,
                        ),
                        onTap: () {
                          // click 하면
                          _imagePath = "images/cat.png";
                        },
                      ),
                      GestureDetector(
                        child: Image.asset(
                          'images/fox.png',
                          width: 80,
                        ),
                        onTap: () {
                          // click 하면
                          _imagePath = "images/fox.png";
                        },
                      ),
                      GestureDetector(
                        child: Image.asset(
                          'images/monkey.png',
                          width: 80,
                        ),
                        onTap: () {
                          // click 하면
                          _imagePath = "images/monkey.png";
                        },
                      ),
                    ],
                  ),
                ),
                ElevatedButton(
                    style: ButtonStyle(
                        backgroundColor:
                            MaterialStateProperty.all(Colors.blue)),
                    onPressed: () {
                      var animal = Animal(
                          // 입력받은 데이터로 Data 생성
                          animalName: nameController.text,
                          kind: getKind(_radioValue), // 선택한 라디오버튼의 값
                          imagePath: _imagePath,
                          flyExist: flyExist); // 체크박스
                      AlertDialog dialog = AlertDialog(
                        // Alert 설정
                        title: Text("동물 추가하기"),
                        content: Text(
                          "이 동물은 ${animal.animalName} 입니다."
                          "이 동물의 종류는 ${animal.kind} 입니다. \n"
                          "이 동물을 추가하시겠습니까?",
                          style: TextStyle(fontSize: 17),
                        ),
                        actions: [
                          ElevatedButton(
                            // alert 내부의 버튼 생성
                            style: ButtonStyle(
                                backgroundColor:
                                    MaterialStateProperty.all(Colors.blue)),
                            onPressed: () {
                              widget.list
                                  .add(animal); // widget을 통해 list에 데이터 추가
                              nameController.text = '';
                              Navigator.of(context).pop(); // alert 창 제거
                            },
                            child: Text('예'),
                          ),
                          ElevatedButton(
                            // alert 내부의 버튼 생성
                            style: ButtonStyle(
                                backgroundColor:
                                    MaterialStateProperty.all(Colors.red)),
                            onPressed: () {
                              Navigator.of(context).pop(); // alert 창 제거
                            },
                            child: Text('아니오'),
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
                    child: Text("동물 추가하기")),
              ],
            ),
          ),
        ),
      ),
    );
  }

  // --------------

  _radioChange(int? value) {
    // 화면 변화를 위함, 자료형은 null값을 포함하도록
    setState(() {
      _radioValue = value!;
    });
  }

  getKind(int radioValue) {
    switch (radioValue) {
      case 0:
        return "양서류";
      case 1:
        return "파충류";
      case 2:
        return "포유류";
    }
  }
}
