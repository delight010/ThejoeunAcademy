import 'package:flutter/material.dart';
import 'package:fluttertoast/fluttertoast.dart';

class MyToast extends StatelessWidget {
  const MyToast({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Center(
      child: ElevatedButton(
          style: ButtonStyle(
              backgroundColor: MaterialStateProperty.all(Colors.blue)),
          onPressed: () {
            // Fluttertoast를 이용한 Toast(pub.dev)
            toastAction();
          },
          child: Text("Toast Button")),
    );
  }
}

// Toast Action
void toastAction() {
  Fluttertoast.showToast(
    msg: "Toast Button is clicked",
    backgroundColor: Colors.black,
    textColor: Colors.white,
    fontSize: 14.0,
    toastLength: Toast.LENGTH_SHORT,
    gravity: ToastGravity.TOP, // Toast 위치 조정
  );
}
