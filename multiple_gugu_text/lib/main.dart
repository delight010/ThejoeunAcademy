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
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({ Key? key }) : super(key: key);

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  TextEditingController? _multilines;
  TextEditingController? _singleline;

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _multilines = TextEditingController();
    _singleline = TextEditingController();
  }

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: (){
        FocusScope.of(context).unfocus();
      },
      child: CupertinoApp(
        home: CupertinoPageScaffold(
          child: Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text('구구단 출력', style: TextStyle(
                  fontWeight: FontWeight.bold,
                  fontSize: 20),
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Container(
                      child: CupertinoTextField(
                        controller: _singleline,
                        maxLines: 1,
                        textAlign: TextAlign.right,
                        keyboardType: TextInputType.number,
                        placeholder: '숫자만 입력',
                      ),
                      width: 100,
                    ),
                    CupertinoButton(
                      child: Text('단 출력'), 
                      onPressed: (){
                        printGugu();
                      },
                    ),
                  ],
                ),
                Container(
                  child: CupertinoTextField(
                    controller: _multilines,
                    maxLines: 9,
                    textAlign: TextAlign.left,
                    decoration: BoxDecoration(color: Colors.amber[100]),
                  ),
                  width: 200,
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }

  void printGugu(){
    setState(() {
      int num = int.parse(_singleline!.text);
      int num2 = 1;
      while(num2<=9){
          _multilines!.text += num.toString() + "X" + num2.toString() + "=" + (num*num2).toString() + "\n";
          num2++;
      }
      FocusScope.of(context).unfocus();
      },
    );   
  }

}