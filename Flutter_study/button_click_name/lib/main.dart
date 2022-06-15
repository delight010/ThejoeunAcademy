import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
      title: 'Flutter Demo',
      debugShowCheckedModeBanner: false,
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
  int click = 1;
  String main = "Welcome!";

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
      home: CupertinoPageScaffold(
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center, // 정렬을 꼭 할 것
            children: [
              Container(
                child: Column(
                  children: [
                    Text(main),
                    SizedBox(
                      height: 100,
                    ),
                    CupertinoButton(
                      child: Text('Name'),
                      onPressed: () {
                        setState(
                          () {
                            click += 1;
                            if (click % 2 == 0) {
                              main = 'Welcome! Korea';
                            } else {
                              main = 'Welcome!';
                            }
                          },
                        );
                      },
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
