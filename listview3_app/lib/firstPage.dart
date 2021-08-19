import 'package:flutter/material.dart';
import 'package:listview3_app/flagItem.dart';

class FirstPage extends StatelessWidget {
  final List<Flag> list;

  // 생성자 const 부터 시작
  const FirstPage({ Key? key, required this.list }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("국가명 맞추기"),
      ),
      body: Center(
        child: ListView.builder(itemBuilder: (context, position){
          return GestureDetector(
            child: Card(
              child: Row(
                children: [
                  Image.asset(
                    list[position].imagePath,
                    height: 100,
                    width: 100,
                    fit: BoxFit.contain
                  ),
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Text(list[position].country[0]+"_____"),
                  )
                ],
              ),
            ),
            onTap: (){ // 클릭하면 현재위치 정보와, list의 내용을 전달
              _showDialog(context, list[position].country);
            },
          );
        },
        itemCount: list.length,),
      ),
    );
  }

void _showDialog(BuildContext context, String name){
  showDialog(
    context: context, 
    builder: (BuildContext context){
      return AlertDialog(
        title: Text("국가명"),
        content: Text(("이 국기는 $name의 국기 입니다.")),
        actions: [
          ElevatedButton(
            style: ButtonStyle(
              backgroundColor: MaterialStateProperty.all(Colors.blue),

            ),
            onPressed: (){
              Navigator.of(context).pop(); // alert 제거
            }, 
            child: Text('종료')),
        ],
      );
    });
  }

}