import 'package:flutter/material.dart';
import 'package:listview_app/firstPage.dart';
import 'package:listview_app/flagItem.dart';
import 'package:listview_app/secondPage.dart';
import 'package:listview_app/animalItem.dart';

import 'firstPage.dart';

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
  List<Animal> animalList = [];
  List<Flag> countryList = [];

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    controller = TabController(length: 2, vsync: this);
    // first page, second page에 tabbar가 들어감.

    // animalList-------------------
    animalList.add(Animal(
        animalName: '벌',
        kind: '곤충',
        imagePath: 'images/bee.png',
        flyExist: true));
    animalList.add(Animal(
        animalName: '고양이',
        kind: '포유류',
        imagePath: 'images/cat.png',
        flyExist: false));
    animalList.add(Animal(
        animalName: '젖소',
        kind: '포유류',
        imagePath: 'images/cow.png',
        flyExist: false));
    animalList.add(Animal(
        animalName: '강아지',
        kind: '포유류',
        imagePath: 'images/dog.png',
        flyExist: false));
    animalList.add(Animal(
        animalName: '여우',
        kind: '포유류',
        imagePath: 'images/fox.png',
        flyExist: false));
    animalList.add(Animal(
        animalName: '원숭이',
        kind: '영장류',
        imagePath: 'images/monkey.png',
        flyExist: false));
    animalList.add(Animal(
        animalName: '돼지',
        kind: '포유류',
        imagePath: 'images/pig.png',
        flyExist: false));
    animalList.add(Animal(
        animalName: '늑대',
        kind: '포유류',
        imagePath: 'images/wolf.png',
        flyExist: false));

    // countryList-------------------
    countryList.add(Flag(country: 'America', imagePath: 'images/america.png'));
    countryList.add(Flag(country: 'Austria', imagePath: 'images/austria.png'));
    countryList.add(Flag(country: 'Belgium', imagePath: 'images/belgium.png'));
    countryList.add(Flag(country: 'Canada', imagePath: 'images/canada.png'));
    countryList.add(Flag(country: 'China', imagePath: 'images/china.png'));
    countryList.add(Flag(country: 'Estonia', imagePath: 'images/estonia.png'));
    countryList.add(Flag(country: 'France', imagePath: 'images/france.png'));
    countryList.add(Flag(country: 'Germany', imagePath: 'images/germany.png'));
    countryList.add(Flag(country: 'Greece', imagePath: 'images/greece.png'));
    countryList.add(Flag(country: 'Hungary', imagePath: 'images/hungary.png'));
    countryList.add(Flag(country: 'Italy', imagePath: 'images/italy.png'));
    countryList.add(Flag(country: 'Korea', imagePath: 'images/korea.png'));
    countryList.add(Flag(country: 'Latvia', imagePath: 'images/latvia.png'));
    countryList
        .add(Flag(country: 'Lithuania', imagePath: 'images/lithuania.png'));
    countryList
        .add(Flag(country: 'Luxemburg', imagePath: 'images/luxemburg.png'));
    countryList
        .add(Flag(country: 'Netherland', imagePath: 'images/netherland.png'));
    countryList.add(Flag(country: 'Romania', imagePath: 'images/romania.png'));
    countryList.add(Flag(country: 'Turkey', imagePath: 'images/turkey.png'));
  }

  @override
  void dispose() {
    // TODO: implement dispose
    super.dispose();
    controller.dispose(); // 멤버로 갖고있는 컨트롤러 제거, 안해주면 더미데이터가 쌓임
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // appBar: AppBar(
      //   title: Text('Animal List'),
      // ),
      body: TabBarView(
        // 생성자 안에 값을 넣는다. ex: FirstPage(value)
        children: [FirstPage(list: animalList), SecondPage(list: countryList)],
        controller: controller,
      ),
      bottomNavigationBar: TabBar(
        labelColor: Colors.blue, // Tab 글자색 변경(디폴트는 white)
        tabs: [
          Tab(
            icon: Icon(
              Icons.looks_one,
              color: Colors.blue,
            ),
            text: '#1',
          ),
          Tab(
            icon: Icon(
              Icons.looks_two,
              color: Colors.orange,
            ),
            text: '#2',
          ),
        ],
        controller: controller,
      ),
    );
  }
}
