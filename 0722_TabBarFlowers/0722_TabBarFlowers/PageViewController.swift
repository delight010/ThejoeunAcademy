//
//  ViewController.swift
//  0721_PageControl
//
//  Created by TJ on 2021/07/21.
//

import UIKit

class PageViewController: UIViewController {

    @IBOutlet weak var imgView: UIImageView!
    @IBOutlet weak var pageControl: UIPageControl!
    
    var images = ["flower_01.png", "flower_02.png", "flower_03.png", "flower_04.png", "flower_05.png", "flower_06.png"]
    
    override func viewDidLoad() {
        super.viewDidLoad()
        imgView.image = UIImage(named: images[0])
    
        pageControl.numberOfPages = images.count // 동그라미 갯수 설정
        pageControl.currentPage = 0 // 처음 동그라미에 위치
        pageControl.pageIndicatorTintColor = UIColor.green // 동그라이 색깔 바꾸기
        pageControl.currentPageIndicatorTintColor = UIColor.red // 현재 동그라미 위치 색깔 바꾸기
        
    }
    
    
    @IBAction func pageChange(_ sender: UIPageControl) {
        imgView.image = UIImage(named: images[pageControl.currentPage]) // 동그라미 위치에 따른 이미지 출력
        
    }
    


} // ViewController

