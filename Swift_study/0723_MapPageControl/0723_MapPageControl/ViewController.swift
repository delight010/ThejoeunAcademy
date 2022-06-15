//
//  ViewController.swift
//  0723_MapPageControl
//
//  Created by TJ on 2021/07/23.
//

import UIKit
import MapKit // <<<<< MapKit 불러오기

class ViewController: UIViewController {
    @IBOutlet weak var lblTitle: UILabel!
    @IBOutlet weak var myMap: MKMapView!
    @IBOutlet weak var pageControl: UIPageControl!
    
    
    
    var listOfSights:[(String, Double, Double)] = [("혜화문", 37.5878892, 127.0037098), ("흥인지문", 37.5711907, 127.009506), ("창의문", 37.5926027, 126.9664771), ("숙정문", 37.5956584, 126.9810576)]
    var maxArrayNum = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        // 첫화면에 띄워주는 것들
        lblTitle.text = listOfSights[0].0
        mapMove(listOfSights[0].1, listOfSights[0].2, listOfSights[0].0)
        maxArrayNum = listOfSights.count
        
        
        pageControl.numberOfPages = listOfSights.count // 동그라미 갯수 설정
        pageControl.currentPage = 0 // 처음 동그라미 위치
        pageControl.pageIndicatorTintColor = UIColor.green // 동그라미 색깔 바꾸기
        pageControl.currentPageIndicatorTintColor = UIColor.red // 현재 페이지 동그라미 색깔 바꾸기
    
        // Map 띄우기
        myMap.showsUserLocation = true
    }
    
    func mapMove(_ lat: CLLocationDegrees, _ lon: CLLocationDegrees, _ txt1: String){
        // _ txt1 = 주소내용
        
        // 지도의 중점 설정
        let pLoc = CLLocationCoordinate2DMake(lat, lon)
        
        // 배율 설정(지도)
        let pSpan = MKCoordinateSpan(latitudeDelta: 0.005, longitudeDelta: 0.005)
        
        // 좌표 정보(지도 중점과 배율 설정)
        let pRegion = MKCoordinateRegion(center: pLoc, span: pSpan)
        
        // 현재 지도를 좌표 정보로 보이기
        myMap.setRegion(pRegion, animated: true)
        
        let addrLoc = CLLocation(latitude: lat, longitude: lon)
//        var txt2 = ""
        
        // completionHandler는 클로저로 설정
//        CLGeocoder().reverseGeocodeLocation(addrLoc, completionHandler:{place, error in
//            let pm = place!.first
//            txt2 = pm!.country! // 국가
//            txt2 += " " + pm!.locality! // 시, 도
//            txt2 += " " + pm!.thoroughfare! // 동면리
//        })
        
        setPoint(pLoc, txt1) // pin 꽂기
        
    }
    
    
    // Map에 pin 꽂기
    func setPoint(_ loc: CLLocationCoordinate2D, _ txt1: String){
        // pin 메소드 불러오기
        let pin = MKPointAnnotation()
        
        // pin 좌표
        pin.coordinate = loc
        // pin title
        pin.title = txt1
        
        myMap.addAnnotation(pin) // pin 꽂기
    }
    

    // pageControl 실행
    @IBAction func pageChange(_ sender: UIPageControl) {
        // sender가 누른 위치를 알고 있다.
        
        // 라벨 변경
        lblTitle.text = listOfSights[pageControl.currentPage].0
        
        // 지도 위치
        mapMove(listOfSights[pageControl.currentPage].1, listOfSights[pageControl.currentPage].2, listOfSights[pageControl.currentPage].0)
        
        
        
    }
    
    
}// ViewController

