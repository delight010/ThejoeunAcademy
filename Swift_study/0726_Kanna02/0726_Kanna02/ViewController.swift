//
//  ViewController.swift
//  0726_Kanna02
//
//  Created by Seong A Oh on 2021/07/26.
//

import UIKit
import Kanna

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        dataCrawling()
    }

    // dataCrawling 메소드 정의
    func dataCrawling(){
        let mainUrl = "https://www.rottentomatoes.com/top/bestofrt/?year=2019"
        
        // 만일 url이 비어있다면
        guard let main = URL(string: mainUrl) else {
            print("Error: \(mainUrl) doesn't seem to be a valid URL")
            return
        }
        
        do{
            // //*[@id="top_movies_main"]/div/table/tbody/tr[1]/td[3]/a
            
            // main 주소를 utf8로 인코딩
            let htmlData = try String(contentsOf: main, encoding: .utf8)
            // htmlData에 접근 시도 utf8로 인코딩
            let doc = try HTML(html: htmlData, encoding: .utf8)
            
            var count = 1 // 순서번호를 보여주기를 위한 변수
            for title in doc.xpath("//*[@id='top_movies_main']/div/table/tr/td/a") {// xpath는 Python으로 찾든 Xcode로 찾든 동일
                // 번호와 title을 불러옴.
                // .trimmingCharacters(in: .whitespacesAndNewlines)를 이용하여 공백을 제거
                print(count, title.text!.trimmingCharacters(in: .whitespacesAndNewlines))
                count += 1
            }
            
        }catch let error{
            print("Error :\(error)")
        }
        
    }

} // ViewController

