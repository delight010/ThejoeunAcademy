import 'package:flutter/material.dart';
import 'package:tabbar_calc_app/firstPage.dart';
import 'package:tabbar_calc_app/secondPage.dart';

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
  const MyHomePage({ Key? key }) : super(key: key);

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> with SingleTickerProviderStateMixin{

late TabController controller; // TabBar

@override
  void initState() {
    // TODO: implement initState
    super.initState();
    controller = TabController(length: 2, vsync: this);
    // first page, second page에 tabbar가 들어감
  }

  @override
  void dispose() {
    // TODO: implement dispose
    super.dispose();
    controller.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('탭바를 이용한 덧셈계산 비교'),
      ),
      body: TabBarView( // Tab Bar 설정
        children: [FirstPage(), SecondPage()],
        controller: controller,
      ),
      bottomNavigationBar: TabBar(
        labelColor: Colors.blue, // Tab 글자 색 변경(디폴트는 white)
        tabs: [
          Tab(
            icon: Icon(Icons.square_foot,
            color: Colors.blue,),
            text: '덧셈계산 #1',
          ),
          Tab(
            icon: Icon(Icons.square_foot_sharp,
            color: Colors.orange,),
            text: '덧셈계산 #2',
          ),
        ],
        controller: controller,
      ),      
    );
  }
}