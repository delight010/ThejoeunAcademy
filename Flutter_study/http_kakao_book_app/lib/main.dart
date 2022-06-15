import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert'; // JSON  사용

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
  String result = '';
  late List data;

  @override
  void initState() {
    // TODO: implement initState
    // 화면 띄우기 전에 준비
    super.initState();
    data = [];
    getJSONData();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Http Exercise"),
      ),
      body: SingleChildScrollView(
        // 스크롤뷰 설정
        child: Container(
          child: ListView.builder(
            itemBuilder: (context, index) {
              return Card(
                child: Container(
                  child: Image.network(
                    data[index]['thumbnail'],
                    height: 100,
                    width: 100,
                    fit: BoxFit.contain,
                  ),
                ),
              );
            },
          ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          getJSONData();
        },
        child: Icon(Icons.file_download),
      ),
    );
  }

  Future<String> getJSONData() async {
    var url = Uri.parse(
        'https://dapi.kakao.com/v3/search/book?tartget=title&query=플러터');
    var response = await http.get(url, headers: {
      "Authorization": "KakaoAK 131e47d3423b9f248e9f2b6fceb9d2d2"
    }); // key:value
    print(response.body);

    setState(() {
      var dataConvertedJSON =
          json.decode(response.body); // 괄호를 제외한 key,value 추가
      List result = dataConvertedJSON['documents'];
    });
    return "Success";
  }
}
