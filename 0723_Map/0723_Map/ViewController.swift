//
//  ViewController.swift
//  0723_Map
//
//  Created by TJ on 2021/07/23.
//

import UIKit
import MapKit // <<<<< MapKit 불러오기

class ViewController: UIViewController {
    @IBOutlet weak var locationGo: UISegmentedControl!
    @IBOutlet weak var myMap: MKMapView!
    @IBOutlet weak var addr1: UILabel!
    @IBOutlet weak var addr2: UILabel!
    
    let myLoc = CLLocationManager()
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        // extension 설정한 것을 실행
        myLoc.delegate = self
        myLoc.requestWhenInUseAuthorization() // 승인 허용 문구 받아서 처리
        myLoc.startUpdatingLocation() // GPS 좌표 받기 시작
        myMap.showsUserLocation = true // 좌표 찍기
    }
    
    
    func mapMove(_ lat: CLLocationDegrees, _ lon: CLLocationDegrees, _ txt1: String){
        // _txt1 = 주소내용
        
        // 지도의 중점 설정
        let pLoc = CLLocationCoordinate2DMake(lat, lon)
        
        // 배율 설정(지도)
        let pSpan = MKCoordinateSpan(latitudeDelta: 0.02, longitudeDelta: 0.02)
        
        // 좌표 정보 (지도 중점과 배율 설정)
        let pRegion = MKCoordinateRegion(center: pLoc, span: pSpan)
        
        // 현재 지도를 좌표 정보로 보이기
        myMap.setRegion(pRegion, animated: true)
        
        let addrLoc = CLLocation(latitude: lat, longitude: lon) // 좌표 넣기
        var txt2 = ""
        
        
        // 주소 내역 받아오기
        // 미국과 다르게 우리나라는 국가부터 받아오므로 reverseGeocodeLocation를 사용
        // completionHandler는 클로저로 설정
        CLGeocoder().reverseGeocodeLocation(addrLoc, completionHandler: {place, error in
            let pm = place!.first
            txt2 = pm!.country! // 국가
            txt2 += " " + pm!.locality! // 시, 도
            txt2 += " " + pm!.thoroughfare! // 동
            self.addr2.text = txt2
        })
        addr1.text = txt1
        setPoint(pLoc, txt1, txt2) // pin 꽂기
    }
    
    // pin 꽂기
    func setPoint(_ loc: CLLocationCoordinate2D, _ txt1: String, _ txt2: String){
        // pin 메소드 불러오기
        let pin = MKPointAnnotation()
        
        // pin 좌표
        pin.coordinate = loc
        // pin title
        pin.title = txt1
        // pin subtitle
        pin.subtitle = txt2
        
        myMap.addAnnotation(pin) // pin 꽂기
        
    }
    

    @IBAction func locationGo(_ sender: UISegmentedControl) {
        // sender가 누른 위치를 알고 있다
        if sender.selectedSegmentIndex == 0{ // 현재 위치
            myLoc.startUpdatingLocation()
        }else if sender.selectedSegmentIndex == 1{ // 둘리뮤지엄
            mapMove(37.65243153, 127.0276397, "둘리뮤지엄")
        }else if sender.selectedSegmentIndex == 2{ // 서대문 형무소
            mapMove(37.57244171, 126.9595412, "서대문 형무소 역사관")
        }
    }
    
}// ViewController

// myLoc = CLLocationManager()가 호출 시 자동 실행
// GPS 설정
extension ViewController: CLLocationManagerDelegate{
    // 현재 위치 불러오기
    func locationManager(_ manager: CLLocationManager, didUpdateLocations locations: [CLLocation]) {
        let lastLoc = locations.last // 마지막 값을 가져옴
        
        // 지도보기
        // coordinate = 좌표
        mapMove((lastLoc?.coordinate.latitude)!, (lastLoc?.coordinate.longitude)!, "현재 위치") // 지도 이동
        myLoc.stopUpdatingLocation() // 좌표받기 중지
        
    }
}

