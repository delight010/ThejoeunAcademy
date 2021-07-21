//
//  ViewController.swift
//  0721_PageControlNumber
//
//  Created by TJ on 2021/07/21.
//

import UIKit

class ViewController: UIViewController {
    
    
    @IBOutlet weak var lblNumber: UILabel!
    @IBOutlet weak var pageControl: UIPageControl!
    
    var numberArray = Array<Int>(1...10)
    var maxArrayNum = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        lblNumber.text = String(numberArray[0])
        textColorChange(numberArray[0])
        
        pageControl.numberOfPages = numberArray.count // 동그라미 갯수 설정
        pageControl.currentPage = 0 // 처음 동그라미에 위치
        pageControl.pageIndicatorTintColor = UIColor.green // 동그라미 색깔 바꾸기
        pageControl.currentPageIndicatorTintColor = UIColor.red // 현재 동그라미 위치 색깔 바꾸기
        
    }
    
    // 라벨 글씨 색 변경
    func textColorChange(_ num: Int) {
        if num % 2 == 1{
            lblNumber.textColor = UIColor.red
        }else{
            lblNumber.textColor = UIColor.blue
        }
    }

    
    // pageControl 실행
    @IBAction func pageChange(_ sender: UIPageControl) {
        lblNumber.text = String(numberArray[pageControl.currentPage])
        textColorChange(numberArray[pageControl.currentPage])
        
    }
    
}

