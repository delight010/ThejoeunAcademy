//
//  ViewController.swift
//  0726_Kanna04_TableView_WebView
//
//  Created by Seong A Oh on 2021/07/26.
//

import UIKit
import WebKit  //  <<<<<<<<<<<< 잊지 말 것

var baseUrl = "https://www.rottentomatoes.com"
var receiveItem = ""

class ViewController: UIViewController {
    @IBOutlet weak var myWebView: WKWebView!
    @IBOutlet weak var myActivityIndicator: UIActivityIndicatorView!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        loadWebPage(url: baseUrl+receiveItem)
        
        // extension으로 설정한 것을 실행
        myWebView.navigationDelegate = self
    }
    
    // 셀 클릭 시 셀에 해당하는 url 내용 가져오기
    func receiveItems(_ item: String){
        receiveItem = item
    }
    
    func loadWebPage(url: String){
        let myUrl = URL(string: url)
        let myRequest = URLRequest(url: myUrl!)
        myWebView.load(myRequest)
    }

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

} // ViewController


extension ViewController: WKNavigationDelegate{
    
    // Indicator 시작 :: 화면에 보이기
    func webView(_ webView: WKWebView, didCommit navigation: WKNavigation!) {
            myActivityIndicator.startAnimating()
            myActivityIndicator.isHidden = false
    }
    
    // Indicator 종료
    func webView(_ webView: WKWebView, didFinish navigation: WKNavigation!) {
        myActivityIndicator.stopAnimating()
        myActivityIndicator.isHidden = true
    }
        
    // Error 발생 시
    func webView(_ webView: WKWebView, didFail navigation: WKNavigation!, withError error: Error) {
        myActivityIndicator.stopAnimating()
        myActivityIndicator.isHidden = true
    }
    
}
