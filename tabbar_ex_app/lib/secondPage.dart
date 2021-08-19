import 'package:flutter/material.dart';

class SecondPage extends StatelessWidget {
  const SecondPage({ Key? key }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.orange,
      // appBar: AppBar(
      //   title: Text("Second Page"),
      // ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Padding(
              padding: const EdgeInsets.all(10.0),
              child: CircleAvatar(
                backgroundImage: AssetImage('images/picachu1.png'),
                radius: 50.0,
              ),
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Padding(
                  padding: const EdgeInsets.all(10.0),
                  child: CircleAvatar(
                    backgroundImage: AssetImage('images/picachu2.png'),
                    radius: 50.0,
                  ),
                ),
                Padding(
                  padding: const EdgeInsets.all(10.0),
                  child: CircleAvatar(
                    backgroundImage: AssetImage('images/picachu3.png'),
                    radius: 50.0,
                  ),
                ),
              ],
            ),
          ],          
        ),
      ),
    );
  }
}