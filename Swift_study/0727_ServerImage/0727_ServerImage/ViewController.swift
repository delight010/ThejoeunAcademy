//
//  ViewController.swift
//  0727_ServerImage
//
//  Created by TJ on 2021/07/27.
//

import UIKit


class ViewController: UIViewController {
    @IBOutlet weak var imgView: UIImageView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    
    // 첫번째 방법 : 서버에 있는 이미지 -> 기기 저장 -> 불러옴 (옛날 방식)
    @IBAction func btnImage1(_ sender: UIButton) {
        let url: URL = URL(string: "http://192.168.200.180:8080/ios/flower_01.png")!
        let defaultSession = Foundation.URLSession(configuration: URLSessionConfiguration.default)
        
        // dataTask 구성
        let task = defaultSession.dataTask(with: url){(data, response, error) in
            if error != nil{ // error가 nil이 아니라면
                print("Failed to download data")
            }else{
                print("Data is downloaded")
                DispatchQueue.main.async {
                    self.imgView.image = UIImage(data: data!)
                    if let image = UIImage(data: data!){
                        if let data = image.pngData(){
                            let filename = self.getDocumentDirectory().appendingPathComponent("copy.png") // 받아오는 이미지 이름을 copy.png로 지정 -> getDocumentDirectory를 저장위치로 지정
                            try? data.write(to: filename) // 파일을 저장
                        }
                    }
                }
            }
        }
        task.resume() // asyncTask 실행
    }
    
    func getDocumentDirectory() -> URL{
        let paths = FileManager.default.urls(for: .documentDirectory, in: .userDomainMask)
        return paths[0]
    }
    
    
    // 두번째 방법 ( 최신 방식 )
    @IBAction func btnImage2(_ sender: UIButton) {
        let url = URL(string: "http://192.168.200.180:8080/ios/flower_02.png")
        let data = try? Data(contentsOf: url!) // url에서 Data를 가져옴
        
        imgView.image = UIImage(data: data!) // 이미지를 띄움
        // 여러 이미지일 경우 배열에 저장
    }
    

} // ViewController

