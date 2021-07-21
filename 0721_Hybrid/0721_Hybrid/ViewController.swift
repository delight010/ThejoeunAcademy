//
//  ViewController.swift
//  0721_Hybrid
//
//  Created by TJ on 2021/07/21.
//

import UIKit
import WebKit  //  <<<<<<<<<<<< 잊지 말 것

class ViewController: UIViewController {
    @IBOutlet weak var tfUrl: UITextField!
    @IBOutlet weak var myWebView: WKWebView!
    @IBOutlet weak var myActivityIndicator: UIActivityIndicatorView!
    
    

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        loadWebPage(url: "https://www.naver.com")
        myWebView.navigationDelegate = self
        
    }
    
    func loadWebPage(url: String){
        let myUrl = URL(string: url)
        let myRequest = URLRequest(url: myUrl!)
        myWebView.load(myRequest)
    }


    @IBAction func btnSite1(_ sender: UIButton) {
        loadWebPage(url: "https://www.google.com")
        myWebView.navigationDelegate = self
    }
    
    
    @IBAction func btnSite2(_ sender: UIButton) {
        loadWebPage(url: "https://www.daum.net")
        myWebView.navigationDelegate = self
    }
    
    
    @IBAction func btnGo(_ sender: UIButton) {
        let myUrl = checkUrl(url: tfUrl.text!)
        tfUrl.text = ""
        loadWebPage(url: myUrl)
        
        
//        var url = tfUrl.text!
//        if url.contains("https://"){
//            loadWebPage(url: tfUrl.text!)
//        }else{
//            loadWebPage(url: "http://\(url)")
//        }
//        myWebView.navigationDelegate = self
    }
    
    func checkUrl(url: String) -> String{
        var strUrl = url
        let flag = strUrl.hasPrefix("https://") // https://로 시작되는 지 확인
        if !flag{
            strUrl = "http://" + strUrl
        }
        return strUrl
    }
    
    
    @IBAction func btnHtml(_ sender: UIButton) {
        let htmlString = """
        <html>
            <head>
                <meta charset="utf-8">
                <meta name="viewport" content="width=device, initial-scale=1.0">
            </head>
            <body>
                <h1>HTML String</h1>
                <p>String 변수를 이용한 웹페이지</p>
                <p><a href = "http://jtbc.joins.com">JTBC</a>로 이동</p>
            </body>
        </html>
        """
        // <meta name="viewport" content="width=device, initial-scale=1.0">
        // 기종에 상관없이,
        // width=device  ::  가로 폭을 기종에 맞춰서 출력
        // initial-scale=2.0  ::  크기를 몇배로
        myWebView.loadHTMLString(htmlString, baseURL: nil)
    }
    
    
    @IBAction func btnFile(_ sender: UIButton) {
        let filePath = Bundle.main.path(forResource: "htmlView", ofType: "html")
        // forResource: 파일이름 :: "htmlView"
        // ofType: 확장자(Type) :: "html"
        let myUrl = URL(fileURLWithPath: filePath!)
        let myRequest = URLRequest(url: myUrl)
        myWebView.load(myRequest)
    }
    
    
    
    
    @IBAction func btnStop(_ sender: UIBarButtonItem) {
        myWebView.stopLoading()
    }
    
    
    @IBAction func btnReload(_ sender: UIBarButtonItem) {
        myWebView.reload()
    }
    
    
    @IBAction func btnGoBack(_ sender: UIBarButtonItem) {
        myWebView.goBack()
    }
    
    
    @IBAction func btnGoForward(_ sender: UIBarButtonItem) {
        myWebView.goForward()
    }
    
    
    
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
    
} // WKNavigationDelegate

