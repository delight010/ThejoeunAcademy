import 'package:flutter/material.dart';
import 'package:listview_app/animalItem.dart';

class FirstPage extends StatelessWidget {
  final List<Animal> list;

  // 생성자 const 부터 시작
  const FirstPage({ Key? key, required this.list }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Animal List"),
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
                  Text(list[position].animalName)
                ],
              ),
            ),
            onTap: (){ // 클릭하면 현재위치 정보와, list의 내용을 전달
              _showDialog(context, list[position].kind, list[position].animalName);
            },
          );
        },
        itemCount: list.length,)
      ),
    );
  }

void _showDialog(BuildContext context, String kind, String name){
  showDialog(
    context: context, 
    builder: (BuildContext context){
      return AlertDialog(
        title: Text("$name"),
        content: Text(("이 동물은 $kind 입니다.")),
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

