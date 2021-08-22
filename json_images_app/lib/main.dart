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
        title: Text('JSON Image Test'),
      ),
      body: Container(
        child: ListView.builder(
          scrollDirection: Axis.vertical,
          itemBuilder: (context, index) {
            return Card(
              child: Container(
                child: Image.network(
                  data[index]['image'],
                  height: 100,
                  width: 100,
                  fit: BoxFit.contain,
                ),
              ),
            );
          },
          itemCount: data.length,
        ),
      ),
    );
  }

  Future<String> getJSONData() async {
    // async 사용
    var url = Uri.parse('http://localhost:8080/Flutter/images.json');
    var response = await http.get(url);
    //print(response.body);

    setState(() {
      var dataConvertedJSON =
          json.decode(response.body); // 괄호를 제외한 key, value 값만 추가
      List result = dataConvertedJSON['results'];
      print(result);
      data.addAll(result); // data에 jsonData를 전부 추가
    });

    return "a";
  }
}
