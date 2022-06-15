void main() {
  checkVersion(); // 비동기 함수이므로 나중에 실행
  print('end process');
}

// 비동기 함수 (Future)
Future checkVersion() async {
  print("------");

  // await는 대기 상태로 전환
  var version = await lookUpVersion();
  print(version);
}

int lookUpVersion() {
  return 12;
}

// 출력 결과
// ------
// end process
// 12
