//
//  ViewController.swift
//  0721_PickerViewWeb
//
//  Created by TJ on 2021/07/21.
//

import UIKit
import WebKit  //  <<<<<<<<<<<< 잊지 말 것

class ViewController: UIViewController {
    
    
    @IBOutlet weak var myPickerView: UIPickerView!
    @IBOutlet weak var myWebView: WKWebView!
    @IBOutlet weak var myActivityIndicator: UIActivityIndicatorView!
    
//    // 배열 2개
//    var siteListName = ["네이버", "다음", "구글", "기상청", "BBC", "CBS"]
//    var siteList = ["www.naver.com", "www.daum.net", "www.google.com", "www.weather.go.kr", "www.bbc.com", "www.cbs.com"]
    
    // Tuple 이용
    var siteListTuple:[(String, String)] = [("네이버","www.naver.com"), ("다음","www.daum.net"),("구글","www.google.com"),("기상청", "www.weather.go.kr"),("BBC","www.bbc.com"), ("CBS", "www.cbs.com") ]
    
    
    let viewColumn = 1 // pickerView의 열의 갯수
    var maxArrayNum = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()
        //maxArrayNum = siteList.count // 출력할 데이터 갯수 설정 (배열)
        maxArrayNum = siteListTuple.count // 출력할 데이터 갯수 설정 (Tuple)
        myActivityIndicator.isHidden = true
        
        // extension으로 설정한 것을 사용
        myPickerView.dataSource = self // 갯수만큼 행을 만듦
        myPickerView.delegate = self // pickerView Title 입력 & webView 사이트 출력
        
        myWebView.navigationDelegate = self
    }
    
    // 사이트 출력
    func loadWebPage(url: String){
        let myUrl = URL(string: url)
        let myRequest = URLRequest(url: myUrl!)
        myWebView.load(myRequest)
    }

    // 주소 체크
    func checkUrl(url:String) -> String{
        var strUrl = url
        let flag = strUrl.hasPrefix("http://")
        // "http://"로 시작되는 지 확인
        if !flag{
            strUrl = "http://" + strUrl
        }
        
        return strUrl
    }


} // ViewController


extension ViewController: UIPickerViewDataSource{
    // picekrView의 컬럼 갯수
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return viewColumn // 1개만 리턴
    }
    
    // 출력할 데이터 갯수
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return maxArrayNum
    }
    
    
} // UIPickerViewDataSource


extension ViewController: UIPickerViewDelegate{
    // PickerView에 Title 입히기
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        //let siteName: String? = "\(String(siteListName[row]))" // 배열 이용
        let siteName: String? = "\(String(siteListTuple[row].0))" // Tuple 이용
        return siteName
    }
    
    // webView 출력하기
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        
        //let siteUrl = checkUrl(url: "\(siteList[row])") // 배열 이용
        let siteUrl = checkUrl(url: "\(siteListTuple[row].1)") // Tuple 이용
        print(siteUrl)
        loadWebPage(url: siteUrl)
        
    }
    
} // UIPickerViewDelegate

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

 
