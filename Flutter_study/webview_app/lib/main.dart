import 'dart:async';

import 'package:flutter/material.dart';
import 'package:webview_flutter/webview_flutter.dart';

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
  final Completer<WebViewController> _controller =
      Completer<WebViewController>(); // package 등록해야 함

  bool isLoading = true; // for indicator

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("WebView"),
      ),
      body: Stack(
        // StackWidget 사용
        children: [
          WebView(
            initialUrl: 'https://www.daum.net',
            javascriptMode: JavascriptMode.unrestricted, // JavaScript 수행 O
            onWebViewCreated: (WebViewController webViewController) {
              // 웹이 만들어 질 때,
              _controller.complete(webViewController); // 컨트롤러에 기능을 부여
            },
            onPageFinished: (finish) {
              // 웹로딩이 끝나면
              setState(() {
                isLoading = false;
              });
            },
            onPageStarted: (start) {
              // 웹로딩이 시작되면
              setState(() {
                isLoading = true;
              });
            },
          ),
          isLoading // 삼항연산자, isLoading ? true : false
              ? Center(
                  child: CircularProgressIndicator(), // 로딩바를 실행
                )
              : Stack(), // Stack()을 실행
        ],
      ),
      floatingActionButton: FutureBuilder<WebViewController>(
        future: _controller.future, // 맨 마지막에 구동됨, async도 마지막에 구동됨
        builder: (BuildContext context,
            AsyncSnapshot<WebViewController> controller) {
          // AsyncSnapshot
          if (controller.hasData) {
            return FloatingActionButton(
                child: Icon(Icons.arrow_back),
                backgroundColor: Colors.redAccent,
                onPressed: () {
                  // 클릭하면
                  controller.data!.goBack(); // 이전 화면으로 이동
                });
          }
          return Container();
        },
      ),
    );
  }
}
