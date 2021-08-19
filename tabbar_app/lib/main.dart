import 'package:flutter/material.dart';
import 'package:tabbar_app/firstPage.dart';
import 'package:tabbar_app/secondPage.dart';

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

class _MyHomePageState extends State<MyHomePage> with SingleTickerProviderStateMixin {
      
  late TabController controller; // TabBar 

  @override
  void initState(){
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
        title: Text('Tab Bar Test'),
      ),
      body: TabBarView( // TabBar 설정
      // 클릭하면 첫번째 / 두번째 페이지로 이동
        children: [FirstPage(), SecondPage()],
        controller: controller,
      ),
      bottomNavigationBar: TabBar(
        labelColor: Colors.blueAccent,// Tab 글자 색 변경(디폴트는 white)
        tabs: [
          Tab(
          icon: Icon(Icons.looks_one,
          color: Colors.blue,),
          text: 'Page #1',
          ),
          Tab(
          icon: Icon(Icons.looks_two,
          color: Colors.red,),
          text: 'Page #2',
          ),
        ],
        controller: controller,
      ),
    );
  }
}