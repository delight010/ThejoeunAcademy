//
//  ViewController.swift
//  0721_PageControlWebView
//
//  Created by TJ on 2021/07/21.
//

import UIKit
import WebKit  //  <<<<<<<<<<<< 잊지 말 것

class ViewController: UIViewController {

    
    @IBOutlet weak var lblTitle: UILabel!
    @IBOutlet weak var webView: WKWebView!
    @IBOutlet weak var pageControl: UIPageControl!
    @IBOutlet weak var myActivityIndicator: UIActivityIndicatorView!
    
    
    
    // Tuple 이용
    var siteListTuple:[(String, String)] = [("네이버","www.naver.com"), ("다음","www.daum.net"),("구글","www.google.com"),("기상청", "www.weather.go.kr"),("BBC","www.bbc.com"), ("CBS", "www.cbs.com") ]
    
    var maxArrayNum = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        maxArrayNum = siteListTuple.count // 출력할 데이터 갯수 설정 (Tuple)
        lblTitle.text = String(siteListTuple[0].0)
        loadWebPage(url: checkUrl(url: siteListTuple[0].1))
        
        myActivityIndicator.isHidden = true
        webView.navigationDelegate = self
        
        pageControl.numberOfPages = siteListTuple.count // 동그라미 갯수 설정
        pageControl.currentPage = 0 // 처음 동그라미에 위치
        pageControl.pageIndicatorTintColor = UIColor.green // 동그라미 색깔 바꾸기
        pageControl.currentPageIndicatorTintColor = UIColor.red // 현재 동그라미 위치 색깔 바꾸기
        
        
    }
    
    // 사이트 출력
    func loadWebPage(url: String){
        let myUrl = URL(string: url)
        let myRequest = URLRequest(url: myUrl!)
        webView.load(myRequest)
    }
    
    // 주소 체크
    func checkUrl(url: String) -> String{
        var strUrl = url
        let flag = strUrl.hasPrefix("http://") // "http://"로 시작되는 지 확인
        if !flag{
            strUrl = "http://" + strUrl
        }
        
        return strUrl
    }
    
    // pageControl 실행
    @IBAction func pageChange(_ sender: UIPageControl) {
        lblTitle.text = siteListTuple[pageControl.currentPage].0 // 라벨 변경
        let siteUrl = checkUrl(url: siteListTuple[pageControl.currentPage].1) // urlCheck
        loadWebPage(url: siteUrl) // webView 띄우기
    }
    


} // ViewController

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
