import 'package:flutter/material.dart';
import 'package:tabbar_ex_app/firstPage.dart';
import 'package:tabbar_ex_app/secondPage.dart';

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

class _MyHomePageState extends State<MyHomePage>
    with SingleTickerProviderStateMixin {
  late TabController controller; // TabBar

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    controller = TabController(length: 2, vsync: this);
    // first page, second page에 tabbar가 들어감.
  }

  @override
  void dispose() {
    // TODO: implement dispose
    super.dispose();
    controller.dispose(); // 멤버로 갖고있는 컨트롤러 제거
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('피카츄 이미지 탭바'),
      ),
      body: TabBarView(
        children: [FirstPage(), SecondPage()],
        controller: controller,
      ),
      bottomNavigationBar: TabBar(
        labelColor: Colors.blue, // Tab 글자색 변경(디폴트는 white)
        tabs: [
          Tab(
            icon: Icon(
              Icons.lock_clock,
              color: Colors.blue,
            ),
            text: 'Picachu Scene #1',
          ),
          Tab(
            icon: Icon(
              Icons.person,
              color: Colors.orange,
            ),
            text: 'Picachu Scene #2',
          ),
        ],
        controller: controller,
      ),
    );
  }
}
