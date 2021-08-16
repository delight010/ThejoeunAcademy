// async와 await는 함께 쓴다.
void main() async {
  await getVersionName().then((value) => {print(value)});
  print("end process");
}

Future<String> getVersionName() async {
  var versionName = await lookUpVersionName();
  return versionName;
}

String lookUpVersionName() {
  return "Flutter";
}

// 출력
// Flutter
// end process
