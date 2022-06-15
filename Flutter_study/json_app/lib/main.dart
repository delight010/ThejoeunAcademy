import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert'; // json 사용

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
    // 화면 띄우기 전에 준비
    // TODO: implement initState
    super.initState();
    data = [];
    getJSONData();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('JSON Test'),
      ),
      body: Container(
        child: Center(
          child: data.length == 0 // 삼항연산자 사용
              ? Text(
                  '데이터가 없습니다.',
                  style: TextStyle(
                    fontSize: 20,
                  ),
                  textAlign: TextAlign.center,
                )
              : ListView.builder(
                  itemBuilder: (context, index) {
                    return Card(
                      child: Column(
                        children: [
                          // 셀 1개씩 디자인
                          Padding(
                            padding: const EdgeInsets.all(8.0),
                            child: Row(
                              children: [
                                Text(
                                  "Code : ",
                                  style: TextStyle(fontWeight: FontWeight.bold),
                                ),
                                Text(data[index]['code'].toString()),
                              ],
                            ),
                          ),
                          Padding(
                            padding: const EdgeInsets.all(8.0),
                            child: Row(
                              children: [
                                Text(
                                  "Name : ",
                                  style: TextStyle(fontWeight: FontWeight.bold),
                                ),
                                Text(data[index]['name'].toString()),
                              ],
                            ),
                          ),
                          Padding(
                            padding: const EdgeInsets.all(8.0),
                            child: Row(
                              children: [
                                Text(
                                  "Dept : ",
                                  style: TextStyle(fontWeight: FontWeight.bold),
                                ),
                                Text(data[index]['dept'].toString()),
                              ],
                            ),
                          ),

                          Padding(
                            padding: const EdgeInsets.all(8.0),
                            child: Row(
                              children: [
                                Text(
                                  "Phone : ",
                                  style: TextStyle(fontWeight: FontWeight.bold),
                                ),
                                Text(data[index]['phone'].toString()),
                              ],
                            ),
                          ),
                        ],
                      ),
                    );
                  },
                  itemCount: data.length,
                ),
        ),
      ),
    );
  }

  Future<String> getJSONData() async {
    // async 사용
    var url = Uri.parse('http://localhost:8080/Flutter/student.json');
    var response = await http.get(url);
    print(response.body);

    setState(() {
      var dataConvertedJSON =
          json.decode(response.body); // 괄호를 제외한 key, value 값만 가져옴
      List result_a = dataConvertedJSON['results'];
      print(result_a);
      data.addAll(result_a); // data에 jsonData를 전부 집어넣음
    });

    return "a";
  }
}
